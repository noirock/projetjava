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
    int resistance;
    int provocation;
    public Nain(String nom, int pv, int fo, int ad, int in){
        super(nom, pv, fo, ad, in);
    }
    public void resistance(){
        if(action(getIntelligence(),10)==1){
            resistance=3;
            System.out.println(getNom()+" gagne en résistance!");
        }
        else{
            System.out.println(getNom()+" rate son sort...");
        }
    }
    public void provocation(){
        if(action(getIntelligence(),10)==1){
            provocation=3;
            System.out.println(getNom()+" provoque les ennemis pour qu'ils l'attaquent et oublient ses alliés!");
        }
        else{
            System.out.println(getNom()+" rate son sort...");
        }
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