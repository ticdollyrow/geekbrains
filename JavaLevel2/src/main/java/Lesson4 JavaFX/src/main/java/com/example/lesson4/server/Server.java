package com.example.lesson4.server;

import com.example.lesson4.Commands;
import com.example.lesson4.database.DatabaseHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;

public class Server {
    private final static int PORT = 8190;

    private final AuthService authService;
    private final DatabaseHandler databaseHandler;
    private final Map<String, ClientHandler> clientHandlers;

    public Server() {

        this.databaseHandler = new DatabaseHandler();
        this.authService = new AuthServiceImpl();
        this.clientHandlers = new HashMap<>();
    }

    public void run() {
        try {
            this.databaseHandler.connect();
            this.databaseHandler.createAuthTable();

            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                while (true) {
                    final Socket socket = serverSocket.accept();
                    new ClientHandler(socket, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.databaseHandler.disconnect();
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
        broadcastCLientsList();
    }

    private void broadcastCLientsList() {
        StringBuilder clientsCommand = new StringBuilder(Commands.CLIENTS.getCommand());
        for(ClientHandler client : clientHandlers.values()){
            clientsCommand.append(client.getNick()).append(" ");
        }
        broadcast(clientsCommand.toString());
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
