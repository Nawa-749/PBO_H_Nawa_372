public class MainRekeningBank {
    public static void main(String[] args) {
        // Membuat objek rekening1
        RekeningBank rekening1 = new RekeningBank("202410370110372", "Nawa", 10000000.0);

        // Membuat objek rekening2
        RekeningBank rekening2 = new RekeningBank("202410370110368", "Alfina", 5000000.0);

        // Menampilkan informasi awal kedua rekening
        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
        System.out.println();

        // Melakukan transaksi pada rekening1
        rekening1.setorUang(2000000.0);

        // Melakukan transaksi pada rekening2
        rekening2.setorUang(500000.0);
        System.out.println();

        // Melakukan penarikan pada rekening1
        rekening1.tarikUang(8000000.0);

        // Melakukan penarikan pada rekening2
        rekening2.tarikUang(300000.0);
        System.out.println();

        // Menampilkan informasi akhir kedua rekening
        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
    }
}