package przyklady.testy_szybkosci;

public class TestySzybkosci {
	public static String testStringBuilder(double ileTestow) {
		int LICZBA_CYKLI = (int)ileTestow;
		String raport = "";
		String s = "a";
		long start = System.nanoTime();
		for (int i = 0; i < LICZBA_CYKLI; i++) {
			s = s + "a";
			//s = new StringBuilder(s).append("a").toString();
		}
		raport += "Czas - string : " + (System.nanoTime() - start) + "\n";
	
		s = "a";
		start = System.nanoTime();
		StringBuilder sB = new StringBuilder(s);
	
		for(int i = 0; i < LICZBA_CYKLI; i++) {
			sB.append("a");
		}
	
		s = sB.toString();
		raport += "Czas - string builder " + (System.nanoTime() - start) + "\n";		
		
		s = "a";
		start = System.nanoTime();
		StringBuffer strB = new StringBuffer(s);
		for(int i=0; i<LICZBA_CYKLI; i++)
			strB.append("a");
		s = strB.toString();
		raport += "Czas - string buffer: " + (System.nanoTime() - start) + "\n";
		return raport;
	}	
}
