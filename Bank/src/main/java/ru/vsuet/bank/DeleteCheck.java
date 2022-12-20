package ru.vsuet.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.DeleteCheckService;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCheck extends DeleteCheckService {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text checkDeleteSuccessfull;

    @FXML
    private Text checkDoesntExist;

    @FXML
    private TextField checkNumber;

    @FXML
    private Button deleteCheckButton;

    private int isCheckDeleted;
    @FXML
    void initialize() {
        deleteCheckButton.setOnAction(actionEvent -> {
            String checkName = checkNumber.getText().trim();
            DeleteCheckService.Delete(checkName);
            checkDeleteSuccessfull.setText("Счет успешно удален");
        });
    }
}
