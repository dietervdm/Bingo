
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
    
    public Major(String winkelnaam, int accountnr)
    {
        this.accountnr = accountnr;
        this.winkelnaam = winkelnaam;
    }
    
    public Major(int accountnr, String winkelnaam, Date puntendatum, boolean actief)
    {
        this.accountnr = accountnr;
        this.winkelnaam = winkelnaam;
        this.puntendatum = puntendatum;
        this.actief = actief;
    }

    public int getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(int accountnr) {
        this.accountnr = accountnr;
    }

    public String getWinkelnaam() {
        return winkelnaam;
    }

    public void setWinkelnaam(String winkelnaam) {
        this.winkelnaam = winkelnaam;
    }

    public Date getPuntendatum() {
        return puntendatum;
    }

    public void setPuntendatum(Date puntendatum) {
        this.puntendatum = puntendatum;
    }
    
    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }
}
