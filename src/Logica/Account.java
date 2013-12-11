
package Logica;

import Database.Database;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
//Deze nodig voor mail
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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
    private java.sql.Date startm = new java.sql.Date(jstartw.getTime());
    private boolean bedrijf;
    private String btwnummer;
    private Image logo;
    Database db = new Database();
    
    public Account()
    {}
    
    public Account(int accountnr, boolean wolverine, boolean bigspender, boolean bedrijf)
    {
        this.accountnr = accountnr;
        this.wolverine = wolverine;
        this.bigspender = bigspender;
        this.bedrijf = bedrijf;
    }
    
    public Account(int accountnr, String naam, String email, String adres, int punten, boolean wolverine, java.sql.Date startw, boolean bigspender, java.sql.Date startb, boolean bedrijf, String btwnummer)
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
    
    public void setStartb(Date datum)
    {
        this.startb = startb;
    }
    

    
    public Date getStartm()
    {
        return this.startm;
    }
    
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
    
    
    public void bedrijfOfParticulier(Boolean bedrijf)
    {
        if (bedrijf == true)
            this.bedrijf = true;
        else
            this.bedrijf = false;
    }
    
    public boolean isVip(int accountnr){
        return totaalPuntenJaar(accountnr) > 9999;
    }
    
    public void isMajorWorden(String winkelnaam){
        Account acc1 = db.getAccount(this.getAccountnr());
        Account acc2 = db.getAccount(db.getWinkel(winkelnaam).getAccount());
        
        
        if(acc1.isVip(acc1.getAccountnr()))
        {
            if(db.heeftMajor(winkelnaam))
            {
                if(this.getAccountnr() != db.getWinkel(winkelnaam).getAccount())
                {
                    if(acc1.totaalGeldJaar(acc1.getAccountnr()) > acc2.totaalGeldJaar(acc2.getAccountnr()))
                    {
                        Major major1 = db.getMajor(this.getAccountnr(), winkelnaam);
                        Major major2 = db.getMajor(db.getWinkel(winkelnaam).getAccount(), winkelnaam);
                
                        if(db.checkMajor(this.getAccountnr(), winkelnaam))
                        {
                            // acc1 wordt major
                            db.updateAccountnrWinkel(db.getWinkel(winkelnaam), acc1.getAccountnr());
                    
                            if(db.krijgtPunten(major1))
                            {
                                // geef punten
                                int nieuwepunten = acc1.getPunten() + 100;  // Major krijgt 100 punten bij.
                                db.updateAantalpunten(acc1, nieuwepunten);
                                // zet datum op vandaag
                                db.updateMajor(acc1, db.getWinkel(winkelnaam));
                            }
                        }
                        else
                        {
                        // acc1 was nog geen major geweest en wordt major
                        db.addMajor(this.getAccountnr(), winkelnaam);
                        // geef punten
                        int nieuwepunten = acc1.getPunten() + 100;  // Major krijgt 100 punten bij.
                        db.updateAantalpunten(acc1, nieuwepunten);
                        }
                        
                    }
                else
                {
                    // niets doen, acc2 blijft major
                }
            }
            else
            {
                db.addMajor(acc1.getAccountnr(), winkelnaam);
            }
        }
        else
        {
            db.updateAccountnrWinkel(db.getWinkel(winkelnaam), acc1.getAccountnr());
            // geef punten
            int nieuwepunten = acc1.getPunten() + 100;  // Major krijgt 100 punten bij.
            db.updateAantalpunten(acc1, nieuwepunten);
            // acc1 was nog geen major geweest en wordt major
            db.addMajor(this.getAccountnr(), winkelnaam);
        }
        }
        else
        {
            
        }  
    }
    
    public void isWolverineWorden(){
        Account acc = db.getAccount(accountnr);
        
        if(this.isVip(this.getAccountnr()))
        {
            if(this.isWolverine())
            {
                // Doe niets, is al Wolverine
            }
            else
            {
                if(db.getAantalVerschillendeWinkels(this) > 19)
                {
                    if(db.getDatumVoorWolverine(accountnr))
                    {
                        int nieuwepunten = acc.getPunten() + 600;  // Wolverine krijgt 600 punten bij.
                        db.updateAantalpunten(acc, nieuwepunten);
                        this.sendMailGoed("Wolverine", "600");
                        Date vandaag = new Date();
                        this.setStartw(vandaag);
                        db.updateWolverineAccountDatum(accountnr);
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
        }
        else
            this.setWolverine(false);
        
        // OPSLAAN NAAR DE DATABASE
        db.updateWolverineAccount(accountnr, this.isWolverine());
    }
    
    public void isBigSpenderWorden(){
        
        Account acc = db.getAccount(accountnr);
        if(this.isVip(this.getAccountnr()))
        {
            if(this.isBigspender())
            {
                // niets doen, is al Big Spender
            }
            else
            {
               if(this.totaalGeldJaar(this.accountnr) > 5000)
                {
                    this.setBigspender(true);
                    if(db.getDatumVoorBigspender(accountnr))
                    {
                        int nieuwepunten = acc.getPunten() + 500;  // Bigspender krijgt 500
                        db.updateAantalpunten(acc, nieuwepunten);

                        this.sendMailGoed("Bigspender", "600");
                        Date vandaag = new Date();
                        this.setStartw(vandaag);
                        db.updateBigSpenderAccountDatum(accountnr);
                    }
                    else
                    {
                        this.sendMailGoed("Bigspender", "0");
                    }
                }
                else
                {
                    this.setBigspender(false);
                } 
            }
        }
        else
        {
            this.setBigspender(false);
        }
        
        // OPSLAAN NAAR DATABASE
        db.updateBigSpenderAccount(accountnr, this.isBigspender());
    }
    
    public int totaalPuntenJaar(int accountnr){
        return db.getTotaalPuntenVerkregenAccount(accountnr);       
    }
    
    public double totaalGeldJaar(int accountnr){
        return db.getTotaalGespendeerdeBedragAccount(this.accountnr);
    }
    
    public void sendMailGoed(String badge, String ptn){
        final String username = " bingogroep31@gmail.com";
	final String password = "aeCahqu3";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
                Session session = Session.getInstance(props,
                new javax.mail.Authenticator() 
                {
                protected PasswordAuthentication getPasswordAuthentication() 
                        {
				return new PasswordAuthentication(username, password);
			}
		});
 
		try
                {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(" bingogroep31@gmail.com"));
                            // Zend email adres is vast.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.getEmail()));
                            // Ontvang email adres is variabel
			message.setSubject(badge + "-badge verworven!");
			message.setText("Beste " + this.getNaam() + ", \n\n"
                          + "Bedankt om bij Bingo klant te zijn. \n"
                          + "Proficiat, u bent " + badge + " geworden.\n\n"
                          + "U krijgt " + Integer.parseInt(ptn) + " punten bij op uw account. \n"
                          + "U heeft nu " + this.getPunten() + " punten."
                                
                          + "met vriendelijke groet, \n"
                          + "uw Bingo-team");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} 
                catch (MessagingException e) 
                {
			throw new RuntimeException(e);
		}
    }
    
    public void sendMailSlecht(String badge){
        final String username = " bingogroep31@gmail.com";
	final String password = "aeCahqu3";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
                Session session = Session.getInstance(props,
                new javax.mail.Authenticator() 
                {
                protected PasswordAuthentication getPasswordAuthentication() 
                        {
				return new PasswordAuthentication(username, password);
			}
		});
 
		try
                {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(" bingogroep31@gmail.com"));
                            // Zend email adres is vast.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.getEmail()));
                            // Ontvang email adres is variabel
			message.setSubject(badge + "-badge verloren!");
			message.setText("Beste " + this.getNaam() + ", \n\n"
                          + "Bedankt om bij Bingo klant te zijn. \n"
                          + "Helaas, u bent uw " + badge + "-badge kwijtgeraakt. \n\n "
                                
                          + "met vriendelijke groet, \n"
                          + "uw Bingo-team");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} 
                catch (MessagingException e) 
                {
			throw new RuntimeException(e);
		}
    }
    
    public boolean isMajor(Winkel winkel){
        return winkel.getAccount() == this.accountnr;
    }
}
