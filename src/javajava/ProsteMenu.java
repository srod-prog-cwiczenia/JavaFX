package javajava;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProsteMenu {
    String[] listaZ;
    int m_ile;
    Scanner m_sc;
    ProsteMenu(String [] lista, Scanner sc) {
      listaZ = lista;
      m_ile = lista.length;
      m_sc = sc;  
    };
    public int wybierz() {
      for (int iii = 0; iii < m_ile; iii++) {
        System.out.println("" + (iii + 1) + ". " + listaZ[iii]);
      }
      int iOpcja = 0;
      boolean dobraOpcja = true;
      do {
	      try {
	    	  iOpcja = m_sc.nextInt();
	    	  dobraOpcja = true;
	      } catch (InputMismatchException e) {
	    	  m_sc.nextLine();
	    	  System.out.println("Prosze podac liczbe");
	    	  dobraOpcja = false;
	      }
      } while (!dobraOpcja);    
      //int odp = Integer.parseInt(sOpcja);
      m_sc.nextLine(); /*nie wiem czemu trzeba wczytac kolejna linie (bedzie ona pusta)
      ale w przeciwnym razie nie dzialaja dalsze skany - przeszkadza prawdopodobnie
      rzeczona pusta linia
      */
      if (!(1 <= iOpcja && iOpcja <= m_ile)) {
    	  iOpcja = 0;
      }
      return iOpcja;
    }
}
