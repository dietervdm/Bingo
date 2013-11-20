package bingo;

import java.awt.Image;

public class Bedrijf extends Account
{
    private String btwNummer;
    private String bedrijfsNaam;
    private Image logo;
    
    public Bedrijf()
    {
         
    }
    
    public Bedrijf(String accountNummer, String straat, int nummer, String gemeente,
                   String postcode, char bus, String btw, String naam)
    {
        super(accountNummer, straat, nummer, gemeente, postcode, bus);
        this.btwNummer = btw;
        this.bedrijfsNaam = naam;
    }
    
    public Bedrijf(String accountNummer, String straat, int nummer, String gemeente,
                   String postcode, char bus)
    {
        super(accountNummer, straat, nummer, gemeente, postcode, bus);
        this.btwNummer = "<btw-nummer>";
        this.bedrijfsNaam = "<bedrijfsnaam>";
    } 
}