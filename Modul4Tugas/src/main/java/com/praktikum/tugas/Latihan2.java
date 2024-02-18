package com.praktikum.tugas;
import java.util.Scanner;
//API = kumpulan aturan dan protokol
//yang memungkinkan perangkat lunak satu untuk berinteraksi dengan perangkat lunak lainnya.

//Library = Kumpulan kode yang dapat digunakan kembali yang menyediakan fungsi-fungsi dan rutin-rutin untuk
//membantu pengembangan perangkat lunak
public class Latihan2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teks = "";

        while (true) {
            System.out.println("\nMenu Program:");
            System.out.println("1. Masukkan Teks");
            System.out.println("2. Hitung Jumlah Karakter");
            System.out.println("3. Hitung Jumlah Kata");
            System.out.println("4. Cari Kata dalam Teks");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membuang karakter newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks: ");
                    teks = scanner.nextLine();
                    break;
                case 2:
                    int jumlahKarakter = hitungJumlahKarakter(teks);
                    System.out.println("Jumlah karakter: " + jumlahKarakter);
                    break;
                case 3:
                    int jumlahKata = hitungJumlahKataYangDitemukan(teks, "");
                    System.out.println("Jumlah kata: " + jumlahKata);
                    break;
                case 4:
                    System.out.print("Masukkan kata yang ingin dicari: ");
                    String kataCari = scanner.next();
                    cariKata(teks, kataCari);
                    break;
                case 5:
                    System.out.println("Exited.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }

    private static int hitungJumlahKarakter(String teks) {
        System.out.println("Masukkan Teks terlebih dahulu.");
        return teks.length();
    }

    private static int hitungJumlahKataYangDitemukan(String teks, String kata) {
        if (teks.isEmpty()) {
            System.out.println("Masukkan Teks terlebih dahulu.");
        }

        if (kata.isEmpty()) {
            String[] kataArray = teks.split("\\s+"); //memecah teks menjadi array dengan regex \\s untuk menambahkan spasi
            return kataArray.length;
        }
        String[] kataArray = teks.split("\\s+");

        int count = 0;
        for (String k : kataArray) {
            if (k.equalsIgnoreCase(kata)) { //to check whether the word in the text is the same as the searched word
                count++;
            }
        }

        return count;
    }

    private static boolean cariKata(String teks, String kata) {
        if (teks.trim().isEmpty() || kata.trim().isEmpty()) { //check if the input text is empty or not
            System.out.println("Masukkan Teks terlebih dahulu.");
            return false;
        }

        int jumlahKataDitemukan = hitungJumlahKataYangDitemukan(teks, kata); //call HJKYD method to count total amount of words in text.

        if (jumlahKataDitemukan > 0) {
            System.out.println("Kata '" + kata + "' ditemukan sebanyak " + jumlahKataDitemukan + " kali dalam teks.");
            return true;
        } else {
            return false;
        }
    }
}
