
package GUI;

import javax.swing.JFrame;
import Database.*;
import Logica.*;
import javax.swing.JOptionPane;

public class ToevoegenWinkel extends javax.swing.JFrame {
    
    private JFrame myCaller;
    public Database d = new Database();
    public Winkel actief = InlogScherm.getInstance().getActief();
    
    private static final ToevoegenWinkel toevoegenWinkel = new ToevoegenWinkel();
    
    public static ToevoegenWinkel getInstance(){
        return toevoegenWinkel;
    }
    
    public ToevoegenWinkel() {
        initComponents();
    }
    
    public ToevoegenWinkel(JFrame caller) {
        initComponents();
        myCaller = caller;
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu7 = new javax.swing.JMenu();
        knopAnnuleren = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPaswoord = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtPaswoord2 = new javax.swing.JPasswordField();
        knopGaVerder = new javax.swing.JButton();
        labelPaswoord = new javax.swing.JLabel();

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Klantengegevens");

        knopAnnuleren.setText("Annuleren");
        knopAnnuleren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopAnnulerenActionPerformed(evt);
            }
        });

        jLabel1.setText("Vul uw gegevens in.");

        jLabel2.setText("Naam:");

        jLabel3.setText("Wachtwoord:");

        jLabel4.setText("Herhaal wachtwoord:");

        knopGaVerder.setText("Ga verder");
        knopGaVerder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopGaVerderActionPerformed(evt);
            }
        });

        labelPaswoord.setForeground(new java.awt.Color(153, 0, 0));
        labelPaswoord.setText("De 2 wachtwoorden moeten gelijk zijn!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPaswoord2)
                                    .addComponent(txtPaswoord, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(labelPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(217, 217, 217))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(knopAnnuleren, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
                        .addComponent(knopGaVerder)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPaswoord2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPaswoord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopAnnuleren)
                    .addComponent(knopGaVerder))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopAnnulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopAnnulerenActionPerformed
        if (actief == null){
            
        }
        else{
            d.deleteWinkel(actief);
            InlogScherm s = new InlogScherm();
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_knopAnnulerenActionPerformed

    private void knopGaVerderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopGaVerderActionPerformed
        
        String paswoord = txtPaswoord.getText();
        String paswoordHerhaald = txtPaswoord2.getText();
        
        if(checkPaswoord(paswoord))
        {
            if(paswoord.equals(paswoordHerhaald))
            {
                Winkel w = new Winkel(txtNaam.getText(), paswoord);
            
                if(d.checkWinkel(w.getWinkelnaam()))
                {
                    JOptionPane.showMessageDialog(null, "Deze winkelnaam bestaat al.");
                }
                else
                {
                    d.addWinkel(w);
                    InlogScherm.getInstance().setActief(w);
                    
                    ToevoegenWinkel2 s = new ToevoegenWinkel2(this);
                    s.setLocationRelativeTo(null);
                    s.setVisible(true);
                    setVisible(false);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Beide wachtwoorden komen niet overeen.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Het wachtwoord moet tussen 7 à 14 karakters lang zijn en mag geen vreemde cijfers bevatten.");
        }
    }//GEN-LAST:event_knopGaVerderActionPerformed
    
    public boolean checkPaswoord(String paswoord)
    {
        int length;
        length = paswoord.length();
        
        if(length < 6 || length > 15)
        {
            return false;
        }
        
        for(int i = 0; i < paswoord.length();i++)
        {
            if (!Character.isLetter(paswoord.charAt(i)))
            {
                return false;
            }           
            return true;
        }
        return true;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToevoegenWinkel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JButton knopAnnuleren;
    private javax.swing.JButton knopGaVerder;
    private javax.swing.JLabel labelPaswoord;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JPasswordField txtPaswoord;
    private javax.swing.JPasswordField txtPaswoord2;
    // End of variables declaration//GEN-END:variables

    
    public JFrame getMyCaller() {
        return myCaller;
    }

    
    public void setMyCaller(JFrame myCaller) {
        this.myCaller = myCaller;
    }
}
