/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

/**
 *
 * @author louis
 */
public class DarkesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Aventurier nain = new Aventurier("Gurdil", 11, 70, 40, 20);
       Aventurier elfe = new Aventurier("Tirael", 8, 40, 70, 50);
       Aventurier mage = new Aventurier("Bandoulf", 7, 20, 30, 70);
       
       Ennemi gobl1 = new Ennemi("Zibli", 5, "2", "Garboulag!");
       Ennemi gobl2 = new Ennemi("Billi", 5, "2", "Garboulug!");
       Ennemi gobl3 = new Ennemi("Guili", 5, "2", "Garboulog!");
    }
    
}
