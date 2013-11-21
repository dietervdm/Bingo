
package logica;

public class Spaarkaart 
{
    private int qrCode;
    private String spaarkaartHouder;
    
    public Spaarkaart()
    {
        this.qrCode = 0;
        this.spaarkaartHouder = "<Naam spaarkaarthouder>";
    }
    
    public Spaarkaart(int qr, String spaarkaartHouder){
        this.qrCode = qr;
        this.spaarkaartHouder = spaarkaartHouder;
    }
    
    public void toevoegenSpaarkaart(){
        
    }
    
    public void verwijderenSpaarkaart(){
        
    }
    
    public void wijzigAccountSpaarkaart(){
        
    }
}
