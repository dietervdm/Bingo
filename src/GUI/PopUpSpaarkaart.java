
package GUI;

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
import javax.swing.JTextField;

    public class PopUpSpaarkaart {
        
    Timer timer;
    
    static JFrame f = new JFrame();
    static JPanel topPanel = new JPanel();
    static JPanel downPanel = new JPanel();
    
    private JTextField account = new JTextField();
    private JTextField spaarkaart = new JTextField();
    private JTextField aantalPunten = new JTextField();
    

    public PopUpSpaarkaart(int seconds) {
        timer = new Timer();
        timer.schedule(new afsluiten(), seconds*1000);
        initComponents();
	}

    public static void initComponents() {
        String path1 = "src\\GUI\\Badge\\Major.png";
        String path2 = "src\\GUI\\Badge\\BigSpender.png";
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
        
        JLabel maj = new JLabel(major);
        JLabel bs = new JLabel(bigSpender);
        JLabel wol = new JLabel(wolverine);
        
        f.setLayout(new GridLayout(2,1,5,5));               // gridlayout (int rows, int cols, int hGap, int vGap)
        topPanel.setLayout(new GridLayout(3,4,5,5));
        downPanel.setLayout(new GridLayout(1,3,5,5));
        
        JLabel naamKlant = new JLabel("Naam van de klant: ");
        //naamKlant.setFont(new java.awt.Font("Tahoma", 1, 18)); // Lettertype aanpassen
        JLabel naamAccount = new JLabel("Naam account: ");
        //naamAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // Lettertype aanpassen
        JLabel aantalPunten = new JLabel("aantal punten verzameld: ");
        //aantalPunten.setFont(new java.awt.Font("Tahoma", 1, 14)); // Lettertype aanpassen
        
        topPanel.add(naamKlant);
        topPanel.add(naamAccount);
        topPanel.add(aantalPunten);
        
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
        System.out.println("error");
        }
    }

    public void setAccount(String accountNaam) {
        this.account = new JTextField(accountNaam);
    }

    /**
     * @param spaarkaart the spaarkaart to set
     */
    public void setSpaarkaart(String spaarkaartHouder) {
        this.spaarkaart = new JTextField(spaarkaartHouder);
    }

    /**
     * @param aantalPunten the aantalPunten to set
     */
    public void setAantalPunten(int aantalPunten) {
        this.aantalPunten = new JTextField(Integer.toString(aantalPunten));
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
        new PopUpSpaarkaart(5);
        initComponents();
        f.setSize(600, 400);
        f.setVisible(true);
    }
}