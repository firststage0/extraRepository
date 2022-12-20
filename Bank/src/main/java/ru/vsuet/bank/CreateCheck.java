package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.CreateCheckService;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateCheck extends CreateCheckService{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createCheckButton;

    @FXML
    private TextField checkNumber;

    @FXML
    private Text checkAlreadyExistText;

    @FXML
    void initialize() {
        createCheckButton.setOnAction(actionEvent -> {
            String loginText = AppMain.loginText;
            String checkName = checkNumber.getText().trim();
            if (checkName.equals("")){
                checkAlreadyExistText.setText("Вы не ввели номер счета");
            } else{
                int count = CreateCheckService.isCheckExist(checkName);
                if (count == 0) {
                    CreateCheckService.createCheck(checkName, loginText);
                    checkAlreadyExistText.setText("Счет создан");
                } else {
                    checkAlreadyExistText.setText("Такой счет уже существует");
                }
            }

        });
    }


}
