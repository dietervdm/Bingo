
package Logica;


public class Winkel
{
    private String winkelnaam;
    private Account account;
    private String paswoord;
    
    
    public Winkel()
    {}
    
    public Winkel(String winkelnaam)
    {
        this.winkelnaam = winkelnaam;
    }
    
    public Winkel(String winkelnaam, String paswoord)
    {
        this.winkelnaam = winkelnaam;
        this.paswoord = paswoord;
        account = null;
    }
    
    public Winkel(String winkelnaam, Account account, String paswoord)
    {
        this.winkelnaam = winkelnaam;
        this.account = account;
        this.paswoord = paswoord;
    }
    
    public String getWinkelnaam()
    {
        return this.winkelnaam;
    }
    
    public void setWinkelnaam(String winkelnaam)
    {
        this.winkelnaam = winkelnaam;
    }
    
    public Account getAccount()
    {
        return this.account;
    }
    
    public void setAccount(Account account)
    {
        this.account = account;
    }
    
    public String getPaswoord()
    {
        return this.paswoord;
    }
    
    public void setPaswoord(String paswoord)
    {
        this.paswoord = paswoord;
    }
    
    
}
