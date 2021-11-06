package com.example.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private TextField message;
    @FXML
    private TextArea messageArea;
    private Client client;

    public HelloController() {
        client = new Client(this);
    }

    @FXML
    protected void onSendButtonClick() {
        String text = message.getText().trim();
        if(text.isEmpty()){
            return;
        }
//        messageArea.appendText(text + "\n");
        client.sendMessage(text);
        message.clear();
        message.requestFocus();
    }

    public void exitMenuSelect(ActionEvent actionEvent) {
        client.close();
        System.exit(0);
    }


    public void addMessage(String s) {
        messageArea.appendText(s + "\n");
    }
}