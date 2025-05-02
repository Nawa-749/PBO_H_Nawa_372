package perpustakaan;

public class Fiksi extends Buku {
    // Atribut khusus untuk buku fiksi
    private String genre;

    // Constructor
    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis); // Memanggil constructor dari parent class (Buku)
        this.genre = genre;
    }

    // Implementasi method abstract dari parent class
    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Genre: " + genre);
    }
}