package perpustakaan;

public class NonFiksi extends Buku {
    // Atribut khusus untuk buku non-fiksi
    private String subjek;

    // Constructor
    public NonFiksi(String judul, String penulis, String subjek) {
        super(judul, penulis); // Memanggil constructor dari parent class (Buku)
        this.subjek = subjek;
    }

    // Implementasi method abstract dari parent class
    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Subjek: " + subjek);
    }
}