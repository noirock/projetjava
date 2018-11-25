
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
public class Combat extends Evenement{
    Ennemi[] liste;
    public Combat(String in, Ennemi[] adv){
        super(in);
        this.liste=adv;
    }
        public static boolean groupeVivant(Personnage[] G){
        for(int i=0; i< G.length; i++){
            if (G[i].getPV()>0){
                return true;
            }
        }
        return false;
    }
    public void evenement(Aventurier[] groupe){
        
       Random adversaire = new Random();
       Ennemi[] adversaires = new Ennemi [3];
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
                   adversaires[i]=liste[k];
                   verif[i]=k;
                   j=1;
               }
           }  
       }
        Scanner choi = new Scanner(System.in);
        
        for (int i=0;i<groupe.length;i++){
            System.out.println(groupe[i].getNom()+" est actuellement à "+groupe[i].getPV()+" PV,  ");
            groupe[i].resetcD();            
        }
        System.out.println();
        System.out.println(intro);
        for (int i=0;i<groupe.length;i++){
            System.out.print(adversaires[i].getNom()+", actuellement à "+adversaires[i].getPV()+" PV,  ");
        }
        System.out.println();
        int v =0;
        while(v==0){
            for(int i=0; i<groupe.length;i++){
                if (v==0){
                    if(groupe[i].getPV()>0){
                        int k=0;
                        while (k==0){
                            System.out.println("Choisir une action pour "+groupe[i].getNom()+" : Attaque physique (a),"+groupe[i].sort1+" (utilisable dans "+groupe[i].cd1+" tours)(b),"+groupe[i].sort2+"(utilisable dans "+groupe[i].cd2+" tours)(c)");
                            char c='e';
                            do {String s = choi.nextLine();
                                if(s.length()!=0){
                                    c=s.charAt(0);
                                }
                                    }while((c!='a')&&(c!='b')&&(c!='c'));
                            if (c=='a'){
                                groupe[i].coup(adversaires);
                                groupe[i].cd1D();
                                groupe[i].cd2D();
                                k=1;
                                groupe[i].fintour();
                            }
                            else if (c=='b' && groupe[i].cd1<=0){
                                groupe[i].sort1(groupe, adversaires);
                                groupe[i].cd2D();
                                k=1;
                                groupe[i].fintour();
                            }
                            else if (c=='c' && groupe[i].cd2<=0){
                                groupe[i].sort2(groupe, adversaires);
                                groupe[i].cd1D();
                                k=1;
                                groupe[i].fintour();
                            }
                            if (groupeVivant(adversaires)==false){
                                v=1;
                                i=groupe.length;
                                System.out.println("Victoire!!!");
                            }
                            if (k==0){
                                System.out.println("Ce sort est en recharge, il ne peut pas encore être lancer, utilisez une autre compétence");
                            }
                        }
                    }
                }
            }
            
            for(int i=0; i<adversaires.length;i++){
                if (v==0){
                    if(adversaires[i].getPV()>0){
                        adversaires[i].attaque(groupe);
                        if(groupeVivant(groupe)==false){
                            v=1;
                            i=adversaires.length;
                            System.out.println("Défaite...");
                        }
                    }
                }
            }
        }
    }
}
