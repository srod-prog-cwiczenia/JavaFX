package przyklady;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import narzedzia.Pomocnicze;

public class BazaDanych {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:osoby.db";

    private Connection conn;
    private Statement stat;
    private boolean poprawnie;
    public boolean isPoprawnie() {
    	return poprawnie;
    }
    public BazaDanych() {
    	   poprawnie = true;
    	   try {
               Class.forName(BazaDanych.DRIVER);
           } catch (ClassNotFoundException e) {
        	   Pomocnicze.komunikat("Brak sterownika JDBC.\n" + 
                 "Należy ściągnąć plik sqlite-jdbc*.jar i podpiąć go do lib używanych przez projekt");
               poprawnie = false;
               return;
           }

           try {
               conn = DriverManager.getConnection(DB_URL);
               stat = conn.createStatement();
           } catch (SQLException e) {
        	   Pomocnicze.komunikat("Problem z otwarciem polaczenia z bazą danych");
               poprawnie = false;
               return;
           }    	
    }

    public void testBazyDanych() {
//stworzenie tabeli    	
    	String createSQL = 
    			"CREATE TABLE IF NOT EXISTS OSOBY " +
    			"(ID INTEGER PRIMARY KEY AUTOINCREMENT, IMIE VARCHAR(255), " +
    			"NAZWISKO VARCHAR(255), PESEL VARCHAR(11))";
        try {
            stat.execute(createSQL);
        } catch (SQLException e) {
            Pomocnicze.komunikat("Blad podczas tworzeniu tabeli OSOBY!");
        }    	
     
        try {
        	PreparedStatement prepStmt = 
        		conn.prepareStatement(
                "INSERT INTO OSOBY VALUES (NULL, ?, ?, ?);");
        	prepStmt.setString(1, "Anna");
        	prepStmt.setString(2, "Koralewska");
        	prepStmt.setString(3, "11111111111");
        	prepStmt.execute();
        	prepStmt.setString(1, "Danuta");
        	prepStmt.setString(2, "Kamińska");
        	prepStmt.setString(3, "22222222222");
        	prepStmt.execute();
        } catch (SQLException e) {
        	Pomocnicze.komunikat("Blad przy wstawianiu pozycji do tabeli OSOBY");
        }
        
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM OSOBY");
            int id;
            String imie, nazwisko, pesel;
            String txt = "";
            while (result.next()) {
                id = result.getInt("ID");
                imie = result.getString("IMIE");
                nazwisko = result.getString("NAZWISKO");
                pesel = result.getString("PESEL");
                txt += id + " " + imie + " " + nazwisko + " " + pesel;
                txt += "\n";
            }
            Pomocnicze.komunikat(txt);
        } catch (SQLException e) {
        	Pomocnicze.komunikat("Błąd podczas wykonywania SELECT na tabeli OSOBY");
        }

        
        try {
        	String sql = "DELETE FROM OSOBY";
            stat.executeUpdate(sql);
        	sql = "DROP TABLE OSOBY";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
        	Pomocnicze.komunikat("Blad przy usuwaniu tabeli OSOBY");
        }    	

    }
    
    public void zamknieciePolaczenia() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
