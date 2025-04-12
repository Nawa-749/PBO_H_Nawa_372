// Mendefinisikan class Main sebagai class utama yang akan dieksekusi
public class Main {
    // Method main adalah titik awal eksekusi program
    public static void main(String[] args) {
        // Membuat objek KarakterGame dengan nama "Karakter Umum" dan kesehatan 100
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        // Membuat objek Pahlawan dengan nama "Brimstone" dan kesehatan 150
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        // Membuat objek Musuh dengan nama "Viper" dan kesehatan 200
        Musuh viper = new Musuh("Viper", 200);

        // Mencetak pesan untuk menunjukkan status awal karakter
        System.out.println("Status awal:");
        // Mencetak nama dan kesehatan awal dari karakter Brimstone
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        // Mencetak nama dan kesehatan awal dari karakter Viper
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

        // Memanggil method serang dari objek brimstone untuk menyerang viper
        brimstone.serang(viper);
        // Memanggil method serang dari objek viper untuk menyerang brimstone
        viper.serang(brimstone);
    }
} // Akhir dari definisi class Main