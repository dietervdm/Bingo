
package Database;

import Logica.*;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



public class Database2 {
    
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
    
    
    
    public Account getMajor(Winkel w){
        try{
            String sql = "SELECT accountnr FROM major WHERE winkelnaam = '" + w.getWinkelnaam() + "' AND actief = true;";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int accountnr = srs.getInt("accountnr");
                Account a = this.getAccount(accountnr);
                this.closeConnection();
                return a;
            }
            else {this.closeConnection();return null;}
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    
    public Boolean wasMajor(Major m){
        try{
            String sql = "SELECT * FROM major WHERE accountnr = " + m.getAccountnr() + " AND winkelnaam = '" + m.getWinkelnaam() + "';";
            ResultSet srs = getData(sql);
            if(srs.next()){
                this.closeConnection();
                return true;
            }
            else {this.closeConnection();return false;}
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    
    public void activeerMajor(Major m){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE major SET actief = true WHERE accountnr = " + m.getAccountnr() + " and winkelnaam = '" + m.getWinkelnaam() + "'" );
                    
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void deactiveerMajor(Major m){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE major SET actief = false WHERE accountnr = " + m.getAccountnr() + " and winkelnaam = '" + m.getWinkelnaam() + "'" );
                    
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean krijgtPunten(Major m){
        try{
            String sql = "SELECT puntendatum FROM major WHERE accountnr = " + m.getAccountnr() + " AND winkelnaam = '" + m.getWinkelnaam() + "' AND puntendatum > CURRENT_DATE - INTERVAL '1' YEAR";
            ResultSet srs = getData(sql);
            if(srs.next()){
                this.closeConnection();
                return false;
            }
            else {this.closeConnection();return true;}
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return true;
        }
    }
    
    public Boolean heeftMajor(String winkelnaam){
        try{
            String sql = "SELECT puntendatum FROM major WHERE winkelnaam = '" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            if(srs.next()){
                this.closeConnection();
                return true;
            }
            else {this.closeConnection();return false;}
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
    }
    
    
    public Account getAccount(int accountnr){
        try{
            String sql = "SELECT * FROM account WHERE accountnr = " + accountnr + ";";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int accountnummer = srs.getInt("accountnr");
                String naam = srs.getString("naam");
                String email = srs.getString("email");
                String adres = srs.getString("adres");
                int punten = srs.getInt("punten");
                boolean wolverine = srs.getBoolean("wolverine");
                java.sql.Date startw = srs.getDate("startw");
                boolean bigspender = srs.getBoolean("bigspender");
                java.sql.Date startb = srs.getDate("startb");
                boolean major = srs.getBoolean("major");
                java.sql.Date startm = srs.getDate("startm");
                boolean bedrijf = srs.getBoolean("bedrijf");
                String btwnummer = srs.getString("btwnummer");
                Account a = new Account(accountnummer,naam,email,adres,punten,wolverine,startw,bigspender,startb,bedrijf,btwnummer);
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
    
    
    public int getUitgegevenBedrag(Major m){
        try{
        String sql = "SELECT SUM(prijzen.prijs*aantallen.aantal)FROM"
                        + "(SELECT aantal,artikelnr FROM `artikelaankoop` WHERE transactienr IN (SELECT transactienr from aankoop where kaartnr IN (SELECT kaartnr FROM spaarkaart WHERE accountnr = " + m.getAccountnr() + ") AND  datum > CURRENT_DATE - INTERVAL '1' YEAR)  AND metPuntenBetaald = 0)AS aantallen,"
                        + "(SELECT prijs,artikelnr FROM artikel WHERE artikelnr IN( SELECT artikelnr FROM `artikelaankoop` WHERE transactienr IN (SELECT transactienr from aankoop where kaartnr IN (SELECT kaartnr FROM spaarkaart WHERE accountnr = 4) AND  datum > CURRENT_DATE - INTERVAL '1' YEAR)  AND metPuntenBetaald = 0) AND artikel.winkelnaam = '" + m.getWinkelnaam() + "')AS prijzen"
                        + " WHERE prijzen.artikelnr = aantallen.artikelnr";
        
            ResultSet srs = getData(sql);
            if(srs.next()){
                int bedrag = srs.getInt("SUM(prijzen.prijs*aantallen.aantal)");
                this.closeConnection();
                return bedrag;
            }
            else {this.closeConnection();return 0;}
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
        
    }
    
    public void addMajor(Major m){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO major VALUES ('" + m.getWinkelnaam() + "', " + m.getAccountnr() + ",CURRENT_DATE, 'true');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    
    public Winkel getWinkel(String winkelnaam){
        try{
            String sql = "SELECT * FROM winkel WHERE winkelnaam = '" + winkelnaam + "';";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int accountnr = srs.getInt("accountnr");
                String naam = srs.getString("winkelnaam");
                String paswoord = srs.getString("paswoord");
                Winkel w = new Winkel(naam,accountnr,paswoord);
                this.closeConnection();
                return w;
            }
            else {this.closeConnection();return null;}
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    
  }  
    
    
    
    
    
    
    
    
    
    
    