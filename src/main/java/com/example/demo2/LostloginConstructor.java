package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import com.example.demo2.Check.*;

public class LostloginConstructor {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink SigninLink;

    @FXML
    private PasswordField passText;

    @FXML
    private TextField userText;

    @FXML
    private Button login;

    @FXML
    void initialize() {
        SigninLink.setOnAction(actionEvent -> {
            SigninLink.getScene().getWindow().hide();
            FXMLLoader forSignUp = new FXMLLoader(SignUpConstructor.class.getResource("signup-view.fxml"));
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
        });

        //

        login.setOnAction(actionEvent -> {
            if(!userText.getText().isEmpty() && !passText.getText().isEmpty()){
                String selectQuery = "SELECT password FROM users WHERE email = ?";
                try (Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL, DatabaseInfo.DB_USER, DatabaseInfo.DB_PASSWORD)) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                        preparedStatement.setString(1, userText.getText());
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            if(resultSet.next()){
                                int storedPassword = Integer.parseInt(resultSet.getString("password"));
                                int usersPassword  = passText.getText().hashCode();
                                    if(storedPassword == usersPassword){
                                        login.getScene().getWindow().hide();
                                        FXMLLoader forSignUp = new FXMLLoader(Controller.class.getResource("MainPage.fxml"));
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
                                    else new alertException().setAlert();
                            }
                            else new alertException().setAlert();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else{
                new alertException().setAlert();
            }
        });
    }

}
