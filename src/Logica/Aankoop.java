
package Logica;


import Database.Database;
import java.util.Date;

public class Aankoop
{
    private int transactienr;
    private int spaarkaart;
    private int vestigingid;
    private String winkelnaam;
    private Date datum;
    //private int ptnplus;
    //private int ptnmin;
    //private int totprijs;
    
    
    public Aankoop()
    {}

//    public Aankoop(int transactienr, int spaarkaart, int vestigingid, String winkelnaam)
//    {
//        this.transactienr = transactienr;
//        this.spaarkaart = spaarkaart;
//        this.vestigingid = vestigingid;
//        this.winkelnaam = winkelnaam;
//    }
    
    public Aankoop(int transactienr, int vestigingid, String winkelnaam, int spaarkaart, Date datum)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestigingid = vestigingid;
        this.winkelnaam = winkelnaam;
        this.datum = datum;
        //this.ptnplus = ptnplus;
        //this.ptnmin = ptnmin;
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
    
    public int getVestigingid()
    {
        return this.vestigingid;
    }
    
    public void setVestigingid(int vestigingid)
    {
        this.vestigingid = vestigingid;
    }
    
    public String getWinkelnaam() {
        return winkelnaam;
    }

    public void setWinkelnaam(String winkelnaam) {
        this.winkelnaam = winkelnaam;
    }
    
    public Date getDatum()
    {
        return this.datum;
    }
    
    public void setDatum(Date datum)
    {
        this.datum = datum;
    }
    
//    public Aankoop getLaatsteAankoop(){
//        Database db = new Database();
//        return db.getLaatsteAankoop();
//    }
    
//    public int getPtnplus()
//    {
//        return this.ptnplus;
//    }
//    
//    public void setPtnplus(int ptnplus)
//    {
//        this.ptnplus = ptnplus;
//    }
//    
//    public int getPtnmin()
//    {
//        return this.ptnmin;
//    }
//    
//    public void setPtnmin(int ptnmin)
//    {
//        this.ptnmin = ptnmin;
//    }
//    
//    public int getTotprijs()
//    {
//        return this.totprijs;
//    }
//    
//    public void setTotprijs(int totprijs)
//    {
//        this.totprijs = totprijs;
//    }
}
