
package Logica;

import Database.Database;


public class Spaarkaart
{
    private int kaartnr;
    private int accountnr;
    private String naamhouder;
    
    
    public Spaarkaart()
    {}
    
    public Spaarkaart(int kaartnr){
        this.kaartnr = kaartnr;
        setAccountnrFromKaartnr(kaartnr);
        setNaamhouderFromKaartnr(kaartnr);
    }
    
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
    
    public void setAccountnrFromKaartnr(int kaartnr){
        Database db = new Database();
        this.accountnr = db.getSpaarkaart(kaartnr).getAccountnr();
    }
    
    public String getNaamhouder()
    {
        return this.naamhouder;
    }
    
    public void setNaamhouder(String naamhouder)
    {
        this.naamhouder = naamhouder;
    }
    
    public void setNaamhouderFromKaartnr(int kaarnr){
        Database db = new Database();
        this.naamhouder = db.getSpaarkaart(kaartnr).getNaamhouder();
    }
}
