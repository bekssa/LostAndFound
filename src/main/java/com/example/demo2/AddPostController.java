package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPostController  implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Button acceptButton;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextArea commentArea;


    @FXML
    private ImageView imageIcon;

    @FXML
    private Button openFileButton;

    @FXML
    private TextField pathArea;

    @FXML
    void fileHandle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(null);
        try {
            Image image = new Image(file.getAbsolutePath());
            pathArea.setText(file.getAbsolutePath());
            imageIcon.setImage(image);
        }catch (NullPointerException ex){

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(FXCollections.observableArrayList("Lost", "Found"));
    }
}
