package com.example.lesson4.server;

import com.example.lesson4.database.DatabaseHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthServiceImpl implements AuthService {

    private final DatabaseHandler databaseHandler;

    private static class UserData{
        private final String login;
        private final String password;
        private final String nick;

        private UserData(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }


    public AuthServiceImpl( DatabaseHandler databaseHandler ) {
        this.databaseHandler = databaseHandler;
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        try {
            return databaseHandler.getUserData(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void registerNewUser(String login, String password, String nick){
        try {
            databaseHandler.signUpUser(login, password,nick);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
