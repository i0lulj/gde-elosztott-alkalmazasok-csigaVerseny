/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csigaverseny;

/**
 * 
 * @author Péter Birkás NK: il0ulj
 * 
 * Az alábbi feladatot kell elkészíteni OOP szemlélettel, Git-re feltöltve:
 * A játékban 3 csiga versenyzik 5 körön keresztül, az nyer, 
 * aki messzebb jut. Egy körben, egy csiga 0..3 egységet megy, véletlenszerűen. 
 * A csigáknak van színe: piros zöld, kék.
 * A játék elején lehet fogadni, hogy melyik csiga nyer!
 * A játékban minden körben 20% eséllyel kiválasztásra kerül egy csiga, 
 * aki kap csigagyorsítót! Ennek hatására abban a körben dupla lesz a sebessége!
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class CsigaVerseny {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

class Csiga {
    private String szin;
    private int pozicio;

    public Csiga(String szin) {
        this.szin = szin;
        this.pozicio = 0;
    }

    public String getSzin() {
        return szin;
    }

    public int getPozicio() {
        return pozicio;
    }

    public void lep(int lepes) {
        pozicio += lepes;
    }

    public void csigagyorsito() {
        pozicio *= 2;
    }
}
