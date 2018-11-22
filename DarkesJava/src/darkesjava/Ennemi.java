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
    public void attaque(Aventurier[] groupe){
     //faire un switch, cf labw1
     //et oué
     
     Random rand = new Random();
     int n = rand.nextInt(groupe.length);
     while (groupe[n].getPV()<=0){
         n = rand.nextInt(groupe.length);
     }
     int p=0;
     for (int i=0; i<groupe.length; i++){
         if ((groupe[i].provocation>0)&&(p<groupe[i].provocation)){
             n=i;
             p=groupe[i].provocation;
         }
     }
     System.out.println(getNom()+" attaque");
     Random jet = new Random();
     int touche = jet.nextInt(101); //de a 101 faces parce que disney
     if (touche>=adresse){
        groupe[n].modifPV(-attaque);
        groupe[n].parle("AIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!");
        System.out.println(groupe[n].getNom() + " perd "+ attaque + "PV");
        System.out.println(groupe[n].getNom()+ " est maintenant à "+groupe[n].getPV()+" PV");
        if (groupe[n].getPV()<=0){
                    System.out.println(groupe[n].getNom()+" n'était pas assez fort, sa mort était inévitable");
                }
     }
     else{
         System.out.println("Mais loupe sa cible");
     }
     
         
    
    }
}
