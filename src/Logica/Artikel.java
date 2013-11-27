
package Logica;


public class Artikel  implements java.io.Serializable
{
    private int Artikelnr;
    private Winkel winkel;
    private String artikelnaam;
    private Integer prijs;
    private Integer ptnwinst;
    private Integer minimumaantal;
    private Integer ptnkost;
    private Integer minimumbedrag;
    
    
    public Artikel()
    {}
    
    public Artikel(int ArtikelId, Winkel winkel)
    {
        this.Artikelnr = ArtikelId;
        this.winkel = winkel;
    }
    
    public Artikel(Integer ArtikelId, Winkel winkel, String artikelnaam, Integer prijs,
                   Integer ptnwinst, Integer minimumaantal, Integer ptnkost, Integer minimumbedrag)
    {
       this.Artikelnr = ArtikelId;
       this.winkel = winkel;
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
    
    public Winkel getWinkel()
    {
        return this.winkel;
    }
    
    public void setWinkel(Winkel winkel)
    {
        this.winkel = winkel;
    }
    
    public String getArtikelnaam()
    {
        return this.artikelnaam;
    }
    
    public void setArtikelnaam(String artikelnaam)
    {
        this.artikelnaam = artikelnaam;
    }
    
    public Integer getPrijs()
    {
        return this.prijs;
    }
    
    public void setPrijs(Integer prijs)
    {
        this.prijs = prijs;
    }
    
    public Integer getPtnwinst()
    {
        return this.ptnwinst;
    }
    
    public void setPtnwinst(Integer ptnwinst)
    {
        this.ptnwinst = ptnwinst;
    }
    
    public Integer getMinimumaantal()
    {
        return this.minimumaantal;
    }
    
    public void setMinimumaantal(Integer minimumaantal)
    {
        this.minimumaantal = minimumaantal;
    }
    
    public Integer getPtnkost()
    {
        return this.ptnkost;
    }
    
    public void setPtnkost(Integer ptnkost)
    {
        this.ptnkost = ptnkost;
    }
    
    public Integer getMinimumbedrag()
    {
        return this.minimumbedrag;
    }
    
    public void setMinimumbedrag(Integer minimumbedrag)
    {
        this.minimumbedrag = minimumbedrag;
    }
}
