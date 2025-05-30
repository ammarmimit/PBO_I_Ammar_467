//superclass
class KarakterGame {
    private String nama;
    private int kesehatan;

    // Constructor parameter
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // getter setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Method serang
    public void serang(KarakterGame target) {

    }
}

// subclass, pahlawan
class Pahlawan extends KarakterGame {

    // konstruktor super
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang (pahlawan)
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// subclass, musuh
class Musuh extends KarakterGame {

    // konstruktor super
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang (musuh)
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

class Vigilante extends KarakterGame {

    // konstruktor super
    public Vigilante(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang (vigilante)
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan lagu somebody pleasure!");
        target.setKesehatan(target.getKesehatan() - 90);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

class Saiyan extends KarakterGame {

    // konstruktor super
    public Saiyan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang (vigilante)
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " KAMEHAMEHAA! ");
        target.setKesehatan(target.getKesehatan() - 100);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

public class Main {
    public static void main(String[] args) {

        // objek
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);
        Vigilante Dmau = new Vigilante("Dmau", 500);
        Saiyan Goku = new Saiyan("Goku", 900);

        // output awal
        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());
        System.out.println(Dmau.getNama() + " memiliki kesehatan: " + Dmau.getKesehatan());
        System.out.println(Goku.getNama() + " memiliki kesehatan: " + Goku.getKesehatan());
        System.out.println();
        System.out.println();

        // output method override diatas
        brimstone.serang(viper);
        viper.serang(brimstone);
        Dmau.serang(viper);
        viper.serang(Dmau);
        Goku.serang(viper);
        System.out.println();
        System.out.println("The End.. ");

    }
}