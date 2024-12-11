/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class KoneksiDB {
     public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/DB_fairway";
        String user = "root"; 
        String password = ""; 
        return DriverManager.getConnection(url, user, password);
    }
    
}

