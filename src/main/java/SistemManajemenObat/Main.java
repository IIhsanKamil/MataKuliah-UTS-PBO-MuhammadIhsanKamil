package SistemManajemenObat;
import java.util.Scanner;

import SistemManajemenObat.ManajemenStok;
import java.util.Scanner;
import SistemManajemenObat.KategoriObat;
import SistemManajemenObat.Obat;
import SistemManajemenObat.ObatBebas;
import SistemManajemenObat.ObatResep;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManajemenStok app = new ManajemenStok();

        KategoriObat bebas = new KategoriObat("Obat Bebas", "Dapat dibeli tanpa resep");
        KategoriObat keras = new KategoriObat("Obat Keras", "Harus dengan resep dokter");

        Obat ob1 = new ObatBebas("OBT01", "Paracetamol", 50, 5000, bebas, "Mengantuk");
        Obat ob2 = new ObatResep("OBT02", "Amoxicillin", 20, 12000, keras, "dr. Rizki");

        app.tambahObatAwal(ob1);
        app.tambahObatAwal(ob2);

        boolean running = true;

        while (running) {
            System.out.println("\n=== SISTEM MANAJEMEN STOK OBAT APOTEK ===");
            System.out.println("1. Tampilkan Semua Obat (Read)");
            System.out.println("2. Tambah Obat Baru (Create)");
            System.out.println("3. Ubah Data Obat (Update)");
            System.out.println("4. Hapus Obat (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    app.tampilkanSemuaObat();
                    break;

                case "2":
                    System.out.println("\n--- TAMBAH OBAT BARU ---");
                    System.out.print("Masukkan ID Obat: ");
                    String id = scanner.nextLine().trim();

                    System.out.print("Masukkan Nama Obat: ");
                    String nama = scanner.nextLine().trim();

                    int stok = inputInt(scanner, "Masukkan Jumlah Stok: ");
                    double harga = inputDouble(scanner, "Masukkan Harga Obat: ");

                    System.out.println("\nPilih Kategori Obat:");
                    System.out.println("1. Obat Bebas (Dapat dibeli tanpa resep)");
                    System.out.println("2. Obat Keras (Harus dengan resep dokter)");
                    System.out.print("Pilih Kategori (1/2): ");
                    String katPilih = scanner.nextLine().trim();

                    if (katPilih.equals("1")) {
                        System.out.print("Masukkan Efek Samping: ");
                        String efekSamping = scanner.nextLine().trim();
                        app.tambahObat(new ObatBebas(id, nama, stok, harga, bebas, efekSamping));
                    } else if (katPilih.equals("2")) {
                        System.out.print("Masukkan Nama Dokter: ");
                        String namaDokter = scanner.nextLine().trim();
                        app.tambahObat(new ObatResep(id, nama, stok, harga, keras, namaDokter));
                    } else {
                        System.out.println("Pilihan kategori tidak valid! Batal menambahkan data.");
                    }
                    break;

                case "3":
                    System.out.print("Masukkan ID Obat yang ingin diubah: ");
                    String idUpdate = scanner.nextLine().trim();
                    if (app.cariObatById(idUpdate) != null) {
                        System.out.print("Masukkan Nama Baru: ");
                        String namaBaru = scanner.nextLine().trim();
                        int stokBaru = inputInt(scanner, "Masukkan Stok Baru: ");
                        double hargaBaru = inputDouble(scanner, "Masukkan Harga Baru: ");

                        if (app.updateObat(idUpdate, namaBaru, stokBaru, hargaBaru)) {
                            System.out.println("Data obat berhasil diubah!");
                        }
                    } else {
                        System.out.println("ID Obat tidak ditemukan!");
                    }
                    break;

                case "4":
                    System.out.print("Masukkan ID Obat yang ingin dihapus: ");
                    String idHapus = scanner.nextLine().trim();
                    if (app.hapusObat(idHapus)) {
                        System.out.println("Obat berhasil dihapus!");
                    } else {
                        System.out.println("ID Obat tidak ditemukan!");
                    }
                    break;

                case "5":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;

                default:
                    System.out.println("Input wajib diantara 1-5!");
            }
        }
        scanner.close();
    }

    private static int inputInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("Input salah! Masukkan angka bulat.");
            }
        }
    }

    private static double inputDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Double.parseDouble(raw);
            } catch (NumberFormatException e) {
                System.out.println("Input salah! Masukkan angka desimal/bulat.");
            }
        }
    }
}