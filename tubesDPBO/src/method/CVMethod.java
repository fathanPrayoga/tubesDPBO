/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ACER
 */
public class CVMethod {
    private String nama;
    private String birthDate;
    private String riwayatPendidikan;
    private String departemen;
    private String riwayatExp;
    private String deskripsi;

    public CVMethod(String nama, String birthDate, String riwayatPendidikan, String departemen, String riwayatExp, String deskripsi) {
        this.nama = nama;
        this.birthDate = birthDate;
        this.riwayatPendidikan = riwayatPendidikan;
        this.departemen = departemen;
        this.riwayatExp = riwayatExp;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRiwayatPendidikan() {
        return riwayatPendidikan;
    }

    public void setRiwayatPendidikan(String riwayatPendidikan) {
        this.riwayatPendidikan = riwayatPendidikan;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getRiwayatExp() {
        return riwayatExp;
    }

    public void setRiwayatExp(String riwayatExp) {
        this.riwayatExp = riwayatExp;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public int countAge() {
        LocalDate birth = LocalDate.parse(this.birthDate);
        LocalDate today = LocalDate.now();
        return Period.between(birth, today).getYears();
    }
    public void display() {
        System.out.println("===== CV =====");
        System.out.println("Nama: " + this.nama);
        System.out.println("Tanggal Lahir: " + this.birthDate);
        System.out.println("Umur: " + countAge() + " tahun");
        System.out.println("Riwayat Pendidikan: " + this.riwayatPendidikan);
        System.out.println("Departemen: " + this.departemen);
        System.out.println("Pengalaman Kerja: " + this.riwayatExp);
        System.out.println("Deskripsi: " + this.deskripsi);
    }
}
