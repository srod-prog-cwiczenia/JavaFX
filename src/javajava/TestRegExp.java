package javajava;
//import javafx.css.converter.PaintConverter;

import java.util.Scanner;
import java.util.regex.*;

public class TestRegExp {
    public static void test(Scanner sc) {
        System.out.println("Podaj wyrażenie regularne.");
//        Scanner sc = new Scanner(System.in);
        String wzorStr = sc.nextLine();

        Pattern wzor;
		try {
			wzor = Pattern.compile(wzorStr);
		} catch (PatternSyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println("Błąd w wyrażeniu regularnym");
			//e.printStackTrace();
			return;
		}

        do {
            System.out.println("Podaj napis (pusty oznacza wyjście).");
            String liniaStr = sc.nextLine();
            if (liniaStr == null || liniaStr.isEmpty()) {
                break;
            }
            Matcher mm = wzor.matcher(liniaStr);

            System.out.println("-------- sprawdzenie za pomoca instrukcji matcher.find() --------");
            if (mm.find()) {
                System.out.println("Pasuje");
                for (int l = 1; l <= mm.groupCount(); l++)
                    System.out.println(String.format("Podwyrażenie %s",
                            mm.group(l)));
                	System.out.println(String.format("Znaleziony wzorzec: znaki od %d do %d", 
                			mm.start(), mm.end()));

            } else {
                System.out.println("Nie pasuje.");
            }
            
            System.out.println("\n-------- sprawdzenie za pomoca instrukcji matcher.matches() --------");
            if (mm.matches()) {
                System.out.println("Pasuje");
                int ileTrafien = mm.groupCount();
                if (ileTrafien > 0) {
                	for (int i = 0; i < liniaStr.length(); i++) {
                		for (int j = 1; j <= ileTrafien; j++) 
                			if (i == mm.start(j))
                				System.out.print('(');
                		System.out.print(liniaStr.charAt(i));                		
                		for (int j = 1; j <= ileTrafien; j++) 
                			if (i + 1 == mm.end(j))
                				System.out.print(')');
                	}
                }
            } else {
                System.out.println("Nie pasuje.");
            }
        } while (true);
    }
}
