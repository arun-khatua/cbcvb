package com.example.ide.ide;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;

public class FileChooserController {

    @FXML
    private TextField pathField;

    @FXML
    private ListView<File> fileListView;

    private File currentDir;

    @FXML
    public void initialize() {
        currentDir = new File(System.getProperty("user.home")); // start dir
        updateFileList(currentDir);

        fileListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                File selected = fileListView.getSelectionModel().getSelectedItem();
                if (selected != null && selected.isDirectory()) {
                    updateFileList(selected);
                }
            }
        });
    }

    private void updateFileList(File dir) {
        if (dir != null && dir.exists()) {
            currentDir = dir;
            pathField.setText(dir.getAbsolutePath());

            File[] files = dir.listFiles();
            ObservableList<File> fileList = FXCollections.observableArrayList();
            if (files != null) {
                Arrays.sort(files);
                fileList.addAll(files);
            }
            fileListView.setItems(fileList);
        }
    }

    @FXML
    private void handleCancel() {
        ((Stage) pathField.getScene().getWindow()).close();
    }

    @FXML
    private void handleSelect() {
        File selected = fileListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            System.out.println("Selected file: " + selected.getAbsolutePath());
            // you can return this value to caller class via static/shared var
        }
        ((Stage) pathField.getScene().getWindow()).close();
    }
}
