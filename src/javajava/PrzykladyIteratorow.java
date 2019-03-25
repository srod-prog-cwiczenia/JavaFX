package javajava;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PrzykladyIteratorow {
	Map<String, String> m_mapa;
	public PrzykladyIteratorow() {
		m_mapa = new HashMap<String,String>();		  
	}
	public void wypelnienieMapy(Scanner sc1) {
          System.out.println("Podaj nazwę pliku");
          String nazwaPliku = sc1.nextLine();
//          String nazwaPliku = "mapka.txt"; // w razie klopotow ze skanerem
          File ff = new File(nazwaPliku);
          try {
              Scanner scf = new Scanner(ff);
              while (scf.hasNextLine()) {
                  String linia = scf.nextLine();
                  String[] splitTab = linia.split(" ");
		  m_mapa.put(splitTab[0], splitTab[1]);
              }
              scf.close();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
	}
	public void pokazNamWersja1() {
  		for (Map.Entry<String, String> entry : m_mapa.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
	public void pokazNamWersja2() {
		m_mapa.forEach((key,value) -> System.out.println(key + " = " + value));
	}
	public void pokazNamWersja3() {
		for (Iterator<Entry<String, String>> iter = m_mapa.entrySet().iterator();
		  iter.hasNext(); ) {
			Map.Entry<String, String> para = (Map.Entry<String, String>) iter.next();
			System.out.println(para.getKey() + " = " + para.getValue());
		}
	}
}


