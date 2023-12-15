package com.example.demo2.Check;

import javafx.scene.control.*;

public class alertException {
    public void setAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Invalid data!");
        alert.setContentText("Something went wrong!");
        alert.showAndWait();
    }
}
