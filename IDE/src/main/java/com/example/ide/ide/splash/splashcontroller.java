package com.example.ide.ide.splash;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class splashcontroller {

    @FXML
    private Label loadingLabel;

    @FXML
    public void initialize() {
        loadingLabel.setText("Loading IntelliJ File Chooser...");

        PauseTransition delay = new PauseTransition(Duration.seconds(2.5));
        delay.setOnFinished(event -> {
           
            Stage stage = (Stage) loadingLabel.getScene().getWindow();
            stage.close();

            // TODO: Launch main app window here
            // new IntelliJFileChooserFX().start(new Stage());
        });
        delay.play();
    }
}
