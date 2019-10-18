package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import sample.service.MultiplicationService;
import sample.service.impl.defaultMultiplicationService;
import sample.utils.AlertUtil;

public class Controller {

    @FXML
    private TextField numberField;

    @FXML
    private TextField multiplierField;

    @FXML
    private Button submit;

    @FXML
    private Label multiplicationResult;

    private int number;
    private int multiplier;

    private MultiplicationService multiplicationService;

    public Controller() {
        multiplicationService = new defaultMultiplicationService();
    }

    @FXML
    protected void handleMultiplyAction(ActionEvent event) {
        Window owner = submit.getScene().getWindow();
        if (isValidInput(numberField, multiplierField)){
        try {
            number = getTextFieldNumericValue(numberField);
            multiplier = getTextFieldNumericValue(multiplierField);
            multiplicationResult.setText(String.valueOf(multiplicationService.multiply(number,multiplier)));
        }catch (NumberFormatException e) {
            AlertUtil.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter numeric values only");

        }
        }else {
            AlertUtil.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Enter two numbers");
        }
    }

    private boolean isValidInput(TextField numberField, TextField multiplierField) {
        return !numberField.getText().isEmpty() && !multiplierField.getText().isEmpty();
    }

    private int getTextFieldNumericValue(TextField textField) {
        return Integer.parseInt(textField.getText());
    }
}
