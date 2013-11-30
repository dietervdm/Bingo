
package GUI;

import Logica.Account;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

    public class PopUpSpaarkaart {
        
    Timer timer;
    
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
    
    static JLabel maj;
    static JLabel bs;
    static JLabel wol;
    
    
    static JLabel naamKlant = new JLabel("\t Naam van de klant: ");
    //naamKlant.setFont(new java.awt.Font("Tahoma", 1, 18)); // Lettertype aanpassen
    static JLabel naamAccount = new JLabel("\t Naam account: ");
    //naamAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // Lettertype aanpassen
    static JLabel aantalPunten = new JLabel("\t aantal punten verzameld: ");
        //aantalPunten.setFont(new java.awt.Font("Tahoma", 1, 14)); // Lettertype aanpassen

    public PopUpSpaarkaart(int seconds) {
        timer = new Timer();
        timer.schedule(new afsluiten(), seconds*1000);
        initComponents();
        
	}

    public static void initComponents() {
        //String path1 = afbeeldingMajor();
        String path1 = "src\\GUI\\Badge\\MajorBlack.png";
        //String path2 = afbeeldingBigSpender();
        String path2 = "src\\GUI\\Badge\\BigSpender.png";
        //String path3 = afbeeldingWolverine();
        String path3 = "src\\GUI\\Badge\\Wolverine.png";
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
            
        ImageIcon major = new ImageIcon(img1);
        ImageIcon bigSpender = new ImageIcon(img2);
        ImageIcon wolverine = new ImageIcon(img3);
        
        maj = new JLabel(major);
        bs = new JLabel(bigSpender);
        wol = new JLabel(wolverine);
        
        f.setLayout(new GridLayout(2,1,5,5));               // gridlayout (int rows, int cols, int hGap, int vGap)
        topPanel.setLayout(new GridLayout(3,1,10,3));
        downPanel.setLayout(new GridLayout(1,3,5,5));
        spaarkaartBalk.setLayout(new GridLayout(1,3,1,1));
        accountBalk.setLayout(new GridLayout(1,3,1,1));
        puntenBalk.setLayout(new GridLayout(1,3,1,1));
        
        
        
        spaarkaartBalk.add(naamKlant);
        spaarkaartBalk.add(spaarkaart);
        accountBalk.add(naamAccount);
        accountBalk.add(account);
        puntenBalk.add(aantalPunten);
        puntenBalk.add(punten);
        
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

    public void setAccount(String accountNaam) {
        this.account.setText(accountNaam);
    }

    /**
     * @param spaarkaart the spaarkaart to set
     */
    public void setSpaarkaart(String spaarkaartHouder) {
        this.spaarkaart.setText(spaarkaartHouder);
    }

    /**
     * @param aantalPunten the aantalPunten to set
     */
    public void setAantalPunten(int aantalPunten) {
        this.punten.setText(Integer.toString(aantalPunten));
    }
    

    class afsluiten extends TimerTask {
        public void run() {
            f.setVisible(false);
            
            timer.cancel(); //Terminate the timer thread
            VerkopenAfrekening s = new VerkopenAfrekening();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
        }
    }

    public static void main(String args[]) {
        //new PopUpSpaarkaart(5);
        initComponents();
        f.setSize(600, 400);
        f.setVisible(true);
    }
    
    public String afbeeldingMajor(){
        Account acc = new Account();
        if (acc.isMajor())
            return "src\\GUI\\Badge\\Major.png";
        else
            return "src\\GUI\\Badge\\MajorBlack.png";
    }
    
    public String afbeeldingBigSpender(){
        Account acc = new Account();
        if (acc.isMajor())
            return "src\\GUI\\Badge\\BigSpender.png";
        else
            return "src\\GUI\\Badge\\BigSpenderBlack.png";
    }
    
    public String Wolverine(){
        Account acc = new Account();
        if (acc.isMajor())
            return "src\\GUI\\Badge\\Wolverine.png";
        else
            return "src\\GUI\\Badge\\WolverineBlack.png";
    }
}