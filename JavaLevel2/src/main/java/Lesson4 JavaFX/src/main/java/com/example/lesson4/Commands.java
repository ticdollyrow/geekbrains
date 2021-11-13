package com.example.lesson4;

public enum Commands {

    END_CHAT("/end"),
    AUTH("/auth"),
    AUTH_OK("/authok"),
    PRIVATE_MESSAGE("/w"),
    LOG_OUT("/logout");

    private String command;

    Commands(String command){
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
