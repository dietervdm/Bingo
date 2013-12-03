
package GUI;

import javax.swing.JFrame;
import Database.*;
import Logica.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ToevoegenProduct extends javax.swing.JFrame {
    
    public JFrame myCaller;
    public Winkel actief = InlogScherm.getInstance().getActief();
    public Database d = new Database();
    DefaultTableModel t = d.naarTabel("select * from artikel where winkelnaam = '" + actief.getWinkelnaam() + "'");
    
    public ToevoegenProduct() {
        initComponents();
        actief = InlogScherm.getInstance().getActief();
    }
    
    public ToevoegenProduct(JFrame caller) {
        initComponents();
        myCaller = caller;
        actief = InlogScherm.getInstance().getActief();
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu7 = new javax.swing.JMenu();
        knopTerug = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtArtikelnr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtArtikelnaam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrijs = new javax.swing.JTextField();
        checkGeeftpunten = new javax.swing.JCheckBox();
        txtPuntenplus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        checkKostpunten = new javax.swing.JCheckBox();
        txtPuntenmin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        checkMinimumartikelen = new javax.swing.JCheckBox();
        checkMinimumaankoopbedrag = new javax.swing.JCheckBox();
        txtMinimumartikelen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMinimumbedrag = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        knopToevoegen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelArtikelen = new javax.swing.JTable(t);
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
        jMenuItem2 = new javax.swing.JMenuItem();
        menuknopToevoegen = new javax.swing.JMenu();
        menuknopToevoegenVestiging = new javax.swing.JMenuItem();
        menuknopToevoegenKlant = new javax.swing.JMenuItem();
        MenuknopToevoegenArtikel = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuknopVerwijderenwinkel = new javax.swing.JMenuItem();
        menuknopVerwijderenvestiging = new javax.swing.JMenuItem();
        menuknopVerwijderenklant = new javax.swing.JMenuItem();
        MenuknopVerwijderenartikel = new javax.swing.JMenuItem();
        menuknopVerwijderenspaarkaart = new javax.swing.JMenuItem();
        menuknopUitloggen = new javax.swing.JMenu();

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Toevoegen product");

        knopTerug.setText("Terug");
        knopTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopTerugActionPerformed(evt);
            }
        });

        jLabel1.setText("Voeg een artikel toe.");

        jLabel2.setText("Artikelnummer");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Opgepast! Elk artikel moet een verschillend nummer hebben.");

        jLabel4.setText("Artikelnaam");

        txtArtikelnaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtikelnaamActionPerformed(evt);
            }
        });

        jLabel5.setText("Prijs");

        checkGeeftpunten.setText("Geeft");

        jLabel8.setText("bonuspunten");

        checkKostpunten.setText("Kost");

        jLabel9.setText("bonuspunten");

        checkMinimumartikelen.setText("Bij aankoop van");

        checkMinimumaankoopbedrag.setText("Bij een minimum aankoopbedrag van");

        txtMinimumartikelen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimumartikelenActionPerformed(evt);
            }
        });

        jLabel10.setText("artikelen");

        txtMinimumbedrag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimumbedragActionPerformed(evt);
            }
        });

        jLabel11.setText("euro");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Opgepast! Er moet minstens 1 artikel zijn dat punten oplevert en 1 artikel dat punten kost om deel te kunnen nemen aan het systeem.");

        knopToevoegen.setText("Toevoegen");
        knopToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopToevoegenActionPerformed(evt);
            }
        });

        tabelArtikelen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelArtikelen);

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

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Spaarkaart.png"))); // NOI18N
        jMenuItem2.setText("Spaarkaart");
        menuknopAanpassen.add(jMenuItem2);

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

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon Pack/Spaarkaart.png"))); // NOI18N
        jMenuItem1.setText("Spaarkaart");
        menuknopToevoegen.add(jMenuItem1);

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
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtArtikelnaam)
                                                .addComponent(txtArtikelnr, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(checkGeeftpunten)
                                                    .addGap(38, 38, 38))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(55, 55, 55)
                                                    .addComponent(txtPuntenplus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(6, 6, 6)))
                                            .addComponent(jLabel8)
                                            .addGap(83, 83, 83)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkKostpunten)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPuntenmin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkMinimumaankoopbedrag)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinimumbedrag, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrijs, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkMinimumartikelen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinimumartikelen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(knopToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(knopTerug)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtArtikelnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtArtikelnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkKostpunten)
                    .addComponent(txtPuntenmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(checkMinimumaankoopbedrag)
                    .addComponent(txtMinimumbedrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addComponent(knopToevoegen)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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

    private void txtArtikelnaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtikelnaamActionPerformed
        ToevoegenWinkel2 s = new ToevoegenWinkel2(this);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_txtArtikelnaamActionPerformed

    private void knopToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopToevoegenActionPerformed
        
        // voorwaarden worden niet opgenomen
        
        String winkelnaam = InlogScherm.getInstance().getActief().getWinkelnaam();
        
        int puntenplus = 0;
        int puntenmin = -1;
        int minimumartikelen = 1;
        int minimumbedrag = 0;
        int artikelnr = Integer.parseInt(txtArtikelnr.getText());
        double prijs = Double.parseDouble(txtPrijs.getText());
        double prijsAfgerond = 0;
        String artikelnaam = txtArtikelnaam.getText();
        
        if(prijs < 0)
        {
            JOptionPane.showMessageDialog(null, "Controleer de prijs, deze moet positief zijn.");
        }
        else
        {
            int pr = (int) Math.round(prijs * 100);
            prijsAfgerond = pr / 100.00 ;
        }
        
        Artikel p = new Artikel(artikelnr, winkelnaam, prijs, puntenplus, puntenmin);
        
        if(checkGeeftpunten.isSelected() && !txtPuntenplus.getText().equals(""))
        {
            puntenplus = Integer.parseInt(txtPuntenplus.getText());
            
            if(puntenplus < 0)
            {
                JOptionPane.showMessageDialog(null, "Aantal te ontvangen punten moeten positief zijn.");
            }
            
            if(p.checkPuntenplusWaarde(puntenplus, prijs))
            {
                if(checkMinimumartikelen.isSelected() && !txtMinimumartikelen.getText().equals(""))
                {
                    minimumartikelen = Integer.parseInt(txtMinimumartikelen.getText());
                }
                else
                {
                    minimumartikelen = 1;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "De punten per eenheid van de prijs moeten tussen de 0,25 en 2 punten.");
            }
        }
        else
        {
                puntenplus = 0;
                minimumartikelen = 1;
        }
        
        if(checkKostpunten.isSelected() && !txtPuntenmin.getText().equals(""))
        {
            puntenmin = Integer.parseInt(txtPuntenmin.getText());
            
            if(puntenmin < 0)
            {
                JOptionPane.showMessageDialog(null, "Het aantal punten dat een product kost, moet positief zijn.");
            }
            
            if(p.checkPuntenminWaarde(puntenmin, prijs))
            {
                if(checkMinimumartikelen.isSelected() && !txtMinimumartikelen.getText().equals(""))
                {
                    minimumbedrag = Integer.parseInt(txtMinimumartikelen.getText());
                }
                else
                {
                    minimumbedrag = 0;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "De punten per eenheid van de prijs moeten tussen de 0,25 en 2 punten.");
            }
        }
        else
        {
            puntenmin = -1;
            minimumbedrag = 0;
        }
        
        if(d.checkArtikel(artikelnr, winkelnaam))
        {
            JOptionPane.showMessageDialog(null, "Dit productnummer bestaat al voor deze winkel.");
        }
        else
        {
            Artikel q = new Artikel(artikelnr, winkelnaam, artikelnaam, prijsAfgerond, puntenplus, minimumartikelen, puntenmin, minimumbedrag);
            
            d.addArtikel(q);
            t = d.naarTabel("select * from artikel where winkelnaam = '" + actief.getWinkelnaam() + "'");
            tabelArtikelen.setModel(t);
            txtArtikelnr.setText("");
            txtPrijs.setText("");
            txtPuntenplus.setText("");
            txtPuntenmin.setText("");
            txtMinimumartikelen.setText("");
            txtMinimumbedrag.setText("");
            txtArtikelnaam.setText("");
            checkKostpunten.setSelected(false);
            checkMinimumartikelen.setSelected(false);
            checkGeeftpunten.setSelected(false);
            checkMinimumaankoopbedrag.setSelected(false);
        }
    }//GEN-LAST:event_knopToevoegenActionPerformed

    private void txtMinimumbedragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimumbedragActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimumbedragActionPerformed

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

    private void txtMinimumartikelenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimumartikelenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimumartikelenActionPerformed

    
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
            java.util.logging.Logger.getLogger(ToevoegenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToevoegenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToevoegenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToevoegenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToevoegenProduct().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuknopArtikelgegevens;
    private javax.swing.JMenuItem MenuknopToevoegenArtikel;
    private javax.swing.JMenuItem MenuknopVerwijderenartikel;
    private javax.swing.JCheckBox checkGeeftpunten;
    private javax.swing.JCheckBox checkKostpunten;
    private javax.swing.JCheckBox checkMinimumaankoopbedrag;
    private javax.swing.JCheckBox checkMinimumartikelen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton knopTerug;
    private javax.swing.JButton knopToevoegen;
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
    private javax.swing.JTable tabelArtikelen;
    private javax.swing.JTextField txtArtikelnaam;
    private javax.swing.JTextField txtArtikelnr;
    private javax.swing.JTextField txtMinimumartikelen;
    private javax.swing.JTextField txtMinimumbedrag;
    private javax.swing.JTextField txtPrijs;
    private javax.swing.JTextField txtPuntenmin;
    private javax.swing.JTextField txtPuntenplus;
    // End of variables declaration//GEN-END:variables
}
