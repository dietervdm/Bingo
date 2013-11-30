/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Dieter
 */
    public class PopUpSpaarkaart {
    Timer timer;
    
    static JFrame f = new JFrame();
    

    public PopUpSpaarkaart(int seconds) {
        timer = new Timer();
        timer.schedule(new afsluiten(), seconds*1000);
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
        try{
        String path1 = "src\\GUI\\Badge\\Major.png";
        String path2 = "src\\GUI\\Badge\\BigSpender.png";
        String path3 = "src\\GUI\\Badge\\Wolverine.png";
        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);
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
        f.setLayout(new GridLayout(2,1,5,5));
        
        JLabel naamKlant = new JLabel("Naam van de klant: ");
        JLabel naamAccount = new JLabel("Naam account: ");
        JLabel aantalPunten = new JLabel("aantal punten verzameld: ");
        
        f.add(naamKlant);
        f.add(naamAccount);
        f.add(aantalPunten);
        
        f.add(maj);
        f.add(bs);
        f.add(wol);
        
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        }
        catch(IOException ex){
        System.out.println("error");
    }
    }
}

//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * Simple demo that uses java.util.Timer to schedule a task 
// * to execute once 5 seconds have passed.
// */
//
//public class Reminder {
//    Timer timer;
//
//    public Reminder(int seconds) {
//        timer = new Timer();
//        timer.schedule(new RemindTask(), seconds*1000);
//	}
//
//    class RemindTask extends TimerTask {
//        public void run() {
//            System.out.format("Time's up!%n");
//            timer.cancel(); //Terminate the timer thread
//        }
//    }
//
//    public static void main(String args[]) {
//        new Reminder(5);
//        System.out.format("Task scheduled.%n");
//    }
//}
