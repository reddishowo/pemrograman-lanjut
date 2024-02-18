package com.proglan.Tugas2;

import java.util.Arrays;
import java.util.Random;

/**
 * Kelas BubbleSort adalah implementasi algoritma Bubble Sort
 * untuk mengurutkan array integer.
 */
public class BubbleSort {

    /**
     * Metode utama yang digunakan untuk menguji algoritma Bubble Sort.
     * Ini akan menghasilkan array acak, mengurutkannya menggunakan Bubble Sort,
     * dan mencetak hasilnya.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(5); // Masukkan size array yang ingin di urutkan (sorting)

        System.out.println("Algoritma Bubble Sort: ");
        bubbleSort(randomArray);
        System.out.println("Hasil setelah sorting : " + Arrays.toString(randomArray));
    }

    /**
     * Metode Bubble Sort untuk mengurutkan array integer.
     *
     * @param arr Array integer yang akan diurutkan.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                System.out.println(Arrays.toString(arr));
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Metode untuk menghasilkan array integer acak dengan panjang tertentu.
     *
     * @param size Panjang array yang akan dihasilkan.
     * @return Array integer acak dengan panjang `size`.
     */
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
