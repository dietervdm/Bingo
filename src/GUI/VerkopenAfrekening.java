
package GUI;

import Database.Database;
import Logica.Aankoop;
import Logica.Artikel;
import Logica.Artikelaankoop;
import Logica.Spaarkaart;
import Logica.Vestiging;
import Logica.Winkel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VerkopenAfrekening extends javax.swing.JFrame {

    private Winkel actief = InlogScherm.getInstance().actief;
    private Vestiging actieveVest;
    private Spaarkaart actieveSpaarkaart;
    
    private Database db = new Database();
    private int transactienummer = (db.maxTransactienr() + 1);
        
    
    private double totaalPrijs = 0.0;
    private int totaalPuntenPlus = 0;
    private int totaalPuntenMin = 0;
    private int puntenOver;
    private int artikelenMetPunten = 0;
    
    private Aankoop ak; // = new Aankoop(transactienummer, actieveVest.getVestigingId(), actief.getWinkelnaam(), actieveSpaarkaart.getKaartnr(), datum);

    DefaultTableModel t = db.naarTabel("select artikelaankoop.artikelnr, artikel.artikelnaam, artikel.prijs, artikelaankoop.aantal, artikelaankoop.MetPuntenBetaald from artikelaankoop, artikel where transactienr = 0");
    //DefaultTableModel t = db.naarTabel("select * from artikelaankoop where winkelnaam = 'sdjqshdgfqskjdygfqskjd'");

    public VerkopenAfrekening() {
        initComponents();
        // initialiseren van aantal punten door uit de database te halen.
        puntenOver = db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten();
        ak = new Aankoop(transactienummer, actieveVest.getVestigingId(),
                                    actief.getWinkelnaam(), actieveSpaarkaart.getKaartnr());
        db.addAankoop(ak);
    }
    
    
    public VerkopenAfrekening(Spaarkaart sk, Vestiging vest) {
        setActieveSpaarkaart(sk);
        setActieveVest(vest);
        // initialiseren van aantal punten door uit de database te halen.
        puntenOver = db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten();
        ak = new Aankoop((transactienummer), actieveVest.getVestigingId(),
                                    actief.getWinkelnaam(), actieveSpaarkaart.getKaartnr());
        db.addAankoop(ak);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAankopen = new javax.swing.JTable(t);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtProductVerwijderen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        knopVoegToe = new javax.swing.JButton();
        knopAnnuleer = new javax.swing.JButton();
        knopRegistreerAankoop = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProductToevoegen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totaalBedrag = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        puntenVerkregen = new javax.swing.JLabel();
        weergaveAfgetrokkenPunten = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        aantalArtikelenPunten = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        weergaveTeGebruikenPunten = new javax.swing.JLabel();
        aantalBepaler = new javax.swing.JSpinner();
        knopVerwijder = new javax.swing.JButton();
        transactieNummer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Kaarthouder");

        jLabel2.setText("Aantal punten:");

        jScrollPane1.setViewportView(tabelAankopen);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Afrekening");

        jLabel8.setText("productcode:");

        jLabel9.setText("aantal:");

        knopVoegToe.setText("Voeg toe");
        knopVoegToe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopVoegToeActionPerformed(evt);
            }
        });

        knopAnnuleer.setText("Annuleer");
        knopAnnuleer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopAnnuleerActionPerformed(evt);
            }
        });

        knopRegistreerAankoop.setText("Registreer aankoop");
        knopRegistreerAankoop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopRegistreerAankoopActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Scan product");

        jLabel11.setText("Productcode:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Verwijder product");

        jLabel13.setText("Totaalbedrag:");

        totaalBedrag.setText(Double.toString(totaalPrijs));

        jLabel15.setText("Punten verkregen:");

        jLabel16.setText("Punten afgetrokken:");

        puntenVerkregen.setText(Integer.toString(totaalPuntenPlus));

        weergaveAfgetrokkenPunten.setText(Integer.toString(totaalPuntenMin));

        jLabel19.setText("voor");

        aantalArtikelenPunten.setText(Integer.toString(artikelenMetPunten));

        jLabel21.setText("artikelen");

        weergaveTeGebruikenPunten.setForeground(new java.awt.Color(255, 0, 0));
        weergaveTeGebruikenPunten.setText(Integer.toString(puntenOver));

        aantalBepaler.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        aantalBepaler.setValue(1);

        knopVerwijder.setText("Verwijder");
        knopVerwijder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopVerwijderActionPerformed(evt);
            }
        });

        transactieNummer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        transactieNummer.setText(Integer.toString(this.transactienummer));

        jLabel3.setText("€");

        jLabel4.setText("transactienummer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(knopAnnuleer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(knopRegistreerAankoop, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totaalBedrag)
                                            .addComponent(puntenVerkregen)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtProductToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(aantalBepaler, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(transactieNummer)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(weergaveAfgetrokkenPunten)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aantalArtikelenPunten)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductVerwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knopVoegToe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knopVerwijder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(weergaveTeGebruikenPunten)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transactieNummer)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(weergaveTeGebruikenPunten))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtProductToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aantalBepaler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(knopVoegToe)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtProductVerwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(knopVerwijder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totaalBedrag)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addComponent(puntenVerkregen)))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(weergaveAfgetrokkenPunten)
                            .addComponent(jLabel19)
                            .addComponent(aantalArtikelenPunten)
                            .addComponent(jLabel21))))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopAnnuleer)
                    .addComponent(knopRegistreerAankoop))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopRegistreerAankoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopRegistreerAankoopActionPerformed

        int puntenToevoegen = puntenOver + totaalPuntenPlus;
        db.updateAantalpunten(db.getAccount(actieveSpaarkaart.getAccountnr()), puntenToevoegen);
        db.schrijfTotaalPrijsEnTotaalPtnNaarDatabase(transactienummer, totaalPrijs , totaalPuntenPlus);
        // KLOPT NOG NIET: TOTAALPUNTENPLUS MOET TOTAALPRIJS WORDEN MAAR IS DOUBLE
        VerkopenKlant s = new VerkopenKlant();
                s.setActieveVest(actieveVest);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopRegistreerAankoopActionPerformed

    private void knopVoegToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopVoegToeActionPerformed
        System.out.println(puntenOver);
        Artikel art = db.getArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam());
        
