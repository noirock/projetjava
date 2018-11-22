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
    private Integer attaque;
    private Integer adresse;
    private String cri;
    public Ennemi(String nom, int pv, int atk,int adr, String c){
        super(nom, pv);
        this.attaque=atk;
        this.adresse=adr;
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
     System.out.println(getNom()+" attaque");
     Random jet = new Random();
     int touche = jet.nextInt(101);
     if (touche>=adresse){
        groupe[n].modifPV(-attaque);
        groupe[n].parle("AIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!");
        System.out.println(groupe[n].getNom() + " perd "+ attaque + "PV");
        System.out.println(groupe[n].getNom()+ "est maintenant à "+groupe[n].getPV()+" PV");
     }
     else{
         System.out.println("Mais loupe sa cible");
     }
     
         
    
    }
}
