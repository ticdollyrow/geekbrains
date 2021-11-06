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

    public static void main(String[] args) {
        Socket socket = null;

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Ожидаем подключение клиента");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            //обработчики входящего и исходящего потока
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true){
                String s = dataInputStream.readUTF();
                if(s.equals(END)){
                    dataOutputStream.writeUTF(END);
                    break;
                }
                System.out.println(s);
                dataOutputStream.writeUTF("Клиент: " + s);

                sendMessage(dataOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(DataOutputStream out) {
        Scanner scan = new Scanner(System.in);
        String next = scan.next();
        if(! next.isEmpty()) {
            try {
                out.writeUTF("Server: " + next);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
