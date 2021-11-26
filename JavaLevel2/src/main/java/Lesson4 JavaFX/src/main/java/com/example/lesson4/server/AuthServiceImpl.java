package com.example.lesson4.server;

import java.util.ArrayList;
import java.util.List;

public class AuthServiceImpl implements AuthService {

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

    private final List<UserData> users;

    public AuthServiceImpl( ) {
        this.users = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            this.users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {

        for (UserData user : users) {
            if(user.login.equals(login) && user.password.equals(password)){
                return  user.nick;
            }
        }
        return null;
    }
}
