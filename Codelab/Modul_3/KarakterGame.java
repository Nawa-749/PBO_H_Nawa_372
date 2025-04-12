// Mendefinisikan class KarakterGame yang merepresentasikan karakter dalam game
public class KarakterGame {
    // Deklarasi variabel instance untuk menyimpan nama karakter
    private String nama;
    // Deklarasi variabel instance untuk menyimpan nilai kesehatan karakter
    private int kesehatan;

    // Constructor dengan parameter untuk menginisialisasi karakter baru
    public KarakterGame(String nama, int kesehatan) {
        // Inisialisasi variabel nama dengan nilai parameter
        this.nama = nama;
        // Inisialisasi variabel kesehatan dengan nilai parameter
        this.kesehatan = kesehatan;
    }

    // Bagian Getter dan Setter
    // Method getter untuk mendapatkan nilai nama karakter
    public String getNama() {
        // Mengembalikan nilai nama karakter
        return nama;
    }

    // Method setter untuk mengubah nilai nama karakter
    public void setNama(String nama) {
        // Mengubah nilai variabel nama dengan nilai parameter baru
        this.nama = nama;
    }

    // Method getter untuk mendapatkan nilai kesehatan karakter
    public int getKesehatan() {
        // Mengembalikan nilai kesehatan karakter
        return kesehatan;
    }

    // Method setter untuk mengubah nilai kesehatan karakter
    public void setKesehatan(int kesehatan) {
        // Mengubah nilai variabel kesehatan dengan nilai parameter baru
        this.kesehatan = kesehatan;
    }

    // Method yang digunakan untuk menyerang karakter lain dan dapat di-override oleh subclass
    public void serang(KarakterGame target) {
        // Mencetak pesan serangan dengan nama penyerang dan target
        System.out.println(this.nama + " menyerang " + target.getNama() + "!");
    }
} // Akhir dari definisi class KarakterGame