# Modul5Tugas - PemrogramanLanjut

## Aplikasi Manajemen Data Mahasiswa

Aplikasi ini ditulis dalam bahasa pemrograman Java dan bertujuan untuk mengelola data mahasiswa. Aplikasi ini dapat melakukan input data mahasiswa, menyimpan data ke dalam file, dan menghapus data duplikat.

### Cara Menggunakan

1. **Menjalankan Program:**
   - Pastikan Anda memiliki software IDEA untuk menjalankan program Java, disini saya menggunakan IntelliJ IDEA
   - Jalankan file didalam project, yaitu `Main.java`.

2. **Input Data Mahasiswa:**
   - metode `inputData()` digunakan untuk memasukkan data mahasiswa ke dalam aplikasi.

3. **Simpan Data ke File:**
   - metode `simpanDataKeFile()` digunakanc untuk menyimpan data ke dalam file `data_mahasiswa.txt`.

4. **Hapus Data Duplikat:**
   - metode `hapusDataDuplikat()` digunakan untuk menghapus data mahasiswa yang duplikat.

5. **Menampilkan Data Tanpa Duplikat:**
   - Hasil akhir akan ditampilkan di konsol setelah menghapus data duplikat.

### Struktur Data

Data mahasiswa disimpan dalam bentuk list menggunakan array, dan data duplikat dihapus menggunakan set.

### Hasil Data yang Sudah Dilakukan Penghapusan Duplikat
      

```
         Sebelum
+--------+-------+---------+
| Nama   | NIM   | Semester|
+--------+-------+---------+
| Andi   | 11119 | 1       |
| Bima   | 11112 | 1       |
| Rahma  | 11131 | 3       |
| Zeno   | 11198 | 9       |
| Rahma  | 11131 | 3       |
| Andi   | 11119 | 1       |
+--------+-------+---------+

         Sesudah
+--------+-------+---------+
| Nama   | NIM   | Semester|
+--------+-------+---------+
| Andi   | 11119 | 1       |
| Bima   | 11112 | 1       |
| Rahma  | 11131 | 3       |
| Zeno   | 11198 | 9       |
+--------+-------+---------+

