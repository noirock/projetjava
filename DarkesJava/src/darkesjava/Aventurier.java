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
public class Aventurier extends Personnage {
    
    private int force;
    private int adresse;
    private int intelligence;
    protected int pvmax;
    int provocation;
    
    public Aventurier(String nom, int pv, int fo, int ad, int in){
        super(nom, pv);
        this.force=fo;
        this.adresse=ad;
        this.intelligence=in;
        this.pvmax=pv;
        this.provocation=0;
    }
    
    
    public int action(int stat, float bonus){
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        if (stat+bonus<n){//echec
            return 0;
        }
        return 1; //succès
    }
    public int getForce(){
        return force;
    }
    public int getAdresse(){
        return adresse;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public void changeAdresse(int a){
        adresse = adresse + a;
    }
    public void changeForce(int a){
        adresse = adresse + a;
    }
    public void changeIntelligence(int a){
        adresse = adresse + a;
    }
    public int getPVmax(){
        return pvmax;
    }
    public void modifPVmax(int p){
        pvmax=p;
    }
    String sort1;
    public void sort1(){}
    String sort2;
    public void sort2(){}
    Integer cd1;
    Integer cd2;

    public void coup(Ennemi[] mechant){
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
        if(action(adresse, 20)==1){ 
            mechant[j].modifPV(-force/10);
            System.out.println(mechant[j].getCri());
            System.out.println(mechant[j].getNom() + " perds " +(force/10)+"PV");
        }
        else {
            System.out.println(mechant[j].getNom() + " esquive!");
        }
    }
}
