package com.example.youtubechannel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeFormController {
    @FXML
    private AnchorPane context;

    @FXML
    void btnStart(ActionEvent event) {
        context.getChildren().clear();
        Stage stage = (Stage) context.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"))));
            stage.setTitle("YouTube Channel Detail");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
