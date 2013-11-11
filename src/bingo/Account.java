
package bingo;

/**
 *
 * @author djvdrmee
 */
public class Account 
{
    protected String klantenNummer;
    protected Adres adres;
    protected boolean vip;
    protected boolean bigSpender;
    protected boolean wolverine;
    protected boolean major;
    
    public Account(){
        this.klantenNummer = "000000";
        this.adres.setStraat("<Straat>");
        this.adres.setNummer(-1);
        this.adres.setGemeente("<Gemeente>");
        this.adres.setPostcode("0000");
        this.adres.setBus('0');
        
        this.vip = false;
        this.bigSpender = false;
        this.wolverine = false;
        this.major = false;
    }
    
    public Account (String AccountNummer, String straat, int nummer, String gemeente, 
                    String postcode, char bus)
    {
        this(AccountNummer, new Adres(straat, nummer, gemeente, postcode, bus));
    }
    
    public Account(String nummer, Adres adres){
        this.klantenNummer = nummer;
        this.adres = adres;
        
        this.vip = false;
        this.bigSpender = false;
        this.wolverine = false;
        this.major = false;
    }
    
    
}
