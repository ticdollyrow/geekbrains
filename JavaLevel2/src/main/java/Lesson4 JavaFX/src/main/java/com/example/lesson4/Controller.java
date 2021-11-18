package com.example.lesson4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ListView<String> clientList;
    @FXML
    private HBox messageBox;
    @FXML
    private HBox loginBox;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField loginField;
    @FXML
    private TextField message;
    @FXML
    private TextArea messageArea;
    private Client client;

    public Controller() {
        client = new Client(this);
    }

    @FXML
    protected void onSendButtonClick() {
        String text = message.getText().trim();
        if(text.isEmpty()){
            return;
        }

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

    public void btnAuthClick(ActionEvent actionEvent) {
        client.sendMessage(Commands.AUTH.getCommand() + " " + loginField.getText() + " " + passwordField.getText() );
    }

    public void setAuth(boolean isAuthorisated){
        loginBox.setVisible(!isAuthorisated);
        messageBox.setVisible(isAuthorisated);

        loginBox.managedProperty().bind(loginBox.visibleProperty());
    }

    public void logOutMenuSelect(ActionEvent actionEvent) {

        client.sendMessage(Commands.LOG_OUT.getCommand());
    }

    public void selectClient(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            String messageText= message.getText();
            String nick = clientList.getSelectionModel().getSelectedItem();
            message.setText(Commands.PRIVATE_MESSAGE.getCommand() + " " + nick + " " + messageText);
            message.requestFocus();
            message.selectEnd();
        }
    }

    public void updateClientList(List<String> clients) {
        clientList.getItems().clear();
        clientList.getItems().addAll(clients);

    }
}