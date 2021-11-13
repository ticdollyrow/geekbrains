package com.example.lesson4.server;

import com.example.lesson4.Commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final DataInputStream in;
    private final DataOutputStream out;
    private final Socket socket;
    private final Server server;
    private String nick;

    public ClientHandler(Socket socket, Server server){

        try {
            this.nick = "";
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());


            new Thread(() -> {
                try {
                    authenticate();
                    readMessages();
                }finally {
                    closeConnection();
                }
            }).start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void closeConnection() {
        try {
            if(socket != null){
                server.unsubscribe(this);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            if(in != null){
                in.close();
            }
        } catch (IOException e) {
                e.printStackTrace();
        }

        try {
            if(out != null) {
                out.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readMessages() {
        try{
            while(true){
                String msg = in.readUTF();
                if(msg.equals(Commands.END_CHAT.getCommand())){

                    sendMessage(Commands.END_CHAT.getCommand());
                    break;
                }
                server.broadcast(nick + " " + msg);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void authenticate() {
        while (true){
            try {
                String strClient = in.readUTF();
                if(strClient.startsWith(Commands.AUTH.getCommand())){
                    String[] split = strClient.split(" ");
                    if(split.length == 3){
                    String login = split[1];
                    String pass = split[2];
                    String nick = server.getAuthService().getNickByLoginAndPassword(login, pass);
                    if(nick != null) {
                        if (server.isNickBusy(nick)) {
                            sendMessage("Пользователь уже авторизован");
                            continue;
                        }

                        sendMessage(Commands.AUTH_OK.getCommand() + " " + nick);
                        this.nick = nick;
                        server.subscribe(this);
                        server.broadcast("пользователь " + nick + "зашел в чат");
                        break;
                    }
                    }else{
                        sendMessage("Неверный логин/пароль");
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendMessage(String s) {
        try {
            out.writeUTF(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }
}
