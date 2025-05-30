package praktikum.users;
import praktikum.main.LoginSystem;
import praktikum.actions.MahasiswaActions;
import praktikum.model.Item;
import java.util.Scanner;
import java.util.Iterator;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nim;
    private String nama;

    public Mahasiswa(String username, String password, String nim, String nama) {
        super(username, password);
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public boolean login(String inputUser, String inputPass) {
        return this.username.equals(inputUser) && this.password.equals(inputPass);
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
                case 1: reportItem(); break;
                case 2: viewReportedItems(); break;
            }
        } while (pilihan != 3);
    }

    @Override
    public void reportItem() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nama Barang: ");
            String nama = sc.nextLine();
            System.out.print("Deskripsi: ");
            String deskripsi = sc.nextLine();
            System.out.print("Lokasi: ");
            String lokasi = sc.nextLine();

            LoginSystem.reportedItems.add(new Item(nama, deskripsi, lokasi));
            System.out.println("Laporan berhasil dikirim!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Iterator<Item> it = LoginSystem.reportedItems.iterator();
        while(it.hasNext()) {
            Item item = it.next();
            System.out.println(item.getItemName());
        }

    }

    @Override
    public void viewReportedItems() {
        if(LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("Daftar Laporan Barang:");
        int index = 1;
        for(Item item : LoginSystem.reportedItems) {
            if(item.getStatus().equals("Reported")) {
                System.out.println(index++ + ". " + item.getItemName());
                System.out.println("   Deskripsi: " + item.getDescription());
                System.out.println("   Lokasi: " + item.getLocation());
                System.out.println("-----------------------------");
            }
        }
    }
}
