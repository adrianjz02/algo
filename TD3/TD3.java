package TD3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TD3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // exo1();
        // exo2();
        // exo3();
        // exo4();
        // exo5();
        // exo6();
        // exo8();
        exo9();
    }

    static int[] saisieTableau() {
        System.out.print("Entrer la taille du tableau: ");
        int taille = sc.nextInt();
        return saisieTableau(taille);
    }

    static int[] saisieTableau(int taille) {
        int[] t = new int[taille];
        saisieTableau(t);
        return t;
    }

    static void saisieTableau(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print("Entrer l'élement t[" + i + "]: ");
            t[i] = sc.nextInt();
        }
    }

    static int[] initAleatoireTableau(int taille) {
        int[] t = new int[taille];
        for (int i = 0; i < taille; i++) {
            t[i] = (int) (Math.random() * taille); // t[i] = un nombre random dans [0,taille[
        }
        return t;
    }

    static void afficheTableau(int[] t) {
        afficheTableau(t, t.length);
    }

    static void afficheTableau(int[] t, int nb) {
        for (int i = 0; i < nb; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    static void exo1() {
        int n = sc.nextInt();
        int[] tab = creationTab(n);
        System.out.println("Le tableau : " + Arrays.toString(tab));
        System.out.println(maxTab(tab));
    }

    static int[] creationTab(int n) {
        int[] tab = new int[n];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = sc.nextInt();
        }
        return tab;
    }

    static int maxTab(int[] tab) {
        int max = tab[0];
        for (int i : tab) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static void exo2() {
        int n = sc.nextInt();
        base2(n);
    }

    static void base2(int n) {
        int[] tab = new int[32];
        int longueur = 0;
        do {
            tab[longueur++] = n % 2;
            n /= 2;
        } while (n > 0);

        for (int i = longueur - 1; i >= 0; i--) {
            System.out.print(tab[i]);
        }
        /* ENCORE MIEUX
        while (lg > 0) {
            System.out.print(tab[--lg])
        }
         */
    }

    static void exo3() { // On peut faire avec la methode initAleatoireTableau
        int n = sc.nextInt();
        int[] tab = creationTab(n);
        System.out.println("Le tableau : " + Arrays.toString(tab));
        int nombre = sc.nextInt();
        System.out.println(appartientTab(tab, nombre));
    }

    static boolean appartientTab(int[] tab, int n) {
        for (int i : tab) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    static void exo3bis() { // Fais par le professeur
        int[] t = initAleatoireTableau(30);
        Arrays.sort(t);
        afficheTableau(t);
        int x = sc.nextInt();
        if (appartientTab(t, x)) {
            System.out.println("appartient");
        } else {
            System.out.println("n'appartient pas");
        }
    }

    static boolean afficheTableauDicho(int[] t, int x) {
        int iDeb = 0;
        int iFin = t.length - 1;
        while (iDeb != iFin) {
            int iMil = (iDeb + iFin) / 2;
            if (x > t[iMil]) {
                iDeb = iMil + 1;
            } else {
                iFin = iMil;
            }
        }
        return (t[iDeb] == x);
    }

    static void exo4() {
        int n = sc.nextInt();
        int[] tab = creationTab(n);
        System.out.println("Le tableau : " + Arrays.toString(tab));
        System.out.println(testTriTab(tab));
    }

    static boolean testTriTab(int[] tab) {
        int valeur = tab[0];
        for (int i : tab) {
            if (i < valeur) {
                return false;
            }
            valeur = i;
        }
        return true;
    }

    static void exo5() {
        int n = sc.nextInt();
        int[] tab = creationTab(n);
        System.out.println(evalPolynome(tab, tab.length));
    }

    static int evalPolynome(int[] coeff, int x) {
        int s = 0;
        int puissX = 1;
        for (int i = 0; i < coeff.length; i++) {
            s = s + coeff[i] * puissX;
            puissX = puissX * x;
        }
        return s;
    }

    static void exo6() {
        int max = sc.nextInt();
        int[] tab = new int[max];
        tab[0] = -1;
        tab[1] = -1;
        for (int i = 2; i < tab.length; i++) {
            if (tab[i] != -1) {
                System.out.println(i);
                for (int k = i + i; k < tab.length; k = k + i) {
                    tab[k] = -1;
                }
            }
        }
    }

    static void exo7() {

    }
    static void exo8() {
    }

    static void exo9() {
        int n = 5;
        int p = 3;

        // Initialise la matrice de bits
        boolean[][] bits = new boolean[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                bits[i][j] = false;
            }
        }

        // Parcours en profondeur de la matrice de bits
        for (int i = 0; i < (1 << n); i++) {
            // Affiche le sous-ensemble courant
            for (int j = 0; j < p; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}

