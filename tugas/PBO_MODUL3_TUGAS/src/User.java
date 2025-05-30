// superclass
class User {
    private String nama;
    private String nim;

    // konsturktor
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // getter setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // method login
    public boolean login(String input1, String input2) {
        return false;
    }

    // method displayinfo
    public void displayInfo() {
        System.out.println("User info");
    }
}
