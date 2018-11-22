/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author louis
 */
public class DarkesJava {

    /**
     * @param args the command line arguments
     */
    
    
    public static boolean groupeVivant(Personnage[] G){
        for(int i=0; i< G.length; i++){
            if (G[i].getPV()>0){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       Aventurier nain = new Aventurier("Gurdil", 11, 70, 40, 50);
       Aventurier elfe = new Aventurier("Tirael", 8, 50, 70, 40);
       Aventurier mage = new Aventurier("Bandoulf", 7, 40, 50, 70);
       
       Aventurier[] groupe=new Aventurier[3];
       groupe[0]=nain;
       groupe[1]=elfe;
       groupe[2]=mage;
      
   
       Ennemi gobl1 = new Ennemi("Zibli", 7, "2", "Garboulag!");
       Ennemi gobl2 = new Ennemi("Billi", 7, "2", "Garboulug!");
       Ennemi gobl3 = new Ennemi("Guili", 7, "2", "Garboulog!");
       Ennemi[] adv = new Ennemi [3];
       adv[0]=gobl1;
       adv[1]=gobl2;
       adv[2]=gobl3;
       
       Combat fight1 = new Combat();
       fight1.adversaires=adv;
       fight1.combat(groupe);
       
       Personnage sirene = new Personnage("La sirene", 7);
       Rencontre mermaid = new Rencontre("Vous arrivez dans une grotte, vous entendez l'eau couler d'un lac proche et une silhouette se dessine au bord de l'eau", "Bonjour étrangers, que faites-vous en mon domaine?", sirene);
       mermaid.rencontre(groupe,mermaid);
    
       
       Epreuve epr = new Epreuve("Vous arrivez dans une salle et devant vous se trouve un coffre","Le coffre",1);
       epr.epreuve(groupe);
       
    }
}
