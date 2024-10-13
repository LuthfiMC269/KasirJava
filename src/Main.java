import java.util.ArrayList; // Buat bikin Array
import java.util.InputMismatchException; // Buat bikin input error detect
import java.util.Scanner; // Buat Input
public class Main {
    // function print list barang
    public static void list(ArrayList<lsBarang> menu){
       System.out.println("Menu:");
       for (lsBarang i : menu) {
           System.out.println(i.nama + " - Harga Rp." + i.harga);
       }
    }
    public static void main(String[] args) {
        ArrayList<lsBarang> menu = new ArrayList<>();
        menu.add(new lsBarang("1. Milo", 6000, 0));
        menu.add(new lsBarang("2. Ayam Goreng", 8000, 0));
        list(menu);
    }
}