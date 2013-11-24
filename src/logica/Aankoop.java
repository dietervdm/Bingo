
package logica;

import java.util.ArrayList;

public class Aankoop 
{
    private String winkel;
    private String transactieNummer;
    private Datum aankoopDatum;
    private ArrayList<Artikel> aankooplijst;
    
    public Aankoop(){
        this.winkel = "<winkel>";
        this.transactieNummer = "<transactienummer>";
        this.aankoopDatum = new Datum();
        this.aankooplijst = new ArrayList<Artikel>();
    }
    
    public Aankoop(String winkel, String tnr, Datum datum, ArrayList<Artikel> aklst){
        this.winkel = winkel;
        this.transactieNummer = tnr;
        this.aankoopDatum = datum;
        this.aankooplijst = aklst;
    }
}
