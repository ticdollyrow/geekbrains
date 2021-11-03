package com.example.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField message;
    @FXML
    private TextArea messageArea;
    @FXML
    protected void onSendButtonClick() {
        String text = message.getText();
        if(text.isEmpty()){
            return;
        }
        messageArea.appendText(text + "\n");
        message.clear();
        message.requestFocus();
    }

    public void exitMenuSelect(ActionEvent actionEvent) {
        System.exit(0);
    }
}