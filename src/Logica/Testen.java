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
        Account acc = db.getAccount(55);
        
        System.out.println(acc.totaalPuntenJaar(55));
        System.out.println(acc.totaalGeldJaar(55));
        System.out.println(db.getAantalVerschillendeWinkels(acc));
    }
}
