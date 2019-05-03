package javajava;
import java.util.ArrayList;

public class KlasaZewnetrzna {
	public class KlasaWewnetrzna {
  
  	}
  
	public KlasaWewnetrzna utworzenieInstancji() {
		return new KlasaWewnetrzna();
	}
	private static void innerClassInstantiation() {
	    KlasaZewnetrzna outerClass = new KlasaZewnetrzna();
	    KlasaZewnetrzna.KlasaWewnetrzna instance1 = outerClass.utworzenieInstancji();
	    KlasaZewnetrzna.KlasaWewnetrzna instance2 = outerClass.new KlasaWewnetrzna();
	}

	public static void localClassInstantiation(ArrayList<String> lArgs) {
	    class LocalClass {
	    	ArrayList<String> mLista;        	
	    	public LocalClass(ArrayList<String> aLista) {
	    		mLista = aLista;	
	    	}
        	@Override
        	public String toString() {
        		String listString = "";			
        		for (String s : mLista) {
        			listString += s + "\t";
        		}
        		return "Lista : " + listString;
        	}
	    }   
    	LocalClass localClassInstance = new LocalClass(lArgs);
    	System.out.println(localClassInstance);
	}
}
