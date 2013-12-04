
package GUI;

import Database.Database;
import Logica.*;
import Logica.Vestiging;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ToevoegenWinkel3 extends javax.swing.JFrame {

    public JFrame myCaller;
    public Database d = new Database();
    public Winkel actief = InlogScherm.getInstance().getActief();
    public DefaultTableModel t = d.naarTabel("select artikelnr, artikelnaam, prijs, ptnwinst, minimumaantal, ptnkost, minimumbedrag from artikel where winkelnaam = '" + actief.getWinkelnaam() + "'");

    
    public ToevoegenWinkel3() {
        initComponents();
    }
    
    public ToevoegenWinkel3(JFrame caller) {
        initComponents();
        myCaller = caller;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        knopTerug = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtArtikelnr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNaam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelArtikelen = new javax.swing.JTable(t);
        knopToevoegen = new javax.swing.JButton();
        knopVoegToe = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPrijs = new javax.swing.JTextField();
        txtPuntenplus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPuntenmin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        checkMinimumartikelen = new javax.swing.JCheckBox();
        checkMinimumaankoopbedrag = new javax.swing.JCheckBox();
        txtMinimumartikelen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMinimumbedrag = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        checkGeeftpunten = new javax.swing.JCheckBox();
        checkKostpunten = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Er moet minstens 1 artikel zijn dat punten oplevert");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Artikel toevoegen");

        knopTerug.setText("Terug");
        knopTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopTerugActionPerformed(evt);
            }
        });

        jLabel1.setText("Voeg minstens 1 artikel toe.");

        jLabel2.setText("Artikelnummer");

        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Opgepast! Elk artikel moet een verschillend nummer hebben.");

        jLabel4.setText("Artikelnaam");

        txtNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNaamActionPerformed(evt);
            }
        });

        tabelArtikelen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelArtikelen);

        knopToevoegen.setText("Toevoegen");
        knopToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopToevoegenActionPerformed(evt);
            }
        });

        knopVoegToe.setText("Voeg deze winkel toe!");
        knopVoegToe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopVoegToeActionPerformed(evt);
            }
        });

        jLabel5.setText("Prijs");

        jLabel8.setText("bonuspunten");

        jLabel9.setText("bonuspunten");

        checkMinimumartikelen.setText("Bij aankoop van");

        checkMinimumaankoopbedrag.setText("Bij een minimum aankoopbedrag van");

        jLabel10.setText("artikelen");

        jLabel11.setText("euro");

        checkGeeftpunten.setText("Geeft");

        checkKostpunten.setText("Kost");

        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Opgepast! Er moet minstens 1 artikel zijn dat punten oplevert en 1 artikel dat punten kost.");

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
                        .addComponent(knopVoegToe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrijs, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtArtikelnr, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkGeeftpunten)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPuntenplus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addComponent(knopToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkKostpunten)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtPuntenmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkMinimumaankoopbedrag)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinimumbedrag, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkMinimumartikelen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinimumartikelen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtArtikelnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrijs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkGeeftpunten)
                    .addComponent(txtPuntenplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(checkMinimumartikelen)
                    .addComponent(txtMinimumartikelen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkKostpunten)
                    .addComponent(txtPuntenmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(checkMinimumaankoopbedrag)
                    .addComponent(txtMinimumbedrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(knopToevoegen)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopTerug)
                    .addComponent(knopVoegToe))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNaamActionPerformed
        ToevoegenWinkel2 s = new ToevoegenWinkel2(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_txtNaamActionPerformed

    private void knopVoegToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopVoegToeActionPerformed
        System.out.println("Winkel toegevoegd, u kan nu inloggen.");
        InlogScherm s = new InlogScherm();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopVoegToeActionPerformed

    private void knopTerugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopTerugActionPerformed
        myCaller.setVisible(true);
        myCaller.setLocationRelativeTo(null);
                setVisible(false);
    }//GEN-LAST:event_knopTerugActionPerformed

    private void knopToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopToevoegenActionPerformed
       
        String winkelnaam = actief.getWinkelnaam();
        int puntenplus = 0;
        Integer puntenmin = null;
        int minimumartikelen = 1;
        int minimumbedrag = 0;
        int artikelnr = Integer.parseInt(txtArtikelnr.getText());
        double prijs = Double.parseDouble(txtPrijs.getText());
        int pr = (int) Math.round(prijs * 100);
        double prijsAfgerond = pr / 100.00 ;
        String artikelnaam = txtNaam.getText();
        boolean toevoegen = true;
        
        
        if(checkGeeftpunten.isSelected()){
            if(txtPuntenplus.getText().equals("")){
                toevoegen = false;
                JOptionPane.showMessageDialog(null, "Aantal pluspunten niet ingevuld");
            }
            else if(!Artikel.checkPuntenplusWaarde(Integer.parseInt(txtPuntenplus.getText()), prijs)){
                toevoegen = false;
                JOptionPane.showMessageDialog(null, "De punten per eenheid van de prijs moeten tussen de 0,25 en 2 punten.");
            }
            else {
               puntenplus = Integer.parseInt(txtPuntenplus.getText());
               if(checkMinimumartikelen.isSelected()){
                    if(txtMinimumartikelen.getText().equals("")){
                        toevoegen = false;
                        JOptionPane.showMessageDialog(null, "Aantal minimumartikelen niet ingevuld");
                    }
                    else {
                       minimumartikelen = Integer.parseInt(txtPuntenplus.getText()); 
                    }
                }
            }
        }
        
        if(checkKostpunten.isSelected()){
            if(txtPuntenmin.getText().equals("")){
                toevoegen = false;
                JOptionPane.showMessageDialog(null, "Aantal pluspunten niet ingevuld");
            }
            else if(!Artikel.checkPuntenminWaarde(Integer.parseInt(txtPuntenmin.getText()), prijs)){
                toevoegen = false;
                JOptionPane.showMessageDialog(null, "De punten per eenheid van de prijs moeten tussen de 0,25 en 2 punten.");
            }
            else {
               puntenmin = Integer.parseInt(txtPuntenmin.getText());
               if(checkMinimumaankoopbedrag.isSelected()){
                    if(txtMinimumbedrag.getText().equals("")){
                        toevoegen = false;
                        JOptionPane.showMessageDialog(null, "Minimumbedrag niet ingevuld");
                    }
                    else {
                       minimumbedrag = Integer.parseInt(txtPuntenmin.getText()); 
                    }
                }
            }
        }
        
        if(d.checkArtikel(artikelnr, winkelnaam)){
            toevoegen = false;
            JOptionPane.showMessageDialog(null, "Dit productnummer bestaat al voor deze winkel.");
        }
        
        Artikel q = new Artikel(artikelnr, winkelnaam, artikelnaam, prijsAfgerond, puntenplus, minimumartikelen, puntenmin, minimumbedrag);
        
        if(toevoegen){
            
            d.addArtikel(q);
            t = d.naarTabel("select artikelnr, artikelnaam, prijs, ptnwinst, minimumaantal, ptnkost, minimumbedrag from artikel where winkelnaam = '" + actief.getWinkelnaam() + "'");
            tabelArtikelen.setModel(t);
            txtArtikelnr.setText("");
            txtPrijs.setText("");
            txtPuntenplus.setText("");
            txtPuntenmin.setText("");
            txtMinimumartikelen.setText("");
            txtMinimumbedrag.setText("");
            txtNaam.setText("");
            checkKostpunten.setSelected(false);
            checkMinimumartikelen.setSelected(false);
            checkGeeftpunten.setSelected(false);
            checkMinimumaankoopbedrag.setSelected(false);
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
            java.util.logging.Logger.getLogger(ToevoegenWinkel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToevoegenWinkel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToevoegenWinkel3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkGeeftpunten;
    private javax.swing.JCheckBox checkKostpunten;
    private javax.swing.JCheckBox checkMinimumaankoopbedrag;
    private javax.swing.JCheckBox checkMinimumartikelen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton knopTerug;
    private javax.swing.JButton knopToevoegen;
    private javax.swing.JButton knopVoegToe;
    private javax.swing.JTable tabelArtikelen;
    private javax.swing.JTextField txtArtikelnr;
    private javax.swing.JTextField txtMinimumartikelen;
    private javax.swing.JTextField txtMinimumbedrag;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtPrijs;
    private javax.swing.JTextField txtPuntenmin;
    private javax.swing.JTextField txtPuntenplus;
    // End of variables declaration//GEN-END:variables
}
