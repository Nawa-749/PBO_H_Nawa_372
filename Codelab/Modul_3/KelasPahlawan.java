// Mendefinisikan class Pahlawan yang merupakan subclass dari KarakterGame
public class Pahlawan extends KarakterGame {
    // Constructor dengan parameter nama dan kesehatan untuk membuat objek Pahlawan baru
    public Pahlawan(String nama, int kesehatan) {
        // Memanggil constructor parent class (KarakterGame) untuk menginisialisasi nama dan kesehatan
        super(nama, kesehatan);
    }

    // Mendeklarasikan method serang yang akan menimpa (override) method serang dari class parent
    @Override
    // Method untuk menyerang karakter lain dengan kemampuan khusus Pahlawan
    public void serang(KarakterGame target) {
        // Mencetak pesan serangan dengan nama Pahlawan dan nama target, menunjukkan serangan khusus "Orbital Strike"
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        // Mengurangi kesehatan target sebanyak 20 poin
        target.setKesehatan(target.getKesehatan() - 20);
        // Mencetak pesan yang menunjukkan kesehatan target setelah diserang
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
} // Akhir dari definisi class Pahlawan