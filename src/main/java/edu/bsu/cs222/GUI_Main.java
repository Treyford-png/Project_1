package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI_Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
        System.out.println(getClass().getResource("/GUI.fxml"));
        stage.setScene(new Scene(root, 300, 275));
        stage.setTitle("Hello World");
        stage.show();
    }
    public static void main(String[] args) {launch(args); }
    
    
}
