// Mendefinisikan class Musuh yang merupakan subclass dari KarakterGame
public class Musuh extends KarakterGame {
    // Constructor dengan parameter nama dan kesehatan untuk membuat objek Musuh baru
    public Musuh(String nama, int kesehatan) {
        // Memanggil constructor parent class (KarakterGame) untuk menginisialisasi nilai nama dan kesehatan
        super(nama, kesehatan);
    }

    // Mendeklarasikan method serang yang akan menimpa (override) method serang dari class parent
    @Override
    // Method untuk menyerang karakter lain dengan kemampuan khusus Musuh
    public void serang(KarakterGame target) {
        // Mencetak pesan serangan dengan nama Musuh dan nama target, menunjukkan serangan khusus "Snake Bite"
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        // Mengurangi kesehatan target sebanyak 15 poin
        target.setKesehatan(target.getKesehatan() - 15);
        // Mencetak pesan yang menunjukkan kesehatan target setelah diserang
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
} // Akhir dari definisi class Musuh