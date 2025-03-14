import java.util.Scanner;
import java.time.LocalDate;

class Mahasiswa {
    public String setJenisKelamin(char jenisKelamin) {
        if (jenisKelamin == 'l' || jenisKelamin == 'L') {
            return "Laki-laki";
        } else if (jenisKelamin == 'p' || jenisKelamin == 'P') {
            return "Perempuan";
        }
        return "Tidak diketahui";
    }

    public int hitungUmur(int tahunLahir) {
        LocalDate today = LocalDate.now();
        int tahunSekarang = today.getYear();
        int umur = tahunSekarang - tahunLahir;
        return umur;
    }

    public void tampilkanData(String nama, char jenisKelamin, int tahunLahir) {
        System.out.println("Data Diri:");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin: " + setJenisKelamin(jenisKelamin));
        System.out.println("Umur          : " + hitungUmur(tahunLahir) + " tahun");
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();

        System.out.println();
        mhs.tampilkanData(nama, jenisKelamin, tahunLahir);

        System.out.println("\nProcess finished with exit code 0");

        scanner.close();
    }
}