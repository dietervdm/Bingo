
package Logica;


public class Artikelaankoop
{
    private int transactienrAankoop;
    private Artikel artikel;
    private Aankoop aankoop;
    private int aantal;
    
    
    public Artikelaankoop()
    {}
    
    public Artikelaankoop(int transactienr, Artikel artikel, Aankoop aankoop)
    {
        this.transactienrAankoop = transactienr;
        this.artikel = artikel;
        this.aankoop = aankoop;
    }
    
    public Artikelaankoop(int transactienr, Artikel artikel, Aankoop aankoop, int aantal)
    {
        this.transactienrAankoop = transactienr;
        this.artikel = artikel;
        this.aankoop = aankoop;
        this.aantal = aantal;
    }
    
    public int getTransactienr()
    {
        return this.transactienrAankoop;
    }
    
    public void setTransactienr(int transactienr)
    {
        this.transactienrAankoop = transactienr;
    }
    
    public Artikel getArtikel()
    {
        return this.artikel;
    }
    
    public void setArtikel(Artikel artikel)
    {
        this.artikel = artikel;
    }
    
    public Aankoop getAankoop()
    {
        return this.aankoop;
    }
    
    public void setAankoop(Aankoop aankoop)
    {
        this.aankoop = aankoop;
    }
    
    public int getAantal()
    {
        return this.aantal;
    }
    
    public void setAantal(int aantal)
    {
        this.aantal = aantal;
    }
}
