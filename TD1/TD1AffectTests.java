
/**
 * La classe associée au TD1 sur les affectations et tests.
 */

import java.util.Scanner;

public class TD1AffectTests {

    /**
     * Un scanner pour lire les valeurs au claver
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * La méthode principale (main). Décommenter l'exercice à tester.
     *
     * @param args
     */
    public static void main(String[] args) {
        // exo0();
        // exo1();
        // exo2();
        // exo3();
        // exo4();
        // exo5();
        // exo6();
        // exo7();
        exo8();
    }

    /**
     * L'exemple du support de cours (addition de 2 entiers)
     */
    static void exo0() {
        System.out.println("Entrer 2 entiers");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int r = x + y;
        System.out.println("somme: " + r);
    }

    /**
     * L'exercice 1 : échange de 2 valeurs entières
     */
    static void exo1() {
        System.out.println("Entrer 2 entiers");
        int x = sc.nextInt();
        int y = sc.nextInt();


        int temp = x;
        x = y;
        y = temp;

        System.out.println("Après la permutation : " + x + " " + y);

    }

    /**
     * L'exercice 2 : échange de 2 valeurs entières sans variable auxiliaire.
     */
    static void exo2() {
        System.out.println("Entrer 2 entiers");
        int x = sc.nextInt();
        int y = sc.nextInt();


        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("Après la permutation : " + x + " " + y);
    }

    static void exo3() {
        System.out.println("Entrer 3 entiers");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int temp = x;
        x = y;
        y = z;
        z = temp;

        System.out.println("Après la permutation : " + x + " " + y + " " + z);
    }

    static void exo4() {
        System.out.println("Entrer 3 entiers");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int max;

        if (y > x) {
            if (y > z) {
                max = y;
            } else {
                max = z;
            }
        } else {
            if (x > z) {
                max = x;
            } else {
                max = z;
            }
        }


        System.out.println("Le maximum entre ces trois valeurs est : " + max);
    }

    static void exo5() {
        System.out.println("Entrer 3 entiers");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int temp;
        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }
        if (y > z) {
            temp = y;
            y = z;
            z = temp;
        }

        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }
        System.out.println("Après la permutation : " + x + " " + y + " " + z);
    }

    static void exo6() {
        System.out.println("Entrer votre note : ");
        int note = sc.nextInt();

        if (note >= 0 && note < 10) {
            System.out.println("recalé");
        } else if (note >= 10 && note < 12) {
            System.out.println("passable");
        } else if (note >= 12 && note < 14) {
            System.out.println("assez bien");
        } else if (note >= 14 && note < 16) {
            System.out.println("bien");
        } else if (note >= 16 && note < 20) {
            System.out.println("très bien");
        }
    }

    static void exo7() {
        System.out.println("Entrer le prix : ");

        int prix = sc.nextInt();

        int vingt = 0;
        int dix = 0;
        int cinq = 0;
        int deux = 0;
        int un = 0;


        if (prix >= 20) {
            vingt = prix / 20;
            prix = prix % 20;
        }
        if (prix >= 10) {
            dix = prix / 10;
            prix = prix % 10;
        }
        if (prix >= 5) {
            cinq = prix / 5;
            prix = prix % 5;
        }
        if (prix >= 2) {
            deux = prix / 2;
            prix = prix % 2;
        }
        if (prix >= 1) {
            un = prix;
        }

        System.out.println("Décomposé en billet : \n" +
                vingt + " billet de 20, \n" +
                dix + " billet de 10, \n" +
                cinq + " billet de 5, \n" +
                deux + " pièces de 2, \n" +
                un + " pièce de 1");
    }

    static void exo8() {

        System.out.println("Entrer  le nombre de votre ticket : ");
        int ticket = sc.nextInt();

        // UTILISER LES PUISSANCES DE 10 !!!!!
        // à droite c'est le modulo
        // à gauche c'est une division

        int chiffresAGauche = ticket / 1000;
        int chiffresADroite = ticket % 1000;

        int nombreAGauche = chiffresAGauche % 10 + chiffresAGauche % 100 + (int) (chiffresAGauche / 100);
        int nombreADroite = chiffresADroite % 10 + chiffresADroite % 100 + (int) (chiffresADroite / 100);

        if (nombreADroite == nombreAGauche) {
            System.out.println("Votre ticket est chanceux.");
        } else {
            System.out.println("Votre ticket n'est pas chanceux");
        }

    }
}
