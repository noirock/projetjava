/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkestjava;

/**
 *
 * @author Justin Duban
 */
public class Ennemi extends Personnage {
    private String attaque;
    private String cri;
    private int pv;
    public Ennemi(String nom, float pv, String atk, String c){
        super(nom, pv);
        this.attaque=atk;
        this.cri=c;
    }
    public void attaque(Personnage[] groupe){
     //faire un switch, cf labw1
     //et oué
    }
}
