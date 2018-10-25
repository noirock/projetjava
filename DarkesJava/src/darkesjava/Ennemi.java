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
    private int force;
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

     Random rand = new Random();
     int n = rand.nextInt(groupe.length);
     while (groupe[n].getPV()<=0){
         n = rand.nextInt(groupe.length);
     }
     groupe[n].modifPV(-force%10);
     groupe[n].parle("AIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!");
     System.out.println(groupe[n].getNom() + "perd "+ force%10 + "PV");
         
    
    }
}
