package com.praktikum.users;
import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    public Admin(String username, String password) {
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
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1: manageItems(); break;
                case 2: manageUsers(); break;
            }
        } while (pilihan != 3);
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}