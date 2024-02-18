# Bubble Sort Java

Proyek ini adalah contoh implementasi algoritma Bubble Sort dalam bahasa pemrograman Java. Algoritma Bubble Sort digunakan untuk mengurutkan array integer secara ascending.
## Cara Menjalankan Proyek

Untuk menjalankan proyek ini, Anda dapat mengikuti langkah-langkah berikut:

1. Pastikan kamu telah menginstal Java Development Kit (JDK) pada komputer Anda.

2. Buka proyek ini menggunakan IntelliJ IDEA.

3. Buka file `BubbleSort.java` dalam proyek kamu.

4. Kamu akan menemukan metode `main` yang digunakan untuk menguji algoritma Bubble Sort. Kamu dapat mengganti panjang array acak dengan mengedit angka pada baris berikut:

```java
int[] randomArray = generateRandomArray(5);

// Gantilah angka (5) dengan panjang array yang diinginkan.
```


## Metode Bubble Sort

Metode `bubbleSort` adalah inti atau perhitungan dari algoritma Bubble Sort itu sendiri. Metode ini mengambil satu argumen, yaitu array integer yang akan diurutkan.

```java
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
```

5. Jalankan program dengan mengklik tombol "Run" (biasanya berbentuk ikon segitiga hijau) di IntelliJ IDEA.

6. Hasil dari Bubble Sort akan dapat terlihat di Terminal IDEA.

### Contoh Hasil

Setelah menjalankan proyek ini, Anda akan melihat output seperti berikut:

```java
Algoritma Bubble Sort:
[73, 40, 62, 15, 44]
[40, 62, 15, 44, 73]
[40, 15, 44, 62, 73]
[15, 40, 44, 62, 73]
[15, 40, 44, 62, 73]
Hasil setelah sorting : [15, 40, 44, 62, 73]
```
## Kontribusi
Kontribusi terhadap proyek BubbleSort ini sangat diterima. Jika ingin berkontribusi, bisa langsung dengan mengirimkan pull request dengan perbaikan atau peningkatan yang diusulkan.

## Lisensi

This project is licensed under the [MIT License](LICENSE).

Copyright © [Farriel Arrianta Akbar Pratama]

