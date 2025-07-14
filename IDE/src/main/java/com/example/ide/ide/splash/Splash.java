package com.example.ide.ide.splash;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Splash extends Application {

    @Override
    public void start(Stage splashStage) {
        Image splashImage = new Image(getClass().getResourceAsStream("/com/example/ide/ide/splash/splash.png"));
        
        ImageView logo = new ImageView(splashImage);
        logo.setPreserveRatio(true);

        
        double imgWidth = splashImage.getWidth();
        double imgHeight = splashImage.getHeight();

       
        StackPane layout = new StackPane(logo);
        layout.setStyle("-fx-background-color: transparent;");

        Scene scene = new Scene(layout, imgWidth, imgHeight);
        scene.setFill(null); 

        splashStage.initStyle(StageStyle.TRANSPARENT); 
        splashStage.setAlwaysOnTop(true); 
        splashStage.setScene(scene);

        
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        splashStage.setX((screenBounds.getWidth() - imgWidth) / 2);
        splashStage.setY((screenBounds.getHeight() - imgHeight) / 2);

        splashStage.show();

        
        PauseTransition delay = new PauseTransition(Duration.seconds(2.5));
        delay.setOnFinished(e -> {
            splashStage.close();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ide/ide/hello-view.fxml"));
                Parent root = loader.load();

                Scene mainScene = new Scene(root, 620, 540);
                mainScene.getStylesheets().add(getClass().getResource("/com/example/ide/ide/style.css").toExternalForm());

                Stage mainStage = new Stage();
                mainStage.setTitle("WELCOME TO ARUN IDE");
                mainStage.setScene(mainScene);
                mainStage.show();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        delay.play();
    }

    public static void main(String[] args) {
        launch();
    }
}
