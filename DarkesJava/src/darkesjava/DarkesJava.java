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
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       Partie test = new Partie(); 
       test.lancerPartie();
      
   
       Ennemi gobl1 = new Ennemi("Zibli", 5, 2, 40, "Garboulag!");
       Ennemi gobl2 = new Ennemi("Billi", 5, 2, 40, "Garboulug!");
       Ennemi gobl3 = new Ennemi("Guili", 5, 2, 40, "Garboulog!");
       Ennemi troll1 = new Ennemi("bazoul",15,4,20, "bougabouh");
       Ennemi troll2 = new Ennemi("bazeyl",15,4,20, "bougabouh");
       Ennemi troll3 = new Ennemi("bazort",15,4,20, "bougabouh");
       
       Ennemi[] liste = new Ennemi[6];
       liste[0]=gobl1;
       liste[1]=gobl2;
       liste[2]=gobl3;
       liste[3]=troll1;
       liste[4]=troll2;
       liste[5]=troll3;
       
       
       Combat fight1 = new Combat("Le combat se déclenche contre ","Le combat se déclenche contre ",liste);
       fight1.combat(test.groupe);
       
       Personnage sirene = new Personnage("La sirene", 7);
       Rencontre mermaid = new Rencontre("la sirène","Vous arrivez dans une grotte, vous entendez l'eau couler d'un lac proche et une silhouette se dessine au bord de l'eau", "Bonjour étrangers, que faites-vous en mon domaine?", sirene);
       mermaid.rencontre(test.groupe,mermaid);
    
       
       Epreuve epr = new Epreuve("Vous arrivez dans une salle et devant vous se trouve un coffre","Le coffre",1,"I am a trial");
       epr.epreuve(test.groupe);
       
    }
}
