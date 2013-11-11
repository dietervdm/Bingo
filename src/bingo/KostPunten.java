/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author djvdrmee
 */
public class KostPunten extends Artikel
{
    protected int kostAantalPunten;
    
    public KostPunten(){
        
    }
    
    public KostPunten(int kostPunten){
        this.kostAantalPunten = kostPunten;
    }
}
