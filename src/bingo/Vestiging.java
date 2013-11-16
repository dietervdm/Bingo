package bingo;

public class Vestiging 
{
    private Adres adres;
    
    public Vestiging()
    {}
    
    public Vestiging(Adres adres)
    {
        this.adres = adres;
    }
    
    public Vestiging(String straat, int nummer, String gemeente, String postcode, char bus)
    {
        this(new Adres(straat, nummer, gemeente, postcode, bus));
    }
}