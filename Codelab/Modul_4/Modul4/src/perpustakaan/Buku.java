package perpustakaan;

public abstract class Buku {
    // Atribut
    protected String judul;
    protected String penulis;

    // Constructor
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    // Getter methods
    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    // Abstract method yang harus diimplementasikan oleh subclass
    public abstract void displayInfo();
}