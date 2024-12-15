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
 * @author ACER
 */
public class LowonganMethod {
    private String jobName;
    private String kategori;
    private String jobDescription;
    private String lokasiKerja;
    private String hireDate;
    private String gaji;
    private String expireDate;
    private String syaratPelamar;
    private int limitPenerimaan;

    public LowonganMethod(String jobName, String kategori, String jobDescription, String lokasiKerja, String hireDate, String gaji, String expireDate, String syaratPelamar, int limitPenerimaan) {
        this.jobName = jobName;
        this.kategori = kategori;
        this.jobDescription = jobDescription;
        this.lokasiKerja = lokasiKerja;
        this.hireDate = hireDate;
        this.gaji = gaji;
        this.expireDate = expireDate;
        this.syaratPelamar = syaratPelamar;
        this.limitPenerimaan = limitPenerimaan;
    }
    public static LowonganMethod create(String jobName, String kategori, String jobDescription, String lokasiKerja, 
                                  String hireDate, String gaji, String expireDate, String syaratPelamar, int limitPenerimaan) {
        return new LowonganMethod(jobName, kategori, jobDescription, lokasiKerja, hireDate, gaji, expireDate, syaratPelamar, limitPenerimaan);
    }
    public String getJobName() {
        return jobName;
    }

    public String getKategori() {
        return kategori;
    }

    public String getLokasiKerja() {
        return lokasiKerja;
    }

    public String getGaji() {
        return gaji;
    }
    public void isCandidateSelected(String candidateName) {
    try {
        Connection conn = (Connection) KoneksiDB.connect();
        String query = "SELECT COUNT(*) AS jumlah FROM Lamaran WHERE jobName = ? AND namaPelamar = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, this.jobName);
        pstmt.setString(2, candidateName);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int jumlah = rs.getInt("jumlah");
            if (jumlah > 0) {
                System.out.println("Kandidat " + candidateName + " telah melamar pekerjaan: " + this.jobName);
            } else {
                System.out.println("Kandidat " + candidateName + " belum melamar pekerjaan ini.");
            }
        }
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
}
