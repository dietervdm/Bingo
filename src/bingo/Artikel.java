
package bingo;

/**
 *
 * @author djvdrmee
 */
public class Artikel 
{
    private int artikelNummer;
    private String artikelNaam;
    private float prijs;
    private boolean systeem;
    
    public Artikel(){
        
    }
    
    public Artikel(int nummer, String naam, float prijs, boolean systeem){
        this.artikelNummer = nummer;
        this.artikelNaam = naam;
        this.prijs = prijs;
        this.systeem = systeem;
    }
}
