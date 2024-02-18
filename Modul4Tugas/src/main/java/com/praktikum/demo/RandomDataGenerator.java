package com.praktikum.demo;
import java.util.Random;
import java.util.Scanner;

/**
 * Farriel Arrianta Akbar Pratama
 * 202210370311077
 * Pemrograman Lanjut 3D
 */

public class RandomDataGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Random Angka");
            System.out.println("2. Random String");
            System.out.println("3. Keluar");

            System.out.print("Pilih opsi (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    generateRandomNumber();
                    break;
                case 2:
                    generateRandomString();
                    break;
                case 3:
                    System.out.println("Terima kasih, program berakhir.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }

    private static void generateRandomNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan batas bawah angka acak: ");
        int lowerBound = scanner.nextInt();
        System.out.print("Masukkan batas atas angka acak: ");
        int upperBound = scanner.nextInt();

        Random random = new Random();
        int randomInteger = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        System.out.println("Angka acak: " + randomInteger);
    }

    private static void generateRandomString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan panjang string acak: ");
        int length = scanner.nextInt();

        String randomString = generateRandomString(length);

        System.out.println("String acak: " + randomString);
    }

    private static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(new Random().nextInt(characters.length()));
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}
