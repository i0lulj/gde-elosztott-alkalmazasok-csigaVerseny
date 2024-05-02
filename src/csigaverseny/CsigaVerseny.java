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
    private Csiga[] csigak;
    private String felhasznaloTipp;
    
    public void fogadas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérjük fogadjon egy csigára: (piros, zold vagy kek). A színeket ékezetek nélkül adja meg!");
        felhasznaloTipp = scanner.nextLine();

        boolean ervenyesTipp = false;
        for (Csiga csiga : csigak) {
            if (csiga.getSzin().equalsIgnoreCase(felhasznaloTipp)) {
                ervenyesTipp = true;
                break;
            }
        }

        if (!ervenyesTipp) {
            System.out.print("Érvénytelen tipp! ");
            fogadas();
        }
    }
    
    public CsigaVerseny() {
        csigak = new Csiga[3];
        csigak[0] = new Csiga("piros");
        csigak[1] = new Csiga("zold");
        csigak[2] = new Csiga("kek");
    }
    
    public void fut() {
        Random random = new Random();
        for (int kor = 1; kor <= 5; kor++) {
            System.out.println(kor + " kör:");

            for (Csiga csiga : csigak) {
                int lepes = random.nextInt(4);
                if (random.nextDouble() < 0.2) {
                    lepes *= 2;
                    System.out.println(csiga.getSzin() + " csiga kapott csigagyorsítót és dupla sebességgel lép!");
                }
                csiga.lep(lepes);
                System.out.println(csiga.getSzin() + " csiga lép " + lepes + " egységet.");
            }

            System.out.println("----------");
        }

        System.out.println("Összesítés:");
        for (Csiga csiga : csigak) {
            System.out.println(csiga.getSzin() + " csiga végső pozíciója: " + csiga.getPozicio());
        }

        int maxPozicio = -1;
        String nyertes = "";
        for (Csiga csiga : csigak) {
            if (csiga.getPozicio() > maxPozicio) {
                maxPozicio = csiga.getPozicio();
                nyertes = csiga.getSzin();
            }
        }
        
        System.out.println("----------");
        System.out.println("A versenyt a(z) " + nyertes + " csiga nyerte!");
        System.out.println("----------");
        
        if (felhasznaloTipp.equalsIgnoreCase(nyertes)) {
            System.out.println("Gratulálunk, nyert!");
        } else {
            System.out.println("Sajnos nem nyert, próbálkozzon újra!");
        }
    }
    
    public static void main(String[] args) {
        CsigaVerseny verseny = new CsigaVerseny();
        verseny.fogadas();
        verseny.fut();
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
}