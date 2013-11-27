
package Database;

import Logica.*;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;



public class Database {
    
    private static final String db = "BINFG31";
    private static final String user = "BINFG31";
    private static final String pasw = "aeCahqu3";
    
    private Connection dbConnection = null;
    
    public Connection getConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String protocol = "jdbc";
            String subProtocol = "mysql";
            String subName = "//mysqlha2.ugent.be/" + db +
                    "?user=" + user +
                    "&password=" + pasw;

            String URL = protocol +":"+ subProtocol +":"+subName;

            dbConnection = DriverManager.getConnection(URL);
            
            return dbConnection;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            try{
                dbConnection.close();
            } 
            catch (Exception e){}
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            try{
                dbConnection.close();
            } 
            catch (Exception e){}
            return null;
        }
    }
    
    public void closeConnection(){
        try {
            dbConnection.close();
        } 
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            try{
                dbConnection.close();
            } 
            catch (Exception e){}
        }
    }
    
    public ResultSet getData(String opdracht){
        
        ResultSet srs = null;
        
        try{
            dbConnection = getConnection();
            
            Statement stmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = opdracht;
            srs = stmt.executeQuery(sql);

            return srs;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return srs;
        }
    }
    
    public void addWinkel(Winkel w){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO winkel(winkelnaam,accountnr,paswoord) " + "VALUES ( '" + w.getWinkelnaam() + "', 0, '" + w.getPaswoord() + "')");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkWinkel(String winkelnaam){
        try{
            String sql = "SELECT * FROM winkel WHERE winkelnaam='" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            if(srs.next()){
                return true;
            }
            else return false;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    public Winkel getWinkel(String winkelnaam){
        try{
            String sql = "SELECT * FROM winkel WHERE winkelnaam='" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int accountnr = srs.getInt("accountnr");
                String naam = srs.getString("winkelnaam");
                String paswoord = srs.getString("paswoord");
                Winkel w = new Winkel(naam,accountnr,paswoord);
                this.closeConnection();
                return w;
            }
            else return null;
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    public void deleteWinkel(Winkel w){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from winkel WHERE winkelnaam=" + w.getWinkelnaam());
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void addArtikel(Artikel a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO artikel(artikelnr,winkelnaam,artikelnaam,prijs,ptnwinst,minimumaantal,ptnkost,minimumbedrag) " + "VALUES (" + a.getArtikelnr() + ", '" + a.getWinkelnaam() + "', '" + a.getArtikelnaam() + "', " + a.getPrijs() + ", " + a.getPtnwinst() + ", " + a.getMinimumaantal() + ", " + a.getPtnkost() + ", " + a.getMinimumbedrag() +")");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
        
    public Boolean checkArtikel(int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikel WHERE winkelnaam='" + winkelnaam + "' and artikelnr=" + artikelnr;
            ResultSet srs = getData(sql);
            if(srs.next()){
                return true;
            }
            else return false;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    } 
     
    public Artikel getArtikel(int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikel WHERE winkelnaam='" + winkelnaam + "' and artikelnr=" + artikelnr;
            ResultSet srs = getData(sql);
            if(srs.next()){
                String naam = srs.getString("winkelnaam");
                int artikelnummer = srs.getInt("artikelnr");
                String artikelnaam = srs.getString("artikelnaam");
                int prijs = srs.getInt("prijs");
                int ptnwinst = srs.getInt("ptnwinst");
                int ptnkost = srs.getInt("ptnkost");
                int minimumaantal = srs.getInt("minimumaantal");
                int minimumbedrag = srs.getInt("minimumbedrag");
                Artikel a = new Artikel(artikelnummer,naam,artikelnaam,prijs,ptnwinst,minimumaantal,ptnkost,minimumbedrag);
                this.closeConnection();
                return a;
            }
            else return null;
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    public ArrayList<Artikel> getAssortimentWinkel(String winkelnaam){
        try{
            ArrayList<Artikel> assortiment = new ArrayList<Artikel>();
            String sql = "SELECT * FROM artikel WHERE winkelnaam='" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            while(srs.next()){
                String naam = srs.getString("winkelnaam");
                int artikelnummer = srs.getInt("artikelnr");
                String artikelnaam = srs.getString("artikelnaam");
                int prijs = srs.getInt("prijs");
                int ptnwinst = srs.getInt("ptnwinst");
                int ptnkost = srs.getInt("ptnkost");
                int minimumaantal = srs.getInt("minimumaantal");
                int minimumbedrag = srs.getInt("minimumbedrag");
                
                Artikel a = new Artikel(artikelnummer,naam,artikelnaam,prijs,ptnwinst,minimumaantal,ptnkost,minimumbedrag);
                assortiment.add(a);
            }
            this.closeConnection();
            return assortiment;          
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    public ArrayList<Aankoop> getVerkopenWinkel(String winkelnaam){
        try{
            ArrayList<Aankoop> assortiment = new ArrayList<Aankoop>();
            String sql = "SELECT * FROM aankoop WHERE winkelnaam='" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            while(srs.next()){
                int transactienr = srs.getInt("transactienr");
                int vestigingsid = srs.getInt("vestigingsid");
                String naam = srs.getString("winkelnaam");
                int kaartnr = srs.getInt("kaartnr");
                Date datum = srs.getDate("datum");
                int ptnplus = srs.getInt("ptnplus");
                int ptnmin = srs.getInt("ptnmin");
                int totprijs = srs.getInt("totprijs");
                
                Aankoop ak = new Aankoop(transactienr, vestigingsid, kaartnr, datum, ptnplus, ptnmin, totprijs);
                assortiment.add(ak);
            }
            this.closeConnection();
            return assortiment;          
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
      
    
    public void addVestiging(Vestiging v){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO vestiging (vestigingid,winkelnaam,adres) " + "VALUES ( '" + v.getVestigingId() + "', '" + v.getWinkelnaam() + "', '" + v.getAdres() + "')");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkVestiging(int vestigingnummer, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE vestigingid=" + vestigingnummer + " and winkelnaam='" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            if(srs.next()){
                return true;
            }
            else return false;
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    public Vestiging getVestiging(int vestigingsid, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE winkelnaam='" + winkelnaam + "' and vestigingsid=" + vestigingsid;
            ResultSet srs = getData(sql);
            if(srs.next()){
                String naam = srs.getString("winkelnaam");
                int vestid = srs.getInt("vestigingsid");
                String adres = srs.getString("adres");
                Vestiging v = new Vestiging(vestid,naam,adres);
                this.closeConnection();
                return v;
            }
            else return null;
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    
    
//    public void getAccount(String accountnr){
//        try{
//            String sql = "SELECT * FROM account WHERE accountnr='" + accountnr + "'";
//            ResultSet srs = getData(sql);
//            srs.next();
//            int id = srs.getInt("accountnr");
//            String naam = srs.getString("winkelnaam");
//            String paswoord = srs.getString("paswoord");
//            String paswoord = srs.getString("paswoord");
//            Winkel w = new Winkel(naam,paswoord);
//            this.closeConnection();
//            return w;
//            JOptionPane.showMessageDialog(null, "gelukt");
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//        }
    }
    
//    public setVestiging
    
    //    Voorbeeld van een functie waarmee een vestiging kan gecreerd/opgeroepen worden uit database via getData().
    
//    public Vestiging getVestiging(){
//        
//        Vestiging v = new Vestiging();
//        
//        try {
//            String sql = "SELECT vestigingid, winkelnaam, adres FROM vestiging;";
//            ResultSet srs = getData(sql);
//            srs.next();
//            int id = srs.getInt("vestigingid");
//            String winkelnaam = srs.getString("winkelnaam");
//            String adres = srs.getString("adres");
//            v = new Vestiging();
//            this.closeConnection();
//            return v;
//        } catch (SQLException sqle) {
//            System.out.println("SQLException: " + sqle.getMessage());
//            System.out.println("Troubles");
//            this.closeConnection();
//            return v;
//        }
//    }
