
package Logica;


import java.util.Date;

public class Aankoop
{
    private int transactienr;
    private Spaarkaart spaarkaart;
    private Vestiging vestiging;
    private Date datum;
    private Integer ptnplus;
    private Integer ptnmin;
    private Integer totprijs;
    
    
    public Aankoop()
    {}
    
    public Aankoop(int transactienr, Spaarkaart spaarkaart, Vestiging vestiging)
    {
        this.transactienr = transactienr;
        this.spaarkaart = spaarkaart;
        this.vestiging = vestiging;
    }
    
    public Aankoop(int transactienr, Spaarkaart spaarkaart, Vestiging vestiging,
                   Date datum, Integer ptnplus, Integer ptnmin, Integer totprijs)
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
    
    public Integer getPtnplus()
    {
        return this.ptnplus;
    }
    
    public void setPtnplus(Integer ptnplus)
    {
        this.ptnplus = ptnplus;
    }
    
    public Integer getPtnmin()
    {
        return this.ptnmin;
    }
    
    public void setPtnmin(Integer ptnmin)
    {
        this.ptnmin = ptnmin;
    }
    
    public Integer getTotprijs()
    {
        return this.totprijs;
    }
    
    public void setTotprijs(Integer totprijs)
    {
        this.totprijs = totprijs;
    }
}
