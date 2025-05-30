// SUBCLASS MAHASISWA
class Mahasiswa extends User {

    // konstruktor
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Override login
    @Override
    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}