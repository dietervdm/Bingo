
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
            stmt.executeUpdate("INSERT INTO winkel VALUES ('" + w.getWinkelnaam() + "', 0, '" + w.getPaswoord() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkWinkel(String winkelnaam){
        try{
            String sql = "SELECT * FROM winkel WHERE winkelnaam='" + winkelnaam + "';";
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
            String sql = "SELECT * FROM winkel WHERE winkelnaam='" + winkelnaam + "';";
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
            stmt.executeUpdate("DELETE from winkel WHERE winkelnaam='" + w.getWinkelnaam() +"';");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateWinkel(Winkel oud, Winkel nieuw){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE winkel SET accountnr = " + nieuw.getAccount() + " WHERE winkelnaam = '" + oud.getWinkelnaam() + "'; "
                    + "UPDATE winkel SET paswoord = '" + nieuw.getPaswoord() + "' WHERE winkelnaam = '" + oud.getWinkelnaam()+ "'; "
                    + "UPDATE winkel SET winkelnaam = '" + nieuw.getWinkelnaam() + "' WHERE winkelnaam = '" + oud.getWinkelnaam() + "';");           
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
            stmt.executeUpdate("INSERT INTO artikel VALUES (" + a.getArtikelnr() + ", '" + a.getWinkelnaam() + "', '" + a.getArtikelnaam() + "', " + a.getPrijs() + ", " + a.getPtnwinst() + ", " + a.getMinimumaantal() + ", " + a.getPtnkost() + ", " + a.getMinimumbedrag() +");");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
        
    public Boolean checkArtikel(int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikel WHERE winkelnaam='" + winkelnaam + "' and artikelnr=" + artikelnr + ";";
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
            String sql = "SELECT * FROM artikel WHERE winkelnaam='" + winkelnaam + "' and artikelnr=" + artikelnr + ";";
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
    
    public void deleteArtikel(Artikel a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from artikel WHERE winkelnaam = '" + a.getWinkelnaam() + "' and artikelnr=" + a.getArtikelnr() + ";");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateArtikel(Artikel oud, Artikel nieuw, String winkelnaam){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE artikel SET artikelnaam = '" + nieuw.getArtikelnaam() + "' WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';" 
                    + "UPDATE artikel SET prijs = " + nieuw.getPrijs() + " WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';"
                    + "UPDATE artikel SET ptnwinst = " + nieuw.getPtnwinst() + " WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';"
                    + "UPDATE artikel SET minimumaantal = " + nieuw.getMinimumaantal()+ " WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';"
                    + "UPDATE artikel SET ptnkost = " + nieuw.getPtnkost() + " WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';"
                    + "UPDATE artikel SET minimumbedrag = " + nieuw.getMinimumbedrag() + " WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';"
                    + "UPDATE artikel SET artikelnr = " + nieuw.getArtikelnr() + " WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';");           
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
        
    public ArrayList<Artikel> getAssortimentWinkel(String winkelnaam){
        try{
            ArrayList<Artikel> assortiment = new ArrayList<Artikel>();
            String sql = "SELECT * FROM artikel WHERE winkelnaam='" + winkelnaam + "';";
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
            String sql = "SELECT * FROM aankoop WHERE winkelnaam='" + winkelnaam + "';";
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
            stmt.executeUpdate("INSERT INTO vestiging VALUES (" + v.getVestigingId() + ", '" + v.getWinkelnaam() + "', '" + v.getAdres() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkVestiging(int vestigingid, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE vestigingid=" + vestigingid + " and winkelnaam='" + winkelnaam + "';";
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
    
    public Vestiging getVestiging(int vestigingid, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE winkelnaam='" + winkelnaam + "' and vestigingid=" + vestigingid + ";";
            ResultSet srs = getData(sql);
            if(srs.next()){
                String naam = srs.getString("winkelnaam");
                int vestid = srs.getInt("vestigingid");
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
    
    public void deleteVestiging(Vestiging v){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from vestiging WHERE winkelnaam='" + v.getWinkelnaam() + "' and vestigingid=" + v.getVestigingId() + ";");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateVestiging(Vestiging oud, Vestiging nieuw, String winkelnaam){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE vestiging SET adres = '" + nieuw.getAdres() + "' WHERE vestigingid = " + oud.getVestigingId() + " and winkelnaam = '" + winkelnaam + "';" 
                    + "UPDATE vestiging SET vestigingid = " + nieuw.getVestigingId() + " WHERE vestigingid = " + oud.getVestigingId() + " and winkelnaam = '" + winkelnaam + "';");           
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void addAccount(Account a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO account VALUES (" + a.getAccountnr() + ", '" + a.getNaam() + "', '" + a.getEmail() + "', '" + a.getAdres() + "', " + a.getPunten() + ", " + a.isWolverine() + ", " + a.getStartw() + ", " + a.isBigspender() + ", " + a.getStartb() + ", " + a.isMajor() + ", " + a.getStartm() + ", " + a.isBedrijf() + ", '" + a.getBtwnummer() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkAccount(int accountnr){
        try{
            String sql = "SELECT * FROM account WHERE accountnr = " + accountnr + ";";
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
    
    public Winkel getAccount(int accountnr){
        try{
            String sql = "SELECT * FROM account WHERE accountnr=" + accountnr + ";";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int accountnummer = srs.getInt("accountnr");
                String naam = srs.getString("naam");
                String email = srs.getString("email");
                String adres = srs.getString("adres");
                int punten = srs.getInt("punten");
                boolean wolverine = srs.getBoolean("wolverine");
                Date startw = srs.getDate("startw");
                boolean bigspender = srs.getBoolean("bigspender");
                Date startb = srs.getDate("startb");
                boolean major = srs.getBoolean("major");
                Date startm = srs.getDate("startm");
                boolean bedrijf = srs.getBoolean("bedrijf");
                String btwnummer = srs.getString("btwnummer");
                Account a = new Account(accountnummer,naam,email,adres,punten,wolverine,startw,bigspender,startb,major,startm,bedrijf,btwnummer);
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
    public void deleteAccount(Account a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from account WHERE accountnr=" + a.getAccountnr() +";");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateAccount(Account oud, Account nieuw){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE account SET naam = '" + nieuw.getNaam() + "' WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET email = '" + nieuw.getEmail() + "' WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET adres = '" + nieuw.getAdres() + "' WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET punten = " + nieuw.getPunten() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET wolverine = " + nieuw.isWolverine() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET startw = " + nieuw.getStartw() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET bigspender = " + nieuw.isBigspender() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET startb = " + nieuw.getStartb() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET major = " + nieuw.isMajor() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET startm = " + nieuw.getStartm() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET bedrijf = " + nieuw.isBedrijf() + " WHERE accountnr = " + oud.getAccountnr() + "; "
                    + "UPDATE account SET btwnummer = '" + nieuw.getBtwnummer() + "' WHERE accountnr = " + oud.getAccountnr() + "; ");           
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    

   }
