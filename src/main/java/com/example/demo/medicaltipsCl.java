package com.example.demo;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class medicaltipsCl {

    public void Back1 (Event e) throws IOException {
        Node node = (Node) e.getSource() ;
        Stage stage =(Stage) node.getScene().getWindow() ;
        Parent root = FXMLLoader.load(getClass().getResource("Home .fxml")) ;
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }


}
