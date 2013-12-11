
package Logica;

import Database.Database;
import java.sql.Date;
import java.util.ArrayList;


public class Major
{
    private int accountnr;
    private String winkelnaam;
    private Date puntendatum;
    
    Database db = new Database();
    
    public Major()
    {}
    
    public Major(String winkelnaam, int accountnr)
    {
        this.winkelnaam = winkelnaam;
        this.accountnr = accountnr;
    }
    
    public Major(int accountnr, String winkelnaam, Date puntendatum)
    {
        this.accountnr = accountnr;
        this.winkelnaam = winkelnaam;
        this.puntendatum = puntendatum;
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
  }
