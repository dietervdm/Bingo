
package GUI;

import Database.*;


public class InlogScherm extends javax.swing.JFrame {
    
    public String actief = null;
    public Database d;
    
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
        jPasswordField1 = new javax.swing.JPasswordField();
        knopLogIn = new javax.swing.JButton();
        knopNieuweWinkel = new javax.swing.JButton();
        keuzeWinkel = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in");

        jLabel1.setText("Naam");

        jLabel2.setText("Wachtwoord");

        jLabel3.setText("Gelieve in te loggen of een nieuwe winkel toe te voegen.");

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

        keuzeWinkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "winkel 1", "winkel 2", "winkel 3", "winkel 4" }));
        keuzeWinkel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keuzeWinkelActionPerformed(evt);
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
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keuzeWinkel, javax.swing.GroupLayout.Alignment.TRAILING, 0, 272, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(keuzeWinkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopLogIn)
                    .addComponent(knopNieuweWinkel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopLogInActionPerformed
        inlogscherm.setActief(keuzeWinkel.getSelectedItem().toString());
        
        Home s = new Home(this);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopLogInActionPerformed

    private void knopNieuweWinkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopNieuweWinkelActionPerformed

       
                ToevoegenWinkel s = new ToevoegenWinkel(this);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopNieuweWinkelActionPerformed

    private void keuzeWinkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keuzeWinkelActionPerformed
        
    }//GEN-LAST:event_keuzeWinkelActionPerformed

    
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
                new InlogScherm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JComboBox keuzeWinkel;
    private javax.swing.JButton knopLogIn;
    private javax.swing.JButton knopNieuweWinkel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the actief
     */
    public String getActief() {
        return actief;
    }

    /**
     * @param actief the actief to set
     */
    public void setActief(String actief) {
        this.actief = actief;
    }
}
