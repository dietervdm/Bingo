
package Logica;

import Database.Database;
import java.sql.Date;
import java.util.ArrayList;


public class Major
{
    private int accountnr;
    private String winkelnaam;
    private Date puntendatum;
    private boolean actief;
    
    public Major()
    {}
    
    public Major(int accountnr, String winkelnaam, Date puntendatum, boolean actief)
    {
        this.accountnr = accountnr;
        this.winkelnaam = winkelnaam;
        this.puntendatum = puntendatum;
        this.actief = actief;
    }

    /**
     * @return the accountnr
     */
    public int getAccountnr() {
        return accountnr;
    }

    /**
     * @param accountnr the accountnr to set
     */
    public void setAccountnr(int accountnr) {
        this.accountnr = accountnr;
    }

    /**
     * @return the winkelnaam
     */
    public String getWinkelnaam() {
        return winkelnaam;
    }

    /**
     * @param winkelnaam the winkelnaam to set
     */
    public void setWinkelnaam(String winkelnaam) {
        this.winkelnaam = winkelnaam;
    }

    /**
     * @return the puntendatum
     */
    public Date getPuntendatum() {
        return puntendatum;
    }

    /**
     * @param puntendatum the puntendatum to set
     */
    public void setPuntendatum(Date puntendatum) {
        this.puntendatum = puntendatum;
    }

    /**
     * @return the actief
     */
    public boolean isActief() {
        return actief;
    }

    /**
     * @param actief the actief to set
     */
    public void setActief(boolean actief) {
        this.actief = actief;
    }
    
    
}
