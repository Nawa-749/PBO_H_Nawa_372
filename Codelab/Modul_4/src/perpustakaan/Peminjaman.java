package perpustakaan;

public interface Peminjaman {
    // Method signature untuk peminjaman buku
    void pinjamBuku(String judulBuku);

    // Method signature dengan parameter tambahan durasi
    void pinjamBuku(String judulBuku, int durasi);

    // Method signature untuk pengembalian buku
    void kembalikanBuku();
}