package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static edu.bsu.cs222.GetJson.jsonFromName;

public class Controller {
    @FXML
    private TextField textbox;

    @FXML
    public void controller(ActionEvent actionEvent) {
        String input = textbox.getText();
        String output = getOutput(input);

        Label label = new Label(output);
        StackPane stack = new StackPane(label);
        Scene scene = new Scene(stack, 300, 300);
        Stage popup = new Stage();
        popup.setTitle("Wikipedia Revision History");
        popup.setScene(scene);
        popup.show();
    }

    public String getOutput(String input){
        if (input.isEmpty()) { // Handles no input
            return "Error 400: bad request";
        }

        // Gets JSON
        SwitchString jsonSwitchString = jsonFromName(input);
        if (jsonSwitchString.isStringOrError() == StringOrError.ERROR) { // Filters out errors
            return jsonSwitchString.getString();
        }

        // Gets output
        JsonParser jsonParser = new JsonParser(jsonSwitchString);
        return jsonParser.getArticle().print();
    }
}
