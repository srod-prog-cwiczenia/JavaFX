package nowe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;

public class MieleniePliku {
	public static void pobranieNazwyPliku(Stage formatka) {
		FileChooser wybierakPliku = new FileChooser();
        FileChooser.ExtensionFilter filtrRozszerzen = new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml");
        wybierakPliku.getExtensionFilters().add(filtrRozszerzen);
        wybierakPliku.setInitialDirectory(new File(System.getProperty("user.home")));
        //wybierakPliku.setInitialFileName("poczatkowyPlik.xml");
        File wybranyPlik = wybierakPliku.showOpenDialog(formatka);
        if (wybranyPlik == null) return;
        try {
			BufferedReader br = new BufferedReader(new FileReader(wybranyPlik));
			
			FileChooser wybierakPlikuSave = new FileChooser();
            FileChooser.ExtensionFilter filtrRozszerzenSave = new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml");
            wybierakPlikuSave.getExtensionFilters().add(filtrRozszerzenSave);
            wybierakPlikuSave.setInitialDirectory(new File(System.getProperty("user.home")));
            wybierakPlikuSave.setInitialFileName("___" + wybranyPlik.getName());
            File plik2 = wybierakPlikuSave.showSaveDialog(formatka);
            if (plik2 != null) {
    			BufferedWriter bw = new BufferedWriter(new FileWriter(plik2));
    			int c;
    			int licznik = 0;
    			while((c = br.read()) != -1) {
    				char znak = (char)c;
    				if (znak == '<') licznik++;
    				if (znak == '>') licznik--;
    				if (znak == '\r' || znak == '\n' || znak == '\t' || licznik == 0 && znak == ' ')
    					continue;
    				bw.write(znak);
    			}
    			bw.close();
            }
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
