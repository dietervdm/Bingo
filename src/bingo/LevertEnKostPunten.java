/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author djvdrmee
 */
public class LevertEnKostPunten 
{
    protected int levertAantalPuntenOp;
    protected int kostAantalPunten;
    
    public LevertEnKostPunten(){
        
    }
    
    public LevertEnKostPunten(int levertPuntenOp, int kostPunten){
        this.levertAantalPuntenOp = levertPuntenOp;
        this.kostAantalPunten = kostPunten;
    }
}
