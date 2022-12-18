package com.example.snakeandladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GamePageLoader {
    public AnchorPane root;
    GamePageLoader() throws  IOException {
        root= FXMLLoader.load(getClass().getResource("SnakeAndLadder.fxml"));

    }
}
