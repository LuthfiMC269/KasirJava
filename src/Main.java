import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Etalase etalaseInstance = new Etalase(); // Membuat instance untuk etalase dan keranjang

        int pilih, jumlah;

        System.out.println("Selamat datang di kasir Java");
        while (true) {
            try {
                Etalase.tampilkanBarang(etalaseInstance.etalase); // Menampilkan etalase
                System.out.println("Masukkan nomor menu, 0 untuk melanjutkan pembayaran");
                pilih = input.nextInt(); // Pilih nomor barang
                if (pilih == 0) break; // Jika user masukkan 0, lanjut ke pembayaran

                if (pilih < 1 || pilih > etalaseInstance.etalase.size()) { // Cek validasi input
                    System.out.println("Nomor menu tidak valid");
                    continue;
                }

                // Meminta jumlah barang
                while (true){
                    try{
                        System.out.println("Masukkan jumlah:");
                        jumlah = input.nextInt();
                        break;
                    }catch (InputMismatchException e){
                        System.out.println("Jumlah Invalid! Masukkan angka");
                        input.next();
                    }
                }

                // Menambah barang ke keranjang berdasarkan input
                etalaseInstance.tambahKeKeranjang(pilih - 1, jumlah); // Pilih barang berdasarkan indeks (pilih-1)


            } catch (InputMismatchException e) {
                System.out.println("Input Invalid! Masukkan angka");
                input.next();
            }
        }
        etalaseInstance.tampilkanKeranjang();
    }
}
