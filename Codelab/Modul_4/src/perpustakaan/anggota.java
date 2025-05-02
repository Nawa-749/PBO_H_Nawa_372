package perpustakaan;

public class anggota implements Peminjaman {
    // Atribut
    private String nama;
    private String idAnggota;
    private String bukuDipinjam;
    private int durasiPinjam;

    // Constructor
    public anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
        this.bukuDipinjam = null;
        this.durasiPinjam = 0;
    }

    // Implementasi method dari interface Peminjaman
    // Overloading method pinjamBuku dengan 1 parameter
    @Override
    public void pinjamBuku(String judulBuku) {
        this.bukuDipinjam = judulBuku;
        this.durasiPinjam = 14; // Default 14 hari
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
        System.out.println("Meminjam buku: " + judulBuku);
        System.out.println("Durasi: " + durasiPinjam + " hari");
    }

    // Overloading method pinjamBuku dengan 2 parameter
    @Override
    public void pinjamBuku(String judulBuku, int durasi) {
        this.bukuDipinjam = judulBuku;
        this.durasiPinjam = durasi;
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
        System.out.println("Meminjam buku: " + judulBuku);
        System.out.println("Durasi: " + durasiPinjam + " hari");
    }

    // Implementasi method kembalikanBuku dari interface
    @Override
    public void kembalikanBuku() {
        if (bukuDipinjam != null) {
            System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
            System.out.println("Mengembalikan buku: " + bukuDipinjam);
            this.bukuDipinjam = null;
            this.durasiPinjam = 0;
        } else {
            System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
            System.out.println("Tidak ada buku yang dipinjam");
        }
    }
}