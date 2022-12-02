package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AppMain extends Controller{

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
            FXMLLoader loader = new FXMLLoader();
            inHomeButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/ru/vsuet/bank/mainwindow.fxml"));

            try{
                loader.load();
            }   catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        createCheckButton.setOnAction(actionEvent -> {
            createCheckButton.getScene().getWindow().hide();
            openNewScene();
        });

    }

    private void openNewScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ru/vsuet/bank/createcheck.fxml"));
        try{
            loader.load();
        }   catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
