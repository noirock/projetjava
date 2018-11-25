/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkesjava;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Justin Duban
 */
public class Partie {
    public int totalOr;
    Aventurier[] disponibles;
    Aventurier[] groupe;
    Evenement[] donjon;
    
    Scanner entree = new Scanner(System.in);
    public void lancerPartie(){
        boolean jouer=true;
        totalOr=20;
        debutPartie();
        while(jouer==true){
            village();
        }
    }
    /*méthode qui permet le lancement de la partie*/
    public void debutPartie(){
        System.out.println("Vous arrivez dans un petit village avec votre groupe d'aventuriers, vous avez soif d'aventure et de trésors et c'est pourquoi vous venez vous confronter au...Donjon");
        Nain Gurdil = new Nain("Gurdil", 13, 70, 40, 50);
        Nain Gunther = new Nain("Gunter", 14, 60, 50, 50);
        Elfe Tirael = new Elfe("Tirael", 10, 50, 70, 40);
        Elfe Touniel = new Elfe("Touniel",9, 40, 70, 50);
        Mage Bandoulf = new Mage("Bandoulf", 7, 40, 50, 70);
        Mage Bordur = new Mage("Bordur", 8, 55, 55, 55);
        Aventurier[] dispos = new Aventurier[6];
        dispos[0]=Gurdil;
        dispos[1]=Gunther;
        dispos[2]=Tirael;
        dispos[3]=Touniel;
        dispos[4]=Bandoulf;
        dispos[5]=Bordur;
        disponibles=dispos;
       
        Nain[] G= new Nain[2];
        Elfe[] T= new Elfe[2];
        Mage[] B= new Mage[2];
        G[0]=Gurdil;
        G[1]=Gunther;
        T[0]=Tirael;
        T[1]=Touniel;
        B[0]=Bandoulf;
        B[1]=Bordur;
        
        Aventurier[] grp=new Aventurier[3];
        groupe=grp;
        Random aventurier = new Random();
        groupe[0]=G[aventurier.nextInt(2)];
        groupe[1]=T[aventurier.nextInt(2)];
        groupe[2]=B[aventurier.nextInt(2)];
        System.out.println("Votre groupe est composé de "+groupe[0].getNom()+", "+groupe[1].getNom()+", "+groupe[2].getNom());
        System.out.println();
    }
    /*méthode qui permet de modifier la composition de l'équipe*/
    public void taverne(){
        System.out.println();
        System.out.println("Bienvenue à l'auberge! Ici vous pouvez recrutez de nouveaux héros pour affronter les hordes du Donjon!");
        boolean sortie = false;
        while(sortie != true){
            int i = 0;
            System.out.println("Aventuriers disponibles :");
            while(i!=disponibles.length){
                System.out.println(i+": "+disponibles[i].getNom()+", PV:"+disponibles[i].pvmax+", Force:"+disponibles[i].getForce()+", Intelligence:"+disponibles[i].getIntelligence()+", Adresse:"+disponibles[i].getAdresse()+" ");
                i++;
            }
            System.out.println();
            System.out.println("Groupe actuel :");
            for(int j=0; j<groupe.length; j++){
                System.out.println(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
            }
            System.out.println();
            do {
                System.out.println("Vous disposez acuellement de "+ totalOr +" pieces d'or. Engagez un nouveau personnage pour 20 po?(taper le numéro du personnage) ou Sortir?(taper X)");
                String s = entree.nextLine();
                if(s.length() !=0){
                    char touche = s.charAt(0);
                    if ((touche<='5') && (touche>='0')){
                        String stouche=String.valueOf(touche);
                        int touch=Integer.parseInt(stouche);
                        if (totalOr<20){
                            i=0;
                            System.out.println("Pas assez d'or...");
                            System.out.println();
                        }
                        else if (disponibles[touch].pvmax!=0){
                            i=0;
                            totalOr=totalOr-20;
                            System.out.println("Choisir personnage à remplacer:");
                            for(int j=0; j<groupe.length; j++){
                                System.out.println(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
                            }
                            System.out.println();
                            char apuce ='e';
                            do{
                                String sapuce = entree.nextLine();
                                if(sapuce.length() !=0){
                                    apuce = sapuce.charAt(0);
                                }
                            } while((apuce!='0')&&(apuce!='1')&&(apuce!='2'));
                            String sapuce=String.valueOf(apuce);
                            if(touche>='0' && touche <='1'){
                                Nain ajout = new Nain(disponibles[touch].getNom(), 0, 0, 0, 0);
                                ajout.pv=disponibles[touch].pv;
                                ajout.pvmax=disponibles[touch].pvmax;
                                ajout.changeForce(disponibles[touch].getForce());
                                ajout.changeIntelligence(disponibles[touch].getIntelligence());
                                ajout.changeAdresse(disponibles[touch].getAdresse());
                                groupe[Integer.parseInt(sapuce)]=ajout;
                            }
                            if(touche>='2' && touche <='3'){
                                Elfe ajout = new Elfe(disponibles[touch].getNom(),0,0,0,0);
                                ajout.pv=disponibles[touch].pv;
                                ajout.pvmax=disponibles[touch].pvmax;
                                ajout.changeForce(disponibles[touch].getForce());
                                ajout.changeIntelligence(disponibles[touch].getIntelligence());
                                ajout.changeAdresse(disponibles[touch].getAdresse());
                                groupe[Integer.parseInt(sapuce)]=ajout;
                            }
                            if(touche>='4' && touche <='5'){
                                Mage ajout = new Mage(disponibles[touch].getNom(),0,0,0,0);
                                ajout.pv=disponibles[touch].pv;
                                ajout.pvmax=disponibles[touch].pvmax;
                                ajout.changeForce(disponibles[touch].getForce());
                                ajout.changeIntelligence(disponibles[touch].getIntelligence());
                                ajout.changeAdresse(disponibles[touch].getAdresse());
                                groupe[Integer.parseInt(sapuce)]=ajout;
                            }
                            
                        }
                    }
                    else if(touche=='X'){
                        i=0;
                        sortie=true;
                        System.out.println();
                    }
                }
            } while(i!=0);
            
        }
    }
    /*méthode qui permet d'augmenter de 5 les stats d'un personnage en réduisant la somme d'or total*/
    public void magasin(){
        System.out.println();
        System.out.println("Bienvenue au magasin! Ici vous pouvez acheter de l'équippement à vos personnages pour affronter les hordes du Donjon!");
        boolean sortie = false;
        while(sortie != true){
            int i = 0;
            System.out.println();
            System.out.println("Equippement disponibles :");
            System.out.println("1) Epee(+5 en Force)(10 po), 2) Cape(+5 en Adresse)(10 po), 3) Livre(+5 en Intelligence)(10 po), 4) Armure(+3 PV)(10 po)");
            System.out.println("Groupe actuel :");
            for(int j=0; j<groupe.length; j++){
                System.out.println(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
            }
            System.out.println();
            do {
                System.out.println("Vous disposez acuellement de "+ totalOr+" pieces d'or. Acheter un objet?(taper le numéro de l'objet) ou Sortir?(taper X)");
                String s = entree.nextLine();
                if(s.length() !=0){
                    char touche = s.charAt(0);
                    if ((touche<'5') && (touche>'0')){
                        if (totalOr<10){
                            i=0;
                            System.out.println("Pas assez d'or...");
                            System.out.println();
                        }
                        else{
                            i=0;
                            System.out.println("Choisir personnage à équiper:");
                            for(int j=0; j<groupe.length; j++){
                                System.out.println(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ("+j+")");
                            }
                            char apuce ='e';
                            do{
                                String sapuce = entree.nextLine();
                                if(sapuce.length() !=0){
                                    apuce = sapuce.charAt(0);
                                }
                            } while((apuce!='0')&&(apuce!='1')&&(apuce!='2'));
                            String sapuce=String.valueOf(apuce);
                            switch(touche){
                                case '1':   groupe[Integer.parseInt(sapuce)].changeForce(5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 5 de Force");
                                            totalOr=totalOr-10;
                                            break;
                                case '2':   groupe[Integer.parseInt(sapuce)].changeAdresse(5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 5 de Adresse");
                                            totalOr=totalOr-10;
                                            break;
                                case '3':   groupe[Integer.parseInt(sapuce)].changeIntelligence(5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 5 d'Intelligence");
                                            totalOr=totalOr-10;
                                            break;
                                case '4':   groupe[Integer.parseInt(sapuce)].modifPVmax(groupe[Integer.parseInt(sapuce)].getPVmax()+5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 3 PV max");
                                            totalOr=totalOr-10;
                                            break;                                    
                            }
                        }
                    }
                    else if(touche=='X'){
                        i=0;
                        sortie=true;
                    }
                }
            } while(i!=0);
            
        }        
    }
    public int donjon(int totalOr){
          
   
       Ennemi gobl1 = new Ennemi("Zibli", 5, 2, 40, "Garboulag!",1);
       Ennemi gobl2 = new Ennemi("Billi", 5, 2, 40, "Garboulug!",1);
       Ennemi gobl3 = new Ennemi("Guili", 5, 2, 40, "Garboulog!",1);
       Ennemi troll1 = new Ennemi("Bazoul",15,4,20, "bougabouh",3);
       Ennemi troll2 = new Ennemi("Tazeyl",15,4,20, "bougabouh",3);
       Ennemi troll3 = new Ennemi("Razort",15,4,20, "bougabouh",3);
       
       Ennemi[] liste = new Ennemi[6];
       liste[0]=gobl1;
       liste[1]=gobl2;
       liste[2]=gobl3;
       liste[3]=troll1;
       liste[4]=troll2;
       liste[5]=troll3;
       
       
       Combat fight = new Combat("Le combat se déclenche contre ",liste);
       
       Personnage sirene = new Personnage("La sirene", 7);
       Rencontre mermaid = new Rencontre("Vous arrivez dans une grotte, vous entendez l'eau couler d'un lac proche et une silhouette se dessine au bord de l'eau", "Bonjour étrangers, que faites-vous en mon domaine?", sirene);
    
       
       Epreuve epr1 = new Epreuve("Vous arrivez dans une salle et devant vous se trouve un coffre","Le coffre",1);
       Epreuve epr0 = new Epreuve("Vous arrivez dans une salle et devant vous se trouve une grande porte dorée","La porte",0);
       Epreuve epr2 = new Epreuve("Vous arrivez dans une salle et devant vous se trouve une salle piégée","La salle piégée",2);
       
       donjon =new Evenement[10];
       donjon[0]=epr1;
       donjon[1]=epr2;
       donjon[2]=epr0;
       donjon[3]=mermaid;
       donjon[4]=mermaid;
       for (int i=5 ; i<10;i++){
           donjon[i]=fight;
       }
       Random salle = new Random();
       int k=0;
       for (int j=0;j<5;j++){
           k=salle.nextInt(donjon.length);
           totalOr=donjon[k].evenement(groupe,totalOr);
           
       }
       return totalOr;
    }
    public void village(){
        System.out.println("Vous vous retrouvez sur la place du village, vous pouvez vous rendre à la taverne (a), au magasin (b) ou au donjon (c). Si vous n'êtes pas satisfait vous pouvez toujours taper 'le nain'.");
        String direction = entree.nextLine();
        if(direction=="le nain"){
            for(int i=0; i<groupe.length; i++){
                if (groupe[i].getNom().charAt(0)=='G'){
                    groupe[i].parle("AIIIIIIIIIIIIIIIIIIIIE!!!");
                    groupe[i].modifPV(-1);
                    direction=" ";
                }
            }
            if(direction!=" "){
                System.out.println("Vous n'avez pas de nain...");
            }
        }
        else if(direction.length()!=0){
            System.out.println("l'or est de "+totalOr);
            switch(direction.charAt(0)){
                case 'a':   taverne();
                            break;
                case 'b':   magasin();
                            break;
                case 'c':   totalOr =donjon(totalOr);
                            break;
                default: System.out.println("Veuillez saisir une des options proposées");
            }
        }
    }
}
