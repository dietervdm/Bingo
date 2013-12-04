
package GUI;

import Database.Database;
import Logica.Aankoop;
import Logica.Vestiging;
import Logica.Winkel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class VerkopenKlant extends javax.swing.JFrame {

    private Winkel actief = InlogScherm.getInstance().getActief();
    private Vestiging actieveVest;
    private Database db = new Database();
    
    public JFrame myCaller;
    
    public VerkopenKlant() {
        initComponents();
    }
    
    public VerkopenKlant(JFrame caller) {
        initComponents();
        myCaller = caller;
    }
    
    public VerkopenKlant(Vestiging vest){
        actieveVest = vest;
        initComponents();
    }
    
    public VerkopenKlant(Vestiging vest, JFrame caller){
        actieveVest = vest;
        initComponents();
        myCaller = caller;
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSpaarkaartNummer = new javax.swing.JTextField();
        knopRegistreerAankoop = new javax.swing.JButton();
        knopAnnuleer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Geef spaarkaartnummer.");

        knopRegistreerAankoop.setText("Registreer aankoop");
        knopRegistreerAankoop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopRegistreerAankoopActionPerformed(evt);
            }
        });

        knopAnnuleer.setText("Annuleer");
        knopAnnuleer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopAnnuleerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(knopAnnuleer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(knopRegistreerAankoop))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSpaarkaartNummer, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtSpaarkaartNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopAnnuleer)
                    .addComponent(knopRegistreerAankoop))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopRegistreerAankoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopRegistreerAankoopActionPerformed

                if(db.checkSpaarkaart(Integer.parseInt(txtSpaarkaartNummer.getText())))
                {
                    //Spaarkaart sk = db.getSpaarkaart(Integer.parseInt(txtSpaarkaartNummer.getText()));
                    PopUpSpaarkaart s = new PopUpSpaarkaart(5, actieveVest, db.getSpaarkaart(Integer.parseInt(txtSpaarkaartNummer.getText())));
                    //s.setActieveSpaarkaart(db.getSpaarkaart(Integer.parseInt(txtSpaarkaartNummer.getText())));
                    //s.setActieveVest(actieveVest);
                    
//                    Aankoop ak = new Aankoop();
//                    db.addAankoop(db.getLaatsteAankoop().getTransactieNummer + 1);
                    
                    setVisible(false);
                }
                else
                {
                    //setVisible(false);
                    JOptionPane.showMessageDialog(null, "Spaarkaart bestaat niet.");
                    //setVisible(true);
                }
                
    }//GEN-LAST:event_knopRegistreerAankoopActionPerformed

    private void knopAnnuleerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopAnnuleerActionPerformed
        setVisible(false);
        
//        myCaller.setVisible(true);
//        myCaller.setLocationRelativeTo(null);
//                setVisible(false);
        
//        Home s = new Home();         // NOG NIET GOED, CREERD TELKENS EEN NIEUW VENSTER!!!
//            s.setLocationRelativeTo(null);
//            s.setVisible(true);
//        setVisible(false);
//        // Naar home??
    }//GEN-LAST:event_knopAnnuleerActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VerkopenKlant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerkopenKlant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerkopenKlant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerkopenKlant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerkopenKlant s = new VerkopenKlant();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton knopAnnuleer;
    private javax.swing.JButton knopRegistreerAankoop;
    private javax.swing.JTextField txtSpaarkaartNummer;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the actieveVest
     */
    public Vestiging getActieveVest() {
        return actieveVest;
    }

    /**
     * @param actieveVest the actieveVest to set
     */
    public void setActieveVest(Vestiging actieveVest) {
        this.actieveVest = actieveVest;
    }
}
