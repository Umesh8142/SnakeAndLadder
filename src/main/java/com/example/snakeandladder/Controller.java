package com.example.snakeandladder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {

    @FXML
    public void Start (MouseEvent event) throws IOException {
        AnchorPane Start = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
        HelloApplication.root.getChildren().setAll(Start);

    }
}
