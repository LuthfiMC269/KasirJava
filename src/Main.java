import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Etalase etalaseInstance = new Etalase(); // Membuat instance untuk etalase dan keranjang

        int pilih, jumlah, ulang = 1;
        do {
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
                    while (true) {
                        try {
                            System.out.println("Masukkan jumlah:");
                            jumlah = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Jumlah Invalid! Masukkan angka");
                            input.next();
                        }
                    }

                    // Menambah barang ke keranjang berdasarkan input
                    // Pilih barang berdasarkan indeks (pilih-1)
                    etalaseInstance.tambahKeKeranjang(pilih - 1, jumlah);

                } catch (InputMismatchException e) {
                    System.out.println("Input Invalid! Masukkan angka");
                    input.next();
                }
            }
            etalaseInstance.tampilkanKeranjang();
            double totalHarga = etalaseInstance.getTotalKeseluruhan();
            System.out.println("Total Harga: " + totalHarga);

            while (true) {
                System.out.println("Masukkan kode diskon bila ada (input '-' bila tidak ada): ");
                String kodeDiskon = input.next();
                if (kodeDiskon.equals("DIS10")) {
                    totalHarga = totalHarga - (totalHarga * 0.1);
                    System.out.println("Kode Diterima! Harga setelah diskon adalah: " + totalHarga);
                    break;
                } else if (kodeDiskon.equals("-")) {
                    System.out.println("Tidak ada kode diskon.");
                    break;
                } else {
                    System.out.println("Kode diskon tidak valid");
                }
            }

            double kembalian, uang;
            while (true) {
                while(true) {
                    try {
                        System.out.println("Masukkan uang: ");
                        uang = input.nextDouble();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Uang Invalid! Masukkan angka");
                        input.next();
                    }
                }
                if (uang < totalHarga) {
                    System.out.println("Uang tidak cukup!");
                } else {
                    kembalian = uang - totalHarga;
                    break;
                }
            }

            System.out.println("Kembalian Anda adalah: Rp." + kembalian);

            while (true) {
                System.out.println("Ulang kasir? (y/n)");
                char confirm = input.next().charAt(0);
                confirm = Character.toUpperCase(confirm);
                if (confirm == 'Y') {
                    break;
                } else if (confirm == 'N') {
                    ulang = 0;
                    System.out.println("Terima kasih!");
                    break;
                } else {
                    System.out.println("Input Invalid!");
                }
            }
        }while (ulang == 1);
        input.close();
    }
}
