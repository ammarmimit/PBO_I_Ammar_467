public class Tringgiling {
    // Atribut
    String nama;
    int umur;
    String habitat;

    // Konstruktor
    public Tringgiling(String nama, int umur, String habitat) {
        this.nama = nama;
        this.umur = umur;
        this.habitat = habitat;
    }

    // Method bergulingGuling
    public void bergulingGuling() {
        System.out.println(nama + " sedang berguling-guling di " + habitat);
    }

    // Method tidur
    public void tidur() {
        System.out.println(nama + " sedang tidur nyenyak setelah lelah berguling-guling.");
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek Tringgiling
        Tringgiling tringgiling = new Tringgiling("Tringgiling Jawa", 3, "Hutan Tropis");

        // Memanggil method bergulingGuling
        tringgiling.bergulingGuling();

        // Memanggil method tidur
        tringgiling.tidur();
    }
}
