import java.io.*;
import java.util.Scanner;

// Kelas Buku untuk menyimpan informasi buku
class Buku {
    String judul;
    String penulis;

    // Method untuk membaca file dan mengambil data judul dan penulis
    void bacaFile(String pathFile) {
        try {
            File file = new File(pathFile);
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Membaca satu baris dari file
                String[] data = line.split(";"); // Memisahkan berdasarkan tanda ';'
                if (data.length == 2) {
                    judul = data[0].trim();
                    penulis = data[1].trim();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        }
    }

    // Method untuk menyimpan data judul dan penulis ke dalam file
    void simpanFile(String namaFile) {
        try {
            FileWriter writer = new FileWriter(namaFile);
            writer.write(judul + "; " + penulis + "\n");
            writer.close();
            System.out.println("Data berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan dalam menyimpan file: " + e.getMessage());
        }
    }

    // Method untuk menghitung royalti dengan persentase 10%
    double hitungRoyalti(double hargaBuku) {
        return hargaBuku * 0.10;
    }

    // Method untuk menghitung royalti dengan persentase sesuai input
    double hitungRoyalti(double hargaBuku, double persen) {
        return hargaBuku * (persen / 100);
    }

    // Method untuk menampilkan informasi buku
    void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
    }
}

// Kelas utama untuk menjalankan program
public class per3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Buku buku = new Buku(); // Membuat objek buku
        
        System.out.print("Masukkan nama file untuk dibaca: ");
        String namaFile = input.nextLine();
        buku.bacaFile(namaFile); // Membaca file
        buku.tampilkanInfo(); // Menampilkan informasi buku

        System.out.print("Masukkan harga buku: ");
        double harga = input.nextDouble();
        System.out.println("Royalti 10%: " + buku.hitungRoyalti(harga));
        
        System.out.print("Masukkan persentase royalti: ");
        double persen = input.nextDouble();
        System.out.println("Royalti " + persen + "%: " + buku.hitungRoyalti(harga, persen));
        
        
        input.close();
    }
}