//        double prijs = art.getPrijs();
//        int ptnplus = art.getPtnwinst();
//        int ptnmin = art.getPtnkost();
//        
        int aantal = Integer.parseInt(aantalBepaler.getValue().toString());
        System.out.println(aantal);
        
        Artikelaankoop artAk = new Artikelaankoop();
        artAk.setTransactienrAankoop(transactienummer);
        artAk.setArtikelnr(Integer.parseInt(txtProductToevoegen.getText()));
        artAk.setWinkelNaam(actief.getWinkelnaam());
        artAk.setAantal(aantal);
        System.out.println(artAk.getAantal());
        
//        Artikelaankoop artAk = new Artikelaankoop(transactienummer, Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam(), aantal, false);
        
        if(db.checkArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()))
        {
            if(db.checkArtikelaankoop(transactienummer, Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()))
            {
//                Artikelaankoop a = db.getArtikelaankoop(transactienummer, Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam());
//                int nieuwAantal = a.getAantal() + artAk.getAantal();
//                // deze functie nog eens uitvoeren maar met nieuwAantal ipv aantal
                
                
                JOptionPane.showMessageDialog(null, "Dit artikel is reeds toevoegd, om er meer van te kopen "
                                                + "moet je het artikel eerst verwijderen en daarna opnieuw toevoegen.");
                txtProductToevoegen.setText("");
                txtProductVerwijderen.requestFocus();
                // hier kan iets anders geschreven worden als er nog tijd is.
            }
            else
            {
                if(art.getPtnkost() == -1 || art.getPtnkost() == 0)
                {
                    System.out.println("test 1");
                    if(aantal >= art.getMinimumaantal())
                    {
                        //System.out.println(Integer.toString(aantal));
                        totaalPrijs = totaalPrijs + (art.getPrijs() * aantal);
                        totaalPuntenPlus = totaalPuntenPlus + (art.getPtnwinst() * aantal);
                    }
                    else
                    {
                        System.out.println("wordt deze gebruikt?");
                        //System.out.println(Integer.toString(aantal));
                        totaalPrijs = totaalPrijs + art.getPrijs() * aantal;
                    }
                    artAk.setMetPuntenBetaald(false);
                }
                else
                {
                    System.out.println("test 2");
                    if(puntenOver >= art.getPtnkost()*aantal)
                    {
                        if(art.getMinimumbedrag() > totaalPrijs)
                        {
                            System.out.println("test 3");
                            totaalPuntenMin = totaalPuntenMin + art.getPtnkost() * aantal;
                            puntenOver = puntenOver - art.getPtnkost() * aantal;
                            artikelenMetPunten = artikelenMetPunten + aantal;
                            artAk.setMetPuntenBetaald(true);
                        }
                        else
                        {
                            System.out.println("test 4");
                            totaalPrijs = totaalPrijs + art.getPrijs() * aantal;
                            totaalPuntenPlus = totaalPuntenPlus + art.getPtnwinst() * aantal;
                            artAk.setMetPuntenBetaald(false);
                        }

                    }
                    //System.out.println("dit product kan met punten betaald worden");
                    else
                    {
                        totaalPrijs = totaalPrijs + art.getPtnwinst() * aantal;
                        totaalPuntenPlus = totaalPuntenPlus + art.getPtnwinst() * aantal;
                        artAk.setMetPuntenBetaald(false);
                    }
                }
            db.addArtikelaankoop(artAk);
//            System.out.println(db.getArtikelaankoop(transactienummer, aantal, actief.getWinkelnaam()).getAantal());
            }
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Dit artikel bestaat niet.");
            txtProductToevoegen.setText("");
            txtProductToevoegen.requestFocus();
        }
        
