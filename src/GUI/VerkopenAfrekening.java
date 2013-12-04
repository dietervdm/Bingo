
package GUI;

import Database.Database;
import Logica.Aankoop;
import Logica.Artikel;
import Logica.Artikelaankoop;
import Logica.Spaarkaart;
import Logica.Vestiging;
import Logica.Winkel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VerkopenAfrekening extends javax.swing.JFrame {

    private Winkel actief = InlogScherm.getInstance().actief;
    private Vestiging actieveVest;
    private Spaarkaart actieveSpaarkaart;
    
    private Aankoop actieveAankoop;
    private int transactienummer;
        
    
    private double totaalPrijs = 0.0;
    private int totaalPuntenPlus = 0;
    private int totaalPuntenMin = 0;
    private int puntenOver;
    private int artikelenMetPunten = 0;
    
    private Database db = new Database();
    DefaultTableModel t = db.naarTabel("select * from artikelaankoop where winkelnaam = 'sdjqshdgfqskjdygfqskjd'");
    
    public VerkopenAfrekening() {
        initComponents();
        // initialiseren van aantal punten door uit de database te halen.
        puntenOver = db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten();
        //this.transactienummer = db.
    }
    
    
    public VerkopenAfrekening(Spaarkaart sk, Vestiging vest) {
        setActieveSpaarkaart(sk);
        setActieveVest(vest);
        // initialiseren van aantal punten door uit de database te halen.
        puntenOver = db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten();
        //this.transactienummer = db.;
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

        weergaveTeGebruikenPunten.setText(Integer.toString(puntenOver));

        aantalBepaler.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        aantalBepaler.setValue(1);

        knopVerwijder.setText("Verwijder");
        knopVerwijder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopVerwijderActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(txtProductToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(28, 28, 28)
                                .addComponent(aantalBepaler, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totaalBedrag)
                                            .addComponent(puntenVerkregen)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(weergaveTeGebruikenPunten))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductVerwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knopVoegToe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knopVerwijder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(knopAnnuleer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(knopRegistreerAankoop, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(weergaveTeGebruikenPunten))
                        .addGap(111, 111, 111)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(totaalBedrag))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(puntenVerkregen))
                        .addGap(83, 83, 83)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(weergaveAfgetrokkenPunten)
                    .addComponent(jLabel19)
                    .addComponent(aantalArtikelenPunten)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knopAnnuleer)
                    .addComponent(knopRegistreerAankoop))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopRegistreerAankoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopRegistreerAankoopActionPerformed
        VerkopenKlant s = new VerkopenKlant();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopRegistreerAankoopActionPerformed

    private void knopVoegToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopVoegToeActionPerformed
        Artikel art = db.getArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam());
//        double prijs = art.getPrijs();
//        int ptnplus = art.getPtnwinst();
//        int ptnmin = art.getPtnkost();
//        
        int aantal = Integer.parseInt(aantalBepaler.getValue().toString());
//        
//        if(aantal >= art.getMinimumaantal())
//        {
//            if(puntenOver > (db.getArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()).getPtnkost() * aantal) && db.getArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()).getPtnkost()!= -1)
//            {
//                int puntenKost = (db.getArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()).getPtnkost() * aantal);
//                puntenOver = puntenOver - puntenKost;
//                totaalPuntenMin = totaalPuntenMin + puntenKost;
//                weergaveTeGebruikenPunten.setText(Integer.toString(puntenOver));
//                weergaveAfgetrokkenPunten.setText(Integer.toString(totaalPuntenMin));
//            }
//            else
//            {
//                
//            }
//        }
//        else
//        {
//            double kost = ((db.getArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()).getPrijs()) * aantal);
//            totaalPrijs = totaalPrijs + kost;
//            totaalBedrag.setText(Double.toString(totaalPrijs));
//        }
        
        Artikelaankoop artAk = new Artikelaankoop();
        artAk.setTransactienrAaankoop(this.transactienummer);
        artAk.setArtikelnr(Integer.parseInt(txtProductToevoegen.getText()));
        artAk.setWinkelNaam(actief.getWinkelnaam());
        artAk.setAantal(aantal);
        
        if(db.checkArtikel(Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelnaam()))
        {
            if(art.getPtnkost() == -1 || art.getPtnkost() == null)
            {
                if(aantal >= art.getMinimumaantal())
                {
                    //System.out.println(Integer.toString(aantal));
                    totaalPrijs = totaalPrijs + (art.getPrijs() * aantal);
                    totaalPuntenPlus = totaalPuntenPlus + (art.getPtnwinst() * aantal);
                }
                else
                {
                    //System.out.println(Integer.toString(aantal));
                    totaalPrijs = totaalPrijs + art.getPrijs();
                }
                artAk.setMetPuntenBetaald(false);
            }
            else
            {
                if(puntenOver >= art.getPtnkost()*aantal)
                {
                    totaalPuntenMin = totaalPuntenMin + art.getPtnkost() * aantal;
                    puntenOver = puntenOver - art.getPtnkost() * aantal;
                    artAk.setMetPuntenBetaald(true);
                    artikelenMetPunten = artikelenMetPunten + aantal;
                }
                //System.out.println("dit product kan met punten betaald worden");
                else
                {
                    totaalPrijs = totaalPrijs + art.getPtnwinst() * aantal;
                    totaalPuntenPlus = totaalPuntenPlus + art.getPtnwinst();
                    artAk.setMetPuntenBetaald(false);
                }
            }
        }
        // db.addArtikelaankoop(this.transactienummer, Integer.parseInt(txtProductToevoegen.getText()), actief.getWinkelNaam(), aantal, metPuntenBetaald;
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
        weergaveAfgetrokkenPunten.setText(Integer.toString(db.getAccount(actieveSpaarkaart.getAccountnr()).getPunten() - puntenOver));
        aantalArtikelenPunten.setText(Integer.toString(artikelenMetPunten));
        
        
        t = db.naarTabel("select * from artikelaankoop where transactienr = '" + this.transactienummer + "'");
        tabelAankopen.setModel(t);
        
        
    }//GEN-LAST:event_knopVoegToeActionPerformed

    private void knopAnnuleerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopAnnuleerActionPerformed
        VerkopenKlant s = new VerkopenKlant();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_knopAnnuleerActionPerformed

    private void knopVerwijderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopVerwijderActionPerformed
//        if(db.checkArtikelaankoop(transactienummer, Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam()))
//        {
//            Artikelaankoop artAk = db.getArtikelaankoop(transactienummer, Integer.parseInt(txtProductVerwijderen.getText()), actief.getWinkelnaam());
//            db.deleteArtikelaankoop(artAk);
//        
//            t = db.naarTabel("select * from artikelaankoop where transactienr = '" + this.transactienummer + "'");
//            tabelAankopen.setModel(t);
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(null, "Dit artikel hebt u niet gescand.");
//            txtProductVerwijderen.setText("");
//            txtProductVerwijderen.requestFocus();
//        }
        
        
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
