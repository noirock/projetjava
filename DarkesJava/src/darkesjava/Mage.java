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
        sort1 = " Boule de feu ";
        sort2 = " Choc de flamme ";
        cd1=0;
        cd2=0;
    }
    String sort1 = " Boule de feu ";
    public void sort1(Ennemi adversaire){
        if(action(getIntelligence(),10)==1){
            adversaire.modifPV(getIntelligence()/7);
            System.out.println(adversaire.getCri());
            System.out.println(adversaire.getNom()+" perd "+getIntelligence()/7+" points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
    String sort2 = " Choc de flamme ";
    public void sort2(Ennemi[] groupe){
        if(action(getIntelligence(),10)==1){
            for(int i=0; i<groupe.length; i++){
                if(groupe[i].pv>0){
                    groupe[i].modifPV(getIntelligence()/20);
                    System.out.println(groupe[i].getCri());
                    System.out.println(groupe[i].getNom()+" perd "+getIntelligence()/20+" points de vie");    
                }  
            }
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
}

