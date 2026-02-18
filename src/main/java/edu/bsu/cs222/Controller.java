package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public void Method(ActionEvent actionEvent) {
        String output = getOutput();
        Label label = new Label(output);
        StackPane stack = new StackPane(label);
        Scene scene = new Scene(stack, 300, 300);
        Stage popup = new Stage();
        popup.setTitle("Placeholder");
        popup.setScene(scene);
        popup.show();
    }

    public String getOutput(){
        return "this is an output";
    }
}
