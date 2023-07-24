package com.example.youtubechannel.controller;

import com.example.youtubechannel.ChannelDetail;
import com.example.youtubechannel.to.ChannelTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private AnchorPane context;

    @FXML
    private Label lblCountry;

    @FXML
    private Label lblCustomURL;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblPublishedAt;

    @FXML
    private Label lblSubscribers;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblVideoCount;

    @FXML
    private Label lblViewCount;

    @FXML
    private TextField txtChannelId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearLabels();
    }

    @FXML
    void txtChannelIdOnAction(ActionEvent event) {

        if(txtChannelId.getText()!=null){
            ChannelTO channelTO = ChannelDetail.getChannelTO(txtChannelId.getText());

            if(channelTO!=null){
                lblTitle.setText(channelTO.getTitle());
                lblSubscribers.setText(channelTO.getSubscribers());
                lblPublishedAt.setText(channelTO.getPublishedAt());
                lblCustomURL.setText(channelTO.getCustomURL());
                lblCountry.setText(channelTO.getCountry());
                lblVideoCount.setText(channelTO.getVideoCount());
                lblViewCount.setText(channelTO.getViewCount());
                lblDescription.setText(channelTO.getDescription());
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Channel not found!");
                // Display the alert
                alert.showAndWait();
            }

        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearLabels();
    }

    private void clearLabels(){
        txtChannelId.setText(null);
        lblTitle.setText(null);
        lblSubscribers.setText(null);
        lblPublishedAt.setText(null);
        lblCustomURL.setText(null);
        lblCountry.setText(null);
        lblVideoCount.setText(null);
        lblViewCount.setText(null);
        lblDescription.setText(null);
    }


}
