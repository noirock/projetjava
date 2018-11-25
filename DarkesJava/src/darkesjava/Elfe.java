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
/*méthode permettant au Mage de soigner 1 allier en cas de réussite*/
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
            if (groupe[j].getPV()>groupe[j].getPVmax()){
                groupe[j].modifPV(groupe[j].getPVmax()-groupe[j].getPV());
            }
            System.out.println(groupe[j].getNom()+" est maintenant à "+groupe[j].getPV()+" points de vie");
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
        cd1=4;
    }
/*méthode permettant au Mage de soigner tous les alliers en cas de réussite*/
    public void sort2(Aventurier[] groupe, Ennemi[] e){
        if(action(getIntelligence(),10)==1){
            for(int i=0; i<groupe.length; i++){
                if(groupe[i].pv>0){
                    groupe[i].modifPV(getIntelligence()/20);
                    if (groupe[i].getPV()>groupe[i].getPVmax()){
                        groupe[i].modifPV(groupe[i].getPVmax()-groupe[i].getPV());
                    }
                    System.out.println(groupe[i].getNom()+" est maintenant à "+groupe[i].getPV()+" points de vie");    
                }  
            }
        }
        else{
            System.out.println(getNom()+" rate son sort");
        }
        cd1=5;
    }
}
