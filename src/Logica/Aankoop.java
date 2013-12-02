
package Logica;


import java.util.Date;

public class Aankoop
{
    private int transactienr;
    private int spaarkaart;
    private int vestiging;
    private String winkelnaam;
    private Date datum;
    //private int ptnplus;
    //private int ptnmin;
    //private int totprijs;
    
    
    public Aankoop()
    {}
    
    public Aankoop(int transactienr, int spaarkaart, int vestiging, String winkelnaam)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestiging = vestiging;
        this.winkelnaam = winkelnaam;
    }
    
    public Aankoop(int transactienr, int spaarkaart, int vestiging, String winkelnaam, Date datum)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestiging = vestiging;
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
    
    public int getVestiging()
    {
        return this.vestiging;
    }
    
    public void setVestiging(int vestiging)
    {
        this.vestiging = vestiging;
    }
    
    public Date getDatum()
    {
        return this.datum;
    }
    
    public void setDatum(Date datum)
    {
        this.datum = datum;
    }
    
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
