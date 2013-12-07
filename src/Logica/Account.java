
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
import java.util.Calendar;


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
    
//    public Date getDatumVorigJaar(Date datum){
//        datum.setYear(datum.getYear()-1);
//        return datum;
//    }
    
    // FUNCTIES VAN VIP SYSTEEM
    
    public static Date getVorigJaar(){
        
        Calendar cal = Calendar.getInstance();
        Date vandaag = cal.getTime();
        cal.add(Calendar.YEAR, -1);
        Date volgendJaar = cal.getTime();
        return volgendJaar;
        
    }
    
    public boolean isVip(int accountnr){
        return totaalPuntenJaar(accountnr) > 10000;
    }
    
    public void isMajorWorden(int accountnr, String winkelnaam){
        Account huidigIngelogdeAccount = db.getAccount(accountnr);
        // Account ingelogdeAccount = db.getAccount(accountnummer waar boolean actief = true
        // Major ingelogdeMajor = db.getMajor(accountnr winkel boolean);
        Account vorigeMajor = db.getAccount(db.getWinkel(winkelnaam).getAccount());
        // Account huidigeMajor = db.getAccount(accountnr);
        // eerst checkMajor(accountnr, winkel)
        // true: Major huidigeMajor = db.getMajor(accountnr, winkel);
        // false: Major huidigeMajor = db.addMajor(accountnr, winkel, false);
        
        if(isVip(huidigIngelogdeAccount.getAccountnr()))
        {
            if(this.totaalGeldJaar(huidigIngelogdeAccount.getAccountnr()) > totaalGeldJaar(vorigeMajor.getAccountnr()))
            {
                this.setMajor(true);
                // ingelogdeAccount.setActief
                
                if(jstartm.after(getVorigJaar()))
                {
                    this.setPunten(punten + 100);
                    huidigIngelogdeAccount.sendMailGoed("major", "100");
                    vorigeMajor.sendMailSlecht("Major");
                }
                else
                {
                    this.sendMailGoed("Major", "0");
                    db.getAccount(db.getWinkel(winkelnaam).getAccount()).sendMailSlecht("major");
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
    
    public void isWolverineWorden(){
        if(this.isVip(this.getAccountnr()))
        {
            if(db.getAantalVerschillendeWinkels(this) > 19)
            {
                if(jstartw.before(getVorigJaar()))
                {
                    this.setPunten(punten + 600);
                    this.sendMailGoed("Wolverine", "600");
                    Date vandaag = new Date();
                    this.setStartw(vandaag);
                }
                else
                {
                    this.sendMailGoed("Wolverine", "0");
                }
                this.setWolverine(true);
            }
            else
                this.setWolverine(false);
        }
        else
            this.setWolverine(false);
        System.out.println(db.getAantalVerschillendeWinkels(this));
        
        // OPSLAAN NAAR DE DATABASE
        
    }
    
    public void isBigSpenderWorden(){
        if(this.isVip(this.getAccountnr()))
        {
            if(this.totaalGeldJaar(this.accountnr) > 5000)
            {
                if(jstartb.before(getVorigJaar()))
                {
                    this.setPunten(punten + 500);
                    this.sendMailGoed("Bigspender", "600");
                    Date vandaag = new Date();
                    this.setStartw(vandaag);
                }
                else
                {
                    this.sendMailGoed("Bigspender", "0");
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
    
    
    public int totaalPuntenJaar(int accountnr){
        return db.getTotaalPuntenVerkregenAccount(accountnr);        
    }
    
    public double totaalGeldJaar(int accountnr){
        return db.getTotaalGespendeerdeBedragAccount(this.accountnr);
    }
    
    public void sendMailGoed(String badge, String punten){
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
                          + "Bedankt om bij Bingo klant te zijn. \n"
                          + "U bent " + badge + " geworden./n "
                          + "U krijgt " + punten + " punten bij op uw account. \n"
                          + "U heeft nu " + this.getPunten() + " punten";
            outputStream.println(line);
        
        outputStream.close();
    }
    
    public void sendMailSlecht(String badge){
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
                          + "Bedankt om bij Bingo klant te zijn. \n"
                          + "U bent uw " + badge + " - Badge helaas kwijtgeraakt.";
            outputStream.println(line);
        
        outputStream.close();
    }
    
    }
