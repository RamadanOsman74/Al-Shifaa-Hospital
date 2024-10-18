package com.example.demo;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginForm_CL {
    @FXML
    TextField txtUser ;
    @FXML
    PasswordField pass ;
    @FXML
    Button btnSign ;
    @FXML
    Label lblMSG ;
    Admin ad = new Admin ();
    logincon lg = new logincon() ;
    public void isSign (Event e) throws SQLException, IOException {
        ad.setUsername(txtUser.getText());
        ad.setPassword(pass.getText());
        if (lg.islogin(ad))
        {
            Node node = (Node) e.getSource() ;
            Stage stage =(Stage) node.getScene().getWindow() ;
            Parent root = FXMLLoader.load(getClass().getResource("Home .fxml")) ;
            Scene scene = new Scene(root) ;
            stage.setScene(scene);
            stage.show();


        }
        else {

            lblMSG.setText("UserName or Password is wrong") ;
        }



    }

}
