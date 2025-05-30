package praktikum.users;
import praktikum.main.LoginSystem;
import praktikum.actions.AdminActions;
import praktikum.model.Item;
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
            sc.nextLine();
            switch (pilihan) {
                case 1: manageItems(); break;
                case 2: manageUsers(); break;
            }
        } while (pilihan != 3);
    }

    @Override
    public void manageItems() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n1. Lihat semua laporan");
            System.out.println("2. Tandai barang telah diambil");
            System.out.print("Pilih: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                viewAllItems();
            } else if(choice == 2) {
                markItemAsClaimed();
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid! " + e.getMessage());
        }
    }

    private void viewAllItems() {
        if(LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("\nSemua Laporan Barang:");
        int index = 1;
        for(Item item : LoginSystem.reportedItems) {
            System.out.println(index++ + ". " + item.getItemName());
            System.out.println("   Status: " + item.getStatus());
            System.out.println("-----------------------------");
        }
    }

    private void markItemAsClaimed() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }
        try {
            viewAllItems();
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan nomor barang: ");
            int itemIndex = sc.nextInt() - 1;

            if(itemIndex >= 0 && itemIndex < LoginSystem.reportedItems.size()) {
                Item item = LoginSystem.reportedItems.get(itemIndex);
                item.setStatus("Claimed");
                System.out.println("Status berhasil diupdate!");
            } else {
                System.out.println("Nomor barang tidak valid!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Indeks tidak valid!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Override
    public void manageUsers() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.print("Pilih: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                addMahasiswa(sc);
            } else if(choice == 2) {
                removeMahasiswa(sc);
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid! " + e.getMessage());
        }
    }

    private void addMahasiswa(Scanner sc) {
        try {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("NIM: ");
            String nim = sc.nextLine();

            LoginSystem.userList.add(new Mahasiswa(username, password, nim, nama));
            System.out.println("Mahasiswa berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private void removeMahasiswa(Scanner sc) {
        try {
            System.out.print("Masukkan NIM yang akan dihapus: ");
            String nim = sc.nextLine();

            for(User user : LoginSystem.userList) {
                if(user instanceof Mahasiswa) {
                    Mahasiswa mhs = (Mahasiswa) user;
                    if(mhs.getNim().equals(nim)) {
                        LoginSystem.userList.remove(user);
                        System.out.println("Mahasiswa berhasil dihapus!");
                        return;
                    }
                }
            }
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
