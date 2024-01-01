package TD3;

import java.util.Scanner;

public class TD3Correc {
    static Scanner sc = new Scanner(System.in);

    static int[] createTab(int n) {
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Entrer une valeur : ");
            tab[i] = sc.nextInt();
        }
        return tab;
    }

    static void afficheTableau(int[] tab) {
        for (int elem : tab) {
            System.out.print(elem + " ");
        }
    }

    static void exo1() {
        System.out.println("Entrer la longueur du tableau : ");
        int n = sc.nextInt();
        int[] tab = createTab(n);
        System.out.println(maxTab(tab));
    }

    static int maxTab(int[] tab) {
        int max = tab[0];
        for (int elem : tab) {
            if (elem > max) {
                max = elem;
            }
        }
        return max;
    }

    static void exo2() {
        int nombre = sc.nextInt();
        int[] tab = new int[32];
        int lg = 0;
        do {
            tab[lg++] = nombre % 2;
            nombre /= 2;
        } while (nombre > 0);
        for (int i = lg - 1; lg > 0; lg--) {
            System.out.print(tab[i] + " ");
        }
    }

    static void exo3() {
        int n = sc.nextInt();
        int[] tab = createTab(n);
        afficheTableau(tab);
        System.out.println("Entrer la valeur recherchée : ");
        int x = sc.nextInt();
        System.out.println(appartientTab(tab, x));
        System.out.println(appartientTableauDicho(tab, x));
    }

    static boolean appartientTab(int[] tab, int x) {

        for (int elem : tab) {
            if (x == elem) {
                return true;
            }
        }
        return false;
    }

    static boolean appartientTableauDicho(int[] t, int x) {

        int iDeb = 0;
        int iFin = t.length - 1;


        while (iDeb != iFin) {
            int iMil = (iDeb + iFin) / 2;
            if (x > t[iMil])
                iDeb = iMil + 1;
            else
                iFin = iMil;
        }
        return (t[iDeb] == x);
    }


    static void exo4() {
        int n = sc.nextInt();
        int[] tab = createTab(n);
        afficheTableau(tab);
        System.out.println(tabCroissant(tab));
    }

    static boolean tabCroissant(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i + 1]) {
                return false;
            }
        }
        return true;
    }

/*
    static boolean tabCroissant2(int[] tab) {
        int valeur = tab[0];
        for (int elem : tab) {
            if (elem < valeur) {
                return false;
            }
            valeur = elem;
        }
        return true;
    }

 */

    static void exo5() {
        int n = sc.nextInt();
        int[] tab = new int[]{1, 2, 3, 4};
        evalPolynome(tab, n);
    }

    static int evalPolynome(int[] coeff, int x) {

        int r = 0;
        for (int i = coeff.length - 1; i >= 0; i--) {
            r = r * x + coeff[i];
        }
        return r;
    }

    static void exo6() {
        int n = sc.nextInt();
        affPremiers2(n);
    }

    static void affPremiers(int max) {

        int[] t = new int[max + 1];

        for (int i = 0; i < t.length; i++) {
            t[0] = t[1] = -1; //est
            t[i] = i;
        }

        for (int i = 2; i < t.length; i++) {
            if (t[i] != -1) { //pas barré donc premier
                System.out.println(i);
                for (int j = i + i; j < t.length; j = j + i) { // on compte de i en i
                    t[j] = -1;// on barre un multiple
                }
            }
        }

        System.out.println();
    }

    static void affPremiers2(int max) {

        boolean[] estBarre = new boolean[max + 1];
        estBarre[0] = estBarre[1] = true; //pas besoin de boucle car on a les valeurs par défaut qui est false

        for (int i = 2; i < estBarre.length; i++) {
            if (!estBarre[i]) { //pas barré donc premier
                System.out.println(i + "_");
                for (int j = i * i; j < estBarre.length; j = j + i) { // on compte de i en i
                    estBarre[j] = true;// on barre un multiple
                }
            }
        }

        System.out.println();

    }

    static void exo7() {

    }

    static int sousTabSommeMax(int[] t) {
        int courSomme = 0;
        int courDeb = 0;
        int maxSomme = t[0];
        int maxDeb = 0;
        int maxFin = 0;
        for (int courFin = 0; courFin < t.length; courFin++) {
            courSomme += t[courFin];
            if (courSomme > maxSomme) {
                maxSomme = courSomme;
                maxDeb = courDeb;
                maxFin = courFin;
            }
            if (courSomme < 0) {
                courSomme = 0;
                courDeb = courFin + 1;
            }
        }
        System.out.println("maxSomme : " + maxSomme + "entre indice " + maxDeb + " et " + maxFin);
        return maxSomme;
    }

    static void exo9() {

    }

    static void afficheTableau2(int[] t) {
        afficheTableau(t, t.length);
    }

    static void afficheTableau(int[] t, int nb) {
        for (int i = 0; i < nb; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    static void affDecomp(int n) {
        int[] t = new int[n];
        int lg = n;
        //Pour decompo, = que des 1
        for (int i = 0; i < n; i++)
            t[i] = 1;
        for (; ; ) { //Invariable Boucle (cad toujours vrai) dans t et lg on a une decoompo
            afficheTableau(t, lg);
            if (lg == 1)
                break;
            lg--; //lg pointe sur le dernier
            t[lg - 1]++; //on incrémente l'avant-dernier
            int nb1 = t[lg] - 1; //nb 1 à mettre à droite de l'avant dernier
            while (nb1-- > 0)
                t[lg++] = 1;
        }
    }


    public static void main(String[] args) {
        // exo9();
        affDecomp(8);
    }
}
