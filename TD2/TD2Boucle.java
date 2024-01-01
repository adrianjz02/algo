package TD2;

import java.util.Scanner;
import java.util.Random;

public class TD2Boucle {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // exo1();
        // exo2();
        // exo3();
        // exo4();
        // exo5();
        // exo6();
        // exo7();
        exo8();
        // exo9();
        // exo10(); A FAIRE!!!!!!!!!!!!!
        // exo11();
        // exo12();
    }

    static void exo1() {

        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();

        System.out.println(sommeEntiers(n));
    }

    static int sommeEntiers(int n) {

        int somme = 0;
        for (int i = 0; i <= n; i++) {
            somme += i;
        }
        return somme;
    }

    static void exo2() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();

        System.out.println(facto(n));
    }

    static int facto(int n) {
        int factoriel = 1;
        for (int i = 1; i <= n; i++) {
            factoriel *= i;
        }
        return factoriel;
    }

    static void exo3() {
        int entier1 = sc.nextInt();
        int entier2 = sc.nextInt();


        System.out.println(produitAvecAddition(entier1, entier2));
    }

    static int produitAvecAddition(int entier1, int entier2) {
        int produit = 0;

        for (int i = 0; i < entier2; i++) {
            produit += entier1;
        }
        return produit;
    }

    static void exo4() {

        int entier1 = sc.nextInt();
        int entier2 = sc.nextInt();

        int quotient = 0;
        int modulo;

        while (entier1 >= entier2) {
            entier1 -= entier2;
            quotient += 1;
        }

        modulo = entier1;
        System.out.println("Le quotient est égale à " + quotient);
        System.out.println("Le modulo est égale à " + modulo);
    }


    static void exo5() {

        int entier1 = sc.nextInt();
        int entier2 = sc.nextInt();

        System.out.println(pgcd(entier1, entier2));

        /* CA C'EST FAUX
        int diviseur = 0;
        int pgcd = 0;

        if (entier2 > entier1) {
            diviseur = entier1;
        } else {
            diviseur = entier2;
        }

        for (int i = 1; i <= diviseur; i++) {
            if (entier1 % i == 0 && entier2 % i == 0) {
                pgcd = i;
            }
        }
        System.out.println(pgcd);

         */


    }

    public static int pgcd(int a, int b) {
        /*
        while (a != b) {
            if (a < b) {
                b -= a;
            } else {
                a -= b;
            }
        }
         */
        int r;
        do {
            r = a % b;
            a = b;
            b = r;
        } while (r != 0);

        return a;
    }

    static void exo6() {

        int entier1 = sc.nextInt();

        System.out.println(fibo(entier1));

    }

    public static int fibo(int n) { // POUR EXO 6
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    static void exo7() {
        int n = sc.nextInt();
        System.out.println(valeurPi(n));
    }

    public static double valeurPi(int n) {
        /*
        double resultat = 0;
        int i;
        double k;
        for (i = 0, k = 1; i < n; i++, k += 2) {
            if (i % 2 == 0) {
                resultat += 1 / k;
            } else {
                resultat -= 1 / k;
            }
        }
         */
        double s = 0;
        double signe = 1;
        double impair = 1;
        /*
        for (int k = 0; k < n; k++) {
         */
        while (n-- > 0) {
            s += signe / impair;
            signe = -signe;
            impair = impair + 2;
        }
        return s * 4;
    }

    static void exo8() {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int somme = 0;
        for (int i = 1; i <= n; i++) {
            somme += (Math.pow(x, i)) / facto(i);
        }
        System.out.println(somme);
    }

    static double approxExp(double x, int n) {
        double s = 1;
        double num = x;
        double den = 1;
        for (int i = 1; i <= n; i++) {
            s = s + num / den;
            num = num * x;
            den = den * i + 1;
        }
        return s;
        /* C'EST MIEUX MAIS TROP DUR
        double s = 1;
        double num = x;
        double den = 1;
        for(int i = 1; i<n ; i++) {
            num = num * x;
            den = den * i;
            s = s + num / den;
        }

         */
    }

    static void exo9() {
        int k = sc.nextInt();
        int nombre = sc.nextInt();

        System.out.println(kiemeChiffre(nombre, k));
        /* MARCHE MAIS BON
        for (int i = 0; i < k - 1; i++) {
            nombre /= 10;
        }
        if (nombre < 10) {
            System.out.println(nombre);
        } else {
            System.out.println(nombre % 10);
        }

         */
    }

    static int kiemeChiffre(int x, int k) {
        for (int i = 1; i <= k - 1; i++) {
            x = x / 10;
        }
        return x % 10;
    }

    static void exo10() {
        int n = 1;
        int mini = 1;
        int maxi = 1000;
        Random rand = new Random();
        while (n == 0) {
            // J'Y ARRIVE PAS
        }
    }

    static void exo11() {
        for (int i = 1; i <= 10000; i++) {
            int somme = 0;
            for (int k = 1; k < i; k++) {
                if (i % k == 0) {
                    somme += k;
                }
            }
            if (somme == i) {
                System.out.println(i + " est un nombre parfait");
            }
        }
    }

    static void exo12() {
        for (int i = 0; i <= 999; i++) {
            int c1 = i / 100;
            int c2 = (i % 100) / 10;
            int c3 = i % 10;

            if ((Math.pow(c1, 3) + Math.pow(c2, 3) + Math.pow(c3, 3)) == i) {
                System.out.println(i + " est un nombre cube.");
            }
        }
    }


}
