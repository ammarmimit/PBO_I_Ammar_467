//Fadgham Ammar Hibatullah
//NIM 202310370311467
//Codelab PBO MODUL 1

import java.time.LocalDate;
import java.util.Scanner;

public class DataDiri {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menggunakan class scanner untuk menginput nama manusia ini
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        // Sama seperti diatas, untuk menginput jenis kelaminnya
        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelaminInput = scanner.nextLine();
        char jenisKelamin = jenisKelaminInput.charAt(0);

        // Menginput tahun lahir
        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();
        scanner.nextLine();

        // Menghitung Umur manusia ini
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        // Menentukan jenis kelamin dengan menggunakan sebuah condition if else, agar bisa menginput 2 jenis kelamin, dan else sebagai nilai yang tidak ada pada keduanya
        String jenisKelaminOutput;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') {
            jenisKelaminOutput = "Laki-laki";
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            jenisKelaminOutput = "Perempuan";
        } else {
            jenisKelaminOutput = "Anda Adalah Sebuah Roti";
        }

        // Hasil output
        System.out.println("\nData Diri:");
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Jenis Kelamin\t: " + jenisKelaminOutput);
        System.out.println("Umur\t\t: " + umur + " tahun");

        scanner.close();
    }
}