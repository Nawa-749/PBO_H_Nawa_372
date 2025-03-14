public class MainRekeningBank {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank("202410370110372", "Nawa", 10000000.0);

        RekeningBank rekening2 = new RekeningBank("202410370110368", "Alfina", 5000000.0);

        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
        System.out.println();

        rekening1.setorUang(2000000.0);
        rekening2.setorUang(500000.0);
        System.out.println();

        rekening1.tarikUang(8000000.0);
        rekening2.tarikUang(300000.0);
        System.out.println();

        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
    }
}