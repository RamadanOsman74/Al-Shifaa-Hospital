package com.example.demo;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class welcomecontrol {
    @FXML
    Button btnp , btnd , btnb ;

    public void openpatients (Event e) throws IOException {
        Node node = (Node) e.getSource() ;
        Stage stage =(Stage) node.getScene().getWindow() ;
        Parent root = FXMLLoader.load(getClass().getResource("patients.fxml")) ;
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
    public void opendoctors (Event e) throws IOException {
        Node node = (Node) e.getSource() ;
        Stage stage =(Stage) node.getScene().getWindow() ;
        Parent root = FXMLLoader.load(getClass().getResource("doctors.fxml")) ;
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void medicaltips(Event e) throws IOException {
        Node node = (Node) e.getSource() ;
        Stage stage =(Stage) node.getScene().getWindow() ;
        Parent root = FXMLLoader.load(getClass().getResource("medicaltips.fxml")) ;
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
    public void Back (Event e) throws IOException {
        Node node = (Node) e.getSource() ;
        Stage stage =(Stage) node.getScene().getWindow() ;
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml")) ;
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

}
