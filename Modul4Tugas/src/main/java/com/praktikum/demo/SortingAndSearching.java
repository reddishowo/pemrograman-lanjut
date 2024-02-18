package com.praktikum.demo;

import java.util.Arrays;
import java.util.Scanner;

public class SortingAndSearching {

    public static void main(String[] args) {
        int[] data = {38, -15, 72, 0, -42, 19, -63, 50, 27, -84, 61, 5};

        // Mengurutkan data
        Arrays.sort(data);

        // Menampilkan data yang sudah diurutkan
        System.out.println("Data yang sudah diurutkan:");
        for (int element : data) {
            System.out.print(element + " ");
        }

        // Mencari index elemen dengan input dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan nilai yang ingin dicari (index ke-berapa nya): ");
        int targetValue = scanner.nextInt();

        int foundIndex = Arrays.binarySearch(data, targetValue);

        if (foundIndex >= 0) {
            System.out.println("\nNilai ditemukan di index: " + foundIndex);
        } else {
            System.out.println("\nNilai tidak ditemukan.");
        }

        // Menghitung elemen rasio
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int element : data) {
            if (element > 0) {
                positiveCount++;
            } else if (element < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // Menampilkan nilai rasio
        System.out.println("Jumlah elemen (positif) : " + positiveCount);
        System.out.println("Jumlah elemen (negatif) : " + negativeCount);
        System.out.println("Jumlah elemen (nilai 0) : " + zeroCount);
    }
}
