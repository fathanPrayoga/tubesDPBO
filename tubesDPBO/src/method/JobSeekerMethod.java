/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;
import java.beans.Statement;
import java.sql.Connection;

public class JobSeekerMethod {
    private String nama;
    private String status;
    private String tanggalLahir;
    private UserAddressMethod address;
    private CVMethod CV;

    public JobSeekerMethod(String nama, String status, String tanggalLahir, UserAddressMethod address, CVMethod CV) {
        this.nama = nama;
        this.status = status;
        this.tanggalLahir = tanggalLahir;
        this.address = address;
        this.CV = CV;
    }
    
    public static JobSeekerMethod create(String nama, String status, String tanggalLahir, UserAddressMethod address, CVMethod cv) {
        return new JobSeekerMethod(nama, status, tanggalLahir, address, cv);
    }  
    public void changeProfile(String newNama, String newStatus) {
        this.nama = newNama;
        this.status = newStatus;
        System.out.println("Profil berhasil diperbarui.");
    }
    public void chatNotification() {
        System.out.println("Notifikasi: Pesan baru dari komunitas.");
    }

    public String getNama() {
        return nama;
    }

    public String getStatus() {
        return status;
    }

    public void setAddress(UserAddressMethod address) {
        this.address = address;
    }

    public void setCV(CVMethod CV) {
        this.CV = CV;
    }
    
    

}
