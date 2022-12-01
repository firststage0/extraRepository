package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FirstNameField;

    @FXML
    private Button inHomeButton;
    @FXML
    private Button SignUpButton;

    @FXML
    private Label UsernameAlreadyExists;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField secondNameField;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(actionEvent -> {
           IsUserAlreadyExists();
        });
    }
    private void SignUpNewUser(String username, String password, String firstname, String secondname) {
        //DBHandler dbHandler = new DBHandler();
        Functions functions = new Functions();
        User user = new User(username, password, firstname, secondname);

        functions.signUpUser(user);
    }

    private void IsUserAlreadyExists(){

        String username = login_field.getText();
        String firstname = FirstNameField.getText();
        String secondname = secondNameField.getText();
        String password = password_field.getText();
        int count = 0;
        DBHandler dbHandler = new DBHandler();
        String query = "SELECT * FROM " + Const.USERS_TABLE;
        try {
            Statement statement = dbHandler.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(count + " in try");
            while(resultSet.next()){
                String userSearch = resultSet.getString("username");
                if(userSearch.equals(username)){
                    count++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(count >= 1){
            UsernameAlreadyExists.setText("Такой пользователь уже существует");

        } else{
            SignUpNewUser(username, firstname, secondname, password);

            SignUpButton.getScene().getWindow().hide();

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

        }
        System.out.println(count + " check after");
    }
}
