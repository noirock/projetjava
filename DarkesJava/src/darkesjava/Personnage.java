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
public class Personnage {
    private String nom;
    protected int pv;
    
    Personnage(String n, int p){
        this.nom=n;
        this.pv=p;
    }
    public String getNom(){
        return nom;
    }
    public int getPV(){
        return pv;
    }
    public void modifPV(int b){
        pv=pv+b;
    }
    
    
    public void sePresenter(){
        System.out.println("Salutations, je suis " + getNom());
    }
    public void parle(String s){
        System.out.println(getNom() + ": " + s);
    }
}
