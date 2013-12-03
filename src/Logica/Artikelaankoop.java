
package Logica;


public class Artikelaankoop
{
    private int transactienrAankoop;
    private int artikelnr;
    private String winkelnaam;
    private int transactienr;
    private int aantal;
    private boolean metPuntenBetaald;
    
    
    public Artikelaankoop()
    {}
    
    public Artikelaankoop(int transactienr, int artikelnr, String winkelnaam, int transactienummer, boolean puntenBetaling)
    {
        this.transactienrAankoop = transactienr;
        this.artikelnr = artikelnr;
        this.winkelnaam = winkelnaam;
        this.transactienr = transactienummer;
        this.metPuntenBetaald = puntenBetaling;
    }
    
    public Artikelaankoop(int transactienr, int artikelnr, String winkelnaam, int transactienummer, int aantal)
    {
        this.transactienrAankoop = transactienr;
        this.artikelnr = artikelnr;
        this.transactienr = transactienummer;
        this.aantal = aantal;
    }
    
    public int getTransactienrAankoop()
    {
        return this.transactienrAankoop;
    }
    
    public void setTransactienrAaankoop(int transactienraankoop)
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
    
    public int getTransactienr()
    {
        return this.transactienr;
    }
    
    public void setAankoop(int transactienummer)
    {
        this.transactienr = transactienummer;
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
