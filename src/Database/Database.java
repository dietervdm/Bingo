
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
    
    public void AddWinkel(Winkel w){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO winkel(winkelnaam,accountnr,paswoord) " + "VALUES ( '" + w.getWinkelnaam() + "', 0, '" + w.getPaswoord() + "')");
            this.closeConnection();
            JOptionPane.showMessageDialog(null, "Winkel toegevoegd!");
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
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
}