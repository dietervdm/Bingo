package Logica;

public class Adres 
{
    private String straat;
    private int nummer;             // String of Int??
    private String gemeente;
    private String postcode;
    private char bus;               // Is het char??
    
    public Adres()
    {}
    
    public Adres(String straat, int nummer, String gemeente, String postcode, char bus)
    {
        this.straat = straat;
        this.nummer = nummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.bus = bus;
    }
    
    public Adres(String straat, int nummer, String gemeente, String postcode)
    {
        this.straat = straat;
        this.nummer = nummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.bus = '0';
    }
    
    public void wijzigAdres(){
        
    }

    public String getStraat()
    {
        return straat;
    }

    public void setStraat(String straat)
    {
        this.straat = straat;
    }

    public String getGemeente()
    {
        return gemeente;
    }

    public void setGemeente(String gemeente)
    {
        this.gemeente = gemeente;
    }

    public int getNummer()
    {
        return nummer;
    }

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public char getBus()
    {
        return bus;
    }

    public void setBus(char bus)
    {
        this.bus = bus;
    }
}