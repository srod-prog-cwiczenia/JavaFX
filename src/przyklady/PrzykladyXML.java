package przyklady;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;

public class PrzykladyXML {
	 
	    public static final String nazwaPlikuXML = "xmlPlikJavaTest.xml";
	 
	    public static void utworzenieXML(Stage aFormatka) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
	            // element glowny (:
            Element root = document.createElement("Dane");
	        document.appendChild(root);
	 
            // element osoba
            Element osoba = document.createElement("Osoba");
            root.appendChild(osoba);
            // tworzymy jakis tam atrybut (powiedzmy id):
	        Attr attr = document.createAttribute("id");
	        attr.setValue("1");
	        osoba.setAttributeNode(attr);
	 
           //mozemy tez uzyc takiej konstrukcji: 
	        osoba.setAttribute("nrId", "1");

	        // element imie:
	        Element imie = document.createElement("Imie");
	        imie.appendChild(document.createTextNode("Adam"));
	        osoba.appendChild(imie);
	 
	        // element nazwisko:
	        Element nazwisko = document.createElement("Nazwisko");
	        nazwisko.appendChild(document.createTextNode("Kowalski"));
	        osoba.appendChild(nazwisko);
	 
            // email osoby
            Element email = document.createElement("Email");
            email.appendChild(document.createTextNode("adam_kowalski@gmail.com"));
            osoba.appendChild(email);
	 
	        // teraz nastepuje zasadnicze utworzenie pliku xml:
	        // (=przeksztalcenie obiektu DOM do pliku XML)
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource domSource = new DOMSource(document);
			FileChooser wybierakPliku = new FileChooser();
            FileChooser.ExtensionFilter filtrRozszerzen = new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml");
            wybierakPliku.getExtensionFilters().add(filtrRozszerzen);
            wybierakPliku.setInitialDirectory(new File(System.getProperty("user.home")));
            wybierakPliku.setInitialFileName(nazwaPlikuXML);

            File plik = wybierakPliku.showSaveDialog(aFormatka);
            
            if (plik == null) {
            	return;
            }
           
	        StreamResult wynikStrumieniowania = new StreamResult(plik);
	 
	        // mozemy takze ,,wylac'' zawartosc pliku XML na konsole:
	        // StreamResult wynikStrumieniowania = new StreamResult(System.out);
            transformer.transform(domSource, wynikStrumieniowania);
            Pomocnicze.komunikat("Plik XML zostal zapisany");
	      } catch (ParserConfigurationException pce) {
	          pce.printStackTrace();
	      } catch (TransformerException tfe) {
	          tfe.printStackTrace();
	      }
	   }
	}

