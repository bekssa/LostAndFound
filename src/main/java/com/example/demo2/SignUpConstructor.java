package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.demo2.Check.*;
public class SignUpConstructor {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;
    @FXML
    private Button signup;

    @FXML
    private PasswordField password;
    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;

    @FXML
    void initialize() {
            back.setOnAction(actionEvent -> backToLogin(back));
            //
            signup.setOnAction(actionEvent -> {
                InsertUsers insertUsers = new InsertUsers();
                String passHash = Integer.toString(password.getText().hashCode());
                if(new isCorrect().isCorrectAll(name.getText(),lastname.getText(),password.getText(),email.getText())) {
                    insertUsers.insert(name.getText(), lastname.getText(),passHash, email.getText());
                    new confirmException().setConfirm();
                    backToLogin(signup);
                }
                else
                    new alertException().setAlert();
            });

    }
    private void backToLogin(Button button){
        button.getScene().getWindow().hide();
        FXMLLoader forSignUp = new FXMLLoader(LostloginConstructor.class.getResource("login-view.fxml"));
        try {
            forSignUp.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = forSignUp.getRoot();
        Stage stage = new Stage();
        stage.setTitle("LostAndFound");
        stage.setScene(new Scene(root));
        stage.show();

    }
}
