package nowe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class WyrazeniaRegularne {
    public static void test() {
		TextAreaConsoleFrm cons = new TextAreaConsoleFrm();    	
        cons.pokaz("Podaj wyrażenie regularne.");
        String wzorStr =  cons.czytajLinie();
        if (wzorStr.isEmpty()) return;
        Pattern wzor;
		try {
			wzor = Pattern.compile(wzorStr);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			cons.pokaz("Błąd w wyrażeniu regularnym");
			//e.printStackTrace();
			return;
		}

        do {
            cons.pokaz("Podaj napis (pusty oznacza wyjście).");
            String liniaStr = cons.czytajLinie();
            if (liniaStr == null || liniaStr.isEmpty()) {
                break;
            }
            Matcher mm = wzor.matcher(liniaStr);

            cons.pokaz("-------- sprawdzenie za pomoca instrukcji matcher.find() --------");
            if (mm.find()) {
            	cons.pokaz("Pasuje");
                for (int l = 1; l <= mm.groupCount(); l++)
                	cons.pokaz(String.format("Podwyrażenie %s",
                            mm.group(l)));
                    cons.pokaz(String.format("Znaleziony wzorzec: znaki od %d do %d", 
                			mm.start(), mm.end()));

            } else {
            	cons.pokaz("Nie pasuje.");
            }
            
            cons.pokaz("\n-------- sprawdzenie za pomoca instrukcji matcher.matches() --------");
            if (mm.matches()) {
            	cons.pokaz("Pasuje");
                int ileTrafien = mm.groupCount();
                if (ileTrafien > 0) {
                	for (int i = 0; i < liniaStr.length(); i++) {
                		for (int j = 1; j <= ileTrafien; j++) 
                			if (i == mm.start(j))
                				cons.pokaz('(');
                		cons.pokaz(liniaStr.charAt(i));                		
                		for (int j = 1; j <= ileTrafien; j++) 
                			if (i + 1 == mm.end(j))
                				cons.pokaz(')');
                	}
                }
            } else {
            	cons.pokaz("Nie pasuje.");
            }
        } while (true);
    }
}
