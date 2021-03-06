/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

/**
 *
 * @author Justin Duban
 */
public class Nain extends Aventurier{
    public Nain(String nom, int pv, int fo, int ad, int in){
        super(nom, pv, fo, ad, in);
        resistance=0;
        provocation=0;
        sort1 = " Resistance ";
        sort2 = " Provocation ";
        cd1=0;
        cd2=0;
    }
    /*méthode qui permet au nain de gagner en resistance pour 3tours*/
    public void sort1(Aventurier[] groupe, Ennemi[] mechant){
        if(action(getIntelligence(),20)==1){
            resistance=4;
            System.out.println(getNom()+" gagne en résistance!");
        }
        else{
            System.out.println(getNom()+" rate son sort...");
        }
        cd1=5;
    }
    /*méthode qui permet au nain de gagner la provocation pour 3tours */
    public void sort2(Aventurier[] groupe, Ennemi[] mechant){
        if(action(getIntelligence(),30)==1){
            provocation=4;
            System.out.println(getNom()+" provoque les ennemis pour qu'ils l'attaquent et oublient ses alliés!");
        }
        else{
            System.out.println(getNom()+" rate son sort...");
        }
        cd2=4;
    }
    public void modifPV(int b){
        if(b<0){
            b=b+resistance;
            if(b>0){
                b=0;
            }
        }
        pv+=b;
    }
}
