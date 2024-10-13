import java.util.ArrayList;

public class Etalase {
    ArrayList<lsBarang> etalase; // Deklarasi etalase

    // Konstruktor untuk menginisialisasi etalase
    public Etalase() {
        etalase = new ArrayList<>();
        etalase.add(new lsBarang("Milo", 6000, 0));
        etalase.add(new lsBarang("Ayam Goreng", 8000, 0));
        etalase.add(new lsBarang("Minyak Goreng", 20000, 0));
    }

    // Menampilkan barang di etalase
    public static void tampilkanBarang(ArrayList<lsBarang> etalase) {
        System.out.println("Daftar etalase yang tersedia:");
        for (int i = 0; i < etalase.size(); i++) {
            lsBarang barang = etalase.get(i);
            System.out.println((i + 1) + ". " + barang.nama + " - Harga Rp." + barang.harga);
        }
    }

    ArrayList<lsBarang> keranjang = new ArrayList<>();

    // Menggunakan indeks sebagai ID
    public void tambahKeKeranjang(int idBarang, int jumlah) {
        lsBarang barangEtalase = etalase.get(idBarang); // ambil barang dari etalase

        // Cek apakah barang sudah ada di keranjang
        boolean barangUdahDiKeranjang = false;
        for (lsBarang barangKeranjang : keranjang) {
            if (barangKeranjang.nama.equals(barangEtalase.nama)) {
                barangKeranjang.jumlah += jumlah; // Tambah jumlah barang
                System.out.println("Jumlah " + barangKeranjang.nama + " di keranjang bertambah menjadi " + barangKeranjang.jumlah);
                barangUdahDiKeranjang = true;
                break;
            }
        }
        if (!barangUdahDiKeranjang) {
            // Jika barang belum ada di keranjang, tambahkan ke keranjang
            lsBarang barangBaru = new lsBarang(barangEtalase.nama, barangEtalase.harga, jumlah);
            keranjang.add(barangBaru);
            System.out.println(barangEtalase.nama + " berhasil ditambahkan ke keranjang.");
        }
    }
    public void tampilkanKeranjang() {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang kosong.");
        } else {
            System.out.println("Isi keranjang:");
            int totalKeseluruhan = 0;
            for (lsBarang barang : keranjang) {
                int totalHargaBarang = barang.harga * barang.jumlah;
                System.out.println(barang.nama + " - Rp." + barang.harga + " x " + barang.jumlah + " = Rp." + totalHargaBarang);
                totalKeseluruhan += totalHargaBarang;
            }
            System.out.println("Total keseluruhan: Rp." + totalKeseluruhan);
        }
    }
}
