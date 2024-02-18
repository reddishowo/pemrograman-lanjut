import csv

def input_data(data, nama, nim, semester):
    mahasiswa = [nama, nim, semester]
    data.append(mahasiswa)

def save_data_to_file(data):
    with open('data_mahasiswa.txt', 'w', newline='') as file:
        writer = csv.writer(file, delimiter='\t')
        writer.writerows(data)

def remove_duplicate_data(data):
    set_of_data = set()
    data_without_duplicate = []

    for mahasiswa in data:
        data_string = mahasiswa[0] + mahasiswa[1] + mahasiswa[2]
        if data_string not in set_of_data:
            set_of_data.add(data_string)
            data_without_duplicate.append(mahasiswa)

    # Update original data list without duplicates
    data.clear()
    data.extend(data_without_duplicate)

def show_data(data):
    print("Nama\tNIM\t\t\tSemester")
    for mahasiswa in data:
        print(f"{mahasiswa[0]}\t{mahasiswa[1]}\t{mahasiswa[2]}")

if __name__ == "__main__":
    data_mahasiswa = []

    # Dummy data for testing
    input_data(data_mahasiswa, "Andi", "2022-119", "1")
    input_data(data_mahasiswa, "Bima", "2022-112", "1")
    input_data(data_mahasiswa, "Rahma", "2022-131", "3")
    input_data(data_mahasiswa, "Zeno", "2022-198", "9")
    input_data(data_mahasiswa, "Rahma", "2022-131", "3")
    input_data(data_mahasiswa, "Andi", "2022-119", "1")

    while True:
        print("\nMenu:")
        print("1. Input Data Baru")
        print("2. Tampilkan Data")
        print("3. Simpan Data to File.txt")
        print("4. Hapus Duplikat Data")
        print("0. Exit")
        choice = int(input("Masukkan Pilihan (1/2/3/4/0): "))

        if choice == 1:
            nama = input("Masukkan Nama: ")
            nim = input("Masukkan NIM (2022-nim): ")
            semester = input("Semester: ")
            input_data(data_mahasiswa, nama, nim, semester)
        elif choice == 2:
            show_data(data_mahasiswa)
        elif choice == 3:
            save_data_to_file(data_mahasiswa)
            print("Data tersimpan kedalam file.")
        elif choice == 4:
            remove_duplicate_data(data_mahasiswa)
            print("Data duplikat terhapus")
        elif choice == 0:
            print("Exited.")
            break
        else:
            print("Pilihan invalid, coba lagi.")
