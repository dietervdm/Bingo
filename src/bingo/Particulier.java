package bingo;

import java.awt.Image;

public class Particulier extends Account
{
    private String klantNaam;
    private String emailAdres;
    private Datum geboorteDatum;
    
    private Image pasfoto;
        //http://wiki.gxtechnical.com/commwiki/servlet/hwiki?Image+Data+Type,
    
    public Particulier()
    {}
    
    public Particulier(String naam, String email, Datum geboorte)
    {
        this.klantNaam = naam;
        this.emailAdres = email;
        this.geboorteDatum = geboorte;
    }
}