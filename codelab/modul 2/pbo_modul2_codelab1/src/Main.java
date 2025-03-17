//membuat class hewan
class Hewan {

    //atribut pada hewannya
    String Nama;
    String Jenis;
    String Suara;
    String Warna;

    //method untuk menampilkan informasi hewan
    void tampilkanInfo() {
        System.out.println("Nama: " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
        System.out.println("Warna: " + Warna);
        System.out.println(); // baris kosong untuk pemisah
    }
}

//implementasi program
public class Main {
    public static void main(String[] args) {

        //membuat objek hewan1
        Hewan hewan1 = new Hewan();
        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "MIAAAAAWWWWWWWWWWWWWW";
        hewan1.Warna = "oren";

        //membuat objek hewan2
        Hewan hewan2 = new Hewan();
        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "GUKGUKGUK AUUUUU RAWRRRRR";
        hewan2.Warna = "hitam";

        //Menampilkan informasi kedua objek
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
