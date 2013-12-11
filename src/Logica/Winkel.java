
package Logica;

import Database.Database;
import java.util.ArrayList;


public class Winkel
{
    private String winkelnaam;
    private int accountnr;
    private String paswoord;
    
    Database wdb = new Database();
    
    
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
        accountnr = 0;
    }
    
    public Winkel(String winkelnaam, int account, String paswoord)
    {
        this.winkelnaam = winkelnaam;
        this.accountnr = account;
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
    
    public int getAccount()
    {
        return this.accountnr;
    }
    
    public void setAccount(int account)
    {
        this.accountnr = account;
    }
    
    public String getPaswoord()
    {
        return this.paswoord;
    }
    
    public void setPaswoord(String paswoord)
    {
        this.paswoord = paswoord;
    }
    
    
    public void addWinkel(String naam, int major, String paswoord)
    {
        Winkel wk = new Winkel(naam, major, paswoord);
        wdb.addWinkel(wk);
    }
    
    public ArrayList<String> getLijstVestigingen(){
        Database db = new Database();
        ArrayList<Vestiging> vVest = null;
        vVest = db.getAlleVestigingen(winkelnaam);
        ArrayList<String> vString = new ArrayList<String>();
        
        for(int i=0; i<vVest.size(); i++)
        {
            vString.add(vVest.get(i).getVestigingId());
        }
        return vString;
    }         
}
