
package Logica;

import Database.Database;


public class Artikel
{
    private int artikelnr;
    private String winkelnaam;
    private String artikelnaam;
    private double prijs;
    private int ptnwinst;
    private int minimumaantal;
    private int ptnkost;
    private int minimumbedrag;
    
    
    public Artikel()
    {}
    
    
    public Artikel(int Artikelnr, String winkelnaam)
    {
        this.artikelnr = Artikelnr;
        this.winkelnaam = winkelnaam;
        getArtikelnaamFromArtikelnr();
        getPrijsFromArtikelnr();
        getPtnwinstFromArtikelnr();
        getMinimumaantalFromArtikelnr();
        getPtnkostFromArtikelnr();
        getMinimumbedragFromArtikelnr();
    }
    
    public Artikel(int Artikelnr, String winkelnaam, String artikelnaam, double prijs,
                   int ptnwinst, int minimumaantal, int ptnkost, int minimumbedrag)
    {
       this.artikelnr = Artikelnr;
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
        return artikelnr;
    }
    
    public void setArtikelnr(int Artikelnr)
    {
        this.artikelnr = Artikelnr;
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
    
    public double getPrijs()
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
    
    public void getArtikelnaamFromArtikelnr(){
        Database db = new Database();
        this.artikelnaam = db.getArtikel(artikelnr, winkelnaam).getArtikelnaam();
    }
    
    public void getPrijsFromArtikelnr(){
        Database db = new Database();
        this.prijs = db.getArtikel(artikelnr, winkelnaam).getPrijs();
    }
    
    public void getPtnwinstFromArtikelnr(){
        Database db = new Database();
        this.ptnwinst = db.getArtikel(artikelnr, winkelnaam).getPtnwinst();
    }
    
    public void getMinimumaantalFromArtikelnr(){
        Database db = new Database();
        this.minimumaantal = db.getArtikel(artikelnr, winkelnaam).getMinimumaantal();
    }
    
    public void getPtnkostFromArtikelnr(){
        Database db = new Database();
        this.ptnkost = db.getArtikel(artikelnr, winkelnaam).getPtnkost();
    }
    
    public void getMinimumbedragFromArtikelnr(){
        Database db = new Database();
        this.minimumbedrag = db.getArtikel(artikelnr, winkelnaam).getMinimumbedrag();
    }
}
