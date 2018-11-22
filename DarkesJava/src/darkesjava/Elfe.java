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
public class Elfe extends Aventurier{
    public Elfe(String nom, int pv, int fo, int ad, int in){
        super(nom, pv, fo, ad, in);
    }
    public void soin(Aventurier compagnon){
        if(action(getIntelligence(),10)==1){
            compagnon.modifPV(5);
            System.out.println(compagnon.getNom()+" gagne 5 points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
    public void soinGroupe(Aventurier[] groupe){
        if(action(getIntelligence(),10)==1){
            for(int i=0; i<groupe.length; i++){
                if(groupe[i].pv>0){
                    groupe[i].modifPV(2);
                    System.out.println(groupe[i].getNom()+" gagne 2 points de vie");    
                }  
            }
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
}
