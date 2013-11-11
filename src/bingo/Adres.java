/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author djvdrmee
 */
public class Adres 
{
    private String straat;
    private int nummer;             // String of Int??
    private String gemeente;
    private String postcode;
    private char bus;               // Is het char??
    
    public Adres(){
        
    }
    
    public Adres(String straat, int nummer, String gemeente, String postcode, char bus){
        this.straat = straat;
        this.nummer = nummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.bus = bus;
    }
    
    public Adres(String straat, int nummer, String gemeente, String postcode){
        this.straat = straat;
        this.nummer = nummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.bus = '0';
    }

    /**
     * @return the straat
     */
    public String getStraat() {
        return straat;
    }

    /**
     * @param straat the straat to set
     */
    public void setStraat(String straat) {
        this.straat = straat;
    }

    /**
     * @return the gemeente
     */
    public String getGemeente() {
        return gemeente;
    }

    /**
     * @param gemeente the gemeente to set
     */
    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    /**
     * @return the nummer
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * @param nummer the nummer to set
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the bus
     */
    public char getBus() {
        return bus;
    }

    /**
     * @param bus the bus to set
     */
    public void setBus(char bus) {
        this.bus = bus;
    }
    
    
}
