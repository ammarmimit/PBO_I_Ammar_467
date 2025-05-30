package com.praktikum.main;
import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = null;
        System.out.println("Login sebagai: 1. Admin 2. Mahasiswa");
        System.out.print("Pilihan (1/2): ");
        int role = sc.nextInt();
        sc.nextLine();

        if (role == 1) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            user = new Admin("admin", "admin123");
            if (user.login(username, password)) {
                user.displayAppMenu();
            } else {
                System.out.println("Login gagal!");
            }
        } else if (role == 2) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            user = new Mahasiswa("mahasiswa", "mhs123");
            if (user.login(username, password)) {
                user.displayAppMenu();
            } else {
                System.out.println("Login gagal!");
            }
        } else {
            System.out.println("Pilihan tidak valid! Silakan jalankan ulang program dan pilih 1 atau 2.");
        }

    }
}
