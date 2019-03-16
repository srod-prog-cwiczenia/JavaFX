package przyklady;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

interface MyString {
	String myStringFunction(String str);
}

interface Funkcja {
	int dzialanie(int x, int y);
}


public class NotacjaLambda {
	public static void komunikat(String txt) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Powiadomienie");
		alert.setHeaderText("Naglowek");
		alert.setContentText(txt);
		alert.showAndWait();
	
	}
	
	public static String reverseStr(MyString reverse, String str){
		  return reverse.myStringFunction(str);
		}

	public static void lambda1() {
	// Block lambda to reverse string
	MyString reverse = (str) -> {
		String result = "";
		
		for(int i = str.length()-1; i >= 0; i--)
			result += str.charAt(i);
		
		return result;
	};

	// Output: omeD adbmaL
	komunikat(reverseStr(reverse, "Lambda Demo")); 
  }

  public static void lambda2() {
	
		Funkcja ff = (x,y) -> x * x + y * y;
		komunikat("" + ff.dzialanie(2,3));
		
	}
	
}
