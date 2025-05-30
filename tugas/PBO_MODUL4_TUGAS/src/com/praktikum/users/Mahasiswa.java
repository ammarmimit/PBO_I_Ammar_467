package com.praktikum.users;
import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Mahasiswa extends User implements MahasiswaActions {
    private List<String> laporanBarang = new ArrayList<>();

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }

    @Override
    public void displayAppMenu() {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("MAIN MENU");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
            }
        } while (pilihan != 3);
    }

    @Override
    public void reportItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = sc.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = sc.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = sc.nextLine();
        System.out.println("Laporan barang berhasil dikirim!");

        String laporan = "Nama: " + nama + ", Deskripsi: " + deskripsi + ", Lokasi: " + lokasi;
        laporanBarang.add(laporan); //menyimpan input barang
    }

    @Override
    public void viewReportedItems() {
        if (laporanBarang.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            System.out.println("Daftar Laporan Barang:");
            int i = 1;
            for (String laporan : laporanBarang) {
                System.out.println(i + ". " + laporan);
                System.out.println();
                i++;
            }
        }
    }
}



