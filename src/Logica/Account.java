
package Logica;


import java.awt.Image;
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
    private String btwNummer;
    private Image logo;
    //particulier
    private Image pasfoto;
    
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
    
    public String getBtwNummer()
    {
        return btwNummer;
    }
    
    public void setBtwNummer(String btwNummer)
    {
        this.btwNummer = btwNummer;
    }
    
    public Image getLogo()
    {
        return logo;
    }
    
    public void setLogo(Image logo)
    {
        this.logo = logo;
    }
    
    public Image getPasfoto()
    {
        return pasfoto;
    }
    
    public void setPasfoto(Image pasfoto)
    {
        this.pasfoto = pasfoto;
    }
    
    
    // via radiant button bedrijf of particulier
    public void bedrijfOfParticulier(Boolean bedrijf)
    {
        if (bedrijf == true)
            this.bedrijf = true;
        else
            this.bedrijf = false;
    }
}
