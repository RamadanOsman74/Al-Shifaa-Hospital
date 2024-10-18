package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class logincon {
    Statement st;
    Admin ad;

    boolean islogin(Admin ad) throws SQLException {

        st = connectionDB.openconnection().createStatement();
        ResultSet res = st.executeQuery("select * from admin where Username= '" + ad.getUsername() + " ' and Password= '" + ad.getPassword() +" '");
        if (res.next())
            return true ;
        return false ;

    }




}
