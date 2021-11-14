package com.example.lesson4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class Server {
    private final static int PORT = 8190;

    private final AuthService authService;
    private final Map<String, ClientHandler> clientHandlers;

    public Server() {
        this.authService = new AuthServiceImpl();
        this.clientHandlers = new HashMap<>();
    }

    public void run() {

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true){
               final Socket socket = serverSocket.accept();
               new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public AuthService getAuthService() {
        return authService;
    }

    public boolean isNickBusy(String nick){
         return clientHandlers.containsKey(nick);
    }

    public void subscribe(ClientHandler client){
        clientHandlers.put(client.getNick(), client);
    }

    public void unsubscribe(ClientHandler client){
        clientHandlers.remove(client.getNick());
    }

    public void broadcast(String s) {
        Collection<ClientHandler> clients = clientHandlers.values();
        for (ClientHandler client : clients) {
            client.sendMessage(s);
        }
    }

    public void sendToUser(ClientHandler sender, String message, String nick){
        ClientHandler clientHandler = clientHandlers.get(nick);
        if(clientHandler != null) {
            clientHandler.sendMessage(sender.getNick() + ": " + message);
            sender.sendMessage(sender.getNick() + ": " + message);
            return;
        }
        sender.sendMessage("Пользователя не существует");
    }
}
