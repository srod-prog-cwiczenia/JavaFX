package przyklady;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import narzedzia.Pomocnicze;
import narzedzia.TextAreaConsoleFrm;

public class WyrazeniaRegularne {
    public static void test() {
		TextAreaConsoleFrm cons = new TextAreaConsoleFrm();    	
        cons.println("Podaj wyrażenie regularne.");
        String wzorStr =  cons.czytajLinie();
        if (wzorStr.isEmpty()) return;
        Pattern wzor;
		try {
			wzor = Pattern.compile(wzorStr);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			cons.println("Błąd w wyrażeniu regularnym");
			cons.println(Pomocnicze.stackTrace2String(e));			//e.printStackTrace();
			return;
		}

        do {
            cons.println("Podaj napis (pusty oznacza wyjście).");
            String liniaStr = cons.czytajLinie();
            if (liniaStr == null || liniaStr.isEmpty()) {
                break;
            }
            Matcher mm = wzor.matcher(liniaStr);

            cons.pokaz("-------- sprawdzenie za pomoca instrukcji matcher.find() --------");
            if (mm.find()) {
            	cons.println("Pasuje");
                for (int l = 1; l <= mm.groupCount(); l++)
                	cons.println(String.format("Podwyrażenie %s",
                            mm.group(l)));
                    cons.println(String.format("Znaleziony wzorzec: znaki od %d do %d", 
                			mm.start(), mm.end()));

            } else {
            	cons.println("Nie pasuje.");
            }
            
            cons.println("\n-------- sprawdzenie za pomoca instrukcji matcher.matches() --------");
            if (mm.matches()) {
            	cons.println("Pasuje");
                int ileTrafien = mm.groupCount();
                if (ileTrafien > 0) {
                	for (int i = 0; i < liniaStr.length(); i++) {
                		for (int j = 1; j <= ileTrafien; j++) 
                			if (i == mm.start(j))
                				cons.print('(');
                		cons.print(liniaStr.charAt(i));                		
                		for (int j = 1; j <= ileTrafien; j++) 
                			if (i + 1 == mm.end(j))
                				cons.print(')');
                	}
                }
            } else {
            	cons.println("Nie pasuje.");
            }
        } while (true);
        cons.zamkniecieFormatki();
    }
}
