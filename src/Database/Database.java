
package Database;

import Logica.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



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
                int id = srs.getInt("accountnr");
                String naam = srs.getString("winkelnaam");
                String paswoord = srs.getString("paswoord");
                Winkel w = new Winkel(naam,paswoord);
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
    
        public void addArtikel(Artikel a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO artikel(artikelnr,winkelnaam,artikelnaam,prijs,ptnwinst,minimumaantal,ptnkost,minimumbedrag) " + "VALUES (" + a.getArtikelnr() + ", " + a.getWinkel().getWinkelnaam() + a.getPrijs() + ")");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void addVestiging(Vestiging v){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO vestiging (vestigingid,winkelnaam,adres) " + "VALUES ( '" + v.getVestigingId() + "', '" + v.getWinkel().getWinkelnaam() + "', '" + v.getAdres() + "')");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkVestiging(int vestigingnummer, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE vestigingid='" + vestigingnummer + "' and winkelnaam='" + winkelnaam + "'";
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
