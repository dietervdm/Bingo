
package Logica;


import Database.Database;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class Account 
{
    private int accountnr;
    private String naam;     //bedrijf = bedrijfsnaam, particulier = naam klant
    private String email;
    private String adres;
    private int punten;
    private boolean wolverine;
    private java.util.Date jstartw = new java.util.Date();
    private java.sql.Date startw = new java.sql.Date(jstartw.getTime());
    private boolean bigspender;
    private java.util.Date jstartb = new java.util.Date();
    private java.sql.Date startb = new java.sql.Date(jstartw.getTime());
    private boolean major;
    private java.util.Date jstartm = new java.util.Date();
    private java.sql.Date startm = new java.sql.Date(jstartw.getTime());
    private boolean bedrijf;
    private String btwnummer;
    //bedrijf
    private Image logo;
    Database db = new Database();
    
    public Account()
    {}
    
    public Account(int accountnr, boolean wolverine, boolean bigspender, boolean major, boolean bedrijf)
    {
        this.accountnr = accountnr;
        this.wolverine = wolverine;
        this.bigspender = bigspender;
        this.major = major;
        this.bedrijf = bedrijf;
    }
    
    public Account(int accountnr, String naam, String email, String adres, int punten, boolean wolverine, java.sql.Date startw, boolean bigspender, java.sql.Date startb, boolean major, java.sql.Date startm, boolean bedrijf, String btwnummer)
    {
        this.accountnr = accountnr;
        this.naam = naam;
        this.email = email;
        this.adres = adres;
        this.punten = punten;
        this.wolverine = wolverine;
        this.startw = startw;
        this.bigspender = bigspender;
        this.startb = startb;
        this.major = major;
        this.startm = startm;
        this.bedrijf = bedrijf;
        this.btwnummer = btwnummer;
    }
    
    public int getAccountnr()
    {
        return this.accountnr;
    }
    
    public void setAccountnr(int accountnr)
    {
        this.accountnr = accountnr;
    }
    
    public String getNaam()
    {
        return this.naam;
    }
    
    public void setNaam(String naam)
    {
        this.naam = naam;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getAdres()
    {
        return this.adres;
    }
    
    public void setAdres(String adres)
    {
        this.adres = adres;
    }
    
    public int getPunten()
    {
        return this.punten;
    }
    
    public void setPunten(int punten)
    {
        this.punten = punten;
    }
    
    public boolean isWolverine()
    {
        return this.wolverine;
    }
    
    public void setWolverine(boolean wolverine)
    {
        this.wolverine = wolverine;
    }
    
    public Date getStartw()
    {
        return this.startw;
    }
    
    public void setStartw(java.sql.Date startw)
    {
        this.startw = startw;
    }
    
    public boolean isBigspender()
    {
        return this.bigspender;
    }
    
    public void setBigspender(boolean bigspender)
    {
        this.bigspender = bigspender;
    }
    
    public Date getStartb()
    {
        return this.startb;
    }
    
    public void setStartb(java.sql.Date startb)
    {
        this.startb = startb;
    }
    
    public boolean isMajor()
    {
        return this.major;
    }
    
    public void setMajor(boolean major)
    {
        this.major = major;
    }
    
    public Date getStartm()
    {
        return this.startm;
    }
    
    public void setStartm(java.sql.Date startm)
    {
        this.startm = startm;
    }
    
    public boolean isBedrijf()
    {
        return this.bedrijf;
    }
    
    public void setBedrijf(boolean bedrijf)
    {
        this.bedrijf = bedrijf;
    }
    
    public String getBtwnummer()
    {
        return this.btwnummer;
    }
    
    public void setBtwnummer(String btwnummer)
    {
        this.btwnummer = btwnummer;
    }
    
    public Image getLogo()
    {
        return logo;
    }
    
    public void setLogo(Image logo)
    {
        this.logo = logo;
    }
    
    
    // via radiant button bedrijf of particulier
    public void bedrijfOfParticulier(Boolean bedrijf)
    {
        if (bedrijf == true)
            this.bedrijf = true;
        else
            this.bedrijf = false;
    }
    
    public Date getDatumVorigJaar(Date datum){
        datum.setYear(datum.getYear()-1);
        return datum;
    }
    
    // FUNCTIES VAN VIP SYSTEEM
    
    public boolean isVip(int accountnr, Date datum){
        
        return totaalPuntenJaar(accountnr, datum) > 10000;
    }
    
    public void isMajor(int accountnr, Date datum, String winkelnaam){
        
        if(isVip(accountnr, datum))
        {
            if(this.totaalGeldJaar(accountnr, datum) > totaalGeldJaar(db.getWinkel(winkelnaam).getAccount(), datum))
            {
                this.setMajor(true);
                
                if(jstartm.after(this.getDatumVorigJaar(datum)))
                {
                    this.setPunten(punten + 100);
                    this.sentMail();
                }
                else
                {
                    // geen punten toekennen
                }
            }
            else
            {
                this.setMajor(major);
            }
        }
        else
        {
            this.setMajor(false);
        }
        
        
//        try{
//        if(isVip(accountnr, datum))
//            //Combineer tabel account, aankoop en artikelaankoop
//        {
//            ResultSet srs = null;
//            if(srs.next()){
//                srs = db.getMajor(accountnr, datum, winkelnaam);
//                
//                // gegevens over winkel
//                int accnr = srs.getInt("accountnr");
//                String naam = srs.getString("winkelnaam");
//                String paswoord = srs.getString("paswoord");
//                
//                Winkel w = new Winkel(naam, accnr, paswoord);
//                
//                //gegevens over aankoop
//                int transactienummer = srs.getInt("transactienr");
//                int vestigingid = srs.getInt("vestigingsid");
//                String winkelnm = srs.getString("winkelnaam");
//                int kaartnr = srs.getInt("kaartnr");
//                Date dat = srs.getDate("datum");
//                
//                Aankoop ak = new Aankoop(transactienummer, vestigingid, kaartnr, winkelnm, dat);
//                
//                //gegevens over artikelaankoop
//                int trans = srs.getInt("transactienr");
//                int artikelnr = srs.getInt("artikelnr");
//                String nm = srs.getString("winkelnaam");
//                int aantal = srs.getInt("aantal");
//                boolean manier = srs.getBoolean("manierbetaling");
//                
//                Artikelaankoop aak = new Artikelaankoop(trans, artikelnr, nm, aantal, manier);
//                
//                Artikel a = new Artikel(aak.getArtikelnr(), aak.getWinkelnaam());
//                a.getPrijs();
//            }
//        }
//            
//        }
//        catch(SQLException sqle){
//            System.out.println("SQLException: " + sqle.getMessage());
//            // Wat moet hier komen?
//        }
    }
    
    public boolean RechtOpPuntenMajor(Date datum){
        datum.setYear(datum.getYear()-1);
        return datum.after(jstartm);
    }
    
    public boolean RechtOpPuntenBigSpender(Date datum){
        datum.setYear(datum.getYear()-1);
        return datum.after(jstartm);
    }
    
    public boolean RechtOpPuntenWolverine(Date datum){
        datum.setYear(datum.getYear()-1);
        return datum.after(jstartm);
    }
    
    
    public int totaalPuntenJaar(int accountnr, Date datum){
        int totaalPunten = 0;
        //functie --> alle aankopen van het vorig jaar van een account: daar alle punten van nemen
        ArrayList<Aankoop> aankopen = new ArrayList<Aankoop>();
        
//        for(int i=0; i<aankopen.size(); i++)
//        {
//            if(aankopen.get(i).getDatum().after(datum.setYear(datum.getYear()-1)))
//            {
//                aankopen.get(i)
//            }
//        }
        return totaalPunten;
        
    }
    
    public double totaalGeldJaar(int accountnr, Date datum){
        double totaalGeld = 0.0;
        //functie --> alle aankopen van het vorig jaar van een account: daar totaal gespendeerd geld van nemen
        // select * from aankoop where accountnr = ...
        
        return totaalGeld;
    }
    
    public void sentMail(){
        
    }
    
}
