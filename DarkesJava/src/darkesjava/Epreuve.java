/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;


import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Justin Duban
 */
public class Epreuve {
    String titre;
    String intro;
    String description;
    Integer type;
    
    
    Epreuve(String in,String de,Integer ty){
        this.intro=in;
        this.description=de;
        this.type= ty;
    }
    
    
    public void epreuve(Aventurier[] groupe){
        System.out.println(intro);
        Scanner aventurier = new Scanner(System.in);
        System.out.println("Quel personnage voullez vous envoyer pour fouiller "+description +"?");
        for (int i=0;i<groupe.length;i++){
            System.out.println("pour "+groupe[i].getNom()+" taper "+ i);
        }
        int j =10;
        int c = 10;
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
         int n=rand.nextInt(30)+51;
        if(type==0){
            if(groupe[c].getForce()>= n){
                System.out.println("felicitation grâce à la force de "+groupe[c].getNom()+"vous réussissez à ouvrir "+description+ " il obtient un bonus d'intelligence");
                groupe[c].changeIntelligence(5);
            }
            else if(groupe[c].getForce()>=n-20){
                System.out.println("zut "+groupe[c].getNom()+" abime "+description+ " n'étant pas assez fort vous passez votre chemin ");
            }
            else{
                System.out.println("Coup dur "+groupe[c].getNom()+" donne un coup dans "+description+ " mais son manque de force résulte à une écharde dans le doigt, il perd 2 pv");
                groupe[c].modifPV(-2);
            }
        }
        else if (type==1){
            if(groupe[c].getIntelligence()>=n){
                System.out.println("felicitation grâce à l'intelligence de "+groupe[c].getNom()+"vous réussissez à ouvrir "+description+ " il obtient un bonus d'adresse");
                groupe[c].changeAdresse(5);
            }
            else if(groupe[c].getIntelligence()>=n-20){
                System.out.println("Après un court essaie "+groupe[c].getNom()+" abime "+description+ " par manque d'intelligence, vous passez donc votre chemin ");
            }
            else{
                System.out.println("Coup dur "+groupe[c].getNom()+" s'enerve face à "+description+ " n'étant pas suffisement intelligent pour résoudre ce problème il se tape la tête et perd 2 pv");
                groupe[c].modifPV(-2);
            }
            
        }
        else{
            if(groupe[c].getAdresse()>=n){
                System.out.println("felicitation grâce à l'adresse de "+groupe[c].getNom()+"vous réussissez à ouvrir "+description+ " il obtient un bonus de force");
                groupe[c].changeForce(5);
            }
        else if(groupe[c].getAdresse()>=n-20){
                System.out.println("Après un court essaie la main de "+groupe[c].getNom()+" glisse et "+description+ " s'éxplose, vous n'en tirerez rien, vous passez donc votre chemin ");
            }
            else{
                System.out.println("Coup dur "+groupe[c].getNom()+" trébuche en allant vers "+description+ " et s'assome en tombant par son manque d'adresse il perd 2 pv");
                groupe[c].modifPV(-2);
            }
        }
    }
}
