/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author djvdrmee
 */
public class Particulier 
{
    private String klantNaam;
    private String emailAdres;
    private Datum geboorteDatum;
    
    public Particulier(){
        
    }
    
    public Particulier(String naam, String email, Datum geboorte){
        this.klantNaam = naam;
        this.emailAdres = email;
        this.geboorteDatum = geboorte;
    }
}
