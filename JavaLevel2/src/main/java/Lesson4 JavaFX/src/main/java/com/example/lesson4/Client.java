package com.example.lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    final static int PORT = 8190;
    private static String END = "/end";
    private boolean flagExit = false;

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private HelloController controller;

    public Client(HelloController controller) {
        this.controller = controller;
        openConnection();
    }

    private void openConnection(){
        try {
            socket = new Socket("localhost", PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new  Thread(new Runnable() {
                @Override
                public void run() {

                        try {
                            while (true) {
                                String s = in.readUTF();
                                if( END.equals(s)){
                                    controller.addMessage(END);
                                    break;
                                }
                                controller.addMessage(s);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            closeConnection();
                            controller.addMessage("диалог окончен");
                            flagExit = true;
                        }

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
        if(flagExit) {
            return;
        }
        try {
            out.writeUTF(END);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
