package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CreateCheck {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createCheckButton;

    @FXML
    private TextField checkNumber;

    private Long userId;
    private String Search;

    @FXML
    void initialize() {
        createCheckButton.setOnAction(actionEvent -> {
            String checkName = checkNumber.getText().trim();
            DBHandler dbHandler = new DBHandler();
            String query = "select * from " + Const.USERS_TABLE;
            try {
                Statement statement = dbHandler.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    Search = resultSet.getString("username");
                    if(Search.equals(AppMain.loginText)){
                        userId = resultSet.getLong("idusers");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            String insert = "insert into accounts(idaccounts, checkNumber, money) values(?,?,?)";
            try {
                PreparedStatement prst = dbHandler.getConnection().prepareStatement(insert);
                prst.setString(1, String.valueOf(userId));
                prst.setString(2, checkName);
                prst.setString(3, String.valueOf(0));

                prst.executeUpdate();
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
            System.out.println(userId);
        });
    }


}
