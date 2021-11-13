package com.example.lesson4.server;

public interface AuthService {

    String getNickByLoginAndPassword(String login, String password);
}
