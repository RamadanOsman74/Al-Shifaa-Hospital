package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class patientCl implements interface_add_delete {
    Statement state;


    public void insert(patient pat) throws SQLException {

        state = connectionDB.openconnection().createStatement();
        state.executeUpdate("INSERT INTO `patients`(`name`, `id`, `age`, `gender`) VALUES ('"+pat.getName()+"','"+pat.getId()+"','"+pat.getAge()+"','"+pat.getGender()+"')");
        connectionDB.closeconnection();
    }

    public void delete(int id) throws SQLException {

        state = connectionDB.openconnection().createStatement();
        state.executeUpdate("DELETE FROM `patients` WHERE  id= + '"+id+"'");
        connectionDB.closeconnection();
    }

    public ObservableList<patient> getAllpatient() throws SQLException {
        ObservableList patient = FXCollections.observableArrayList();
        try {
            state = connectionDB.openconnection().createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM patients");

            while (result.next()) {
                com.example.demo.patient obj = new patient();
                obj.setName(result.getString(1));
                obj.setId(result.getInt(2));
                obj.setAge(result.getInt(3));
                obj.setGender(result.getString(4));

                patient.add(obj);

            }
            connectionDB.closeconnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }


}


