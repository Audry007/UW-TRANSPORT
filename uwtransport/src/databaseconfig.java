/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urbain
 */
public class databaseconfig {
    
        private Connection con=null;
        private String url="jdbc:mysql://localhost:3306/uw-transport?";
        private final String username="root";
        private final String password="";
          
        public databaseconfig(){
          try {
                con=DriverManager.getConnection(url,username,password);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } 
        }

    public Connection getCon() {
        return con;
    }
        
}
