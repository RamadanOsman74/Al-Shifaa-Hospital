package com.example.demo;
import javafx.event.Event;
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
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class patientFormCl implements Initializable {
    @FXML
    private TextField txtname ;
    @FXML
    private TextField txtid ;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtgender ;
    @FXML
    private TableView table ;
    @FXML
    private TableColumn namep ;
    @FXML
    private TableColumn idp ;
    @FXML
    private TableColumn agep ;
    @FXML
    private TableColumn genderp ;
    int id1 ;
    patientCl pat = new patientCl() ;
//    ObservableList<String > olType= FXCollections.observableArrayList() ;

    public void add() throws SQLException
    {
        patient pat1 = new patient() ;
        pat1.setName(txtname.getText());
        pat1.setId(Integer.parseInt(txtid.getText()));
        pat1.setAge(Integer.parseInt(txtage.getText()));
        pat1.setGender(txtgender.getText());
        pat.insert(pat1);
        table.setItems(pat.getAllpatient());
        txtname.setText("");
        txtid.setText("");
        txtage.setText("");
        txtgender.setText("");



    }

    public void delete () throws SQLException
    {
        id1=Integer.parseInt(txtid.getText());
        pat.delete(id1);
        table.setItems(pat.getAllpatient());
        txtname.setText("");
        txtid.setText("");
        txtage.setText("");
        txtgender.setText("");

    }
    patient pat3 = new patient() ;
    public void clicktable ()
    {
       patient pat3 = (patient) table.getSelectionModel().getSelectedItem();
        txtname.setText(pat3.getName());
        txtid.setText(pat3.getId()+"");
        txtage.setText(pat3.getAge()+"");
        txtgender.setText(pat3.getGender());
        id1 = pat3.getId();


    }



    public void initialize(URL location, ResourceBundle resource ){
        idp.setCellValueFactory(new PropertyValueFactory<>("id"));
        namep.setCellValueFactory(new PropertyValueFactory<>("name"));
        agep.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderp.setCellValueFactory(new PropertyValueFactory<>("gender"));

        try {
            table.setItems(pat.getAllpatient());
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
