/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

/**
 *
 * @author Justin Duban
 */
public class Evenement {
    String intro;
    public Evenement(String in){
        this.intro=in;
    }
    public static boolean groupeVivant(Personnage[] G){
        for(int i=0; i< G.length; i++){
            if (G[i].getPV()>0){
                return true;
            }
        }
        return false;
    }
    
    public int evenement(Aventurier[] groupe, Integer totalOr){
        return totalOr;
    }
}
