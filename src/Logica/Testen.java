/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Database.Database;

/**
 *
 * @author djvdrmee
 */
public class Testen {
    private static Database db = new Database();

    public static void main(String[] args) {
        Account acc = db.getAccount(4);
        double test = 10000000.0;
        System.out.println(test);
        System.out.println(acc.totaalPuntenJaar(1));
        System.out.println(acc.totaalGeldJaar(1));
        System.out.println(db.getAantalVerschillendeWinkels(acc));
    }
}
