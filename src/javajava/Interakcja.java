package javajava;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Interakcja {
    protected String [] kolekcja = new String[100];
    protected ArrayList<String> lista = new ArrayList<String>();
    public void pokazKolekcje(ArrayList<String> lista) {
        for (String linia : lista) {
            if (linia == null || linia.isEmpty())
                break;
            System.out.println(linia);
        }
    }
    public void pokazKolekcje(String [] kolekcja) {
        for (String linia : kolekcja) {
            if (linia == null || linia.isEmpty())
                break;
            System.out.println(linia);
        }
    }
    public void pokazKolekcje() {
        pokazKolekcje(lista);
    }

    public void posortujListe() {
        Collections.sort(lista);
    }

    public void pobranieLancuchaZPliku() {
        System.out.println("Podaj nazwę pliku");
        Scanner sc1 = new Scanner(System.in);
        String nazwaPliku = sc1.nextLine();
        //File ff = new File("C:\\Users\\studentwsb\\Desktop\\plik.txt");
        File ff = new File(nazwaPliku);
        try {
            Scanner scf = new Scanner(ff);
            lista.clear();
            while (scf.hasNextLine()) {
                String linia = scf.nextLine();
                lista.add(linia);
            }
            scf.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void zapisanieDoPliku() {
        System.out.println("Podaj nazwę pliku do którego zapisać");
        Scanner sc1 = new Scanner(System.in);
        String nazwaPliku = sc1.nextLine();
        try (PrintWriter pw = new PrintWriter(nazwaPliku)) {
            for (String linia : lista)
                pw.println(linia);
        } catch (Exception e) {};
    }

    public void pobranieLancucha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj linię:");
        int wsk = 0;
        while (sc.hasNextLine()) {
            String linia = sc.nextLine();
            if (linia.isEmpty())
                break;
            kolekcja[wsk++] = linia;
        }
        //lista.addAll(Arrays.asList(kolekcja));
        for (String linia : kolekcja) {
            if (linia == null)
                break;
            lista.add(linia);
        }
    }
}
