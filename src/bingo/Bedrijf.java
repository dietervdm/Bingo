/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author djvdrmee
 */
public class Bedrijf extends Account
{
    private String btwNummer;
    private String bedrijfsNaam;
    
    public Bedrijf(){
        
    }
    
    public Bedrijf(String accountNummer, String straat, int nummer, String gemeente,
                   String postcode, char bus){
        super(accountNummer, straat, nummer, gemeente, postcode, bus);
    }
    
}
