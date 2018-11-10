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
    
    public void rencontre(Aventurier[] groupe, Rencontre rencontre){
        System.out.println(rencontre.intro);
        rencontre.pnj.sePresenter();
        rencontre.pnj.parle(rencontre.defi);
    }
    public static void combat(Aventurier[] groupe, Ennemi[] mechants, Combat combat){
        System.out.println("Début du combat!!!");
        int v =0;
        while(v==0){
            for(int i=0; i<groupe.length;i++){
                if (v==0){
                    if(groupe[i].getPV()>0){
                        groupe[i].coup(mechants);
                        if (groupeVivant(mechants)==false){
                            v=1;
                            i=groupe.length;
                            System.out.println("Victoire!!!");
                        }
                    }
                }
            }
            for(int i=0; i<mechants.length;i++){
                if (v==0){
                    if(mechants[i].getPV()>0){
                        mechants[i].attaque(groupe);
                        if(groupeVivant(groupe)==false){
                            v=1;
                            i=mechants.length;
                            System.out.println("Défaite...");
                        }
                    }
                }
            }
        }
    }
    public static boolean groupeVivant(Personnage[] G){
        for(int i=0; i< G.length; i++){
            if (G[i].getPV()>0){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       Aventurier nain = new Aventurier("Gurdil", 11, 70, 40, 20);
       Aventurier elfe = new Aventurier("Tirael", 8, 40, 70, 50);
       Aventurier mage = new Aventurier("Bandoulf", 7, 20, 30, 70);
       
       Aventurier[] groupe=new Aventurier[3];
       groupe[0]=nain;
       groupe[1]=elfe;
       groupe[2]=mage;
      
       Ennemi[] mechants = new Ennemi[3];
       Ennemi gobl1 = new Ennemi("Zibli", 5, "2", "Garboulag!");
       Ennemi gobl2 = new Ennemi("Billi", 5, "2", "Garboulug!");
       Ennemi gobl3 = new Ennemi("Guili", 5, "2", "Garboulog!");
       mechants[0]=gobl1;
       mechants[1]=gobl2;
       mechants[2]=gobl3;
       
       Combat fight1 = new Combat();
       combat(groupe, mechants,fight1);
       
       Personnage sirene = new Personnage("La sirene", 7);
       Rencontre mermaid = new Rencontre("Vous arrivez dans une grotte, vous entendez l'eau couler d'un lac proche et une silhouette se dessine au bord de l'eau", "Bonjour étrangers, que faites-vous en mon domaine?", sirene);
        
    
    }
}
