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
public class Mage extends Aventurier{
    public Mage(String nom, int pv, int fo, int ad, int in){
        super(nom, pv, fo, ad, in);
    }
    public void bouleDeFeu(Ennemi adversaire){
        if(action(getIntelligence(),10)==1){
            adversaire.modifPV(-5);
            System.out.println(adversaire.getCri());
            System.out.println(adversaire.getNom()+" perd 5 points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
    public void tourbillon(Ennemi[] groupe){
        if(action(getIntelligence(),10)==1){
            for(int i=0; i<groupe.length; i++){
                if(groupe[i].pv>0){
                    groupe[i].modifPV(-2);
                    System.out.println(groupe[i].getCri());
                    System.out.println(groupe[i].getNom()+" perd 2 points de vie");    
                }  
            }
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
}

