package com.example.lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private final static int PORT = 8190;
    private final static String END = "/end";
    private static volatile boolean flagExit = false;

    public static void main(String[] args) {
        Socket socket = null;

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Ожидаем подключение клиента");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            //обработчики входящего и исходящего потока
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    sendClientMessage(dataInputStream, dataOutputStream);
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    sendMessage(dataOutputStream);
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void sendMessage(DataOutputStream out) {
        Scanner scan = new Scanner(System.in);

        while (!flagExit) {
            String next = scan.nextLine();
            if (!next.isEmpty()) {
                try {
                    if (next.equals(END)) {
                        out.writeUTF(END);
                        flagExit = true;
                        break;
                    }
                    out.writeUTF("Server: " + next);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        scan.close();
    }

    private static void sendClientMessage(DataInputStream in, DataOutputStream out){
        try{
            while (!flagExit) {

                String strClient = in.readUTF();
                System.out.println(strClient);
                if (strClient.equals(END)) {
                    out.writeUTF(END);
                    flagExit = true;
                    break;
                }
                out.writeUTF("Клиент: " + strClient);

            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
