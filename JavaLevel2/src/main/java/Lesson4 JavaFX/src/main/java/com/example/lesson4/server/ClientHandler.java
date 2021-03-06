package com.example.lesson4.server;

import com.example.lesson4.Commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final DataInputStream in;
    private final DataOutputStream out;
    private final Socket socket;
    private final Server server;
    private String nick;
    private boolean isLogIn = false;

    public ClientHandler(Socket socket, Server server){

        try {
            this.nick = "";
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());


//            new Thread(() -> {
//                try {
//                    commandProcessing();
//                }finally {
//                    closeConnection();
//                }
//            }).start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void commandProcessing() {
//        authenticate();
        readMessages();
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

                if(!isLogIn){
                    authenticate();
                    if(!isLogIn){

                        break;
                    }
                    continue;
                }


               String msg = in.readUTF();

                if(msg.equals(Commands.END_CHAT.getCommand())){
                    sendMessage(Commands.END_CHAT.getCommand());
                    break;
                }

                if(msg.equals(Commands.LOG_OUT.getCommand())){
                    sendMessage(Commands.LOG_OUT.getCommand());
                    isLogIn = false;
                    server.unsubscribe(this);
                    continue;
                }

                //???????????????? ?????????????? ??????????????????
                if(msg.startsWith(Commands.PRIVATE_MESSAGE.getCommand())){
                    String[] split = msg.split(" ");
                    String nickTo = split[1];
                    int beginMessageIndex = Commands.PRIVATE_MESSAGE.getCommand().length() + 2 + nickTo.length();
                    msg = msg.substring(beginMessageIndex);
                    server.sendToUser(this, msg, nickTo);
                    continue;
                }
                server.broadcast(nick + " " + msg);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void registration(String login, String pass, String nick ){
        System.out.println("ClientHandler ??????????????????????");
        server.getAuthService().registerNewUser(login, pass, nick);
    }

    private void authenticate() {
        System.out.println("??????????????????????");
        long startTime = System.currentTimeMillis();
        long timeOut = 0;
        int available = 0;
        String strClient = "";
        while (true) {
            try {
                while (timeOut < 120 * 1000){
                   available = in.available();
                   if(available > 0){
                       break;
                   }
                   timeOut = System.currentTimeMillis() - startTime;
                }
                if(available == 0){
                    System.out.println("?????????? ???? ??????????????");
                    break;
                }else{
                    startTime = System.currentTimeMillis();
                }

                strClient = in.readUTF();
                System.out.println(strClient);

                if(strClient.startsWith(Commands.REGISTRATION.getCommand())) {

                    String[] split = strClient.split(" ");
                    String login = split[1];
                    String pass = split[2];
                    String nick = split[3];
                    registration(login, pass, nick);
                    continue;
                }

                if (strClient.startsWith(Commands.AUTH.getCommand())) {
                    String[] split = strClient.split(" ");
                    if (split.length == 3) {
                        String login = split[1];
                        String pass = split[2];
                        String nick = server.getAuthService().getNickByLoginAndPassword(login, pass);
                        if (nick != null) {
                            if (server.isNickBusy(nick)) {
                                sendMessage("???????????????????????? ?????? ??????????????????????");
                                continue;
                            }

                            sendMessage(Commands.AUTH_OK.getCommand() + " " + nick);
                            this.nick = nick;
                            server.subscribe(this);
                            server.broadcast("???????????????????????? " + nick + " ?????????? ?? ??????");
                            isLogIn = true;
                            break;
                        }
                    } else {
                        sendMessage("???????????????? ??????????/????????????");
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

    @Override
    public void run() {
        try {
            commandProcessing();
        }finally {
            closeConnection();
        }
    }
}
