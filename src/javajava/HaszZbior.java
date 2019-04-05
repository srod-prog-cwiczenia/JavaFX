package javajava;
import java.util.*; 

public class HaszZbior {
	public static void test(Scanner sc1) { 	
		HashSet<String> h = new HashSet<String>(); 
		System.out.println("Podaj napisy (pusty oznacza koniec wprowadzania).");
          	do {
	            String liniaStr = sc1.nextLine();
	            if (liniaStr.isEmpty()) {
        	        break;
        	    }
		    h.add(liniaStr);
		} while (true);

        // pokazuje HashSet 
        	System.out.println(h); 
        	System.out.println("Zbior zawiera slowo Kot albo nie:" + h.contains("Kot")); 
  
        // Removing items from HashSet using remove() 
        	h.remove("Kot"); 
        	System.out.println("Lista po usunieciu slowa Kot:" + h); 
  
        // Iterating over hash set items 
        	System.out.println("Iterujemy po liscie:"); 
        	Iterator<String> i = h.iterator(); 
        	while (i.hasNext()) 
        	    System.out.println(i.next()); 
	}
} 
