package com.example.lesson4;

import com.example.lesson4.database.UserData;
import javafx.collections.ObservableList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Client {
    final static int PORT = 8190;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Controller controller;

    public Client(Controller controller) {
        this.controller = controller;
        openConnection();
    }

    private void openConnection(){
        try {
            socket = new Socket("localhost", PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


            new  Thread(() -> {
                    try {
//                        while (true){
//                           String msgAuth =  in.readUTF();
//                           if(msgAuth.startsWith(Commands.AUTH_OK.getCommand())){
//                               String[] split = msgAuth.split(" ");
//                               controller.addMessage("успешная авторизация под ником " + split[1]);
//                               controller.setAuth(true);
//                               break;
//                           }
//                        }

                        while (true) {
                            String s = in.readUTF();

//                            String msgAuth =  in.readUTF();
                            String msgAuth = s;
                            if(msgAuth.startsWith(Commands.AUTH_OK.getCommand())){
                                String[] split = msgAuth.split(" ");
                                controller.addMessage("успешная авторизация под ником " + split[1]);
                                controller.setAuth(true);
                                continue;
                            }

                            if(Commands.END_CHAT.getCommand().equals(s)){

                                //controller.setAuth(false);
                                break;
                            }

                            if(Commands.LOG_OUT.getCommand().equals(s)){

                                controller.setAuth(false);
//                                break;
                                continue;
                            }

                            if(s.startsWith(Commands.CLIENTS.getCommand())){
                                List<String> clients = Arrays.asList(s.replace(Commands.CLIENTS.getCommand(), "").split(" "));

                                controller.updateClientList(clients);
                                continue;
                            }

                            controller.addMessage(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        closeConnection();
                    }

                }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void closeConnection() {
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(out != null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String text) {
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if(out != null) {
                out.writeUTF(Commands.END_CHAT.getCommand());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registration(UserData user){
        String message;
        message = Commands.REGISTRATION.getCommand() + " " + user.getLogin() + " " + user.getPassword() + " " + user.getNick();
        sendMessage(message);
    }
}
