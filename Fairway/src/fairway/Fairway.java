/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fairway;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author steve
 */
public class Fairway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();
        Jobseeker currentJobSeeker = null;

        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            

            switch (choice) {
                case 1: // Regis
                    System.out.println("\nPilih tipe akun:");
                    System.out.println("1. JobSeeker");
                    System.out.println("2. Instansi");
                    System.out.print("Pilih tipe: ");
                    int userType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    if (userType == 1) { // JobSeeker
                        System.out.print("Masukkan CV (contoh: CV.pdf): ");
                        String cv = scanner.nextLine();
                        Jobseeker jobSeeker = new Jobseeker(username, password, cv);
                        if (accountManager.register(jobSeeker)) {
                            System.out.println("Pendaftaran berhasil sebagai JobSeeker!");
                        } else {
                            System.out.println("Username sudah digunakan, coba lagi.");
                        }

                    } else if (userType == 2) { // Instansi
                        System.out.print("Masukkan nama perusahaan: ");
                        String companyName = scanner.nextLine();
                        Instansi instansi = new Instansi(username, password, companyName);
                        if (accountManager.register(instansi)) {
                            System.out.println("Pendaftaran berhasil sebagai Instansi!");
                        } else {
                            System.out.println("Username sudah digunakan, coba lagi.");
                        }

                    } else {
                        System.out.println("Tipe user tidak valid!");
                    }
                    break;

                case 2: // Login
                    System.out.print("Masukkan username: ");
                    String logUsername = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String logPassword = scanner.nextLine();

                    User loggedInUser = accountManager.login(logUsername, logPassword);
                    if (loggedInUser != null) {
                        System.out.println("Login berhasil sebagai " + loggedInUser.getRole() + "!");

                        if (loggedInUser instanceof Jobseeker) {
                            currentJobSeeker = (Jobseeker) loggedInUser; // Mengatur currentJobSeeker setelah login
                            Jobseeker jobSeeker = (Jobseeker) loggedInUser;

                            while (true) {
                                System.out.println("\n=== Menu JobSeeker ===");
                                System.out.println("1. Lihat lowongan");
                                System.out.println("2. Lihat lamaran saya");
                                System.out.println("3. Logout");
                                System.out.print("Pilih opsi: ");
                                int jobSeekerChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (jobSeekerChoice == 1) {
                                    System.out.println("Lowongan tersedia:");
                                    ArrayList<Job> jobListings = accountManager.getJobListings();
                                    if (jobListings.isEmpty()) {
                                        System.out.println("Belum ada lowongan.");
                                    } else {
                                        for (int i = 0; i < jobListings.size(); i++) {
                                            Job job = jobListings.get(i);
                                            System.out.println((i + 1) + ". " + job.getTitle() + " (oleh " + job.getCompanyName() + ")");
                                        }
                                    }
                                    
                                    System.out.print("Pilih nomor lowongan untuk melihat detail (0 untuk kembali): ");
                    int jobChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (jobChoice == 0) {
                        continue;
                    } else if (jobChoice > 0 && jobChoice <= jobListings.size()) {
                        Job selectedJob = jobListings.get(jobChoice - 1);
                        selectedJob.displayJobDetails();

                        while (true) {
                            System.out.println("\n1. Lamar pekerjaan ini");
                            System.out.println("2. Kembali ke daftar lowongan");
                            System.out.print("Pilih opsi: ");
                            int detailChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (detailChoice == 1) {
                                System.out.println("Berhasil melamar pekerjaan: " + selectedJob.getTitle());
                                currentJobSeeker.applyJob(selectedJob.getTitle());
                                break;
                            } else if (detailChoice == 2) {
                                break;
                            } else {
                                System.out.println("Pilihan tidak valid, coba lagi.");
                            }
                        }
                    } else {
                        System.out.println("Nomor lowongan tidak valid.");
                    }

                                } else if (jobSeekerChoice == 2) {
                                    jobSeeker.viewAppliedJobs();

                                } else if (jobSeekerChoice == 3) {
                                    break;
                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            }

                        } else if (loggedInUser instanceof Instansi) {
                            Instansi instansi = (Instansi) loggedInUser;

                            while (true) {
                                System.out.println("\n=== Menu Instansi ===");
                                System.out.println("1. Buat lowongan");
                                System.out.println("2. Lihat lowongan saya");
                                System.out.println("3. Logout");
                                System.out.print("Pilih opsi: ");
                                int instansiChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (instansiChoice == 1) {
                                    System.out.print("Masukkan judul lowongan: ");
                                    String jobTitle = scanner.nextLine();
                                    System.out.print("Masukkan deskripsi lowongan: ");
                                    String jobDescription = scanner.nextLine();
                                    System.out.print("Masukkan kategori lowongan: ");
                                    String kategori = scanner.nextLine();
                                    System.out.print("Masukkan lokasi kerja: ");
                                    String lokasiKerja = scanner.nextLine();
                                    System.out.print("Masukkan syaratPelamar: ");
                                    String syaratPelamar = scanner.nextLine();
                                    System.out.print("Masukkan waktu penerimaan: ");
                                    String hireDate = scanner.nextLine();
                                    System.out.print("Masukkan gaji: ");
                                    String gaji = scanner.nextLine();
                                    System.out.print("Masukkan maksimal waktu pelamaran: ");
                                    String expireDate = scanner.nextLine();
                                    System.out.print("Masukkan jumlah orang yang diterima: ");
                                    int limitPenerimaan = scanner.nextInt();
                                    Job job = new Job(jobTitle, kategori, jobDescription, instansi.getCompanyName(), lokasiKerja, syaratPelamar, hireDate, gaji, expireDate, limitPenerimaan);
                                    accountManager.addJob(job);
                                    instansi.createJob(jobTitle, kategori, jobDescription, lokasiKerja, syaratPelamar, hireDate, gaji, expireDate, limitPenerimaan);

                                } else if (instansiChoice == 2) {
                                    instansi.viewJobs();
                                } else if (instansiChoice == 3) {
                                    break;
                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Username atau password salah.");
                    }
                    break;

                case 3: // Keluar
                    System.out.println("Terima kasih telah menggunakan fairway.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }   
}
