package przyklady;

import java.net.*;
import java.io.*;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nowe.TextAreaZTextEdit2Frm;

public class PobranieHTTP extends TextAreaZTextEdit2Frm {

	public PobranieHTTP(String tytul) {
		super(tytul);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void akcjaBtnAkceptuj() {
		URL url;
		List<String> kolekcja = new ArrayList<String>();
		try {
			String urlString = textField.getText();
        	url = new URL(urlString);
        	URLConnection uc = url.openConnection();
        	BufferedReader d = new BufferedReader (new
        			InputStreamReader(uc.getInputStream()));
//DataInputStream dis = new
//DataInputStream(uc.getInputStream()));
        	String line;
        	while ((line = d.readLine()) != null) {
        		kolekcja.add(line);
        	}
        	pokazArrayListLancuchow(kolekcja);
        } catch (Exception e) {e.printStackTrace(); }
	}
}

