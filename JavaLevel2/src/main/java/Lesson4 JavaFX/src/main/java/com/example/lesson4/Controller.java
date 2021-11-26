package com.example.lesson4;

import com.example.lesson4.database.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class Controller {
    @FXML
    private Button singUpButton;
    @FXML
    private MenuItem logout;
    @FXML
    private MenuItem exit;
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
        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();

        if(!login.equals("") && !password.equals("")){
            client.sendMessage(Commands.AUTH.getCommand() + " " + login + " " + password );
        }
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

	public void btnSignUpClick(ActionEvent actionEvent) {
        UserData user;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SignUp.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

        System.out.println("Регистрация");
        SignupController signupController = loader.getController();
        user = signupController.getRegisterData();
        client.registration(user);
    }
}