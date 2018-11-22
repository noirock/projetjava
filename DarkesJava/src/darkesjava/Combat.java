
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

import static darkesjava.DarkesJava.groupeVivant;

/**
 *
 * @author Justin Duban
 */
public class Combat extends Evenement{
    String titre;
    String intro;
    Ennemi[] adversaires;
    public void Combat(String titr, String in, Ennemi[] advs){
        this.titre=titr; 
        this.intro=in;
        this.adversaires=advs;
    }
    public void combat(Aventurier[] groupe){
        System.out.println("Début du combat!!!");
        int v =0;
        while(v==0){
            for(int i=0; i<groupe.length;i++){
                if (v==0){
                    if(groupe[i].getPV()>0){
                        groupe[i].coup(adversaires);
                        if (groupeVivant(adversaires)==false){
                            v=1;
                            i=groupe.length;
                            System.out.println("Victoire!!!");
                        }
                    }
                }
            }
            for(int i=0; i<adversaires.length;i++){
                if (v==0){
                    if(adversaires[i].getPV()>0){
                        adversaires[i].attaque(groupe);
                        if(groupeVivant(groupe)==false){
                            v=1;
                            i=adversaires.length;
                            System.out.println("Défaite...");
                        }
                    }
                }
            }
        }
    }
}
