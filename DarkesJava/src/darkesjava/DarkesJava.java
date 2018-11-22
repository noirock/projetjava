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
        
       Nain Gurdil = new Nain("Gurdil", 13, 70, 40, 50);
       Nain Gunther = new Nain("Gunter", 14, 60, 50, 50);
       Elfe Tirael = new Elfe("Tirael", 10, 50, 70, 40);
       Elfe Touniel = new Elfe("Touniel",9, 40, 70, 50);
       Mage Bandoulf = new Mage("Bandoulf", 7, 40, 50, 70);
       Mage Bordur = new Mage("Bordur", 8, 55, 55, 55);
       
       Nain[] G= new Nain[2];
       Elfe[] T= new Elfe[2];
       Mage[] B= new Mage[2];
       G[0]=Gurdil;
       G[1]=Gunther;
       T[0]=Tirael;
       T[1]=Touniel;
       B[0]=Bandoulf;
       B[1]=Bordur;
       
       Aventurier[] groupe=new Aventurier[3];
       Random aventurier = new Random();
       groupe[0]=G[aventurier.nextInt(2)];
       groupe[1]=T[aventurier.nextInt(2)];
       groupe[2]=B[aventurier.nextInt(2)];
      
   
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
       
       Random adversaire = new Random();
       Ennemi[] adv = new Ennemi [3];
       Integer[] verif=new Integer[3];
       verif[0]=100;
       verif[1]=100;
       int j =0;
       for (int i=0;i<3;i++){
           j=0;
           while (j==0){
               
               int k=adversaire.nextInt(liste.length);
               if (k==verif[0]){
                   j=0;
               }
               else if (k== verif[1]){
                   j=0;
               }
               else{
                   adv[i]=liste[k];
                   verif[i]=k;
                   j=1;
               }
           }  
       }
       Combat fight1 = new Combat("Le combat se déclenche contre ","Le combat se déclenche contre ",adv);
       fight1.combat(groupe);
       
       Personnage sirene = new Personnage("La sirene", 7);
       Rencontre mermaid = new Rencontre("Vous arrivez dans une grotte, vous entendez l'eau couler d'un lac proche et une silhouette se dessine au bord de l'eau", "Bonjour étrangers, que faites-vous en mon domaine?", sirene);
       mermaid.rencontre(groupe,mermaid);
    
       
       Epreuve epr = new Epreuve("Vous arrivez dans une salle et devant vous se trouve un coffre","Le coffre",1,"I am  trial");
       epr.epreuve(groupe);
       
    }
}
