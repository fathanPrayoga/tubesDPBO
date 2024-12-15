/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class UserMethod {
    
    
    public void register(String nama, String email, String password, String telpon) throws Exception {
    String sql = "INSERT INTO pelamar (nama, email, password, telpon) VALUES (?, ?, ?, ?)";
    try (Connection conn = KoneksiDB.connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nama);
        stmt.setString(2, email);
        stmt.setString(3, password);
        stmt.setString(4, telpon);
        stmt.executeUpdate();
        System.out.println("Data berhasil disimpan!");
    } catch (SQLException e) {
        throw new Exception("Kesalahan saat registrasi: " + e.getMessage());
    }
}

public boolean login(String email, String password) throws Exception {
    String sql = "SELECT * FROM pelamar WHERE email = ? AND password = ?";
    try (Connection conn = KoneksiDB.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // True jika data ditemukan
    } catch (SQLException e) {
        throw new Exception("Kesalahan saat login: " + e.getMessage());
    }
}

}