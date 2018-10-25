/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkestjava;
import java.util.Random;

/**
 *
 * @author Justin Duban
 */
public class Personnage {
    private String nom;
    private float pv;
    
    Personnage(String n, float p){
        this.nom=n;
        this.pv=p;
    }
    public String getNom(){
        return nom;
    }
    public float getPV(){
        return pv;
    }
    public void modifPV(float b){
        pv=pv+b;
    }
    
    public void sePresenter(){
        System.out.println("Salutations, mon nom est " + getNom());
    }
    public void parle(String s){
        System.out.print(getNom() + ": " + s);
    }
}
