
package GUI;

import javax.swing.JFrame;
import Database.*;
import Logica.*;
import javax.swing.JOptionPane;

public class ToevoegenWinkel extends javax.swing.JFrame {
    
    private JFrame myCaller;
    public Database d = new Database();
    private Winkel w;
    
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

        txtPaswoord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaswoordActionPerformed(evt);
            }
        });

        jLabel4.setText("Herhaal wachtwoord:");

        knopGaVerder.setText("Ga verder");
        knopGaVerder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopGaVerderActionPerformed(evt);
            }
        });

        labelPaswoord.setForeground(new java.awt.Color(255, 0, 0));
        labelPaswoord.setText("De 2 paswoorden moeten gelijk zijn!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(knopAnnuleren, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPaswoord2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                        .addComponent(knopGaVerder)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelPaswoord, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        getMyCaller().setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopAnnulerenActionPerformed

    private void txtPaswoordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaswoordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaswoordActionPerformed

    private void knopGaVerderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopGaVerderActionPerformed
        
        if(txtPaswoord.getText().equals(txtPaswoord2.getText())){
            w = new Winkel(txtNaam.getText(), txtPaswoord.getText());
            getInstance().setW(w);
            if(d.checkWinkel(getW().getWinkelnaam())){
                JOptionPane.showMessageDialog(null, "Deze winkelnaam bestaat al.");
            }
            else {
                d.addWinkel(getW());
                ToevoegenWinkel2 s = new ToevoegenWinkel2(this);
                s.setVisible(true);
                setVisible(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "De wachtwoorden moeten identiek zijn!");
        }
    }//GEN-LAST:event_knopGaVerderActionPerformed

    
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

    /**
     * @return the myCaller
     */
    public JFrame getMyCaller() {
        return myCaller;
    }

    /**
     * @return the w
     */
    public Winkel getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(Winkel w) {
        this.w = w;
    }
}
