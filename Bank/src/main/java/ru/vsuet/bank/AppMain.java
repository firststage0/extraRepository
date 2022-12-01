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
    private ImageView HomeButton;
    @FXML
    private Text AppUserName;

    @FXML
    void initialize() {
        //DBHandler dbHandler = new DBHandler();
        AppUserName.setText(loginText);
        inHomeButton.setOnAction(actionEvent -> {
            inHomeButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
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
    }

}
