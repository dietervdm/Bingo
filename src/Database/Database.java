
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
    
    public DefaultTableModel naarTabel (String sql) {
         
        Database db = new Database(); 
        ResultSet rs = db.getData(sql);
        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> kolommen = new Vector<>();
        
        try{    
            ResultSetMetaData metaData = rs.getMetaData();
            // kolomnamen
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                kolommen.add(metaData.getColumnName(column));
            }
            // inhoud
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
        }
        return new DefaultTableModel(data, kolommen);
    }
    
    public int getAantalVerschillendeWinkels(Account a){
        try{
            //String sql = "SELECT COUNT(DISTINCT winkelnaam) AS aantal FROM aankoop, account, spaarkaart WHERE (spaarkaart.accountnr = " + a.getAccountnr() + ") AND (aankoop.datum > CURDATE( ) - INTERVAL '1'YEAR);";
            String sql = "SELECT COUNT( DISTINCT winkelnaam ) AS aantal FROM aankoop INNER JOIN spaarkaart ON aankoop.kaartnr = spaarkaart.kaartnr INNER JOIN account ON spaarkaart.accountnr = account.accountnr WHERE (spaarkaart.accountnr = " + a.getAccountnr() + ") AND (aankoop.datum > CURDATE( ) - INTERVAL '1'YEAR)";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int aantal = srs.getInt("aantal");
                this.closeConnection();
                return aantal;
            }
            else
            {
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
    
    public double getTotaalGespendeerdeBedragAccount(int accountnummer){
        try{
            //String sql = "SELECT SUM(totaalPrijs) AS totaalbedrag FROM aankoop, spaarkaart WHERE (spaarkaart.accountnr = " + accountnummer + ") AND (aankoop.datum > CURDATE( ) - INTERVAL '1'YEAR );";
            String sql = "SELECT SUM( totaalPrijs ) AS totaalbedrag FROM aankoop INNER JOIN spaarkaart ON aankoop.kaartnr = spaarkaart.kaartnr WHERE (spaarkaart.accountnr = " + accountnummer + ") AND (aankoop.datum > CURDATE( ) - INTERVAL '1'YEAR)";
            ResultSet srs = getData(sql);
            if(srs.next()){
                double totaalbedrag = srs.getDouble("totaalbedrag");
                this.closeConnection();
                return totaalbedrag;
            }
            else
            {
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
    
    public int getTotaalPuntenVerkregenAccount(int accountnummer){
        try{
            //String sql = "SELECT SUM(totaalPuntenBij) AS totaalbedrag FROM aankoop, spaarkaart WHERE (spaarkaart.accountnr = " + accountnummer + ") and (aankoop.datum > CURDATE( ) - INTERVAL '1'YEAR );";
            String sql = "SELECT SUM(totaalPuntenBij) AS totaalPunten FROM aankoop inner join spaarkaart on aankoop.kaartnr = spaarkaart.kaartnr WHERE (spaarkaart.accountnr = " + accountnummer + ") and (aankoop.datum > CURDATE( ) - INTERVAL '1'YEAR );";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int totaalbedrag = srs.getInt("totaalPunten");
                this.closeConnection();
                return totaalbedrag;
            }
            else
            {
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
    
    public void addWinkel(Winkel w){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO winkel VALUES ('" + w.getWinkelnaam() + "', null, '" + w.getPaswoord() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkWinkel(String winkelnaam){
        try{
            String sql = "SELECT * FROM winkel WHERE winkelnaam = '" + winkelnaam + "';";
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
    public void deleteWinkel(Winkel w){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from winkel WHERE winkelnaam = '" + w.getWinkelnaam() +"';");
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

//            stmt.executeUpdate("UPDATE winkel SET accountnr = " + nieuw.getAccount() + " WHERE winkelnaam = '" + oud.getWinkelnaam() + "'");
            stmt.executeUpdate("UPDATE winkel SET paswoord = '" + nieuw.getPaswoord() + "' WHERE winkelnaam = '" + oud.getWinkelnaam() + "'");
            stmt.executeUpdate("UPDATE winkel SET winkelnaam = '" + nieuw.getWinkelnaam() + "' WHERE winkelnaam = '" + oud.getWinkelnaam() + "'");
            
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateAccountnrWinkel(Winkel winkel, int accountnr){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();

            stmt.executeUpdate("UPDATE winkel SET accountnr = " + accountnr + " WHERE winkelnaam = '" + winkel.getWinkelnaam() + "'");
//            stmt.executeUpdate("UPDATE winkel SET paswoord = '" + nieuw.getPaswoord() + "' WHERE winkelnaam = '" + oud.getWinkelnaam() + "'");
//            stmt.executeUpdate("UPDATE winkel SET winkelnaam = '" + nieuw.getWinkelnaam() + "' WHERE winkelnaam = '" + oud.getWinkelnaam() + "'");
            
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
            try{
            stmt.executeUpdate("INSERT INTO artikel VALUES (" + a.getArtikelnr() + ", '" + a.getWinkelnaam() + "', '" + a.getArtikelnaam() + "', " + a.getPrijs() + ", " + a.getPtnwinst() + ", " + a.getMinimumaantal() + ", " + a.getPtnkost() + ", " + a.getMinimumbedrag() +");");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            
            
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
        
    public Boolean checkArtikel(int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikel WHERE (winkelnaam = '" + winkelnaam + "') and (artikelnr = " + artikelnr + ");";
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
     
    public Artikel getArtikel(int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikel WHERE (winkelnaam = '" + winkelnaam + "') and (artikelnr = " + artikelnr + ");";
            ResultSet srs = getData(sql);
            if(srs.next()){
                String naam = srs.getString("winkelnaam");
                int artikelnummer = srs.getInt("artikelnr");
                String artikelnaam = srs.getString("artikelnaam");
                double prijs = srs.getDouble("prijs");
                int ptnwinst = srs.getInt("ptnwinst");
                int ptnkost = srs.getInt("ptnkost");
                int minimumaantal = srs.getInt("minimumaantal");
                int minimumbedrag = srs.getInt("minimumbedrag");
                Artikel a = new Artikel(artikelnummer,naam,artikelnaam,prijs,ptnwinst,minimumaantal,ptnkost,minimumbedrag);
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
    
    public void deleteArtikel(Artikel a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from artikel WHERE (winkelnaam = '" + a.getWinkelnaam() + "') and (artikelnr = " + a.getArtikelnr() + ");");
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
            
            stmt.executeUpdate("UPDATE artikel SET artikelnaam = '" + nieuw.getArtikelnaam() + "' WHERE artikelnr = " + oud.getArtikelnr() + " and winkelnaam = '" + winkelnaam + "';");
            stmt.executeUpdate("UPDATE artikel SET prijs = " + nieuw.getPrijs() + " WHERE (artikelnr = " + oud.getArtikelnr() + ") and (winkelnaam = '" + winkelnaam + "');");
            stmt.executeUpdate("UPDATE artikel SET ptnwinst = " + nieuw.getPtnwinst() + " WHERE (artikelnr = " + oud.getArtikelnr() + ") and (winkelnaam = '" + winkelnaam + "');");
            stmt.executeUpdate("UPDATE artikel SET minimumaantal = " + nieuw.getMinimumaantal() + " WHERE (artikelnr = " + oud.getArtikelnr() + ") and (winkelnaam = '" + winkelnaam + "');");
            stmt.executeUpdate("UPDATE artikel SET ptnkost = " + nieuw.getPtnkost() + " WHERE (artikelnr = " + oud.getArtikelnr() + ") and (winkelnaam = '" + winkelnaam + "');");
            stmt.executeUpdate("UPDATE artikel SET minimumbedrag = " + nieuw.getMinimumbedrag() + " WHERE (artikelnr = " + oud.getArtikelnr() + ") and (winkelnaam = '" + winkelnaam + "');");
            stmt.executeUpdate("UPDATE artikel SET artikelnr = " + nieuw.getArtikelnr() + " WHERE (artikelnr = " + oud.getArtikelnr() + ") and (winkelnaam = '" + winkelnaam + "');");
            
            
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
        
//    public ArrayList<Artikel> getAssortimentWinkel(String winkelnaam){
//        try{
//            ArrayList<Artikel> assortiment = new ArrayList<Artikel>();
//            String sql = "SELECT * FROM artikel WHERE winkelnaam = '" + winkelnaam + "';";
//            ResultSet srs = getData(sql);
//            while(srs.next()){
//                String naam = srs.getString("winkelnaam");
//                int artikelnummer = srs.getInt("artikelnr");
//                String artikelnaam = srs.getString("artikelnaam");
//                double prijs = srs.getDouble("prijs");
//                int ptnwinst = srs.getInt("ptnwinst");
//                int ptnkost = srs.getInt("ptnkost");
//                int minimumaantal = srs.getInt("minimumaantal");
//                int minimumbedrag = srs.getInt("minimumbedrag");
//                
//                Artikel a = new Artikel(artikelnummer,naam,artikelnaam,prijs,ptnwinst,minimumaantal,ptnkost,minimumbedrag);
//                assortiment.add(a);
//            }
//            this.closeConnection();
//            return assortiment;          
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return null;
//        }
//    }
    
//    public ArrayList<Aankoop> getVerkopenWinkel(String winkelnaam){
//        try{
//            ArrayList<Aankoop> assortiment = new ArrayList<Aankoop>();
//            String sql = "SELECT * FROM aankoop WHERE winkelnaam = '" + winkelnaam + "';";
//            ResultSet srs = getData(sql);
//            while(srs.next()){
//                int transactienr = srs.getInt("transactienr");
//                int vestigingsid = srs.getInt("vestigingsid");
//                String naam = srs.getString("winkelnaam");
//                int kaartnr = srs.getInt("kaartnr");
//                Date datum = srs.getDate("datum");
//                //int ptnplus = srs.getInt("ptnplus");
//                //int ptnmin = srs.getInt("ptnmin");
//                //int totprijs = srs.getInt("totprijs");
//                
//                Aankoop ak = new Aankoop(transactienr, vestigingsid, kaartnr, naam,  datum);
//                assortiment.add(ak);
//            }
//            this.closeConnection();
//            return assortiment;          
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return null;
//        }
//    }
//    
//    public ArrayList<Aankoop> getVerkopenWinkelVestiging(String winkelnaam, int vestigingid){
//        try{
//            ArrayList<Aankoop> assortiment = new ArrayList<Aankoop>();
//            String sql = "SELECT * FROM aankoop WHERE winkelnaam = '" + winkelnaam + "' and + vestigingid = '" + vestigingid + "';";
//            // moet nog getest worden.
//            ResultSet srs = getData(sql);
//            while(srs.next()){
//                int transactienr = srs.getInt("transactienr");
//                int vestigingsid = srs.getInt("vestigingsid");
//                String naam = srs.getString("winkelnaam");
//                int kaartnr = srs.getInt("kaartnr");
//                Date datum = srs.getDate("datum");
//                //int ptnplus = srs.getInt("ptnplus");
//                //int ptnmin = srs.getInt("ptnmin");
//                //int totprijs = srs.getInt("totprijs");
//                
//                Aankoop ak = new Aankoop(transactienr, vestigingsid, kaartnr, naam, datum);
//                assortiment.add(ak);
//            }
//            this.closeConnection();
//            return assortiment;          
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return null;
//        }
//    }
//    
//    public ArrayList<Aankoop> getVerkopenWinkelKlant(String winkelnaam, int kaartnr){
//        try{
//            ArrayList<Aankoop> assortiment = new ArrayList<Aankoop>();
//            String sql = "SELECT * FROM aankoop WHERE winkelnaam = '" + winkelnaam + "' and kaartnummer = '" + kaartnr + "';";
//            // moet nog getest worden.
//            ResultSet srs = getData(sql);
//            while(srs.next()){
//                int transactienr = srs.getInt("transactienr");
//                int vestigingsid = srs.getInt("vestigingsid");
//                String naam = srs.getString("winkelnaam");
//                int kaartnummer = srs.getInt("kaartnr");
//                Date datum = srs.getDate("datum");
//                //int ptnplus = srs.getInt("ptnplus");
//                //int ptnmin = srs.getInt("ptnmin");
//                //int totprijs = srs.getInt("totprijs");
//                
//                Aankoop ak = new Aankoop(transactienr, vestigingsid, kaartnummer, naam, datum);
//                assortiment.add(ak);
//            }
//            this.closeConnection();
//            return assortiment;          
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return null;
//        }
//    }
//    
//    public ArrayList<Aankoop> getVerkopenWinkelKantVestiging(String winkelnaam, int vestigingid, int kaartnr){
//        try{
//            ArrayList<Aankoop> assortiment = new ArrayList<Aankoop>();
//            String sql = "SELECT * FROM aankoop WHERE winkelnaam = '" + winkelnaam + 
//                            "' and vestigingid = '" + vestigingid + 
//                            "' and kaartnr = '" + kaartnr + "';";
//            // moet nog getest worden.
//            ResultSet srs = getData(sql);
//            while(srs.next()){
//                int transactienr = srs.getInt("transactienr");
//                int vestigingsid = srs.getInt("vestigingsid");
//                String naam = srs.getString("winkelnaam");
//                int kaartnummer = srs.getInt("kaartnr");
//                Date datum = srs.getDate("datum");
//                //int ptnplus = srs.getInt("ptnplus");
//                //int ptnmin = srs.getInt("ptnmin");
//                //int totprijs = srs.getInt("totprijs");
//                
//                Aankoop ak = new Aankoop(transactienr, vestigingsid, kaartnummer, naam, datum);
//                assortiment.add(ak);
//            }
//            this.closeConnection();
//            return assortiment;          
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return null;
//        }
//    }
//    
    public void addVestiging(Vestiging v){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO vestiging VALUES ('" + v.getVestigingId() + "', '" + v.getWinkelnaam() + "', '" + v.getAdres() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkVestiging(String vestigingid, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE (vestigingid = '" + vestigingid + "') and (winkelnaam = '" + winkelnaam + "');";
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
    
    public Vestiging getVestiging(String vestigingid, String winkelnaam){
        try{
            String sql = "SELECT * FROM vestiging WHERE (winkelnaam = '" + winkelnaam + "') and (vestigingid = '" + vestigingid + "');";
            ResultSet srs = getData(sql);
            if(srs.next()){
                String naam = srs.getString("winkelnaam");
                String vestid = srs.getString("vestigingid");
                String adres = srs.getString("adres");
                Vestiging v = new Vestiging(vestid, naam, adres);
                this.closeConnection();
                return v;
            }
            else {this.closeConnection();return null;}
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    public ArrayList<Vestiging> getAlleVestigingen(String winkelnaam){
        try{
            ArrayList<Vestiging> alleVestigingen = new ArrayList<Vestiging>();
            String sql = "SELECT * FROM vestiging WHERE winkelnaam = '" + winkelnaam + "';";
            ResultSet srs = getData(sql);
            while(srs.next()){
                String vestigingid = srs.getString("vestigingid");
                String naam = srs.getString("winkelnaam");
                String adres = srs.getString("adres");
                
                Vestiging vest = new Vestiging(vestigingid, naam, adres);
                alleVestigingen.add(vest);
            }
            this.closeConnection();
            return alleVestigingen;          
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
            stmt.executeUpdate("DELETE FROM vestiging WHERE (winkelnaam = '" + v.getWinkelnaam() + "') and (vestigingid = '" + v.getVestigingId() + "');");
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
            
            stmt.executeUpdate("UPDATE vestiging SET adres = '" + nieuw.getAdres() + "' WHERE (vestigingid = '" + oud.getVestigingId() + "') and (winkelnaam = '" + winkelnaam + "');" );
            stmt.executeUpdate("UPDATE vestiging SET vestigingid = '" + nieuw.getVestigingId() + "' WHERE (vestigingid = '" + oud.getVestigingId() + "') and (winkelnaam = '" + winkelnaam + "');" );     
                    
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
//            java.util.Date jtest = new java.util.Date();
//            java.sql.Date test = new java.sql.Date(jtest.getTime());
            stmt.executeUpdate("INSERT INTO account VALUES (" + a.getAccountnr() + ", '" + a.getNaam() + "', '" + a.getEmail() + "', '" + a.getAdres() + "', " + a.getPunten() + ", " + a.isWolverine() + ", " + a.getStartw() + ", " + a.isBigspender() + ", " + a.getStartb() + ", " + a.isBedrijf() + ", '" + a.getBtwnummer() + "');");
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
//                boolean major = srs.getBoolean("major");
//                java.sql.Date startm = srs.getDate("startm");
                boolean bedrijf = srs.getBoolean("bedrijf");
                String btwnummer = srs.getString("btwnummer");
                Account a = new Account(accountnummer, naam, email, adres, punten, wolverine, startw, bigspender, startb, bedrijf, btwnummer);
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
    
    //Nog niet af, moet accountnr opvragen als men het kaartnr meegeeft
    // moet nog aangepast worden
//    public int getAccountnr(int kaartnr){
//        try{
//            String sql = "SELECT accountnr FROM spaarkaart WHERE kaartnr = " + kaartnr + ";";
//            ResultSet srs = getData(sql);
//            if(srs.next()){
//                int spaarkaart = srs.getInt("kaartnr");
//                int accountnummer = srs.getInt("accountnr");
//                String naam = srs.getString("naamhouder");
//                
//                this.closeConnection();
//                return accountnummer;
//            }
//            else return 0;
//            
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return 0;
//        }
//    }
    
    
        
    public void deleteAccount(Account a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from account WHERE accountnr = " + a.getAccountnr() +";");
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
            
            stmt.executeUpdate("UPDATE account SET naam = '" + nieuw.getNaam() + "' WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET email = '" + nieuw.getEmail() + "' WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET adres = '" + nieuw.getAdres() + "' WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET punten = " + nieuw.getPunten() + " WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET wolverine = " + nieuw.isWolverine() + " WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET startw = '" + nieuw.getStartw() + "' WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET bigspender = " + nieuw.isBigspender() + " WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET startb = '" + nieuw.getStartb() + "' WHERE accountnr = " + oud.getAccountnr());
//            stmt.executeUpdate("UPDATE account SET major = " + nieuw.isMajor() + " WHERE accountnr = " + oud.getAccountnr());
//            stmt.executeUpdate("UPDATE account SET startm = '" + nieuw.getStartm() + "' WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET bedrijf = " + nieuw.isBedrijf() + " WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET btwnummer = '" + nieuw.getBtwnummer() + "' WHERE accountnr = " + oud.getAccountnr());
            stmt.executeUpdate("UPDATE account SET accountnr = " + nieuw.getAccountnr() + " WHERE accountnr = " + oud.getAccountnr());
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateWolverineAccount(int accountnr, boolean wol){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE account SET wolverine = " + wol + " WHERE accountnr = " + accountnr);
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateWolverineAccountDatum(int accountnr){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE account SET startw = CURRENT_DATE WHERE accountnr = " + accountnr);
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateBigSpenderAccount(int accountnr, boolean bs){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE account SET bigspender = " + bs + " WHERE accountnr = " + accountnr);
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateBigSpenderAccountDatum(int accountnr){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE account SET startb = CURRENT_DATE WHERE accountnr = " + accountnr);
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateAantalpunten(Account acc, int aantalPuntennieuw){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE account SET punten = " + aantalPuntennieuw + " WHERE accountnr = " + acc.getAccountnr() + ";");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkArtikelaankoop(int transactienr, int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikelaankoop WHERE (transactienr = " + transactienr + ") and (artikelnr = " + artikelnr + ") and (winkelnaam = '" + winkelnaam + "');";
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
    
//    public ResultSet getMajor(int accountnr, Date datum, String winkelnaam){
//        //try{
//            String sql = "";
//            //moet nog getest worden
//            ResultSet srs = getData(sql);
//            this.closeConnection();
//            return srs;
//            
//        //}
////        catch(SQLException sqle){
////            System.out.println("SQLException: " + sqle.getMessage());
////            this.closeConnection();
////            return null;
////        }
//    }
    
    //Functie om van een account alle punten die verkregen waren vorig jaar
    
    public void addSpaarkaart(Spaarkaart s){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO spaarkaart VALUES (" + s.getKaartnr() + ", " + s.getAccountnr() + ", '" + s.getNaamhouder() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Boolean checkSpaarkaart(int kaartnr){
        try{
            String sql = "SELECT * FROM spaarkaart WHERE kaartnr = " + kaartnr + ";";
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
    
    public Spaarkaart getSpaarkaart(int kaartnr){
        try{
            String sql = "SELECT * FROM spaarkaart WHERE kaartnr = " + kaartnr + ";";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int spaarkaartnr = srs.getInt("kaartnr");
                String naamhouder = srs.getString("naamhouder");
                int accountnr = srs.getInt("accountnr");
                Spaarkaart s = new Spaarkaart(spaarkaartnr,accountnr,naamhouder);
                this.closeConnection();
                return s;
            }
            else return null;
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    // geeft de naam van de naamhouder van de kaart met bepaald nummer
    // moet nog aangepast worden
//    public String getNaamhouder(int kaartnr){
//        try{
//            String sql = "SELECT naamhouder FROM spaarkaart WHERE kaartnr = " + kaartnr + ";";
//            ResultSet srs = getData(sql);
//            if(srs.next()){
//                int spaarkaartnr = srs.getInt("kaartnr");
//                String naamhouder = srs.getString("naamhouder");
//                int accountnr = srs.getInt("accountnr");
//                Spaarkaart s = new Spaarkaart(spaarkaartnr,accountnr,naamhouder);
//                this.closeConnection();
//                return naamhouder;
//            }
//            else return "not found";
//            
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            this.closeConnection();
//            return "error";
//        }
//    }
    
    public void deleteSpaarkaart(Spaarkaart s){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from spaarkaart WHERE kaartnr = " + s.getKaartnr() + ";");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void updateSpaarkaart(Spaarkaart oud, Spaarkaart nieuw){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();

            stmt.executeUpdate("UPDATE spaarkaart SET accountnr = " + nieuw.getAccountnr() + " WHERE kaartnr = " + oud.getKaartnr() + ";");
            stmt.executeUpdate("UPDATE spaarkaart SET naamhouder = '" + nieuw.getNaamhouder() + "' WHERE kaartnr = " + oud.getKaartnr() + ";");
            stmt.executeUpdate("UPDATE spaarkaart SET kaartnr = " + nieuw.getKaartnr() + " WHERE kaartnr = " + oud.getKaartnr() + ";");
            
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    
    public int aantalSpaarkaarten(){
        try{
            String sql = "SELECT COUNT(*) FROM spaarkaart;";
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
    
    public int maxSpaarkaarten(){
        try{
            String sql = "SELECT max(kaartnr) FROM spaarkaart;";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int count = srs.getInt("max(kaartnr)");
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
    
    public int aantalAccounts(){
        try{
            String sql = "SELECT COUNT(*) FROM account;";
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
    
    public int maxAccounts(){
        try{
            String sql = "SELECT max(accountnr) FROM account;";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int count = srs.getInt("max(accountnr)");
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
            stmt.executeUpdate("INSERT INTO artikelaankoop VALUES (" + a.getTransactienrAankoop()  + ", " + a.getArtikelnr()+ ", '" + a.getWinkelnaam() + "', " + a.getAantal() + ", " + a.isMetPuntenBetaald() + ");");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public Artikelaankoop getArtikelaankoop(int transactienraankoop, int artikelnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM artikelaankoop WHERE (transactienr = " + transactienraankoop + ") and (artikelnr = " + artikelnr + ") and (winkelnaam = '" + winkelnaam + "');";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int transactienr = srs.getInt("transactienr");
                int artikelnummer = srs.getInt("artikelnr");
                String naam = srs.getString("winkelnaam");
                int aantal = srs.getInt("aantal");
                boolean metPuntenBetaald = srs.getBoolean("metPuntenBetaald");
                Artikelaankoop a = new Artikelaankoop(transactienr, artikelnummer, naam, aantal, metPuntenBetaald );
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
    
    public void deleteArtikelaankoop(Artikelaankoop a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from artikelaankoop WHERE (transactienr = " + a.getTransactienrAankoop() + ") and (artikelnr = " + a.getArtikelnr() + ") and (winkelnaam = '" + a.getWinkelnaam() + "');");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void addAankoop(Aankoop a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO aankoop VALUES (" + a.getTransactienr()  + ", '" + a.getVestigingid()+ "', '" + a.getWinkelnaam() + "', " + a.getSpaarkaart() + ", CURDATE(), 0.0, 0);");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void deleteAankoop(Aankoop a){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("DELETE from aankoop WHERE (transactienr = " + a.getTransactienr() + ") and (vestigingid = '" + a.getVestigingid() + "') and (winkelnaam = '" + a.getWinkelnaam() + "') and (kaartnr = " + a.getSpaarkaart() +");");
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
    
    public void schrijfTotaalPrijsEnTotaalPtnNaarDatabase(int transactienr, double prijs, int punten){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();

            stmt.executeUpdate("UPDATE aankoop SET totaalPrijs = " + prijs + " WHERE transactienr = " + transactienr + ";");
            stmt.executeUpdate("UPDATE aankoop SET totaalPuntenBij = " + punten + " WHERE transactienr = " + transactienr + ";");
            
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
        
    }
    
    public int maxTransactienr(){
        try{
            String sql = "SELECT MAX(transactienr) AS maximum FROM aankoop;";
            ResultSet srs = getData(sql);
                if(srs.next()){
                    int transactienr = srs.getInt("maximum");
                    this.closeConnection();
                    return transactienr;
                 }
                else {this.closeConnection();
                return 0;}
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
    
    }
    
    public int aantalArtikelen(String winkelnaam){
        try{
            String sql = "SELECT COUNT(*) FROM artikel WHERE winkelnaam = '" + winkelnaam + "';";
            ResultSet srs = getData(sql);
            if(srs.next()){
                int a = srs.getInt("count(*)");
                this.closeConnection();
                return a;
            }
         this.closeConnection();
         return 0;
        }   
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
    }
    
    public int aantalArtikelenNietPlus(String winkelnaam){
        try{
            String sql2 = "SELECT count(*) FROM artikel WHERE (winkelnaam = '" + winkelnaam + "') and (ptnwinst = 0);";
            ResultSet srs2 = getData(sql2);
            if(srs2.next()){
                int a = srs2.getInt("count(*)");
                this.closeConnection();
                return a;
            }
        this.closeConnection();
         return 0;
        }   
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
    }
    
    public int aantalArtikelenNietMin(String winkelnaam){
        try{
            String sql2 = "SELECT count(*) FROM artikel WHERE (winkelnaam = '" + winkelnaam + "') and (ptnwinst = 0);";
            ResultSet srs2 = getData(sql2);
            if(srs2.next()){
                int a = srs2.getInt("count(*)");
                this.closeConnection();
                return a;
            }
        this.closeConnection();
         return 0;
        }   
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return 0;
        }
    }
    
    public int aantalVestigingen(String winkelnaam){
        try{
            String sql = "SELECT COUNT(*) FROM vestiging WHERE winkelnaam = '" + winkelnaam + "';";
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
    
    
    
    public void addMajor(int accountnr, String winkelnaam){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            try{
            stmt.executeUpdate("INSERT INTO major VALUES ('" + winkelnaam + "', " + accountnr + ", CURDATE());");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            
            
            this.closeConnection();
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
        }
    }
        
    public Boolean checkMajor(int accountnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM major WHERE (winkelnaam = '" + winkelnaam + "') and (accountnr = " + accountnr + ");";
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
     
    public Major getMajor(int accountnr, String winkelnaam){
        try{
            String sql = "SELECT * FROM major WHERE (winkelnaam = '" + winkelnaam + "') and (accountnr = " + accountnr + ");";
            ResultSet srs = getData(sql);
            if(srs.next()){
                String naam = srs.getString("winkelnaam");
                int accountnummer = srs.getInt("accountnr");
                Major maj = new Major(naam,accountnummer);
                this.closeConnection();
                return maj;
            }
            else {this.closeConnection();return null;}
            
        }
        catch(SQLException sqle){
            System.out.println("SQLException: " + sqle.getMessage());
            this.closeConnection();
            return null;
        }
    }
    
    
    public void updateMajor(Account acc, Winkel winkel){
        
        try{
            dbConnection = getConnection();
            Statement stmt = dbConnection.createStatement();
            
            stmt.executeUpdate("UPDATE major SET puntendatum = CURDATE() WHERE accountnr = " + acc.getAccountnr() + " and winkelnaam = '" + winkel.getWinkelnaam() + "';");
            
            
            
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
            String sql = "SELECT * FROM `winkel` WHERE `accountnr` IS NULL AND winkelnaam = '" + winkelnaam + "'";
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
            return false;
        }
    }
    
        public Boolean getDatumVoorWolverine(int accountnr){
        try{
            String sql = "SELECT * FROM account WHERE (accountnr = " + accountnr + " and (account.startw < (CURDATE() - INTERVAL '1'YEAR) or account.startw IS NULL);";
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
    
    public Boolean getDatumVoorBigspender(int accountnr){
        try{
            // IN DEZE FUNCTIE MOEST HET HAAKJE WEG
            String sql = "SELECT * FROM account WHERE accountnr = " + accountnr + " and (account.startb < (CURDATE() - INTERVAL '1'YEAR) or account.startb IS NULL);";
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
}
