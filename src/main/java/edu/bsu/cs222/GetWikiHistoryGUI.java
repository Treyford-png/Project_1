package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetWikiHistoryGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
        stage.setScene(new Scene(root, 300, 275));
        stage.setTitle("Wikipedia Revision Retriever");
        stage.show();
    }
    public static void main(String[] args) {launch(args); }
    
    
}
