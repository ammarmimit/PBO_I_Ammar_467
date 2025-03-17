class RekeningBank {

    // Atribut
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Konstruktor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    // Method untuk setor uang
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Jumlah setor harus lebih dari 0.");
        }
    }

    // Method untuk tarik uang
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        } else {
            System.out.println("Jumlah tarik harus lebih dari 0.");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Membuat objek rekening1 dan rekening2
        RekeningBank rekening1 = new RekeningBank("202310370311467", "Ammar", 500000.0);
        RekeningBank rekening2 = new RekeningBank("202310370311472", "Daffa", 1000000.0);

        // Menampilkan informasi awal kedua rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Transaksi setor uang
        rekening1.setorUang(200000.0);
        rekening2.setorUang(500000.0);

        // Transaksi tarik uang
        rekening1.tarikUang(800000.0); // Gagal karena saldo tidak mencukupi
        rekening2.tarikUang(300000.0); // Berhasil

        System.out.println(); // Baris kosong untuk pemisah

        // Menampilkan informasi akhir kedua rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}