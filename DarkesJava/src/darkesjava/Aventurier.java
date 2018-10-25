/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkestjava;

import java.util.Random;

/**
 *
 * @author Justin Duban
 */
public class Aventurier extends Personnage {
    
    private int force;
    private int adresse;
    private int intelligence;
    private int or;
    
    public Aventurier(String nom, float pv, int fo, int ad, int in){
        super(nom, pv);
        this.force=fo;
        this.adresse=ad;
        this.intelligence=in;
    }
    
    
    public int action(int stat, float difficulté){
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        if (stat+difficulté<n){//echec
            return 1;
        }
        return 2; //succès
    }
    
}
