package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    double x,y=0;
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root, 1080, 720);
            stage.initStyle(StageStyle.UNDECORATED);
            /*
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y= event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);

        });
    */
        stage.setTitle("The Bomb Benchmark");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}