package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.ControllerService;
import service.RegControllerService;

import java.net.URL;
import java.util.ResourceBundle;

public class RegController extends RegControllerService {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstNameField;

    @FXML
    private Button inHomeButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Label usernameAlreadyExists;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField secondNameField;

    @FXML
    void initialize() {
        signUpButton.setOnAction(actionEvent -> {
            String username = login_field.getText();
            String firstname = firstNameField.getText();
            String secondname = secondNameField.getText();
            String password = password_field.getText();
            int count = isUserAlreadyExists(username);
            if (count == 0){
                RegControllerService.signUpNewUser(username, password, firstname, secondname);
                signUpButton.getScene().getWindow().hide();
                ControllerService.openNewScene("/ru/vsuet/bank/mainwindow.fxml");
            } else {
                usernameAlreadyExists.setText("Такой пользователь уже существует");
            }
        });
        inHomeButton.setOnAction(actionEvent -> {
            inHomeButton.getScene().getWindow().hide();
            ControllerService.openNewScene("/ru/vsuet/bank/mainwindow.fxml");
        });
    }
}
