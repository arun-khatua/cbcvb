package com.example.ide.ide.newproject;

import com.example.ide.ide.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class newprojectui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ide/ide/newproject/newproject.fxml")); // ✅ Correct path
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("New Project");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
