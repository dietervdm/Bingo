
package Logica;


import Database.Database;
import java.util.Date;

public class Aankoop
{
    private int transactienr;
    private int spaarkaart;
    private String vestigingid;
    private String winkelnaam;
    private Date datum;
    //private int ptnplus;
    //private int totprijs;
    
    
    public Aankoop()
    {}
    
    public Aankoop(int transactienr, String vestigingid, String winkelnaam, int spaarkaart)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestigingid = vestigingid;
        this.winkelnaam = winkelnaam;
        //this.ptnplus = ptnplus;
        //this.totprijs = totprijs;
    }
    
    public int getTransactienr()
    {
        return this.transactienr;
    }
    
    public void setTransactienr(int transactienr)
    {
        this.transactienr = transactienr;
    }
    
    public int getSpaarkaart()
    {
        return this.spaarkaart;
    }
    
    public void setSpaarkaart(int spaarkaart)
    {
        this.spaarkaart = spaarkaart;
    }
    
    public String getVestigingid()
    {
        return this.vestigingid;
    }
    
    public void setVestigingid(String vestigingid)
    {
        this.vestigingid = vestigingid;
    }
    
    public String getWinkelnaam() {
        return winkelnaam;
    }

    public void setWinkelnaam(String winkelnaam) {
        this.winkelnaam = winkelnaam;
    }
}
