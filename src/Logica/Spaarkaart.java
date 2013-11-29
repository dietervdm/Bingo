
package Logica;

import javax.swing.Timer;


public class Spaarkaart
{
    private int kaartnr;
    private int accountnr;
    private String naamhouder;
    
    
    public Spaarkaart()
    {}
    
    public Spaarkaart(int kaartnr, int accountnr)
    {
        this.kaartnr = kaartnr;
        this.accountnr = accountnr;
    }
    
    public Spaarkaart(int kaartnr, int accountnr, String naamhouder)
    {
        this.kaartnr = kaartnr;
        this.accountnr = accountnr;
        this.naamhouder = naamhouder;
    }
    
    public int getKaartnr()
    {
        return this.kaartnr;
    }
    
    public void setKaartnr(int kaartnr)
    {
        this.kaartnr = kaartnr;
    }
    
    public int getAccountnr()
    {
        return this.accountnr;
    }
    
    public void setAccountnr(int accountnr)
    {
        this.accountnr = accountnr;
    }
    
    public String getNaamhouder()
    {
        return this.naamhouder;
    }
    
    public void setNaamhouder(String naamhouder)
    {
        this.naamhouder = naamhouder;
    }
}
