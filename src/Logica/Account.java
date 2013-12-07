
package Logica;

import Database.Database;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


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
    
    //public void setStartw(java.sql.Date startw)
    public void setStartw(Date datum)
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
    
    //public void setStartb(java.sql.Date startb)
    public void setStartb(Date datum)
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
    
    //public void setStartm(java.sql.Date startm)
    public void setStartm(Date datum)
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
        Account huidigIngelogdeAccount = db.getAccount(accountnr);
        Account vorigeMajor = db.getAccount(db.getWinkel(winkelnaam).getAccount());
        
        if(isVip(huidigIngelogdeAccount.getAccountnr(), datum))
        {
            if(this.totaalGeldJaar(huidigIngelogdeAccount.getAccountnr(), datum) > totaalGeldJaar(vorigeMajor.getAccountnr(), datum))
            {
                this.setMajor(true);
                
                if(jstartm.after(this.getDatumVorigJaar(datum)))
                {
                    this.setPunten(punten + 100);
                    huidigIngelogdeAccount.sendMailGoed(db.getWinkel(winkelnaam), "major", "100");
                    vorigeMajor.sentMailSlecht(db.getWinkel(winkelnaam), "Major");
                }
                else
                {
                    this.sendMailGoed(db.getWinkel(winkelnaam), "Major", "0");
                    db.getAccount(db.getWinkel(winkelnaam).getAccount()).sentMailSlecht(db.getWinkel(winkelnaam), "major");
                }
            }
            else
            {
                this.setMajor(false);
            }
        }
        else
        {
            this.setMajor(false);
        }
        
        //OPSLAAN NAAR DE DATABASE
    }
    
    public void isWolverine(String winkelnaam, Date datum){
        if(this.isVip(this.getAccountnr(), datum))
        {
            if(db.getAantalVerschillendeWinkels(this, getDatumVorigJaar(datum)) > 19)
            {
                if(jstartw.before(getDatumVorigJaar(datum)))
                {
                    this.setPunten(punten + 600);
                    this.sendMailGoed(db.getWinkel(winkelnaam), "Wolverine", "600");
                    this.setStartw(datum);
                }
                else
                {
                    this.sendMailGoed(db.getWinkel(winkelnaam), "Wolverine", "0");
                }
                this.setWolverine(true);
            }
            else
                this.setWolverine(false);
        }
        else
            this.setWolverine(false);
        System.out.println(db.getAantalVerschillendeWinkels(this,datum));
        
        // OPSLAAN NAAR DE DATABASE
        
    }
    
    public void isBigSpender(String winkelnaam, Date datum){
        if(this.isVip(this.getAccountnr(), datum))
        {
            if(this.totaalGeldJaar(this.accountnr, datum) > 5000)
            {
                if(jstartb.before(getDatumVorigJaar(datum)))
                {
                    this.setPunten(punten + 500);
                    this.sendMailGoed(db.getWinkel(winkelnaam), "Bigspender", "600");
                    this.setStartw(datum);
                }
                else
                {
                    this.sendMailGoed(db.getWinkel(winkelnaam), "Bigspender", "0");
                }
                this.setBigspender(true);
            }
            else
            {
                this.setBigspender(false);
            }
        }
        else
        {
            this.setBigspender(false);
        }
        
        // OPSLAAN NAAR DATABASE
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
        int totaalPunten = 0; //= db.getTotaalVerworvenPuntenAccount(accountnr, getDatumVorigJaar(datum));
        
        return totaalPunten;
        
    }
    
    public double totaalGeldJaar(int accountnr, Date datum){
        double totaalGeld = 0; // db.getTotaalGespendeerdBedragAccount(accountnr, getDatumVorigJaar(datum));
        return totaalGeld;
    }
    
    public void sendMailGoed(Winkel winkel,String badge, String punten){
        String filename = this.getAccountnr() + "_" + this.getNaam() + "_Mail.txt";
        PrintWriter outputStream = null;
        
        try
        {
            outputStream = new PrintWriter(filename);
        }
        
        catch (FileNotFoundException ex)
        {
            System.out.println("Error opening the file " + filename);
            System.exit(0);
        }
        
        
            String line = "Beste " + this.getNaam() + ", \n\n"
                          + "Bedankt om bij " + winkel.getWinkelnaam() + "klant te zijn. \n"
                          + "U bent " + badge + " geworden./n "
                          + "U krijgt " + punten + " punten bij op uw account. \n"
                          + "U heeft nu " + this.getPunten() + " punten";
            outputStream.println(line);
        
        outputStream.close();
    }
    
    public void sentMailSlecht(Winkel winkel,String badge){
        String filename = this.getAccountnr() + "_" + this.getNaam() + "_Mail.txt";
        PrintWriter outputStream = null;
        
        try
        {
            outputStream = new PrintWriter(filename);
        }
        
        catch (FileNotFoundException ex)
        {
            System.out.println("Error opening the file " + filename);
            System.exit(0);
        }
        
        
            String line = "<Send to" + this.getEmail() + "> \n\n" 
                          + "Beste " + this.getNaam() + ", \n\n"
                          + "Bedankt om bij " + winkel.getWinkelnaam() + "klant te zijn. \n"
                          + "U bent uw " + badge + " - Badge helaas kwijtgeraakt.";
            outputStream.println(line);
        
        outputStream.close();
    }
    
}
