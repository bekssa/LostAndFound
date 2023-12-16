package com.example.demo2;

import com.example.demo2.model.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private GridPane postSetter;
    @FXML
    private Button addPostButton;

    private List<Post> addedPosts;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addedPosts = new ArrayList<>(addedPost());
        int column = 0;
        int row = 1;
        try{
            for (Post addedPost : addedPosts) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Post.fxml"));
                VBox vBox = fxmlLoader.load();
                PostController postController = fxmlLoader.getController();
                postController.setPost(addedPost);
                if (column == 3) {
                    column = 0;
                    row++;
                }
                postSetter.add(vBox,column++, row);
                GridPane.setMargin(vBox, new Insets(10));

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Post> addedPost(){
        List<Post> posts = new ArrayList<>();


        Post post = new Post("Lost","/Изображения/SavedPictures/LostMan.jpg","I have lost this man please help me((( i wanna check the text area certain check the correct work wrap method", "Ben Sam");
        Post post2 = new Post("Found","/Изображения/SavedPictures/LostBattery.jpg","I have lost my phone battery plese help me(((", "Ben Sam");
        Post post3 = new Post("Lost", "/Изображения/SavedPictures/LostPhone.jpg", "щщс телефон жогалп калд", "Some Man" );
        Post post4 = new Post("Lost" ,"/Изображения/SavedPictures/SearchingIcon.jpg", "ishu sebya", "Zabytyi");


        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        return posts;
    }
    @FXML
    void newPostView(ActionEvent event) throws IOException {
        Stage stage = (Stage)addPostButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddPost.fxml"));
        primaryStage.setScene(new Scene(root, 810,500));
        primaryStage.show();

    }
}
