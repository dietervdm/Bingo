
package Logica;


public class Artikel
{
    private int Artikelnr;
    private String winkelnaam;
    private String artikelnaam;
    private int prijs;
    private int ptnwinst;
    private int minimumaantal;
    private int ptnkost;
    private int minimumbedrag;
    
    
    public Artikel()
    {}
    
    public Artikel(int Artikelnr, String winkelnaam)
    {
        this.Artikelnr = Artikelnr;
        this.winkelnaam = winkelnaam;
    }
    
    public Artikel(int Artikelnr, String winkelnaam, String artikelnaam, int prijs,
                   int ptnwinst, int minimumaantal, int ptnkost, int minimumbedrag)
    {
       this.Artikelnr = Artikelnr;
       this.winkelnaam = winkelnaam;
       this.artikelnaam = artikelnaam;
       this.prijs = prijs;
       this.ptnwinst = ptnwinst;
       this.minimumaantal = minimumaantal;
       this.ptnkost = ptnkost;
       this.minimumbedrag = minimumbedrag;
    }
    
    public int getArtikelnr()
    {
        return Artikelnr;
    }
    
    public void setArtikelnr(int Artikelnr)
    {
        this.Artikelnr = Artikelnr;
    }
    
    public String getWinkelnaam()
    {
        return winkelnaam;
    }
    
    public void setWinkelnaam(String winkelnaam)
    {
        this.winkelnaam = winkelnaam;
    }
    
    public String getArtikelnaam()
    {
        return this.artikelnaam;
    }
    
    public void setArtikelnaam(String artikelnaam)
    {
        this.artikelnaam = artikelnaam;
    }
    
    public int getPrijs()
    {
        return this.prijs;
    }
    
    public void setPrijs(int prijs)
    {
        this.prijs = prijs;
    }
    
    public int getPtnwinst()
    {
        return this.ptnwinst;
    }
    
    public void setPtnwinst(int ptnwinst)
    {
        this.ptnwinst = ptnwinst;
    }
    
    public int getMinimumaantal()
    {
        return this.minimumaantal;
    }
    
    public void setMinimumaantal(int minimumaantal)
    {
        this.minimumaantal = minimumaantal;
    }
    
    public int getPtnkost()
    {
        return this.ptnkost;
    }
    
    public void setPtnkost(int ptnkost)
    {
        this.ptnkost = ptnkost;
    }
    
    public int getMinimumbedrag()
    {
        return this.minimumbedrag;
    }
    
    public void setMinimumbedrag(int minimumbedrag)
    {
        this.minimumbedrag = minimumbedrag;
    }
}
