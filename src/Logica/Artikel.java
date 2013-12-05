
package Logica;

import Database.Database;
import javax.swing.JOptionPane;


public class Artikel
{
    private int artikelnr;
    private String winkelnaam;
    private String artikelnaam;
    private double prijs;
    private int ptnwinst;
    private int minimumaantal;
    private Integer ptnkost;
    private int minimumbedrag;
    public static Database d = new Database();
    
    
    public Artikel()
    {}
    
    public Artikel(int artikelnr, String winkelnaam)
    {
        this.artikelnr = artikelnr;
        this.winkelnaam = winkelnaam;
    }
    
    public Artikel(int artikelnr, String winkelnaam, String artikelnaam, double prijs,
                   int ptnwinst, int minimumaantal, Integer ptnkost, int minimumbedrag)
    {
       this.artikelnr = artikelnr;
       this.winkelnaam = winkelnaam;
       this.artikelnaam = artikelnaam;
       this.prijs = prijs;
       this.ptnwinst = ptnwinst;
       this.minimumaantal = minimumaantal;
       this.ptnkost = ptnkost;
       this.minimumbedrag = minimumbedrag;
    }
    
    public static boolean minstensArtikelPlus(String winkelnaam){
    
            if(d.aantalArtikelen(winkelnaam) == d.aantalArtikelenNietPlus(winkelnaam)){
                return false;
            }
            else return true;
        }
     
     public static boolean minstensArtikelMin(String winkelnaam){

        if(d.aantalArtikelen(winkelnaam) == d.aantalArtikelenNietPlus(winkelnaam)){
                return false;
            }
            else return true;
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
    
    public Integer getPtnkost()
    {
        return this.ptnkost;
    }
    
    public void setPtnkost(Integer ptnkost)
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
    
    public void getArtikelnaamFromArtikelnr()
    {
        Database db = new Database();
        this.artikelnaam = db.getArtikel(artikelnr, winkelnaam).getArtikelnaam();
    }
    
    public void getPrijsFromArtikelnr()
    {
        Database db = new Database();
        this.prijs = db.getArtikel(artikelnr, winkelnaam).getPrijs();
    }
    
    public void getPtnwinstFromArtikelnr()
    {
        Database db = new Database();
        this.ptnwinst = db.getArtikel(artikelnr, winkelnaam).getPtnwinst();
    }
    
    public void getMinimumaantalFromArtikelnr()
    {
        Database db = new Database();
        this.minimumaantal = db.getArtikel(artikelnr, winkelnaam).getMinimumaantal();
    }
    
    public void getPtnkostFromArtikelnr()
    {
        Database db = new Database();
        this.ptnkost = db.getArtikel(artikelnr, winkelnaam).getPtnkost();
    }
    
    public void getMinimumbedragFromArtikelnr()
    {
        Database db = new Database();
        this.minimumbedrag = db.getArtikel(artikelnr, winkelnaam).getMinimumbedrag();
    }
    
    
    public static boolean checkPuntenplusWaarde(int puntenplus, double prijs)
    {
        if(((puntenplus/prijs) < 0.25) || ((puntenplus/prijs) > 2))
        {
            return false;
        }        
        else
        {
            return true;
        }
    }
    
    public static boolean checkPuntenminWaarde(int puntenmin, double prijs)
    {
        if((puntenmin/prijs) < 0.25 || (puntenmin/prijs) > 2)
        {
            return false;
        }        
        else
        {
            return true;
        }
    }
}
