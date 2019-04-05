package javajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class PrzykladRefleksji {
  public static void run(Scanner sc1) {
	  System.out.println("Podaj nazwe klasy");
	  String nazwa = sc1.next();
	  try {
		  Class<?> klasa = Class.forName(nazwa);
		  Class<?> nadklasa = klasa.getSuperclass();
		  String modyfikatory = Modifier.toString(klasa.getModifiers());
		  if (modyfikatory.length() > 0) {
			  System.out.println(modyfikatory + "\n");			  
		  }
		  System.out.println("klasa: " + nazwa);
		  if (nadklasa != null && nadklasa != Object.class) {
			  System.out.println(" rozszerza klase " + nadklasa.getName());
		  }
		  System.out.println("\n{\n");
		  drukujKonstruktory(klasa);
		  System.out.println();
		  drukujMetody(klasa);
		  System.out.println();
		  drukujPola(klasa);
		  System.out.println("}");
	  } catch (ClassNotFoundException e) {
		  e.printStackTrace();
	  }
  }
  public static void drukujKonstruktory(Class<?> klasa) {
//TODO: do uzupelnienia	  
	  Constructor<?>[] konstruktory = klasa.getDeclaredConstructors();
	  for (Constructor<?> c: konstruktory) {
		  String nazwa = c.getName();
		  System.out.println("   ");
		  String modyfikatory = Modifier.toString(c.getModifiers());
		  if (modyfikatory.length() > 0) System.out.println(modyfikatory + " ");
		  System.out.println(nazwa + "(");
		  
		  Class<?>[] typyParametrow = c.getParameterTypes();
		  for (int j = 0; j < typyParametrow.length; j++) {
			  if (j > 0) System.out.println(". ");
			  System.out.println(typyParametrow[j].getName());
		  }
		  System.out.println("):");
 	  }
	  
  }
  public static void drukujMetody(Class<?> klasa) {
	  Method[] metody = klasa.getDeclaredMethods();
	  for (Method m : metody) {
		 Class<?> zwracana = m.getReturnType();
		 String nazwa = m.getName();
		 System.out.println("   ");
		 String modyfikatory = Modifier.toString(m.getModifiers());
		 if (modyfikatory.length() > 0) System.out.println(modyfikatory + " ");
		 System.out.println(zwracana.getName() + " " + nazwa + "(");
		 
		 Class<?>[] typyParametrow = m.getParameterTypes();
		 for (int j = 0; j < typyParametrow.length; j++) {
			 if (j > 0) System.out.println(". ");
			 System.out.println(typyParametrow[j].getName());
		 } 
		 System.out.println("):");
	  }
  }
  public static void drukujPola(Class<?> klasa) {
    Field[] pola = klasa.getDeclaredFields();
    for (Field f : pola) {
    	Class<?> typ = f.getType();
    	String nazwa = f.getName();
    	System.out.println("  ");
    	String modyfikatory = Modifier.toString(f.getModifiers());
    	if (modyfikatory.length() > 0) System.out.println(modyfikatory + " ");
    	System.out.println(typ.getName() + " " + nazwa + ":");
    }
  }
}
