public class MainHewan {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Woof-Woof!!";

        hewan1.tampilkanInfo();
        System.out.println();
        hewan2.tampilkanInfo();
    }
}