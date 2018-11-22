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
public class Elfe extends Aventurier{
    public Elfe(String nom, int pv, int fo, int ad, int in){
        super(nom, pv, fo, ad, in);
        sort1 = " Soin concentré ";
        sort2 = " Soin de masse ";
        cd1=0;
        cd2=0;
    }
    String sort1 = " Soin ";
    public void sort1(Aventurier[] groupe, Ennemi[] mechant){
        Scanner choix = new Scanner(System.in);
        System.out.println("Cible de "+getNom()+" :");
        for(int i=0; i<groupe.length; i++){
            if (groupe[i].getPV()>0){
                System.out.println(groupe[i].getNom() + " " + groupe[i].getPV() + "pv : " + i);
            }
        }
        int j = 10;
        while (j==10){
            String l = choix.nextLine();
            if(l.length()!=0){
                if ((l.charAt(0)<='9')&&(l.charAt(0)>='0')){
                    String d = String.valueOf(l.charAt(0));
                    int c = Integer.parseInt(d);
                    if ((c<mechant.length)&&(groupe[c].getPV()>0)){j=c;}
                    else{System.out.println("Veuillez choisir une des cibles proposées");}
                }
            else{System.out.println("Veuillez choisir une des cibles proposées");}}   
        }
        if(action(getIntelligence(),10)==1){
            groupe[j].modifPV(getIntelligence()/7);
            System.out.println(groupe[j].getNom()+" gagne 5"+getIntelligence()/7+" points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
    }
    String sort2 = " Soin de groupe ";
    public void sort2(Aventurier[] groupe, Ennemi[] e){
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
