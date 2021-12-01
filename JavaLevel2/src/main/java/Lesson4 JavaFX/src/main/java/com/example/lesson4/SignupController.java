package com.example.lesson4;

import com.example.lesson4.database.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField loginSignUp;

    @FXML
    private TextField nickSignUp;

    @FXML
    private PasswordField passwordSignUp;

    @FXML
    private Button signUpButton;


    @FXML
    void initialize() {

    }

    public void signUpBtnClick(ActionEvent actionEvent) {

        signUpButton.getScene().getWindow().hide();
    }

    public UserData getRegisterData(){
        String login = loginSignUp.getText().trim();
        String password = passwordSignUp.getText().trim();
        String nick = nickSignUp.getText().trim();
        UserData user = new UserData(login, password, nick);
        return user;
    }
}


