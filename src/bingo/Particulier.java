/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.awt.Image;

/**
 *
 * @author djvdrmee
 */
public class Particulier extends Account
{
    private String klantNaam;
    private String emailAdres;
    private Datum geboorteDatum;
    
    private Image pasfoto;
        //http://wiki.gxtechnical.com/commwiki/servlet/hwiki?Image+Data+Type,
    
    public Particulier(){
        
    }
    
    public Particulier(String naam, String email, Datum geboorte){
        this.klantNaam = naam;
        this.emailAdres = email;
        this.geboorteDatum = geboorte;
    }
}
