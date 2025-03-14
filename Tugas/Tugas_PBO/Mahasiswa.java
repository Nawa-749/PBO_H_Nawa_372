public class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa() {
        this.nama = "Nawa Istiqomah";
        this.nim = "202410370110372";
    }

    public boolean login(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.nim);
    }
}