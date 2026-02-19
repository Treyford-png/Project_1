package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static edu.bsu.cs222.GetJson.jsonFromName;

/**
 * Handles the input/output for the application
 *
 * @author Treyford Mercer
 * @author Holden Hankins
 */
public class Controller {
    @FXML
    private TextField inputBox;
    @FXML
    private TextArea outputBox;

    @FXML
    public void controller(ActionEvent actionEvent) {
        String input = inputBox.getText();
        String output = getOutput(input);
        outputBox.setText(output);
    }

    /**
     * Runs main commands needed to produce list for user
     * @param input string
     * @return 15 newest revisions and if there was a redirection
     */
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