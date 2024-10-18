package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.Event;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class doctorsFormCl implements Initializable {

        doctorsCl doc3 = new doctorsCl() ;

        @FXML
        private TextField txtname ;
        @FXML
        private TextField txtid ;
        @FXML
        private TextField txtage;
        @FXML
        private TextField txtss ;
        @FXML
        private TableView table ;
        @FXML
        private TableColumn named ;
        @FXML
        private TableColumn idd ;
        @FXML
        private TableColumn aged ;
        @FXML
       // private TableColumn sp ;
        int id1 ;
        doctorsCl doc = new doctorsCl() ;
        doctors doc1 = new doctors() ;

//    ObservableList<String > olType= FXCollections.observableArrayList() ;

        public void add() throws SQLException
        {
            doc1.setName(txtname.getText());
            doc1.setId(Integer.parseInt(txtid.getText()));

            doc1.setOffice(Integer.parseInt(txtage.getText()));
           // doc1.setSpecialization(txtss.getText());
            doc.insert(doc1);
            table.setItems(doc3.getAlldoctors());
            txtname.setText("");
            txtid.setText("");
            txtage.setText("");
        }

        public void delete () throws SQLException
        {
            id1=Integer.parseInt(txtid.getText());
            doc.delete(id1);
            table.setItems(doc3.getAlldoctors());
            txtname.setText("");
            txtid.setText("");
            txtage.setText("");
            txtss.setText("");

        }

        public void clicktable (Event e)
        {
            doctors doc2 = (doctors) table.getSelectionModel().getSelectedItem();

            txtname.setText(doc2.getName());
            txtid.setText(doc2.getId()+"");
            txtage.setText(doc2.getOffice()+"");

            id1 = doc2.getId();


        }



        public void initialize(URL location, ResourceBundle resource ){
            idd.setCellValueFactory(new PropertyValueFactory<>("id"));
            named.setCellValueFactory(new PropertyValueFactory<>("name"));
            aged.setCellValueFactory(new PropertyValueFactory<>("office"));
          //  sp.setCellValueFactory(new PropertyValueFactory<>("spp"));

            try {
                table.setItems(doc3.getAlldoctors());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }


    public void Back (Event e) throws IOException {
        Node node = (Node) e.getSource() ;
        Stage stage =(Stage) node.getScene().getWindow() ;
        Parent root = FXMLLoader.load(getClass().getResource("Home .fxml")) ;
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }




    }


