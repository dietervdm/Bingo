
package GUI;

import javax.swing.JFrame;
import Database.*;
import Logica.*;
import java.text.*;
import java.awt.print.*;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class RapportVestiging extends javax.swing.JFrame {
    
    public JFrame myCaller;
    public Winkel actief = InlogScherm.getInstance().getActief();
    public Database d = new Database();
    //DefaultTableModel t = d.naarTabel("select * from artikelaankoop");
    
    private Database db = new Database();
    DefaultTableModel t = db.naarTabel("SELECT * FROM artikelaankoop WHERE transactienr IN (SELECT transactienr FROM aankoop WHERE vestigingid = 99999)");
    
    public RapportVestiging() {
        initComponents();
        
    }
    
    public RapportVestiging(JFrame caller) {
        initComponents();
        myCaller = caller;
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu7 = new javax.swing.JMenu();
        knopTerug = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        knopPrint = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelVerkopen = new javax.swing.JTable(t);
        knopOk = new javax.swing.JButton();
        knopMetPuntenBetaald = new javax.swing.JButton();
        knopMetGeldBetaalt = new javax.swing.JButton();
        knopPuntenUitgereikt = new javax.swing.JButton();
        knopAlleVerkopen = new javax.swing.JButton();
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
        MenuknopArtikelgegevens = new javax.swing.JMenuItem();
        MenuknopAanpassenSpaarkaart = new javax.swing.JMenuItem();
        menuknopToevoegen = new javax.swing.JMenu();
        menuknopToevoegenVestiging = new javax.swing.JMenuItem();
        menuknopToevoegenKlant = new javax.swing.JMenuItem();
        MenuknopToevoegenArtikel = new javax.swing.JMenuItem();
        MenuknopToevoegenSpaarkaart = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuknopVerwijderenwinkel = new javax.swing.JMenuItem();
        menuknopVerwijderenvestiging = new javax.swing.JMenuItem();
        menuknopVerwijderenklant = new javax.swing.JMenuItem();
        MenuknopVerwijderenartikel = new javax.swing.JMenuItem();
        menuknopVerwijderenspaarkaart = new javax.swing.JMenuItem();
        menuknopUitloggen = new javax.swing.JMenu();

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vestigingsrapport");

        knopTerug.setText("Terug");
        knopTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopTerugActionPerformed(evt);
            }
        });

        jLabel1.setText("Vestigingsverkopen");

        knopPrint.setText("Print");
        knopPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopPrintActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(getVestigingen()));

        tabelVerkopen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelVerkopen);

        knopOk.setText("OK");
        knopOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopOkActionPerformed(evt);
            }
        });

        knopMetPuntenBetaald.setText("Met punten betaald");
        knopMetPuntenBetaald.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopMetPuntenBetaaldActionPerformed(evt);
            }
        });

        knopMetGeldBetaalt.setText("Met geld betaald");
        knopMetGeldBetaalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopMetGeldBetaaltActionPerformed(evt);
            }
        });

        knopPuntenUitgereikt.setText("Met uitgereikte punten");
        knopPuntenUitgereikt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopPuntenUitgereiktActionPerformed(evt);
            }
        });

        knopAlleVerkopen.setText("Alle verkopen");
        knopAlleVerkopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopAlleVerkopenActionPerformed(evt);
            }
        });

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
        menuknopWinkelrapport.setText("Winkelverkopen ");
        menuknopWinkelrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopWinkelrapportActionPerformed(evt);
            }
        });
        menuknopWinkelRapport.add(menuknopWinkelrapport);

        menuknopVestigingsrapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Vestiging.png"))); // NOI18N
        menuknopVestigingsrapport.setText("Vestigingsverkopen");
        menuknopVestigingsrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVestigingsrapportActionPerformed(evt);
            }
        });
        menuknopWinkelRapport.add(menuknopVestigingsrapport);

        menuknopKlantenrapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Assortiment.png"))); // NOI18N
        menuknopKlantenrapport.setText("Assortiment");
        menuknopKlantenrapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopKlantenrapportActionPerformed(evt);
            }
        });
        menuknopWinkelRapport.add(menuknopKlantenrapport);

        jMenuBar1.add(menuknopWinkelRapport);

        menuknopAanpassen.setText("Aanpassen");

        menuknopWinkelgegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Winkel.png"))); // NOI18N
        menuknopWinkelgegevens.setText("Winkel");
        menuknopWinkelgegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopWinkelgegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(menuknopWinkelgegevens);

        menuknopVestigingsgegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Vestiging.png"))); // NOI18N
        menuknopVestigingsgegevens.setText("Vestiging");
        menuknopVestigingsgegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVestigingsgegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(menuknopVestigingsgegevens);

        menuknopKlantengegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Klant.png"))); // NOI18N
        menuknopKlantengegevens.setText("Klant");
        menuknopKlantengegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopKlantengegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(menuknopKlantengegevens);

        MenuknopArtikelgegevens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Artikel.png"))); // NOI18N
        MenuknopArtikelgegevens.setText("Artikel");
        MenuknopArtikelgegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuknopArtikelgegevensActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(MenuknopArtikelgegevens);

        MenuknopAanpassenSpaarkaart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Spaarkaart.png"))); // NOI18N
        MenuknopAanpassenSpaarkaart.setText("Spaarkaart");
        MenuknopAanpassenSpaarkaart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuknopAanpassenSpaarkaartActionPerformed(evt);
            }
        });
        menuknopAanpassen.add(MenuknopAanpassenSpaarkaart);

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

        MenuknopToevoegenSpaarkaart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Spaarkaart.png"))); // NOI18N
        MenuknopToevoegenSpaarkaart.setText("Spaarkaart");
        MenuknopToevoegenSpaarkaart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuknopToevoegenSpaarkaartActionPerformed(evt);
            }
        });
        menuknopToevoegen.add(MenuknopToevoegenSpaarkaart);

        jMenuBar1.add(menuknopToevoegen);

        jMenu1.setText("Verwijderen");

        menuknopVerwijderenwinkel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Winkel.png"))); // NOI18N
        menuknopVerwijderenwinkel.setText("Winkel");
        menuknopVerwijderenwinkel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVerwijderenwinkelActionPerformed(evt);
            }
        });
        jMenu1.add(menuknopVerwijderenwinkel);

        menuknopVerwijderenvestiging.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Vestiging.png"))); // NOI18N
        menuknopVerwijderenvestiging.setText("Vestiging");
        menuknopVerwijderenvestiging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVerwijderenvestigingActionPerformed(evt);
            }
        });
        jMenu1.add(menuknopVerwijderenvestiging);

        menuknopVerwijderenklant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Klant.png"))); // NOI18N
        menuknopVerwijderenklant.setText("Klant");
        menuknopVerwijderenklant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVerwijderenklantActionPerformed(evt);
            }
        });
        jMenu1.add(menuknopVerwijderenklant);

        MenuknopVerwijderenartikel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Artikel.png"))); // NOI18N
        MenuknopVerwijderenartikel.setText("Artikel");
        MenuknopVerwijderenartikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuknopVerwijderenartikelActionPerformed(evt);
            }
        });
        jMenu1.add(MenuknopVerwijderenartikel);

        menuknopVerwijderenspaarkaart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Spaarkaart.png"))); // NOI18N
        menuknopVerwijderenspaarkaart.setText("Spaarkaart");
        menuknopVerwijderenspaarkaart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuknopVerwijderenspaarkaartActionPerformed(evt);
            }
        });
        jMenu1.add(menuknopVerwijderenspaarkaart);

        jMenuBar1.add(jMenu1);

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(knopTerug)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knopPrint))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knopAlleVerkopen))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(knopMetPuntenBetaald)
                                        .addGap(18, 18, 18)
                                        .addComponent(knopMetGeldBetaalt)
                                        .addGap(18, 18, 18)
                                        .addComponent(knopPuntenUitgereikt))
                                    .addComponent(knopOk))))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(knopOk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopPrint)
                    .addComponent(knopMetPuntenBetaald)
                    .addComponent(knopMetGeldBetaalt)
                    .addComponent(knopPuntenUitgereikt)
                    .addComponent(knopAlleVerkopen))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
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

    private void knopPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopPrintActionPerformed
        MessageFormat header = new MessageFormat("VESTIGINGSVERKOPEN");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try
        {
            tabelVerkopen.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch (java.awt.print.PrinterException e)
        {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_knopPrintActionPerformed

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

    private void menuknopWinkelrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopWinkelrapportActionPerformed
        RapportWinkel s = new RapportWinkel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopWinkelrapportActionPerformed

    private void menuknopVestigingsrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVestigingsrapportActionPerformed
        RapportVestiging s = new RapportVestiging(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopVestigingsrapportActionPerformed

    private void menuknopKlantenrapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopKlantenrapportActionPerformed
        RapportAssortiment s = new RapportAssortiment(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopKlantenrapportActionPerformed

    private void menuknopWinkelgegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopWinkelgegevensActionPerformed
        AanpassenWinkel s = new AanpassenWinkel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopWinkelgegevensActionPerformed

    private void menuknopVestigingsgegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVestigingsgegevensActionPerformed
        AanpassenVestiging s = new AanpassenVestiging(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopVestigingsgegevensActionPerformed

    private void menuknopKlantengegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopKlantengegevensActionPerformed
        AanpassenKlant s = new AanpassenKlant(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopKlantengegevensActionPerformed

    private void MenuknopArtikelgegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuknopArtikelgegevensActionPerformed
        AanpassenArtikel s = new AanpassenArtikel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuknopArtikelgegevensActionPerformed

    private void MenuknopAanpassenSpaarkaartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuknopAanpassenSpaarkaartActionPerformed
        AanpassenSpaarkaart s = new AanpassenSpaarkaart(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuknopAanpassenSpaarkaartActionPerformed

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
        ToevoegenArtikel s = new ToevoegenArtikel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuknopToevoegenArtikelActionPerformed

    private void MenuknopToevoegenSpaarkaartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuknopToevoegenSpaarkaartActionPerformed
        ToevoegenSpaarkaart s = new ToevoegenSpaarkaart(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuknopToevoegenSpaarkaartActionPerformed

    private void menuknopVerwijderenwinkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVerwijderenwinkelActionPerformed
        VerwijderenWinkel s = new VerwijderenWinkel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopVerwijderenwinkelActionPerformed

    private void menuknopVerwijderenvestigingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVerwijderenvestigingActionPerformed
        VerwijderenVestiging s = new VerwijderenVestiging(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopVerwijderenvestigingActionPerformed

    private void menuknopVerwijderenklantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVerwijderenklantActionPerformed
        VerwijderenKlant s = new VerwijderenKlant(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopVerwijderenklantActionPerformed

    private void MenuknopVerwijderenartikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuknopVerwijderenartikelActionPerformed
        VerwijderenArtikel s = new VerwijderenArtikel(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuknopVerwijderenartikelActionPerformed

    private void menuknopVerwijderenspaarkaartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuknopVerwijderenspaarkaartActionPerformed
        VerwijderenSpaarkaart s = new VerwijderenSpaarkaart(this);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopVerwijderenspaarkaartActionPerformed

    private void menuknopUitloggenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuknopUitloggenMouseClicked
        InlogScherm s = new InlogScherm();
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_menuknopUitloggenMouseClicked

    private void knopOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopOkActionPerformed
        int vestigingId = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        
        t = db.naarTabel("SELECT transactienr,artikelnr,aantal,metPuntenBetaald FROM artikelaankoop WHERE transactienr IN (SELECT transactienr FROM aankoop WHERE vestigingid = '" + vestigingId + "')");
        String namen[] = new String[]{"transactienummer", "artikelnummer", "artikelnaam", "aantal"};
        t.setColumnIdentifiers(namen);
        tabelVerkopen.setModel(t);
    }//GEN-LAST:event_knopOkActionPerformed

    private void knopMetPuntenBetaaldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopMetPuntenBetaaldActionPerformed
       int vestigingId = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        t = db.naarTabel("select artikelaankoop.transactienr, artikelaankoop.artikelnr, artikel.artikelnaam, aantal from artikelaankoop, artikel where artikelaankoop.artikelnr = artikel.artikelnr AND artikelaankoop.winkelnaam = artikel.winkelnaam AND artikelaankoop.winkelnaam = '" + actief.getWinkelnaam() +"' AND artikelaankoop.metPuntenBetaald = true AND artikelaankoop.transactienr IN (SELECT transactienr FROM aankoop WHERE vestigingid = '" + vestigingId + "')");
        String namen[] = new String[]{"transactienummer", "artikelnummer", "artikelnaam", "aantal"};
        t.setColumnIdentifiers(namen);
        tabelVerkopen.setModel(t);
    }//GEN-LAST:event_knopMetPuntenBetaaldActionPerformed

    private void knopMetGeldBetaaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopMetGeldBetaaltActionPerformed
        int vestigingId = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        t = db.naarTabel("select artikelaankoop.transactienr, artikelaankoop.artikelnr, artikel.artikelnaam, aantal from artikelaankoop, artikel where artikelaankoop.artikelnr = artikel.artikelnr AND artikelaankoop.winkelnaam = artikel.winkelnaam AND artikelaankoop.winkelnaam = '" + actief.getWinkelnaam() +"' AND metPuntenBetaald = false AND artikelaankoop.transactienr IN (SELECT transactienr FROM aankoop WHERE vestigingid = '" + vestigingId + "')");
        String namen[] = new String[]{"transactienummer", "artikelnummer", "artikelnaam", "aantal"};
        t.setColumnIdentifiers(namen);
        tabelVerkopen.setModel(t);
    }//GEN-LAST:event_knopMetGeldBetaaltActionPerformed

    private void knopPuntenUitgereiktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopPuntenUitgereiktActionPerformed
        int vestigingId = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        t = db.naarTabel("SELECT artikelaankoop.transactienr, artikelaankoop.artikelnr, artikel.artikelnaam,artikelaankoop.aantal, artikel.ptnwinst*artikelaankoop.aantal from artikelaankoop, artikel WHERE artikelaankoop.artikelnr = artikel.artikelnr AND artikelaankoop.winkelnaam = artikel.winkelnaam AND metPuntenBetaald = 0 AND artikelaankoop.winkelnaam = '" + actief.getWinkelnaam() +"' AND artikelaankoop.transactienr IN (SELECT transactienr FROM aankoop WHERE vestigingid = '" + vestigingId + "')");
        String namen[] = new String[]{"transactienummer", "artikelnummer", "artikelnaam", "aantal", "totaal uitgereikte punten"};
        t.setColumnIdentifiers(namen);
        tabelVerkopen.setModel(t);
    }//GEN-LAST:event_knopPuntenUitgereiktActionPerformed

    private void knopAlleVerkopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopAlleVerkopenActionPerformed
        int vestigingId = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        t = db.naarTabel("select artikelaankoop.transactienr, artikelaankoop.artikelnr, artikel.artikelnaam, artikelaankoop.aantal, artikelaankoop.metPuntenBetaald from artikelaankoop, artikel where artikelaankoop.artikelnr = artikel.artikelnr AND artikelaankoop.winkelnaam = artikel.winkelnaam AND artikelaankoop.winkelnaam = '" + actief.getWinkelnaam() +"' AND artikelaankoop.transactienr IN (SELECT transactienr FROM aankoop WHERE vestigingid = '" + vestigingId + "');");
        String namen[] = new String[]{"transactienummer", "artikelnummer", "artikelnaam", "aantal", "Is het met punten betaald?"};
        t.setColumnIdentifiers(namen);
        tabelVerkopen.setModel(t);
    }//GEN-LAST:event_knopAlleVerkopenActionPerformed

    
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
            java.util.logging.Logger.getLogger(RapportVestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RapportVestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RapportVestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RapportVestiging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RapportVestiging().setVisible(true);
            }
        });
    }
    
    public String[] getVestigingen(){
        ArrayList<String> lijst = actief.getLijstVestigingen();
        
        String[] lijstje = new String[lijst.size()];
        for(int i = 0; i<lijst.size(); i++)
        {
            lijstje[i] = lijst.get(i);
        }
        return lijstje;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuknopAanpassenSpaarkaart;
    private javax.swing.JMenuItem MenuknopArtikelgegevens;
    private javax.swing.JMenuItem MenuknopToevoegenArtikel;
    private javax.swing.JMenuItem MenuknopToevoegenSpaarkaart;
    private javax.swing.JMenuItem MenuknopVerwijderenartikel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton knopAlleVerkopen;
    private javax.swing.JButton knopMetGeldBetaalt;
    private javax.swing.JButton knopMetPuntenBetaald;
    private javax.swing.JButton knopOk;
    private javax.swing.JButton knopPrint;
    private javax.swing.JButton knopPuntenUitgereikt;
    private javax.swing.JButton knopTerug;
    private javax.swing.JMenu menuknopAanpassen;
    private javax.swing.JMenu menuknopHome;
    private javax.swing.JMenuItem menuknopKlantengegevens;
    private javax.swing.JMenuItem menuknopKlantenrapport;
    private javax.swing.JMenu menuknopToevoegen;
    private javax.swing.JMenuItem menuknopToevoegenKlant;
    private javax.swing.JMenuItem menuknopToevoegenVestiging;
    private javax.swing.JMenu menuknopUitloggen;
    private javax.swing.JMenu menuknopVerkopen;
    private javax.swing.JMenuItem menuknopVerwijderenklant;
    private javax.swing.JMenuItem menuknopVerwijderenspaarkaart;
    private javax.swing.JMenuItem menuknopVerwijderenvestiging;
    private javax.swing.JMenuItem menuknopVerwijderenwinkel;
    private javax.swing.JMenuItem menuknopVestigingsgegevens;
    private javax.swing.JMenuItem menuknopVestigingsrapport;
    private javax.swing.JMenu menuknopWinkelRapport;
    private javax.swing.JMenuItem menuknopWinkelgegevens;
    private javax.swing.JMenuItem menuknopWinkelrapport;
    private javax.swing.JTable tabelVerkopen;
    // End of variables declaration//GEN-END:variables
}
