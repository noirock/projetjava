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
    int resistance;
    
    
    public Aventurier(String nom, int pv, int fo, int ad, int in){
        super(nom, pv);
        this.force=fo;
        this.adresse=ad;
        this.intelligence=in;
        this.pvmax=pv;
        this.provocation=0;
        this.resistance=0;
    }
    
    public void mort(){
        changeAdresse(-getAdresse());
        changeForce(-getForce());
        changeIntelligence(-getIntelligence());
        modifPV(-getPV());
        modifPVmax(-getPVmax());
        System.out.println(getNom()+" n'était pas assez fort, sa mort était inévitable");
        resistance=0;
        provocation=0;
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
        force = force + a;
    }
    public void changeIntelligence(int a){
        intelligence = intelligence + a;
    }
    public int getPVmax(){
        return pvmax;
    }
    public void modifPVmax(int p){
        pvmax=p;
    }
    String sort1;
    public void sort1(Aventurier[] a, Ennemi[] e){}
    String sort2;
    public void sort2(Aventurier[] a, Ennemi[] e){}
    Integer cd1=0;
    Integer cd2=0;
    public void cd1D(){
        cd1=cd1-1;
        if (cd1<0){
            cd1=0;
        }
    }
    public void cd2D(){
        cd2=cd2-1;
        if (cd2<0){
            cd2=0;
        }
    }
    public void resetcD(){
        cd1=0;
        cd2=0;
    }
    public void fintour(){
        provocation=provocation-1;
        resistance=resistance-1;
        if (provocation<0){
            provocation=0;
        }
        if (resistance<0){
            resistance=0;
        }
    }

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
        if(action(adresse, 10)==1){ 
            mechant[j].modifPV(-force/10);
            System.out.println(mechant[j].getCri());
            System.out.println(mechant[j].getNom() + " perds " +(force/10)+"PV");
        }
        else {
            System.out.println(mechant[j].getNom() + " esquive!");
        }
    }
}
