
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
    
    
    
    
    
    
    
    public int aantalSpaarkaarten(){
        try{
            String sql = "SELECT COUNT(*) FROM spaarkaart";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int count = srs.getInt("count(*)");
                this.closeConnection();
                return count;
            }
           
            else{
                this.closeConnection();
                return -1;
            }
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return -1;
        }
    }
    
    
   
    
    public void addArtikelaankoop(Artikelaankoop a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO artikelaankoop VALUES (" + a.getTransactienrAankoop()  + ", " + a.getArtikelnr()+ ", '" + a.getWinkelnaam() + "', " + a.getAantal() + ", " + a.isMetPuntenBetaald() + ";");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    
    
    
    public boolean minstensArtikelPlus(String winkelnaam){

        int aantalArtikelen = 0;
        int aantalArtikelenNietPlus = 0;
                
        try{
            String sql = "SELECT COUNT(*) FROM Artikel where WINKELNAAM = '" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            if(srs.next()){
                aantalArtikelen = srs.getInt("count(*)");
            }           
            
            String sql2 = "SELECT count(*) FROM artikel WHERE winkelnaam = 'test1' AND ptnwinst = 0";
            ResultSet srs2 = getData(sql2);
            if(srs2.next()){
                aantalArtikelenNietPlus = srs.getInt("count(*)");
            }
            
            this.closeConnection();
            
            if(aantalArtikelen == aantalArtikelenNietPlus){
                return false;
            }
            else return true;
        }
        
        
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
     }
  
    
  public boolean minstensArtikelMin(String winkelnaam){

        int aantalArtikelen = 0;
        int aantalArtikelenNietMin = 0;
                
        try{
            String sql = "SELECT COUNT(*) FROM Artikel where WINKELNAAM = '" + winkelnaam + "'";
            ResultSet srs = getData(sql);
            if(srs.next()){
                aantalArtikelen = srs.getInt("count(*)");
            }           
            
            String sql2 = "SELECT count(*) FROM artikel WHERE winkelnaam = 'test1' AND ptnkost = null";
            ResultSet srs2 = getData(sql2);
            if(srs2.next()){
                aantalArtikelenNietMin = srs.getInt("count(*)");
            }
            
            this.closeConnection();
            
            if(aantalArtikelen == aantalArtikelenNietMin){
                return false;
            }
            else return true;
        }
        
        
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return false;
        }
     }
  }  
    
    
    
    
    
    
    
    
    
    
    