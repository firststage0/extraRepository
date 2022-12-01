package ru.vsuet.bank;

import assets.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    protected static String loginText;
    @FXML
    void initialize() {

        SignUpButton.setOnAction(actionEvent -> {
            loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if(!loginText.equals("") && !password_field.equals("")){
                loginUser(loginText, loginPassword);
            } else
                System.out.println("Login and password is empty");
            RegisterButton.setOnAction(actionEvent1 -> {
                openNewScene("/ru/vsuet/bank/registerwindow.fxml");

            });
        });

        RegisterButton.setOnAction(actionEvent -> {
            RegisterButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ru/vsuet/bank/registerwindow.fxml"));

            try {
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
    private void openNewScene(String window) {
        RegisterButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

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

    private void loginUser(String loginText, String loginPassword) {
        Functions functions = new Functions();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        //dbHandler.getUser(user);

        ResultSet result = functions.getUser(user);

        int counter = 0;

        try {
            while(result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(counter >= 1){
            openNewScene("/ru/vsuet/bank/app.fxml");
        } else{
            Shake userLoginAnim = new Shake(login_field);
            Shake userPasswordAnim = new Shake(password_field);
            userLoginAnim.PlayAnim();
            userPasswordAnim.PlayAnim();
        }
    }

}
