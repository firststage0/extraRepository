package ru.vsuet.bank;

import assets.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.BankApplication;
import sample.UserService;
import service.ControllerService;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registerButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;
    @FXML
    void initialize() {
        BankApplication bankApplication = BankApplication.getInstance();
        UserService userService = bankApplication.getUserService();

        signUpButton.setOnAction(actionEvent -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();
            User user = userService.login(loginText, loginPassword);
            bankApplication.setActiveUser(user);
            ControllerService.openNewScene("/ru/vsuet/bank/app.fxml");
        });

        registerButton.setOnAction(actionEvent1 -> {
            signUpButton.getScene().getWindow().hide();
            ControllerService.openNewScene("/ru/vsuet/bank/registerwindow.fxml");
        });
    }

    public void Anim(){
        Shake userLoginAnim = new Shake(login_field);
        Shake userPasswordAnim = new Shake(password_field);
        userLoginAnim.PlayAnim();
        userPasswordAnim.PlayAnim();
    }

}
