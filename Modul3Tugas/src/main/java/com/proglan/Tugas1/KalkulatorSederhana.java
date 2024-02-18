package com.proglan.Tugas1;
import java.util.Scanner;
public class KalkulatorSederhana {
    public static void main(String[] args) { //menggunakan shortcut PSVM.
        Scanner input = new Scanner(System.in); //saya menambahkan Live Template 'scn' (scanner) untuk membuat Scanner baru.

        System.out.println("=== Kalkulator Sederhana ===");
        System.out.println("Pilihlah operasi yang ingin anda gunakan :");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");

        System.out.println("Masukkan pilihan (1/2/3/4) : ");
        int pilihan = input.nextInt();

        System.out.println("Masukkan bilangan pertama : ");
        double bilangan1 = input.nextDouble();

        System.out.println("Masukkan bilangan kedua : ");
        double bilangan2 = input.nextDouble();

        double hasil = 0;

        switch (pilihan) {
            case 1 :
                hasil = bilangan1 + bilangan2; //Live template (tambah)
                break;
            case 2 :
                hasil = bilangan1 - bilangan2; //Live template (kurang)
                break;
            case 3 :
                hasil = bilangan1 * bilangan2; //Live template (kali)
                break;
            case 4 :
                if(bilangan2 != 0){
                    hasil = bilangan1 / bilangan2;
                } else {
                    System.out.println("Tidak bisa melakukan pembagian dengan nol.");
                    System.exit(1);
                }
            default :
                System.out.println("Pilihan tidak valid.");
                System.exit(1);
        }
        System.out.println("Hasil : " + hasil);
    }
}
