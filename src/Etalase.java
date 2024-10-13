import java.util.ArrayList;

public class Etalase {
    public static ArrayList<lsBarang> InisialisasiEtalase(){
        ArrayList<lsBarang> etalase = new ArrayList<>();
        etalase.add(new lsBarang("1. Milo", 6000, 0));
        etalase.add(new lsBarang("2. Ayam Goreng", 8000, 0));
        etalase.add(new lsBarang("3. Minyak Goreng", 20000, 0));
        return etalase;
    }
}
