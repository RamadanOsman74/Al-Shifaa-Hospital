package com.example.demo;
import java.sql.* ;
import java.nio.channels.ConnectionPendingException;

public class connectionDB {
     private static Connection con = null ;

    private connectionDB(){
    }

    public static Connection openconnection () throws SQLException {

        if( con == null)
        con = (Connection)  DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","");

        return con ;


    }
    public static void closeconnection(){
        if(con != null)
            con = null;
    }

}
