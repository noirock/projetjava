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
public class Rencontre extends Evenement{
    String defi;
    Personnage pnj;
    Rencontre(String in, String de, Personnage r){
        super(in);
        this.defi=de;
        this.pnj=r;
    }
        public void rencontre(Aventurier[] groupe, Rencontre rencontre){
        System.out.println(intro);
        rencontre.pnj.sePresenter();
        rencontre.pnj.parle(rencontre.defi);
        Scanner aventurier = new Scanner(System.in);
        System.out.println("Quel personnage voulez vous envoyer parler à "+rencontre.pnj.getNom()+" ?");
        for (int i=0;i<groupe.length;i++){
            if(groupe[i].getPV()>0){
                System.out.println("pour "+groupe[i].getNom()+" taper "+ i);
            }
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
            System.out.println("Félicitations, vous réussissez l'épreuve sans soucis grâce à l'inventivité de "+groupe[n].getNom()+", "+ rencontre.pnj.getNom()+" vous accorde un enchantement de 3pv sur chacun de vos aventuriers");
            for (int i=0;i<groupe.length;i++){
                if (groupe[i].getPV()>0){
                    groupe[i].modifPV(3);
                }
            }
        }
        else{
            System.out.println("En essayant une approche "+groupe[c].getNom()+" brutale "+rencontre.pnj.getNom()+" qui vous lance un sort et vous fait perdre 1pv à chacun de vos aventuriers");
            for (int i=0;i<groupe.length;i++){
                if (groupe[i].getPV()>0){
                    groupe[i].modifPV(-1);
                    System.out.println(groupe[i].getNom()+" est maintenant à "+groupe[i].getPV()+" PV");
                    if (groupe[i].getPV()<=0){
                        groupe[i].mort();
                    }
                }
            }
        }
    }
}
