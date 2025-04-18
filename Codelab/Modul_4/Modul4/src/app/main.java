package app;
import perpustakaan.*;

public class main {
    public static void main(String[] args) {
        // Membuat objek dari kelas Fiksi dan NonFiksi
        perpustakaan.Fiksi bukuFiksi = new perpustakaan.Fiksi("Harry Potter", "J.K. Rowling", "Fantasy");
        perpustakaan.NonFiksi bukuNonFiksi = new perpustakaan.NonFiksi("Sapiens", "Yuval Noah Harari", "Sejarah");

        // Membuat objek Anggota
        perpustakaan.anggota anggota1 = new perpustakaan.anggota("Nawa Istiqomah", "H372");
        perpustakaan.anggota anggota2 = new perpustakaan.anggota("Alfina Nil Husna", "H368");

        // Menampilkan informasi buku
        System.out.println("=== Informasi Buku Fiksi ===");
        bukuFiksi.displayInfo();
        System.out.println("\n=== Informasi Buku NonFiksi ===");
        bukuNonFiksi.displayInfo();

        System.out.println("\n=== Informasi Peminjaman Anggota 1 ===");
        // Menggunakan method overloading pinjamBuku
        anggota1.pinjamBuku("Harry Potter");
        System.out.println("\n=== Informasi Peminjaman Anggota 2 ===");
        anggota2.pinjamBuku("Sapiens", 7);

        System.out.println("\n=== Pengembalian Buku Anggota 1 ===");
        anggota1.kembalikanBuku();
        System.out.println("\n=== Pengembalian Buku Anggota 2 ===");
        anggota2.kembalikanBuku();
    }
}