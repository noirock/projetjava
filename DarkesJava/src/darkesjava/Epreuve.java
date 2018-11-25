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
public class Epreuve extends Evenement{
    String description;
    Integer type;
    
    
    Epreuve(String in,String de,Integer ty){
        super(in);
        this.description=de;
        this.type= ty;
    }
    
    
    public void epreuve(Aventurier[] groupe){
        System.out.println();
        System.out.println(intro);
        Scanner aventurier = new Scanner(System.in);
        System.out.println("Quel personnage voulez vous envoyer pour "+description +"?");
        for (int i=0;i<groupe.length;i++){
            if(groupe[i].getPV()>0){
                System.out.println("pour "+groupe[i].getNom()+" taper "+ i);
            }
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
                System.out.println("Félicitations, grâce à la force de "+groupe[c].getNom()+", vous réussissez à ouvrir "+description+ ", il obtient un bonus d'intelligence.");
                groupe[c].changeIntelligence(5);
                System.out.println(groupe[c].getNom()+" est maintenant à"+groupe[c].getIntelligence()+" d'intelligence.");
            }
            else if(groupe[c].getForce()>=n-20){
                System.out.println("Zut! "+groupe[c].getNom()+" abime "+description+ ", n'étant pas assez fort vous passez votre chemin. ");
            }
            else{
                System.out.println("Coup dur "+groupe[c].getNom()+" donne un coup dans "+description+ " mais son manque de force lui octroie une écharde dans le doigt, il perd 2 PV.");
                groupe[c].modifPV(-2);
                System.out.println(groupe[c].getNom()+" est maintenant à"+groupe[c].getPV()+" PV");
                if (groupe[c].getPV()<=0){
                    groupe[c].mort();
                }
            }
        }
        else if (type==1){
            if(groupe[c].getIntelligence()>=n){
                System.out.println("Félicitations, grâce à l'intelligence de "+groupe[c].getNom()+", vous réussissez à ouvrir "+description+ ", il obtient un bonus d'adresse.");
                groupe[c].changeAdresse(5);
                System.out.println(groupe[c].getNom()+" est maintenant à "+groupe[c].getAdresse()+" d'adresse.");
            }
            else if(groupe[c].getIntelligence()>=n-20){
                System.out.println("Après un court essai "+groupe[c].getNom()+" abime "+description+ " par manque d'intelligence, vous passez donc votre chemin. ");
            }
            else{
                System.out.println("Coup dur! "+groupe[c].getNom()+" s'énerve face à "+description+ ", n'étant pas suffisamment intelligent pour résoudre ce problème il se tape la tête et perd 2 PV.");
                groupe[c].modifPV(-2);
                System.out.println(groupe[c].getNom()+" est maintenant à "+groupe[c].getPV()+" PV");
                if (groupe[c].getPV()<=0){
                    groupe[c].mort();
                }
            }
            
        }
        else{
            if(groupe[c].getAdresse()>=n){
                System.out.println("Félicitations, grâce à l'adresse de "+groupe[c].getNom()+", vous réussissez à ouvrir "+description+ ", il obtient un bonus de force.");
                groupe[c].changeForce(5);
                System.out.println(groupe[c].getNom()+" est maintenant à "+groupe[c].getForce()+" de force.");
            }
        else if(groupe[c].getAdresse()>=n-20){
                System.out.println("Après un court essai, la main de "+groupe[c].getNom()+" glisse et "+description+ " explose, vous n'en tirerez rien, vous passez donc votre chemin. ");
            }
            else{
                System.out.println("Coup dur! "+groupe[c].getNom()+" trébuche en allant vers "+description+ " et s'assomme en tombant, par son manque d'adresse il perd 2 PV.");
                groupe[c].modifPV(-2);
                System.out.println(groupe[c].getNom()+" est maintenant à "+groupe[c].getPV()+" PV.");
                if (groupe[c].getPV()<=0){
                    groupe[c].mort();
                }
            }
        }
    }
}
