package Logica;

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
    
    public void toevoegenVestiging(){
        // hier controleren of er een winkel bestaat
        
        // Ideetje: aangezien eerst een nieuwe winkel wordt gemaakt,
        //kan bij het aanmaken van een neiuwe vestiging een drop down menu getoond worden
        //waar enkel de reeds aangemaakte winkels in staan.
    }
    
    public void verwijderenVestiging(){
        
    }
    
    public void wijzigVestiging(){
        // voorbeeld winkel veranderen...
    } 
}