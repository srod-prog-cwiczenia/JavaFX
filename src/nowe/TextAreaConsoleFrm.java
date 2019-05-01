package nowe;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TextAreaConsoleFrm {
	Stage formatka;
	TextArea obszarTxt;
    Tooltip ttEnter;
    Button btnWyjscie;
    VBox vbox;
    Scene scena;
	public TextAreaConsoleFrm() {
    	  formatka = new Stage();
    	  formatka.initModality(Modality.APPLICATION_MODAL);
	      formatka.setTitle("emulacja konsoli w trybie graficznym");
	      obszarTxt = new TextArea();

	      Tooltip ttWyjscie = new Tooltip("Wyjscie z konsoli graficznej");
	      btnWyjscie = new Button("Wyjscie");
	      btnWyjscie.setMinWidth(50);
	      btnWyjscie.setTooltip(ttWyjscie);
	      
	      btnWyjscie.setOnAction(action -> {
	    	  formatka.close();
	      });
	      vbox = new VBox(obszarTxt, btnWyjscie);
	      scena = new Scene(vbox, 500, 300);
	      formatka.setScene(scena);
	      formatka.show();
	  }
	  public void pokaz(List<String> kolekcja) {
	      for (String linia : kolekcja) {
	    	  obszarTxt.appendText(linia);
	      }
	  }
	  
	  public void zamkniecieFormatki() {
		  formatka.close();	  
	  }
	  public String czytajLinie() {
		  /**
		   * TODO: to jeszcze nie działa tak jak powinno
		   */
/*		  formatka.hide();
		  formatka.showAndWait();
		  return "TAK";
*/
		  TextInputDialog dialog = new TextInputDialog("Podaj treść");
		  dialog.setTitle("Podaj treść");
		  dialog.setHeaderText("Podaj treść");
		  dialog.setContentText("Podaj treść");

		  // Traditional way to get the response value.
		  Optional<String> result = dialog.showAndWait();
		  if (result.isPresent()) {
			  obszarTxt.appendText(result.get());
		      return result.get();
		  } else {
			  return "";
		  }
	  }
}
