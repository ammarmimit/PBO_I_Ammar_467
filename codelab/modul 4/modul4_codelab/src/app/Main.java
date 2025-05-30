// File: app.Main.java
package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        //objek buku
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        //objek anggota
        Anggota anggota1 = new Anggota("Wahyu Andika", "B075");
        Anggota anggota2 = new Anggota("Ega Faiz", "A047");

        anggota1.displayInfo();
        anggota2.displayInfo();
        System.out.println();

        //proses pinjam
        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);
        System.out.println();

        //pengembalian
        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}
