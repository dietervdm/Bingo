
package Logica;


public class Spaarkaart
{
    private int kaartnr;
    private Account account;
    private String naamhouder;
    
    
    public Spaarkaart()
    {}
    
    public Spaarkaart(int kaartnr, Account account)
    {
        this.kaartnr = kaartnr;
        this.account = account;
    }
    
    public Spaarkaart(int kaartnr, Account account, String naamhouder)
    {
        this.kaartnr = kaartnr;
        this.account = account;
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
    
    public Account getAccount()
    {
        return this.account;
    }
    
    public void setAccount(Account account)
    {
        this.account = account;
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
