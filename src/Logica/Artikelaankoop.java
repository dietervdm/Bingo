
package Logica;


public class Artikelaankoop
{
    private int transactienrAankoop;
    private int artikelnr;
    private String winkelnaam;
    private int aantal;
    private boolean metPuntenBetaald;
    
    
    public Artikelaankoop()
    {}
    
    public Artikelaankoop(int transactienr, int artikelnr, String winkelnaam, int aantal, boolean puntenBetaling)
    {
        this.transactienrAankoop = transactienr;
        this.artikelnr = artikelnr;
        this.winkelnaam = winkelnaam;
        this.aantal = aantal; // DEZE LIJN WAS NIET INGEVULD, DAAROM GAF HET DEFAULT ALTIJD 0 !!!
        this.metPuntenBetaald = puntenBetaling;
    }
    
    public int getTransactienrAankoop()
    {
        return this.transactienrAankoop;
    }
    
    public void setTransactienrAankoop(int transactienraankoop)
    {
        this.transactienrAankoop = transactienraankoop;
    }
    
    public int getArtikelnr()
    {
        return this.artikelnr;
    }
    
    public void setArtikelnr(int artikelnr)
    {
        this.artikelnr = artikelnr;
    }
    
    public String getWinkelnaam()
    {
        return this.winkelnaam;
    }
    
    public void setWinkelNaam(String winkelnaam){
        this.winkelnaam = winkelnaam;
    }
    
    public void setAankoop(int transactienrAankoop)
    {
        this.transactienrAankoop = transactienrAankoop;
    }
    
    public int getAantal()
    {
        return this.aantal;
    }
    
    public void setAantal(int aantal)
    {
        this.aantal = aantal;
    }

    public boolean isMetPuntenBetaald() {
        return metPuntenBetaald;
    }

    public void setMetPuntenBetaald(boolean metPuntenBetaald) {
        this.metPuntenBetaald = metPuntenBetaald;
    }
}
