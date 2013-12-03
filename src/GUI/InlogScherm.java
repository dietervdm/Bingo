
package GUI;

import Database.*;
import Logica.*;
import javax.swing.JOptionPane;


public class InlogScherm extends javax.swing.JFrame {
    
    public Winkel actief = null;
    public Winkel w = null;
    public Database d = new Database();
    
    private static final InlogScherm inlogscherm = new InlogScherm();
    
    public static InlogScherm getInstance(){
        return inlogscherm;
    }
        
    public InlogScherm() {
        initComponents();
    }

   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPaswoord = new javax.swing.JPasswordField();
        knopLogIn = new javax.swing.JButton();
        knopNieuweWinkel = new javax.swing.JButton();
        txtNaam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in");

        jLabel1.setText("Naam");

        jLabel2.setText("Paswoord");

        jLabel3.setText("Gelieve in te loggen of een nieuwe winkel toe te voegen.");

        txtPaswoord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaswoordActionPerformed(evt);
            }
        });

        knopLogIn.setText("Log in");
        knopLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopLogInActionPerformed(evt);
            }
        });

        knopNieuweWinkel.setText("Nieuwe winkel");
        knopNieuweWinkel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopNieuweWinkelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(knopNieuweWinkel, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(knopLogIn)
                        .addContainerGap(213, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPaswoord, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(txtNaam))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopLogIn)
                    .addComponent(knopNieuweWinkel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopLogInActionPerformed
        
        String naam = txtNaam.getText();
        String paswoord = txtPaswoord.getText();
        
        if(d.checkWinkel(naam)){
            if(naam.equals(paswoord)){
                w = d.getWinkel(naam);
                inlogscherm.setActief(w);
                inlogscherm.setLocationRelativeTo(null);
                Home s = new Home(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
            }
            else JOptionPane.showMessageDialog(null, "Incorrect paswoord. Probeer opnieuw het wachtwoord in te vullen.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Deze winkel bestaat nog niet, je kan hem aanmaken via de knop 'Nieuwe Winkel'.");
        }
        
    }//GEN-LAST:event_knopLogInActionPerformed

    private void knopNieuweWinkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopNieuweWinkelActionPerformed

        inlogscherm.setActief(null);
        ToevoegenWinkel s = new ToevoegenWinkel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_knopNieuweWinkelActionPerformed

    private void txtPaswoordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaswoordActionPerformed
        String naam = txtNaam.getText();
        String paswoord = txtPaswoord.getText();
        
        if(d.checkWinkel(naam)){
            if(naam.equals(paswoord)){
                w = d.getWinkel(naam);
                inlogscherm.setActief(w);
                inlogscherm.setLocationRelativeTo(null);
                Home s = new Home(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
            }
            else JOptionPane.showMessageDialog(null, "Incorrect paswoord. Probeer opnieuw het wachtwoord in te vullen.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Deze winkel bestaat nog niet, je kan hem aanmaken via de knop 'Nieuwe Winkel'.");
        }
    }//GEN-LAST:event_txtPaswoordActionPerformed

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(InlogScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InlogScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InlogScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InlogScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InlogScherm().setVisible(true);
                InlogScherm i = new InlogScherm();
                i.setLocationRelativeTo(null);
                i.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton knopLogIn;
    private javax.swing.JButton knopNieuweWinkel;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JPasswordField txtPaswoord;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the actief
     */
    public Winkel getActief() {
        return actief;
    }

    /**
     * @param actief the actief to set
     */
    public void setActief(Winkel actief) {
        this.actief = actief;
    }
}
