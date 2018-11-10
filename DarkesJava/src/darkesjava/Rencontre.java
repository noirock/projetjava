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
public class Rencontre {
    String titre;
    String intro;
    String defi;
    Personnage pnj;
    Rencontre(String in, String de, Personnage r){
        this.intro=in;
        this.defi=de;
        this.pnj=r;
    }
    
}
