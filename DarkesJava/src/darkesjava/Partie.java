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
    int totalOr;
    Aventurier[] disponibles;
    Aventurier[] groupe;
    Evenement[] evenements;
    Scanner entree = new Scanner(System.in);
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
    public void taverne(){
        System.out.println("Bienvenue à l'auberge! Ici vous pouvez recrutez de nouveaux héros pour affronter les hordes du Donjon!");
        boolean sortie = false;
        while(sortie != true){
            int i = 0;
            System.out.println("Aventuriers disponibles :");
            while(i!=disponibles.length){
                System.out.print(i+": "+disponibles[i].getNom()+", PV:"+disponibles[i].pvmax+", Force:"+disponibles[i].getForce()+", Intelligence:"+disponibles[i].getIntelligence()+", Adresse:"+disponibles[i].getAdresse()+" | ");
                i++;
            }
            System.out.println();
            System.out.println("Groupe actuel :");
            for(int j=0; j<groupe.length; j++){
                System.out.print(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
            }
            System.out.println();
            do {
                System.out.println("Engagez un nouveau personnage pour 100 po?(taper le numéro du personnage) ou Sortir?(taper X)");
                String s = entree.nextLine();
                if(s.length() !=0){
                    char touche = s.charAt(0);
                    if ((touche<='9') && (touche>='0')){
                        String stouche=String.valueOf(touche);
                        int touch=Integer.parseInt(stouche);
                        if (totalOr<100){
                            i=0;
                            System.out.println("Pas assez d'or...");
                            System.out.println();
                        }
                        else if (disponibles[touch].pvmax!=0){
                            i=0;
                            totalOr=totalOr-100;
                            System.out.println("Choisir personnage à remplacer:");
                            for(int j=0; j<groupe.length; j++){
                                System.out.print(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
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
                            groupe[Integer.parseInt(sapuce)]=disponibles[touch];//!\/!\/!\/!\/!\/!\/!\/!\/!\!/\!/!\/!\/!\/!\!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\
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
    public void magasin(){
        System.out.println("Bienvenue au magasin! Ici vous pouvez acheter de l'équippement à vos personnages pour affronter les hordes du Donjon!");
        boolean sortie = false;
        while(sortie != true){
            int i = 0;
            System.out.println();
            System.out.println("Equippement disponibles :");
            System.out.println("1) Epee(+5 en Force)(5 po), 2) Cape(+5 en Adresse)(5 po), 3) Livre(+5 en Intelligence)(5 po), 4) Armure(+3 PV)(5 po)");
            System.out.println("Groupe actuel :");
            for(int j=0; j<groupe.length; j++){
                System.out.print(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
            }
            System.out.println();
            do {
                System.out.println("Acheter un objet?(taper le numéro de l'objet) ou Sortir?(taper X)");
                String s = entree.nextLine();
                if(s.length() !=0){
                    char touche = s.charAt(0);
                    if ((touche<'5') && (touche>'0')){
                        if (totalOr<100){
                            i=0;
                            System.out.println("Pas assez d'or...");
                            System.out.println();
                        }
                        else{
                            i=0;
                            System.out.println("Choisir personnage à équiper:");
                            for(int j=0; j<groupe.length; j++){
                                System.out.print(groupe[j].getNom()+", PV:"+groupe[j].pvmax+", Force:"+groupe[j].getForce()+", Intelligence:"+groupe[j].getIntelligence()+", Adresse:"+groupe[j].getAdresse()+"  ");
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
                                            break;
                                case '2':   groupe[Integer.parseInt(sapuce)].changeAdresse(5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 5 de Adresse");
                                            break;
                                case '3':   groupe[Integer.parseInt(sapuce)].changeIntelligence(5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 5 d'Intelligence");
                                            break;
                                case '4':   groupe[Integer.parseInt(sapuce)].modifPVmax(groupe[Integer.parseInt(sapuce)].getPVmax()+5);
                                            System.out.println(groupe[Integer.parseInt(sapuce)].getNom()+" gagne 3 PV max");
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
    public void donjon(){
        
    }
}
