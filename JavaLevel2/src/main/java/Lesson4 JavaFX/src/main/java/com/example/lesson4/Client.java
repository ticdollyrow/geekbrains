package com.example.lesson4;

import com.example.lesson4.database.UserData;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.io.RandomAccessFile;

public class Client {
    final static int PORT = 8190;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Controller controller;
    private BufferedWriter historyWriter;

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

                        while (true) {
                            String s = in.readUTF();

                            String msgAuth = s;
                            if(msgAuth.startsWith(Commands.AUTH_OK.getCommand())){
                                String[] split = msgAuth.split(" ");
                                final String nick = split[1];

                                readHistory(nick);
                                controller.addMessage("успешная авторизация под ником " + nick);
                                controller.setAuth(true);


                                openWriter(nick);
                                continue;
                            }

                            if(Commands.END_CHAT.getCommand().equals(s)){
                                break;
                            }

                            if(Commands.LOG_OUT.getCommand().equals(s)){
                                controller.setAuth(false);
                                closeWriter();
                                continue;
                            }

                            if(s.startsWith(Commands.CLIENTS.getCommand())){
                                List<String> clients = Arrays.asList(s.replace(Commands.CLIENTS.getCommand(), "").split(" "));

                                controller.updateClientList(clients);
                                continue;
                            }

                            controller.addMessage(s);
                            System.out.println(s);
                            historyWriter.write(s + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                       closeConnection();
                    }

                }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    private void closeConnection() {
        closeWriter();

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

    private void openWriter(String nick){
        String fileName = "HISTORY_" + nick + ".txt";
        try {
            historyWriter = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void closeWriter(){
        if(historyWriter != null){
            try {
                historyWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void readHistory(String nick){
        String fileName = "HISTORY_" + nick + ".txt";
        int countLines = 0;
        StringBuilder builder = new StringBuilder();
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {

            long length = raf.length() - 1;
            System.out.println(length);
            while (length > 0 && countLines < 100) {
                raf.seek(length);
                char c = (char) raf.read();
                System.out.println(c);
                if(c == '\n'){
                    countLines++;
                }
                builder.append(c);
                length--;
            }

            builder.reverse();
            controller.addMessage(builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
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