//        totaalPuntenMin = totaalPuntenMin + ptnmin;
//        totaalPuntenPlus = totaalPuntenPlus + ptnplus;
//        totaalPrijs = totaalPrijs + prijs;
        
        weergaveTeGebruikenPunten.setText(Integer.toString(puntenOver));
        totaalBedrag.setText(Double.toString(totaalPrijs));
        puntenVerkregen.setText(Integer.toString(totaalPuntenPlus));
        weergaveAfgetrokkenPunten.setText(Integer.toString(totaalPuntenMin));
        aantalArtikelenPunten.setText(Integer.toString(artikelenMetPunten));
        
        
        t = db.naarTabel("select artikelaankoop.artikelnr, artikel.artikelnaam, artikel.prijs, artikelaankoop.aantal, artikelaankoop.MetPuntenBetaald FROM artikelaankoop\n" +
"INNER JOIN artikel ON artikelaankoop.artikelnr = artikel.artikelnr\n" +
"WHERE transactienr = '" + this.transactienummer + "' and artikel.winkelnaam = '" + actief.getWinkelnaam() + "'");
        //t = db.naarTabel("select * from artikelaankoop where transactienr = " + transactienummer + ";");
        tabelAankopen.setModel(t);
        
        txtProductToevoegen.setText("");
        txtProductToevoegen.requestFocus();
        aantalBepaler.setValue(1);
        
        
    }//GEN-LAST:event_knopVoegToeActionPerformed

    private void knopAnnuleerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopAnnuleerActionPerformed
        db.deleteAankoop(ak);
        
        VerkopenKlant s = new VerkopenKlant(actieveVest);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopAnnuleerActionPerformed

    private void knopVerwijderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopVerwijderActionPerformed
        if(db.checkArtikelaankoop(transactienummer, Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam()))
        {
            Artikelaankoop artAkVerw = db.getArtikelaankoop(transactienummer, Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam());
            System.out.println("Hier lees je het aantal van het verwijderde product:" + artAkVerw.getAantal());
            
            Artikel art = db.getArtikel(Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam());
            
            if(artAkVerw.isMetPuntenBetaald())
            {
                if(art.getMinimumbedrag() < totaalPrijs)
                    {
                        totaalPuntenMin = totaalPuntenMin - art.getPtnkost() * artAkVerw.getAantal();
                        puntenOver = puntenOver + art.getPtnkost() * artAkVerw.getAantal();
                        artikelenMetPunten = artikelenMetPunten - db.getArtikelaankoop(transactienummer, Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam()).getAantal();
                        System.out.println("11");
                    }
                    else
                    {
                        System.out.println("12");
                        totaalPrijs = totaalPrijs - art.getPrijs() * artAkVerw.getAantal();
                        totaalPuntenPlus = totaalPuntenPlus - art.getPtnwinst() * artAkVerw.getAantal();
                    }
            }
            else
            {
                
                if(artAkVerw.getAantal() >= art.getMinimumaantal())
                {
                    totaalPrijs = totaalPrijs - art.getPrijs() * artAkVerw.getAantal();
                    System.out.println(artAkVerw.getAantal());
                    totaalPuntenPlus = totaalPuntenPlus - art.getPtnwinst() * artAkVerw.getAantal();
                }
                else
                {
                    totaalPrijs = totaalPrijs - art.getPrijs() * artAkVerw.getAantal();
                }
            }
        
            db.deleteArtikelaankoop(artAkVerw);
            System.out.println("verwijderd");
            
            

        }  
        else
        {
            JOptionPane.showMessageDialog(null, "Dit artikel hebt u niet gescand.");
            txtProductVerwijderen.setText("");
            txtProductVerwijderen.requestFocus();
        }
        
            weergaveTeGebruikenPunten.setText(Integer.toString(puntenOver));
            totaalBedrag.setText(Double.toString(totaalPrijs));
            puntenVerkregen.setText(Integer.toString(totaalPuntenPlus));
            weergaveAfgetrokkenPunten.setText(Integer.toString(db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten() - puntenOver));
            aantalArtikelenPunten.setText(Integer.toString(artikelenMetPunten));
            System.out.println("getoond");
        
        
        t = db.naarTabel("select artikelaankoop.artikelnr, artikel.artikelnaam, artikel.prijs, artikelaankoop.aantal, artikelaankoop.MetPuntenBetaald FROM artikelaankoop\n" +
"INNER JOIN artikel ON artikelaankoop.artikelnr = artikel.artikelnr\n" +
"WHERE transactienr = '" + this.transactienummer + "' and artikel.winkelnaam = '" + actief.getWinkelnaam() + "'");
            //t = db.naarTabel("select * from artikelaankoop where transactienr = " + transactienummer + ";");
            tabelAankopen.setModel(t);
            
            txtProductVerwijderen.setText("");
            txtProductToevoegen.requestFocus();
        
    }//GEN-LAST:event_knopVerwijderActionPerformed

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
            java.util.logging.Logger.getLogger(VerkopenAfrekening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerkopenAfrekening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerkopenAfrekening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerkopenAfrekening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VerkopenAfrekening().setVisible(true);
                VerkopenAfrekening s = new VerkopenAfrekening();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
            }
        });
    }
    
    public String setPunten(){
        if(db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten() - totaalPuntenMin >= 0)
        {
            return Integer.toString(db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten() - totaalPuntenMin);
        }
        else
            return "fout";
    }
    
    public String setTotaalPrijs(double prijsplus){
        return Double.toString(totaalPrijs + prijsplus);
    }
    
    public String setVerkregenPunten(int ptnplus){
        return Integer.toString(totaalPuntenPlus + ptnplus);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aantalArtikelenPunten;
    private javax.swing.JSpinner aantalBepaler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton knopAnnuleer;
    private javax.swing.JButton knopRegistreerAankoop;
    private javax.swing.JButton knopVerwijder;
    private javax.swing.JButton knopVoegToe;
    private javax.swing.JLabel puntenVerkregen;
    private javax.swing.JTable tabelAankopen;
    private javax.swing.JLabel totaalBedrag;
    private javax.swing.JLabel transactieNummer;
    private javax.swing.JTextField txtProductToevoegen;
    private javax.swing.JTextField txtProductVerwijderen;
    private javax.swing.JLabel weergaveAfgetrokkenPunten;
    private javax.swing.JLabel weergaveTeGebruikenPunten;
    // End of variables declaration//GEN-END:variables

    public Winkel getActief() {
        return actief;
    }

    public void setActief(Winkel actief) {
        this.actief = actief;
    }

    public Vestiging getActieveVest() {
        return actieveVest;
    }

    public void setActieveVest(Vestiging actieveVest) {
        this.actieveVest = actieveVest;
    }

    public Spaarkaart getActieveSpaarkaart() {
        return actieveSpaarkaart;
    }

    public void setActieveSpaarkaart(Spaarkaart actieveSpaarkaart) {
        this.actieveSpaarkaart = actieveSpaarkaart;
    }
}
