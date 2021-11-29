package com.example.lesson4.server;

public interface AuthService {

    String getNickByLoginAndPassword(String login, String password);

    void registerNewUser(String login, String password, String nick);
}
