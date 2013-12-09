
package Logica;

import Database.Database;
//import static Logica.Account.getVorigJaar;
import java.sql.Date;
import java.util.ArrayList;


public class Major
{
    private int accountnr;
    private String winkelnaam;
    private Date puntendatum;
//    private boolean actief;
    
    Database db = new Database();
    
    public Major()
    {}
    
    public Major(String winkelnaam, int accountnr)
    {
        this.winkelnaam = winkelnaam;
        this.accountnr = accountnr;
    }
    
    public Major(int accountnr, String winkelnaam, Date puntendatum)
    {
        this.accountnr = accountnr;
        this.winkelnaam = winkelnaam;
        this.puntendatum = puntendatum;
//        this.actief = actief;
    }

    public int getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(int accountnr) {
        this.accountnr = accountnr;
    }

    public String getWinkelnaam() {
        return winkelnaam;
    }

    public void setWinkelnaam(String winkelnaam) {
        this.winkelnaam = winkelnaam;
    }

    public Date getPuntendatum() {
        return puntendatum;
    }

    public void setPuntendatum(Date puntendatum) {
        this.puntendatum = puntendatum;
    }
    
//    public boolean isActief() {
//        return actief;
//    }
//
//    public void setActief(boolean actief) {
//        this.actief = actief;
//    }
    
//    public void isMajorWorden(Account acc){
//        Account huidigIngelogdeAccount = db.getAccount(accountnr);
//         Account ingelogdeAccount = db.getAccount(accountnummer waar boolean actief = true
//         Major ingelogdeMajor = db.getMajor(accountnr winkel boolean);
//        Account vorigeMajor = db.getAccount(db.getWinkel(winkelnaam).getAccount());
//         Account huidigeMajor = db.getAccount(accountnr);
//         eerst checkMajor(accountnr, winkel)
//         true: Major huidigeMajor = db.getMajor(accountnr, winkel);
//         false: Major huidigeMajor = db.addMajor(accountnr, winkel, false);
//        
//        if(acc.isVip(huidigIngelogdeAccount.getAccountnr()))
//        {
//            if(acc.totaalGeldJaar(huidigIngelogdeAccount.getAccountnr()) > totaalGeldJaar(vorigeMajor.getAccountnr()))
//            {
//                this.setMajor(true);
//                 ingelogdeAccount.setActief
//                
//                if(jstartm.after(getVorigJaar()))
//                {
//                    this.setPunten(punten + 100);'b'
//                    huidigIngelogdeAccount.sendMailGoed("major", "100");
//                    vorigeMajor.sendMailSlecht("Major");
//                }
//                else
//                {
//                    this.sendMailGoed("Major", "0");
//                    db.getAccount(db.getWinkel(winkelnaam).getAccount()).sendMailSlecht("major");
//                }
//            }
//            else
//            {
//                this.setMajor(false);
//            }
//        }
//        else
//        {
//            this.setMajor(false);
//        }
//        
//        OPSLAAN NAAR DE DATABASE
//    }
    
//    public void majorWorden(Winkel winkel){
//        
//    }
  }
