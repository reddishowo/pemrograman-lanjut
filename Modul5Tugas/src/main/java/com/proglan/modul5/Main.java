package com.proglan.modul5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Input data
        List<String[]> dataMahasiswa = new ArrayList<>();
        inputData(dataMahasiswa, "Andi", "11119", "1");
        inputData(dataMahasiswa, "Bima", "11112", "1");
        inputData(dataMahasiswa, "Rahma", "11131", "3");
        inputData(dataMahasiswa, "Zeno", "11198", "9");
        inputData(dataMahasiswa, "Rahma", "11131", "3");
        inputData(dataMahasiswa, "Andi", "11119", "1");

        // Simpan data ke dalam file
        simpanDataKeFile(dataMahasiswa);

        // Hapus data duplikat
        hapusDataDuplikat(dataMahasiswa);

        // Tampilkan hasil setelah menghapus data duplikat
        System.out.println("Nama\tNIM\tSemester");
        for (int i = 0; i < dataMahasiswa.size(); i++) {
            String[] mahasiswa = dataMahasiswa.get(i);
            System.out.println(mahasiswa[0] + "\t" + mahasiswa[1] + "\t" + mahasiswa[2]);
        }
    }

    private static void inputData(List<String[]> data, String nama, String nim, String semester) {
        String[] mahasiswa = {nama, nim, semester};
        data.add(mahasiswa);
    }

    private static void simpanDataKeFile(List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data_mahasiswa.txt"))) {
            for (String[] mahasiswa : data) {
                writer.write(mahasiswa[0] + "\t" + mahasiswa[1] + "\t" + mahasiswa[2]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void hapusDataDuplikat(List<String[]> data) {
        Set<String> setOfData = new HashSet<>();
        List<String[]> dataTanpaDuplikat = new ArrayList<>();

        for (String[] mahasiswa : data) {
            String dataString = mahasiswa[0] + mahasiswa[1] + mahasiswa[2];
            if (setOfData.add(dataString)) {
                // Tambahkan data ke list jika belum ada dalam set
                dataTanpaDuplikat.add(mahasiswa);
            }
        }

        // Update list data original tanpa duplikat
        data.clear();
        data.addAll(dataTanpaDuplikat);
    }
}
