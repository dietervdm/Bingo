
package GUI;

import Database.Database;
import Logica.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ToevoegenWinkel2 extends javax.swing.JFrame {

    public JFrame myCaller;
    public Database d = new Database();
    public Winkel actief = InlogScherm.getInstance().getActief();
    public DefaultTableModel t = d.naarTabel("select vestigingid,adres from vestiging where winkelnaam = '" + actief.getWinkelnaam() + "'");
    
    
    public ToevoegenWinkel2() {
        initComponents();
    }
    
    public ToevoegenWinkel2(JFrame caller) {
        initComponents();
        myCaller = caller;  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        knopTerug = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtVestigingid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAdres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelVestigingen = new javax.swing.JTable(t);
        knopToevoegen = new javax.swing.JButton();
        knopGaVerder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vestiging toevoegen");

        knopTerug.setText("Terug");
        knopTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopTerugActionPerformed(evt);
            }
        });

        jLabel1.setText("Voeg minstens 1 vestiging toe.");

        jLabel2.setText("VestigingsID");

        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Opgepast! Elke vestiging moet een verschillende ID hebben.");

        jLabel4.setText("Adres");

        txtAdres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresActionPerformed(evt);
            }
        });

        tabelVestigingen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelVestigingen);

        knopToevoegen.setText("Toevoegen");
        knopToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopToevoegenActionPerformed(evt);
            }
        });

        knopGaVerder.setText("Ga verder");
        knopGaVerder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopGaVerderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(knopTerug)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(knopGaVerder))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(knopToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(355, 355, 355)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtVestigingid, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 166, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVestigingid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(93, 93, 93)
                .addComponent(knopToevoegen)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopGaVerder)
                    .addComponent(knopTerug))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAdresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresActionPerformed

    private void knopGaVerderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopGaVerderActionPerformed
  
            ToevoegenWinkel3 s = new ToevoegenWinkel3(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
        
    }//GEN-LAST:event_knopGaVerderActionPerformed

    private void knopTerugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopTerugActionPerformed
        myCaller.setVisible(true);
        myCaller.setLocationRelativeTo(null);
                setVisible(false);
    }//GEN-LAST:event_knopTerugActionPerformed

    private void knopToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopToevoegenActionPerformed
        String winkelnaam = actief.getWinkelnaam();
        String vestigingid = txtVestigingid.getText();
        Vestiging v = new Vestiging(vestigingid, winkelnaam, txtAdres.getText());
        if(d.checkVestiging(vestigingid, winkelnaam))
        {
            JOptionPane.showMessageDialog(null, "Deze vestigingsid bestaat al voor deze winkel");
        }
        else
        {
            d.addVestiging(v);
            t = d.naarTabel("select vestigingid,adres from vestiging where winkelnaam = '" + actief.getWinkelnaam() + "'");
            tabelVestigingen.setModel(t);
            txtVestigingid.setText("");
            txtAdres.setText("");
        }
    }//GEN-LAST:event_knopToevoegenActionPerformed

   
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
            java.util.logging.Logger.getLogger(ToevoegenWinkel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToevoegenWinkel2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton knopGaVerder;
    private javax.swing.JButton knopTerug;
    private javax.swing.JButton knopToevoegen;
    private javax.swing.JTable tabelVestigingen;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtVestigingid;
    // End of variables declaration//GEN-END:variables
}
