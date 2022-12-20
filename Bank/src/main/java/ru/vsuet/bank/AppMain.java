package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import service.ControllerService;

import java.net.URL;
import java.util.ResourceBundle;


public class AppMain extends LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button inHomeButton;

    @FXML
    private URL location;

    @FXML
    private Button addMoneyButton;

    @FXML
    private Button createCheckButton;

    @FXML
    private Button deleteCheckButton;

    @FXML
    private Button getHistoryOperationButton;

    @FXML
    private Button getMoneyButton;

    @FXML
    private Button moneyToCheckButton;
    @FXML
    private ImageView HomeButton;
    @FXML
    private Text AppUserName;

    @FXML
    void initialize() {
        AppUserName.setText(loginText);

        inHomeButton.setOnAction(actionEvent -> {
            inHomeButton.getScene().getWindow().hide();
            ControllerService.openNewScene("/ru/vsuet/bank/mainwindow.fxml");
        });

        createCheckButton.setOnAction(actionEvent -> {
            ControllerService.openNewScene("/ru/vsuet/bank/createcheck.fxml");
        });

        deleteCheckButton.setOnAction(actionEvent -> {
            ControllerService.openNewScene("/ru/vsuet/bank/deletecheck.fxml");
        });

    }

}
