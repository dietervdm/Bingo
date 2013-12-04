
package GUI;

import Database.Database;
import Logica.Account;
import Logica.Spaarkaart;
import Logica.Vestiging;
import Logica.Winkel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

    public class PopUpSpaarkaart {
    
    Timer timer;
    
    private static Database db = new Database();
    
    private static Winkel actief = InlogScherm.getInstance().actief;
    private static Vestiging actieveVest = null;
    private static Spaarkaart actieveSpaarkaart = null;
    private static int spaarkaartHouder;
    
//    private static Account acc;
//    private static Spaarkaart s;
    
    static JFrame f = new JFrame();
    static JPanel topPanel = new JPanel();
    static JPanel downPanel = new JPanel();
    static JPanel spaarkaartBalk = new JPanel();
    static JPanel accountBalk = new JPanel();
    static JPanel puntenBalk = new JPanel();
    
    static JLabel leegBoven = new JLabel("leegb");
    static JLabel leegOnder = new JLabel("leego");
    
    
    static JLabel account = new JLabel("<account naam>");
    static JLabel spaarkaart = new JLabel("<spaarkaart houder>");
    static JLabel punten = new JLabel("<aantal punten reeds verzameld>");
    
    static JLabel bedrijfOfPart = new JLabel("<Bedrijf/Particulier>");
    
    static JLabel maj = new JLabel();
    static JLabel bs = new JLabel();
    static JLabel wol = new JLabel();
    
    static ImageIcon major = null;
    static ImageIcon bigSpender = null;
    static ImageIcon wolverine = null;
    
    
    static JLabel naamKlant = new JLabel("Naam van de klant: ");
    //naamKlant.setFont(new java.awt.Font("Tahoma", 1, 18)); // Lettertype aanpassen
    static JLabel naamAccount = new JLabel("Naam account: ");
    //naamAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // Lettertype aanpassen
    static JLabel aantalPunten = new JLabel("Aantal punten verzameld: ");
        //aantalPunten.setFont(new java.awt.Font("Tahoma", 1, 14)); // Lettertype aanpassen

    public PopUpSpaarkaart(int seconds, Vestiging vest, Spaarkaart sk) {
        timer = new Timer();
        timer.schedule(new afsluiten(), seconds*1000);
        this.setActieveSpaarkaart(sk);
        this.setActieveVest(vest);
        initComponents();
         
//        s = new Spaarkaart(spaarkaartHouder);
//        acc = new Account(s.getAccountnr);
        // is dit een goeie oplossing?
	}

    public static void initComponents() {
        String path1 = afbeeldingMajor();
        //String path1 = "src\\GUI\\Badge\\MajorBlack.png";
        String path2 = afbeeldingBigSpender();
        //String path2 = "src\\GUI\\Badge\\BigSpender.png";
        String path3 = afbeeldingWolverine();
        //String path3 = "src\\GUI\\Badge\\Wolverine.png";
        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);
        
        try{
        BufferedImage image1 = ImageIO.read(file1);
        BufferedImage image2 = ImageIO.read(file2);
        BufferedImage image3 = ImageIO.read(file3);
        
        
        ImageIcon icon1 = new ImageIcon(image1);
        ImageIcon icon2 = new ImageIcon(image2);
        ImageIcon icon3 = new ImageIcon(image3);
        
        
        Image img1 = icon1.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        Image img2 = icon2.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        Image img3 = icon3.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        
        ImageIcon imic1 = new ImageIcon(img1);
        ImageIcon imic2 = new ImageIcon(img2);
        ImageIcon imic3 = new ImageIcon(img3);
        
            
//        //major.setImage((Icon)img1);
//        //bigSpender.setImage(img2);
//        //wolverine.setImage(img3);
//        //major.setIcon((Icon) imic1);
//        //major = new ImageIcon(img1);
//        bigSpender = new ImageIcon(img2);
//        wolverine = new ImageIcon(img3);
        
        maj.setIcon((Icon)imic1);
        //maj = new JLabel(major);
        bs.setIcon((Icon) imic2);
        //bs = new JLabel(bigSpender);
        wol.setIcon((Icon) imic3);
        //wol = new JLabel(wolverine);
        
        String acc = db.getAccount(actieveSpaarkaart.getAccountnr()).getNaam();
        account.setText(acc);
        //account.setText(db.getAccount(actieveSpaarkaart.getAccountnr()).getNaam());
        String sk = actieveSpaarkaart.getNaamhouder();
        spaarkaart.setText(sk);
        //spaarkaart.setText(actieveSpaarkaart.getNaamhouder());
        String pt = Integer.toString(db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten());
        punten.setText(pt);
        //punten.setText(Integer.toString(db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten()));
        
        if(db.getAccount(actieveSpaarkaart.getAccountnr()).isBedrijf())
        {
            bedrijfOfPart.setText("BEDRIJF" + db.getAccount(actieveSpaarkaart.getAccountnr()).getBtwnummer());
        }
        else
            bedrijfOfPart.setText("PARTICULIER");
        
        f.setLayout(new GridLayout(2,1,5,5));
        topPanel.setLayout(new GridLayout(3,1,10,3));       // gridlayout (int rows, int cols, int hGap, int vGap)
        downPanel.setLayout(new GridLayout(1,3,5,5));
        spaarkaartBalk.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 25));
        accountBalk.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 25));
        puntenBalk.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 25));
        
        
        
        spaarkaartBalk.add(naamKlant);
        spaarkaartBalk.add(spaarkaart);
        accountBalk.add(naamAccount);
        accountBalk.add(account);
        accountBalk.add(bedrijfOfPart);
        puntenBalk.add(aantalPunten);
        puntenBalk.add(punten);
        Border compound = BorderFactory.createLineBorder(Color.black, 2, false); // true voor ronde hoeken
        //BorderLayout bl = new BorderLayout(5,5);
        punten.setBorder(compound);
        punten.setAlignmentX(20);
        punten.setAlignmentY(40);
        
        //topPanel.add(leegBoven);
        topPanel.add(spaarkaartBalk);
        topPanel.add(accountBalk);
        topPanel.add(puntenBalk);
        //topPanel.add(leegBoven);
        
        downPanel.add(maj);
        downPanel.add(bs);
        downPanel.add(wol);
        
        f.add(topPanel);
        f.add(downPanel);
        
        f.setSize(600, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        }
        
        catch(IOException ex)
        {
        System.out.println(ex.getMessage());
        }
    }

    public void setAccount() {
        Account acc = new Account();
        this.account.setText(acc.getNaam());
    }

    public void setSpaarkaart() {
        Spaarkaart k = new Spaarkaart(spaarkaartHouder);
        this.spaarkaart.setText(k.getNaamhouder());
    }

    public void setAantalPunten() {
        Account acc = new Account();
        this.punten.setText(Integer.toString(acc.getPunten()));
    }
    
    public void setSpaarkaartHouder(String aSpaarkaartHouder) {
        spaarkaartHouder = Integer.getInteger(aSpaarkaartHouder);
    }

    public Vestiging getActieveVest() {
        return actieveVest;
    }

    public void setActieveVest(Vestiging actieveVest) {
        this.actieveVest = actieveVest;
    }
    
    public Spaarkaart getActieveSpaarkaart() {
        return actieveSpaarkaart;
    }

    public void setActieveSpaarkaart(Spaarkaart aActieveSpaarkaart) {
        actieveSpaarkaart = aActieveSpaarkaart;
    }

    class afsluiten extends TimerTask {
        public void run() {
            f.setVisible(false);
            
            VerkopenAfrekening s = new VerkopenAfrekening(actieveSpaarkaart, actieveVest);
            //s.setActieveSpaarkaart(actieveSpaarkaart);
            //s.setActieveVest(actieveVest);
            
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        //new PopUpSpaarkaart(5);
        initComponents();
        f.setVisible(true);
    }
    
    public static String afbeeldingMajor(){
        if (db.getAccount(actieveSpaarkaart.getAccountnr()).isMajor())
            return "src\\GUI\\Badge\\Major.png";
        else
            return "src\\GUI\\Badge\\MajorBlack.png";
    }
    
    public static String afbeeldingBigSpender(){
        if (db.getAccount(actieveSpaarkaart.getAccountnr()).isBigspender())
            return "src\\GUI\\Badge\\BigSpender.png";
        else
            return "src\\GUI\\Badge\\BigSpenderBlack.png";
    }
    
    public static String afbeeldingWolverine(){
        if (db.getAccount(actieveSpaarkaart.getAccountnr()).isWolverine())
            return "src\\GUI\\Badge\\Wolverine.png";
        else
            return "src\\GUI\\Badge\\WolverineBlack.png";
    }
}