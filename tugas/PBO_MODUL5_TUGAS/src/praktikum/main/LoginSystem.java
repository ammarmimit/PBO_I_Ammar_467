package praktikum.main;
import praktikum.users.*;
import praktikum.model.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        //data awal
        userList.add(new Admin("admin", "admin123"));
        userList.add(new Mahasiswa("mahasiswa", "mhs123", "202310370311010", "Sufyan Arianto"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== LOGIN ===");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            User loggedInUser = null;

            //cari user di list
            for (User user : userList) {
                if (user.login(username, password)) {
                    loggedInUser = user;
                    break;
                }
            }

            if (loggedInUser != null) {
                //output sesuai tipe ueser
                if (loggedInUser instanceof Admin) {
                    System.out.println("\nLogin berhasil sebagai Admin!");
                } else if (loggedInUser instanceof Mahasiswa) {
                    Mahasiswa mhs = (Mahasiswa) loggedInUser;
                    System.out.println("\nLogin berhasil sebagai Mahasiswa!");
                    System.out.println("Selamat datang, " + mhs.getNama() + " (NIM: " + mhs.getNim() + ")");
                }
                loggedInUser.displayAppMenu();
            } else {
                System.out.println("Login gagal! Cek kembali username/password.");
            }
        }
    }
}
