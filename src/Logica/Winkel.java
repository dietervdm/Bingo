
package Logica;

import Database.Database;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;


public class Winkel
{
    private String winkelnaam;
    private int accountnr;
    private String paswoord;
    
    Database wdb = new Database();
    
    
    public Winkel()
    {}
    
    public Winkel(String winkelnaam)
    {
        this.winkelnaam = winkelnaam;
    }
    
    public Winkel(String winkelnaam, String paswoord)
    {
        this.winkelnaam = winkelnaam;
        this.paswoord = paswoord;
        accountnr = 0;
    }
    
    public Winkel(String winkelnaam, int account, String paswoord)
    {
        this.winkelnaam = winkelnaam;
        this.accountnr = account;
        this.paswoord = paswoord;
    }
    
    public String getWinkelnaam()
    {
        return this.winkelnaam;
    }
    
    public void setWinkelnaam(String winkelnaam)
    {
        this.winkelnaam = winkelnaam;
    }
    
    public int getAccount()
    {
        return this.accountnr;
    }
    
    public void setAccount(int account)
    {
        this.accountnr = account;
    }
    
    public String getPaswoord()
    {
        return this.paswoord;
    }
    
    public void setPaswoord(String paswoord)
    {
        this.paswoord = paswoord;
    }
    
    public void addWinkel(String naam, int major, String paswoord)
    {
        Winkel wk = new Winkel(naam, major, paswoord);
        wdb.addWinkel(wk);
    }
    
//    public void printWinkelAankoop(String winkelnaam, String path){
//        Database db = new Database();
//        db.printVerkopen(winkelnaam);
//
//        try
//        {
//            PrintStream out = new PrintStream(new FileOutputStream(path));
//            int cols = db.printVerkopen(winkelnaam).getMetaData().getColumnCount();
//            
//        }
//        catch(FileNotFoundException ex || SQLException sqle){
//            
//        }
        
        
        
     
    }
    
//    public void deleteWinkel(String naam)
//    {
//        this.winkelnaam = naam;
//        wdb.deleteWinkel(winkelnaam);        
//    }
//    
//    public void updateNaamWinkel(String naam){
//        this.winkelnaam = naam;
//        wdb.updateNaamWinkel(winkelnaam);
//    }
//    
//    public void updateMajorWinkel(int accnr){
//        this.accountnr = accnr;
//        wdb.updateMajorWinkel(accountnr);
//    }
//    
//    public void updatePaswoordWinkel(String ps){
//        this.paswoord = ps;
//        wdb.updatePaswoordWinkel(paswoord);
//    }
}
