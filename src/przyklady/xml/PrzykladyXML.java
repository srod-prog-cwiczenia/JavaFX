package przyklady.xml;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Name;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
//import java.net.URL;
import org.xml.sax.SAXException;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import narzedzia.Pomocnicze;
import sun.net.www.content.text.plain;

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
	    	  Pomocnicze.komunikat(Pomocnicze.stackTrace2String(pce));
	      } catch (TransformerException tfe) {
	    	  Pomocnicze.komunikat(Pomocnicze.stackTrace2String(tfe));
	      }
	   }
	   public static void walidacjaXMLzadanymXSD(Stage aFormatka) { 
			FileChooser wybierakPlikuXML = new FileChooser();
            wybierakPlikuXML.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml"));
            wybierakPlikuXML.setTitle("Sciezka do pliku XML");
            wybierakPlikuXML.setInitialDirectory(new File(System.getProperty("user.home")));
//          wybierakPlikuXML.setInitialFileName("plik.xml");
	        File plikXML = wybierakPlikuXML.showOpenDialog(aFormatka);
	        if (plikXML == null) return;
			FileChooser wybierakPlikuXSD = new FileChooser();
	        wybierakPlikuXSD.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pliki XSD (*.xsd)", "*.xsd"));
	        wybierakPlikuXSD.setTitle("Sciezka do pliku XSD");
	        wybierakPlikuXSD.setInitialDirectory(new File(System.getProperty("user.home")));
//	            wybierakPlikuXSD.setInitialFileName("plik.xsd");
	        File plikXSD = wybierakPlikuXSD.showOpenDialog(aFormatka);
	        if (plikXSD == null) return;			   
			   /** to w przypadku kiedy korzystamy z XSD w Sieci:
			   URL schemaFile = new URL("http://host:port/filename.xsd"); */
	        Source xmlFile = new StreamSource(plikXML);
		    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		    try {
		 	   Schema schema = schemaFactory.newSchema(plikXSD);
			   Validator validator = schema.newValidator();
			   validator.validate(xmlFile);
			   Pomocnicze.komunikat(xmlFile.getSystemId() + " jest poprawny.");
		   } catch (SAXException e) {
			   Pomocnicze.komunikat(xmlFile.getSystemId() + " NIE jest poprawny, bo: " + e);
		   } catch (IOException e) {}
	  }
	   
	   public static void wczytanieDowolnegoXML(Stage aFormatka) throws ParserConfigurationException, SAXException, IOException
	   {
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      FileChooser wybierakPlikuXML = new FileChooser();
          wybierakPlikuXML.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml"));
          wybierakPlikuXML.setTitle("Sciezka do pliku XML");
          wybierakPlikuXML.setInitialDirectory(new File(System.getProperty("user.home")));
//          wybierakPlikuXML.setInitialFileName("plik.xml");
	      File plikXML = wybierakPlikuXML.showOpenDialog(aFormatka);
	      if (plikXML == null) return;
       
	      Document document = builder.parse(plikXML);
	      document.getDocumentElement().normalize();
	      Element root = document.getDocumentElement();
	      System.out.println(root.getNodeName());
	      //NodeList nList = document.getElementsByTagName("Osoba");
	      NodeList nList = document.getChildNodes();
	      rekurencyjneOdwiedzinyWezlow(nList);
	   }
	 
	   private static void rekurencyjneOdwiedzinyWezlow(NodeList nList) {
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE) {
	            System.out.println("Nazwa węzła = " + node.getNodeName() + "; Wartość = " + node.getTextContent());
	            if (node.hasAttributes()) {
	               NamedNodeMap nodeMap = node.getAttributes();
	               for (int i = 0; i < nodeMap.getLength(); i++) {
	                   Node tempNode = nodeMap.item(i);
	                   System.out.println("Nazwa atrybutu : " + tempNode.getNodeName() + "; Wartosc = " + tempNode.getNodeValue());
	               }
	            }
                if (node.hasChildNodes()) {
            	   rekurencyjneOdwiedzinyWezlow(node.getChildNodes());
                }
	         }
	      }
	   }	   
}

