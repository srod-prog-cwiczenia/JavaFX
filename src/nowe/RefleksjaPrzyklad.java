package nowe;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import narzedzia.Pomocnicze;
import narzedzia.TextAreaConsoleFrm;

public class RefleksjaPrzyklad {
  public static void run() {
	  TextAreaConsoleFrm cons = new TextAreaConsoleFrm();
	  cons.println("Podaj nazwe klasy");
	  String nazwa = cons.czytajLinie();
	  try {
		  Class<?> klasa = Class.forName(nazwa);
		  Class<?> nadklasa = klasa.getSuperclass();
		  String modyfikatory = Modifier.toString(klasa.getModifiers());
		  if (modyfikatory.length() > 0) {
			  cons.println(modyfikatory + "\n");			  
		  }
		  cons.println("klasa: " + nazwa);
		  if (nadklasa != null && nadklasa != Object.class) {
			  cons.println(" rozszerza klase " + nadklasa.getName());
		  }
		  cons.println("\n{\n");
		  drukujKonstruktory(cons, klasa);
		  cons.println("");
		  drukujMetody(cons, klasa);
		  cons.println("");
		  drukujPola(cons, klasa);
		  cons.println("}");
	  } catch (ClassNotFoundException e) {
//		  e.printStackTrace(); - tak było w wersji konsolowej
		  cons.println("Wyjątek - ClassNotFoundException");
		  cons.println(Pomocnicze.stackTrace2String(e));
	  }
	  cons.czytajLinie();
	  cons.zamkniecieFormatki();
  }
  public static void drukujKonstruktory(TextAreaConsoleFrm cons, Class<?> klasa) {
//TODO: do uzupelnienia	  
	  Constructor<?>[] konstruktory = klasa.getDeclaredConstructors();
	  for (Constructor<?> c: konstruktory) {
		  String nazwa = c.getName();
		  cons.println("   ");
		  String modyfikatory = Modifier.toString(c.getModifiers());
		  if (modyfikatory.length() > 0) cons.println(modyfikatory + " ");
		  cons.println(nazwa + "(");
		  
		  Class<?>[] typyParametrow = c.getParameterTypes();
		  for (int j = 0; j < typyParametrow.length; j++) {
			  if (j > 0) cons.println(". ");
			  cons.println(typyParametrow[j].getName());
		  }
		  cons.println("):");
 	  }
	  
  }
  public static void drukujMetody(TextAreaConsoleFrm cons, Class<?> klasa) {
	  Method[] metody = klasa.getDeclaredMethods();
	  for (Method m : metody) {
		 Class<?> zwracana = m.getReturnType();
		 String nazwa = m.getName();
		 cons.println("   ");
		 String modyfikatory = Modifier.toString(m.getModifiers());
		 if (modyfikatory.length() > 0) cons.println(modyfikatory + " ");
		 cons.println(zwracana.getName() + " " + nazwa + "(");
		 
		 Class<?>[] typyParametrow = m.getParameterTypes();
		 for (int j = 0; j < typyParametrow.length; j++) {
			 if (j > 0) cons.println(". ");
			 cons.println(typyParametrow[j].getName());
		 } 
		 cons.println("):");
	  }
  }
  public static void drukujPola(TextAreaConsoleFrm cons, Class<?> klasa) {
    Field[] pola = klasa.getDeclaredFields();
    for (Field f : pola) {
    	Class<?> typ = f.getType();
    	String nazwa = f.getName();
    	cons.println("  ");
    	String modyfikatory = Modifier.toString(f.getModifiers());
    	if (modyfikatory.length() > 0) cons.println(modyfikatory + " ");
    	cons.println(typ.getName() + " " + nazwa + ":");
    }
  }
}

