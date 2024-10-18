package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class doctorsCl implements interface_add_delete {
        Statement state;
        public void insert(doctors doc) throws SQLException {

            state = connectionDB.openconnection().createStatement();
            state.executeUpdate("INSERT INTO `doctors` (`name`, `id`, `office`)VALUES('"+doc.getName()+"','"+doc.getId()+"','"+doc.getOffice()+"')");
            connectionDB.closeconnection();
        }

        public void delete(int id) throws SQLException {

            state = connectionDB.openconnection().createStatement();
            state.executeUpdate("DELETE FROM `doctors` WHERE  id= '"+id+"'");
            connectionDB.closeconnection();
        }

        public ObservableList<doctors> getAlldoctors() throws SQLException {
            ObservableList doctors = FXCollections.observableArrayList();
            try {
                state = connectionDB.openconnection().createStatement();
                ResultSet result = state.executeQuery("SELECT * FROM doctors");

                while (result.next()) {
                    doctors obj = new doctors();
                    obj.setName(result.getString(1));
                    obj.setId(result.getInt(2));
                    obj.setOffice(result.getInt(3));

                    doctors.add(obj);

                }
                connectionDB.closeconnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return doctors;
        }


    }




