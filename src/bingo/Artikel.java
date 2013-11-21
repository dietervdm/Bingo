package Logica;

public class Artikel 
{
    private String artikelNummer;
    private String artikelNaam;
    private double prijs;
    private boolean systeem;
   
    private int aantalPuntenPlus;
    private int aantalPuntenMin;
    
    public Artikel()
    {
        this.artikelNummer = "<nummer>";
        this.artikelNaam = "<naam>";
        this.prijs = -1.0;
        this.systeem = systeem;
        
        this.aantalPuntenPlus = 0;
        this.aantalPuntenMin = 0;
    }
    
    public Artikel(String nummer, String naam, double prijs, boolean systeem, int pl, int min)
    {
        this.artikelNummer = nummer;
        this.artikelNaam = naam;
        this.prijs = prijs;
        this.systeem = systeem;
        
        this.aantalPuntenPlus = pl;
        this.aantalPuntenMin = min;
    }
    
    
}