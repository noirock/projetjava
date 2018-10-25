/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;
import java.util.Random;
/**
 *
 * @author Justin Duban
 */
public class Ennemi extends Personnage {
    private String attaque;
    private String cri;
    public Ennemi(String nom, float pv, String atk, String c){
        super(nom, pv);
        this.attaque=atk;
        this.cri=c;
    }
    public String getCri(){
        return cri;
    }
    public void attaque(Personnage[] groupe){
     //faire un switch, cf labw1
     //et oué
     int nb=0;
     for (int i=0; i<groupe.length;i++){
         if (groupe[i].getPV()<=0){nb++;}
     }
     Random rand = new Random();
     int n = rand.nextInt(nb) + 1;
     
    }
}
