package logica;

import java.awt.Image;

public class Particulier extends Account
{
    private String klantNaam;
    private String emailAdres;
    private Datum geboorteDatum;
    
    private Image pasfoto;
        //http://wiki.gxtechnical.com/commwiki/servlet/hwiki?Image+Data+Type,
    
    public Particulier(String accountNummer, String straat, int nummer, String gemeente,
                   String postcode, char bus, String btw, String naam, String klantNaam, String email)
    {
        super(accountNummer, straat, nummer, gemeente, postcode, bus);
        this.klantNaam = klantNaam;
        this.emailAdres = email;
        
    }
    
    public Particulier(String naam, String email, Datum geboorte)
    {
        this.klantNaam = naam;
        this.emailAdres = email;
        this.geboorteDatum = geboorte;
    }
}