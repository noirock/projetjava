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
    
    public static void rencontre(Aventurier[] groupe, Rencontre rencontre){
        System.out.println(rencontre.intro);
        rencontre.pnj.sePresenter();
        rencontre.pnj.parle(rencontre.defi);
        Scanner aventurier = new Scanner(System.in);
        System.out.println("Quel personnage voullez vous envoyer pour parler à "+rencontre.pnj.getNom()+" ?");
        for (int i=0;i<groupe.length;i++){
            System.out.println("pour "+groupe[i].getNom()+" taper "+ i);
        }
        int c =10;
        int j = 10;
        while (j==10){
            String l = aventurier.nextLine();
            if(l.length()!=0){
                if ((l.charAt(0)<='9')&&(l.charAt(0)>='0')){
                    String d = String.valueOf(l.charAt(0));
                    c = Integer.parseInt(d);
                    if ((c<groupe.length)){j=c;}
                    else{System.out.println("Veuillez choisir un des personnages proposés");}
                }
            else{System.out.println("Veuillez choisir un des personnages proposés");}}   
        }
        Random rand = new Random();
        int n = rand.nextInt(3);
        if (n==c){
            System.out.println("felicitation vous réussisez l'épreuve sans soucis grâce a linventivité de"+groupe[n].getNom()+"vous vous soignez de 3pv sur chacun de vos aventuriers");
        }
        else{
            System.out.println("En essayant une approche "+groupe[c].getNom()+" enerve "+rencontre.pnj.getNom()+" qui vous lance un sort et vous fait perdre 2pv a chacun de vos aventuriers");
        }
        
    }
    
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
        
       Aventurier nain = new Aventurier("Gurdil", 11, 70, 40, 20);
       Aventurier elfe = new Aventurier("Tirael", 8, 40, 70, 50);
       Aventurier mage = new Aventurier("Bandoulf", 7, 20, 30, 70);
       
       Aventurier[] groupe=new Aventurier[3];
       groupe[0]=nain;
       groupe[1]=elfe;
       groupe[2]=mage;
      
   
       Ennemi gobl1 = new Ennemi("Zibli", 5, "2", "Garboulag!");
       Ennemi gobl2 = new Ennemi("Billi", 5, "2", "Garboulug!");
       Ennemi gobl3 = new Ennemi("Guili", 5, "2", "Garboulog!");
       Ennemi[] adv = new Ennemi [3];
       adv[0]=gobl1;
       adv[1]=gobl2;
       adv[2]=gobl3;
       
       Combat fight1 = new Combat();
       fight1.adversaires=adv;
       fight1.combat(groupe);
       
       Personnage sirene = new Personnage("La sirene", 7);
       Rencontre mermaid = new Rencontre("Vous arrivez dans une grotte, vous entendez l'eau couler d'un lac proche et une silhouette se dessine au bord de l'eau", "Bonjour étrangers, que faites-vous en mon domaine?", sirene);
       rencontre(groupe,mermaid);
    
    }
}
