package com.example.ide.ide;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button open_button;

    @FXML
    private Button new_button;
    @FXML
    private Label open_buton;

    @FXML
    protected void openbutton() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("filechooser.fxml"));
            Parent root = loader.load();

            // Create new scene
            Scene scene = new Scene(root);

            // Create new stage (window)
            Stage newStage = new Stage();
            newStage.setTitle("Second Window"); // Set the window title

            // Set the scene in new window
            newStage.setScene(scene);

            // Show the new window
            newStage.show();

        } catch (IOException e) {
            System.err.println("Error loading second-view.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    private void newbutton( ) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ide/ide/newproject/newproject.fxml")); // ✅ Correct location
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("New Project");
            stage.setResizable(false);
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}