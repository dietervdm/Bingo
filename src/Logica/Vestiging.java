
package Logica;

import Database.Database;
import java.util.ArrayList;


public class Vestiging
{
    private String VestigingId;
    private String winkelnaam;
    private String adres;
    
    
    public Vestiging()
    {}
    
    public Vestiging(String VestigingId, String winkelnaam)
    {
        this.VestigingId = VestigingId;
        this.winkelnaam = winkelnaam;
    }
    
    public Vestiging(String VestigingId, String winkelnaam, String adres)
    {
        this.VestigingId = VestigingId;
        this.winkelnaam = winkelnaam;
        this.adres = adres;
    }
    
    public String getVestigingId()
    {
        return VestigingId;
    }
    
    public void setVestigingId(String VestigingId)
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
    
    public ArrayList<String> getAlleVestigingenNaam(String winkelnaam){
        ArrayList<String> vestigingenId = new ArrayList<String>();
        ArrayList<Vestiging> vest = new ArrayList<Vestiging>();
        Database db = new Database();
        
        vest = db.getAlleVestigingen(winkelnaam);
        for(int i=0; i<vest.size(); i++)
        {
            vestigingenId.add(vest.get(i).getVestigingId());  
        }
        return vestigingenId;
    }
}
