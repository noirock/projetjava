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
        sort1 = " Soin concentré ";
        sort2 = " Soin de masse ";
        cd1=0;
        cd2=0;
    }
    String sort1 = " Soin ";
    public void sort1(Aventurier compagnon){
        if(action(getIntelligence(),10)==1){
            compagnon.modifPV(getIntelligence()/7);
            System.out.println(compagnon.getNom()+" gagne 5"+getIntelligence()/7+" points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
    String sort2 = " Soin de groupe ";
    public void sort2(Aventurier[] groupe){
        if(action(getIntelligence(),10)==1){
            for(int i=0; i<groupe.length; i++){
                if(groupe[i].pv>0){
                    groupe[i].modifPV(getIntelligence()/20);
                    System.out.println(groupe[i].getNom()+" gagne "+getIntelligence()/20+" points de vie");    
                }  
            }
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
}
