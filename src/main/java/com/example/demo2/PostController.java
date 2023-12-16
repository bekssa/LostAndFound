package com.example.demo2;

import com.example.demo2.model.Post;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PostController {
    @FXML
    private ImageView imageIcon;

    @FXML
    private TextArea commentArea;

    @FXML
    private TextField fullNameField;

    @FXML
    private Label statusType;

    public void setPost(Post post) {
        commentArea.setWrapText(true);
        statusType.setText(post.getStatusType());
        commentArea.setText(post.getComment());
        fullNameField.setText(post.getAuthor());
        Image image = new Image(getClass().getResourceAsStream(post.getImagePath()));
        imageIcon.setImage(image);
    }

}
