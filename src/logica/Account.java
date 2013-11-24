
package Logica;

public class Account 
{
    protected String accountNummer;
    protected int aantalPunten;
    protected Adres adres;
    
    protected boolean vip;
    protected boolean bigSpender;
    protected boolean wolverine;
    protected boolean major;
    
    public Account()
    {
        this.accountNummer = "000000";
        this.aantalPunten = 0;
        
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
    
    public Account (String accountNummer, String straat, int nummer, String gemeente, 
                    String postcode, char bus)
    {
        this(accountNummer, new Adres(straat, nummer, gemeente, postcode, bus));
    }
    
    public Account(String nummer, Adres adres)
    {
        this.accountNummer = nummer;
        this.adres = adres;
        
        this.aantalPunten = 0;
        
        this.vip = false;
        this.bigSpender = false;
        this.wolverine = false;
        this.major = false;
    }
    
}