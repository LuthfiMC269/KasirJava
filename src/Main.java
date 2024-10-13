import java.util.ArrayList; // Buat bikin Array
import java.util.InputMismatchException; // Buat bikin input error detect
import java.util.Scanner; // Buat Input

public class Main {
    // function print list barang sesuai struktur list di lsBarang
    public static void list(ArrayList<lsBarang> menu){
       System.out.println("Menu:");
       for (lsBarang i : menu) {
           System.out.println(i.nama + " - Harga Rp." + i.harga);
       }
    }
    // Main
    public static void main(String[] args) {
        Etalase.InisialisasiEtalase();
        list(Etalase.InisialisasiEtalase());
    }
}