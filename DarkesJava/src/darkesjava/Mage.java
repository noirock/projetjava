/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

import java.util.Scanner;

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

    public void sort1(Aventurier[] a,Ennemi[] mechant){
        Scanner choix = new Scanner(System.in);
        System.out.println("Cible de "+getNom()+" :");
        for(int i=0; i<mechant.length; i++){
            if (mechant[i].getPV()>0){
                System.out.println(mechant[i].getNom() + " " + mechant[i].getPV() + "pv : " + i);
            }
        }
        int j = 10;
        while (j==10){
            String l = choix.nextLine();
            if(l.length()!=0){
                if ((l.charAt(0)<='9')&&(l.charAt(0)>='0')){
                    String d = String.valueOf(l.charAt(0));
                    int c = Integer.parseInt(d);
                    if ((c<mechant.length)&&(mechant[c].getPV()>0)){j=c;}
                    else{System.out.println("Veuillez choisir une des cibles proposées");}
                }
            else{System.out.println("Veuillez choisir une des cibles proposées");}}   
        }
        if(action(getIntelligence(),10)==1){
            mechant[j].modifPV(-getIntelligence()/7);
            System.out.println(mechant[j].getCri());
            System.out.println(mechant[j].getNom()+" perd "+getIntelligence()/7+" points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
    public void sort2(Aventurier[] a,Ennemi[] mechant){
        if(action(getIntelligence(),10)==1){
            for(int i=0; i<mechant.length; i++){
                if(mechant[i].pv>0){
                    mechant[i].modifPV(-getIntelligence()/20);
                    System.out.println(mechant[i].getCri());
                    System.out.println(mechant[i].getNom()+" perd "+getIntelligence()/20+" points de vie");    
                }  
            }
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
}

