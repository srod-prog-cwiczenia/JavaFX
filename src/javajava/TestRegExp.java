package javajava;
//import javafx.css.converter.PaintConverter;

import java.util.Scanner;
import java.util.regex.*;

public class TestRegExp {
    public static void test(Scanner sc) {
        System.out.println("Podaj pattern.");
//        Scanner sc = new Scanner(System.in);
        String wzorStr = sc.nextLine();

        Pattern wzor = Pattern.compile(wzorStr);

        do {
            System.out.println("Podaj napis (pusty oznacza wyjście).");
            String liniaStr = sc.nextLine();
            if (liniaStr.isEmpty()) {
                break;
            }
            Matcher mm = wzor.matcher(liniaStr);

            if (mm.find()) {
                System.out.println("Pasuje");
                for (int l = 1; l <= mm.groupCount(); l++)
                    System.out.println(String.format("Podwyrażenie %s",
                            mm.group(l)));
            } else {
                System.out.println("Nie pasuje.");
            }
        } while (true);
    }
}
