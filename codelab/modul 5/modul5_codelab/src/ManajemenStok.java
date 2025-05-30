import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Hapus/Buang Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            int opsi = -1;
            try {
                opsi = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (opsi) {
                case 1:
                    // add barang
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan stok awal: ");
                    try {
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    // lihat barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("--- Daftar Barang ---");
                        int idx = 0;
                        Iterator<Barang> it = daftarBarang.iterator();
                        while (it.hasNext()) {
                            Barang b = it.next();
                            System.out.println(idx + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                            System.out.println("---------------------------");
                            idx++;
                        }
                    }
                    break;

                case 3:
                    // remove stok
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                        break;
                    }
                    System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }
                    try {
                        System.out.print("Masukkan nomor indeks barang: ");
                        int indeks = scanner.nextInt();
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahAmbil = scanner.nextInt();
                        scanner.nextLine();

                        Barang barangDipilih = daftarBarang.get(indeks);
                        if (jumlahAmbil > barangDipilih.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barangDipilih.getNama() + " hanya tersisa " + barangDipilih.getStok());
                        }
                        barangDipilih.setStok(barangDipilih.getStok() - jumlahAmbil);
                        System.out.println("Stok barang '" + barangDipilih.getNama() + "' berhasil dikurangi. Sisa stok: " + barangDipilih.getStok());
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks barang tidak valid!");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    // hapus barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                        break;
                    }
                    System.out.println("--- Daftar Barang (Pilih untuk Dihapus) ---");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }
                    try {
                        System.out.print("Masukkan nomor indeks barang yang akan dihapus: ");
                        int indeksHapus = scanner.nextInt();
                        scanner.nextLine();
                        Barang barangDihapus = daftarBarang.remove(indeksHapus);
                        System.out.println("Barang '" + barangDihapus.getNama() + "' berhasil dihapus dari daftar.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks barang tidak valid!");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Terima kasih! Program berakhir.");
                    break;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
        scanner.close();
    }
}
