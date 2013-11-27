
package Logica;


import java.util.Date;

public class Aankoop
{
    private int transactienr;
    private Spaarkaart spaarkaart;
    private Vestiging vestiging;
    private Date datum;
    private int ptnplus;
    private int ptnmin;
    private int totprijs;
    
    
    public Aankoop()
    {}
    
    public Aankoop(int transactienr, Spaarkaart spaarkaart, Vestiging vestiging)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestiging = vestiging;
    }
    
    public Aankoop(int transactienr, Spaarkaart spaarkaart, Vestiging vestiging,
                   Date datum, int ptnplus, int ptnmin, int totprijs)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestiging = vestiging;
        this.datum = datum;
        this.ptnplus = ptnplus;
        this.ptnmin = ptnmin;
        this.totprijs = totprijs;
    }
    
    public int getTransactienr()
    {
        return this.transactienr;
    }
    
    public void setTransactienr(int transactienr)
    {
        this.transactienr = transactienr;
    }
    
    public Spaarkaart getSpaarkaart()
    {
        return this.spaarkaart;
    }
    
    public void setSpaarkaart(Spaarkaart spaarkaart)
    {
        this.spaarkaart = spaarkaart;
    }
    
    public Vestiging getVestiging()
    {
        return this.vestiging;
    }
    
    public void setVestiging(Vestiging vestiging)
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
    
    public int getPtnplus()
    {
        return this.ptnplus;
    }
    
    public void setPtnplus(int ptnplus)
    {
        this.ptnplus = ptnplus;
    }
    
    public int getPtnmin()
    {
        return this.ptnmin;
    }
    
    public void setPtnmin(int ptnmin)
    {
        this.ptnmin = ptnmin;
    }
    
    public int getTotprijs()
    {
        return this.totprijs;
    }
    
    public void setTotprijs(int totprijs)
    {
        this.totprijs = totprijs;
    }
}
