/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data berhasil disimpan!");
            } else {
                System.out.println("Gagal menyimpan data.");
            }
        }
    }
}
