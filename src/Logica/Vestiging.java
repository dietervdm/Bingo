
package Logica;


public class Vestiging
{
    private int VestigingId;
    private Winkel winkel;
    private String adres;
    
    
    public Vestiging()
    {}
    
    public Vestiging(Integer VestigingsId, Winkel winkel)
    {
        this.VestigingId = VestigingsId;
        this.winkel = winkel;
    }
    
    public Vestiging(Integer VestigingsId, Winkel winkel, String adres)
    {
        this.VestigingId = VestigingsId;
        this.winkel = winkel;
        this.adres = adres;
    }
    
    public int getVestigingId()
    {
        return VestigingId;
    }
    
    public void setVestigingId(int VestigingId)
    {
        this.VestigingId = VestigingId;
    }
    
    public Winkel getWinkel()
    {
        return this.winkel;
    }
    
    public void setWinkel(Winkel winkel)
    {
        this.winkel = winkel;
    }
    
    public String getAdres()
    {
        return this.adres;
    }
    
    public void setAdres(String adres)
    {
        this.adres = adres;
    }
}
