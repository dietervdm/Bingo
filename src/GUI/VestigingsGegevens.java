
package GUI;

import javax.swing.JFrame;
import Database.*;
import Logica.*;

public class VestigingsGegevens extends javax.swing.JFrame {
    
    public JFrame myCaller;
    
    public VestigingsGegevens() {
        initComponents();
    }
    
    public VestigingsGegevens(JFrame caller) {
        initComponents();
        myCaller = caller;
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu7 = new javax.swing.JMenu();
        knopToevoegen = new javax.swing.JButton();
        knopTerug = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVestigingid2 = new javax.swing.JTextField();
        txtVestigingid = new javax.swing.JTextField();
        txtAdres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        knopToevoegen1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuknopHome = new javax.swing.JMenu();
        menuknopVerkopen = new javax.swing.JMenu();
        menuknopWinkelRapport = new javax.swing.JMenu();
        menuknopWinkelrapport = new javax.swing.JMenuItem();
        menuknopVestigingsrapport = new javax.swing.JMenuItem();
        menuknopKlantenrapport = new javax.swing.JMenuItem();
        menuknopAanpassen = new javax.swing.JMenu();
        menuknopWinkelgegevens = new javax.swing.JMenuItem();
        menuknopVestigingsgegevens = new javax.swing.JMenuItem();
        menuknopKlantengegevens = new javax.swing.JMenuItem();
        menuknopToevoegen = new javax.swing.JMenu();
        menuknopToevoegenVestiging = new javax.swing.JMenuItem();
        menuknopToevoegenKlant = new javax.swing.JMenuItem();
        MenuknopToevoegenArtikel = new javax.swing.JMenuItem();
        menuknopUitloggen = new javax.swing.JMenu();

        jMenu7.setText("jMenu7");

        knopToevoegen.setText("Toevoegen");
        knopToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopToevoegenActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vestigingsgegevens");

        knopTerug.setText("Terug");
        knopTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopTerugActionPerformed(evt);
            }
        });

        jLabel1.setText("Pas uw vestiging aan.");

        jLabel2.setText("Huidig vestigingsID");

        jLabel3.setText("Nieuw vestigingsID");

        jLabel4.setText("Adres");

        txtVestigingid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVestigingidActionPerformed(evt);
            }
        });

        txtAdres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Opgepast! Elke vestiging moet een verschillende ID hebben.");

        knopToevoegen1.setText("Aanpassen");
        knopToevoegen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopToevoegen1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        menuknopHome.setText("Home");
        menuknopHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuknopHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuknopHome);

        menuknopVerkopen.setText("Verkopen");
        menuknopVerkopen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuknopVerkopenMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuknopVerkopen);

        menuknopWinkelRapport.setText("Rapporten");

        menuknopWinkelrapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Winkel.png"))); // NOI18N
        menuknopWinkelrapport.setText("Winkelrapport");
        menuknopWinkelrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopWinkelrapportActionPerformed(evt);
            }
        });
        menuknopWinkelRapport.add(menuknopWinkelrapport);

        menuknopVestigingsrapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Vestiging.png"))); // NOI18N
        menuknopVestigingsrapport.setText("Vestigingsrapport");
        menuknopVestigingsrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVestigingsrapportActionPerformed(evt);
            }
        });
        menuknopWinkelRapport.add(menuknopVestigingsrapport);

        menuknopKlantenrapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Klant.png"))); // NOI18N
        menuknopKlantenrapport.setText("Klantenrapport");
        menuknopKlantenrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopKlantenrapportActionPerformed(evt);
            }
        });
        menuknopWinkelRapport.add(menuknopKlantenrapport);

        jMenuBar1.add(menuknopWinkelRapport);

        menuknopAanpassen.setText("Aanpassen");

        menuknopWinkelgegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Winkel.png"))); // NOI18N
        menuknopWinkelgegevens.setText("Winkelgegevens");
        menuknopWinkelgegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopWinkelgegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(menuknopWinkelgegevens);

        menuknopVestigingsgegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Vestiging.png"))); // NOI18N
        menuknopVestigingsgegevens.setText("Vestigingsgegevens");
        menuknopVestigingsgegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVestigingsgegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(menuknopVestigingsgegevens);

        menuknopKlantengegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Klant.png"))); // NOI18N
        menuknopKlantengegevens.setText("Klantengegevens");
        menuknopKlantengegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopKlantengegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(menuknopKlantengegevens);

        jMenuBar1.add(menuknopAanpassen);

        menuknopToevoegen.setText("Toevoegen");

        menuknopToevoegenVestiging.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Vestiging.png"))); // NOI18N
        menuknopToevoegenVestiging.setText("Vestiging");
        menuknopToevoegenVestiging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopToevoegenVestigingActionPerformed(evt);
            }
        });
        menuknopToevoegen.add(menuknopToevoegenVestiging);

        menuknopToevoegenKlant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Klant.png"))); // NOI18N
        menuknopToevoegenKlant.setText("Klant");
        menuknopToevoegenKlant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopToevoegenKlantActionPerformed(evt);
            }
        });
        menuknopToevoegen.add(menuknopToevoegenKlant);

        MenuknopToevoegenArtikel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Artikel.png"))); // NOI18N
        MenuknopToevoegenArtikel.setText("Artikel");
        MenuknopToevoegenArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuknopToevoegenArtikelActionPerformed(evt);
            }
        });
        menuknopToevoegen.add(MenuknopToevoegenArtikel);

        jMenuBar1.add(menuknopToevoegen);

        menuknopUitloggen.setText("Uitloggen");
        menuknopUitloggen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuknopUitloggenMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuknopUitloggen);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(knopTerug)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVestigingid, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtVestigingid2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(knopToevoegen1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVestigingid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVestigingid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(knopToevoegen1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(knopTerug)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopTerugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopTerugActionPerformed
        myCaller.setVisible(true);
        myCaller.setLocationRelativeTo(null);
                setVisible(false);
    }//GEN-LAST:event_knopTerugActionPerformed

    private void menuknopWinkelrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopWinkelrapportActionPerformed
        WinkelRapport s = new WinkelRapport(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopWinkelrapportActionPerformed

    private void menuknopVestigingsrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVestigingsrapportActionPerformed
        VestigingsRapport s = new VestigingsRapport(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopVestigingsrapportActionPerformed

    private void menuknopKlantenrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopKlantenrapportActionPerformed
        KlantenRapport s = new KlantenRapport(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopKlantenrapportActionPerformed

    private void menuknopWinkelgegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopWinkelgegevensActionPerformed
        WinkelGegevens s = new WinkelGegevens(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopWinkelgegevensActionPerformed

    private void menuknopVestigingsgegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVestigingsgegevensActionPerformed
        VestigingsGegevens s = new VestigingsGegevens(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopVestigingsgegevensActionPerformed

    private void menuknopKlantengegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopKlantengegevensActionPerformed
        KlantenGegevens s = new KlantenGegevens(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopKlantengegevensActionPerformed

    private void menuknopToevoegenVestigingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopToevoegenVestigingActionPerformed
        ToevoegenVestiging s = new ToevoegenVestiging(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopToevoegenVestigingActionPerformed

    private void menuknopToevoegenKlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopToevoegenKlantActionPerformed
        ToevoegenKlant s = new ToevoegenKlant(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopToevoegenKlantActionPerformed

    private void MenuknopToevoegenArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuknopToevoegenArtikelActionPerformed
        ToevoegenProduct s = new ToevoegenProduct(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_MenuknopToevoegenArtikelActionPerformed

    private void menuknopUitloggenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuknopUitloggenMouseClicked
        InlogScherm s = new InlogScherm();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopUitloggenMouseClicked

    private void menuknopHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuknopHomeMouseClicked
        Home s = new Home(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopHomeMouseClicked

    private void menuknopVerkopenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuknopVerkopenMouseClicked
        Verkopen s = new Verkopen(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_menuknopVerkopenMouseClicked

    private void txtAdresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresActionPerformed

    private void knopToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopToevoegenActionPerformed
//        String winkelnaam = InlogScherm.getInstance().getActief().getWinkelnaam();
//        int vestigingid = Integer.parseInt(txtVestigingid.getText());
//        Vestiging v = new Vestiging(vestigingid, winkelnaam, txtAdres.getText());
//        if(d.checkVestiging(vestigingid, winkelnaam)){
//            JOptionPane.showMessageDialog(null, "Deze vestigingsid bestaat al voor deze winkel");
//        }
//        else{
//            d.addVestiging(v);
//            JOptionPane.showMessageDialog(null, "Vestiging toegevoegd");
//            txtVestigingid.setText("");
//            txtAdres.setText("");
//       }
    }//GEN-LAST:event_knopToevoegenActionPerformed

    private void knopToevoegen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopToevoegen1ActionPerformed
//        String winkelnaam = InlogScherm.getInstance().getActief().getWinkelnaam();
//        int vestigingid = Integer.parseInt(txtVestigingid.getText());
//        Vestiging v = new Vestiging(vestigingid, winkelnaam, txtAdres.getText());
//        if(d.checkVestiging(vestigingid, winkelnaam)){
//            JOptionPane.showMessageDialog(null, "Deze vestigingsid bestaat al voor deze winkel");
//        }
//        else{
//            d.addVestiging(v);
//            JOptionPane.showMessageDialog(null, "Vestiging toegevoegd");
//            txtVestigingid.setText("");
//            txtAdres.setText("");
//        }
    }//GEN-LAST:event_knopToevoegen1ActionPerformed

    private void txtVestigingidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVestigingidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVestigingidActionPerformed

    
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
            java.util.logging.Logger.getLogger(VestigingsGegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VestigingsGegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VestigingsGegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VestigingsGegevens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VestigingsGegevens().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuknopToevoegenArtikel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton knopTerug;
    private javax.swing.JButton knopToevoegen;
    private javax.swing.JButton knopToevoegen1;
    private javax.swing.JMenu menuknopAanpassen;
    private javax.swing.JMenu menuknopHome;
    private javax.swing.JMenuItem menuknopKlantengegevens;
    private javax.swing.JMenuItem menuknopKlantenrapport;
    private javax.swing.JMenu menuknopToevoegen;
    private javax.swing.JMenuItem menuknopToevoegenKlant;
    private javax.swing.JMenuItem menuknopToevoegenVestiging;
    private javax.swing.JMenu menuknopUitloggen;
    private javax.swing.JMenu menuknopVerkopen;
    private javax.swing.JMenuItem menuknopVestigingsgegevens;
    private javax.swing.JMenuItem menuknopVestigingsrapport;
    private javax.swing.JMenu menuknopWinkelRapport;
    private javax.swing.JMenuItem menuknopWinkelgegevens;
    private javax.swing.JMenuItem menuknopWinkelrapport;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtVestigingid;
    private javax.swing.JTextField txtVestigingid2;
    // End of variables declaration//GEN-END:variables
}
