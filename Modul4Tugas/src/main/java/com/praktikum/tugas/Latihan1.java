package com.praktikum.tugas;
import java.util.Scanner;

public class Latihan1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Kalkulator ===");
        System.out.println("1. Akar Kuadrat");
        System.out.println("2. Pangkat");
        System.out.println("3. Logaritma");
        System.out.println("4. Faktorial");
        System.out.println("5. Keluar");
        System.out.print("Pilih Operasi (1/2/3/4/5) : ");

        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                hitungAkarKuadrat();
                break;
            case 2:
                hitungPangkat();
                break;
            case 3:
                hitungLogaritmaNatural();
                break;
            case 4:
                hitungFaktorial();
                break;
            case 5:
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
        scanner.close();
    }

    private static void hitungAkarKuadrat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        double angka = scanner.nextDouble();

        double hasil = Math.sqrt(angka); //sqrt = menghitung akar kuadrat sebuah nilai

        System.out.println("Hasil akar kuadrat: " + hasil);
    }

    private static void hitungPangkat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        double angka = scanner.nextDouble();

        System.out.print("Masukkan pangkat: ");
        double pangkat = scanner.nextDouble();

        double hasil = Math.pow(angka, pangkat); //pow = menghitung nilai pangkat suatu angka (ex : 2^2)

        System.out.println("Hasil pangkat: " + hasil);
    }

    private static void hitungLogaritmaNatural() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        double angka = scanner.nextDouble();

        double hasil = Math.log(angka); //menghitung logaritma basis e

        System.out.println("Hasil logaritma natural: " + hasil);
    }

    private static void hitungFaktorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int angka = scanner.nextInt();

        long hasil = 1;

        for (int i = 1; i <= angka; i++) {
            hasil *= i;
        }

        System.out.println("Hasil faktorial: " + hasil);
    }
}
