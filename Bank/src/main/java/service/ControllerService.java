package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.Functions;
import ru.vsuet.bank.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerService {

    private final Functions functions;

    public ControllerService(Functions functions) {
        this.functions = functions;
    }

    public boolean checkUser(String loginText, String loginPassword) {

        if (!(loginText.isBlank() || loginPassword.isBlank())) {
            int counter = loginUser(loginText, loginPassword);
            if (counter > 0) {
                return true;
            }
        } else {
            System.out.println("Login and password is empty");
        }
        return false;
    }

     public static void openNewScene(String window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ControllerService.class.getResource(window));

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

    public int loginUser(String loginText, String loginPassword) {
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);

        ResultSet result = functions.getUser(user);

        int counter = 0;

        try {
            while(result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
