
package Logica;


public class Vestiging
{
    private int VestigingId;
    private String winkelnaam;
    private String adres;
    
    
    public Vestiging()
    {}
    
    public Vestiging(int VestigingId, String winkelnaam)
    {
        this.VestigingId = VestigingId;
        this.winkelnaam = winkelnaam;
    }
    
    public Vestiging(int VestigingId, String winkelnaam, String adres)
    {
        this.VestigingId = VestigingId;
        this.winkelnaam = winkelnaam;
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
    
    public String getWinkelnaam()
    {
        return this.winkelnaam;
    }
    
    public void setWinkelnaam(String winkelnaam)
    {
        this.winkelnaam = winkelnaam;
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
