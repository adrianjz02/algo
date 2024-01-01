import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] tab1 = {1, 1, 2, 3, 2, 2, 2, 4};
    public static void main(String[] args) {
        // System.out.println(exo6());
        // exo6();
        System.out.println(plusPtitElem(tab1));
        // System.out.println(minRepetable(tab1));
    }

    static double exo(int n) {
        double r = 0;
        double den = 1;
        double signe = 1;
        for (int i = 0; i < n; i++) {
            r += signe / den;
            den += 2;
            signe = -signe;
        }
        return r * 4;
    }

    static double exo2(double x, int n) {
        int pui = 0;
        double s = 0;
        int facto = 1;
        for (int i = 1; i <= n; i++) {
            s += Math.pow(x, pui++) / facto;
            facto *= i;
        }
        return s;
    }

    static int exo3(int entier, int kieme) {
        for (int i = 0; i < kieme - 1; i++) {
            entier /= 10;
        }
        return entier % 10;
    }

    static double exo4(int n) {
        double r = 0;
        int signe = 1;
        int den = 1;
        for (int i = 0; i < n; i++) {
            r += signe / (den * Math.pow(3, i));
            den += 2;
            signe = -signe;
        }
        return r * Math.sqrt(12);
    }

    static double exo5() {
        int moy = 0;
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        do {
            int max = (n1 + n2 + n3) / 3;
            if (max > moy) {
                moy = max;
            }
            n1 = n2;
            n2 = n3;
            n3 = sc.nextInt();
        } while (n3 >= 0);
        return moy;
    }

    static void exo6() {
        /*
        System.out.println("Entrer la longueur du tableau : ");
        int lg = sc.nextInt();
        int[] tab = creationTab(lg);

         */
        int[] tab = {1, 2, 2, 5, 5};
        System.out.println(minTab(tab));
    }

    static int[] creationTab(int n) {
        int[] tab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Entrer une valeur : ");
            tab[i] = sc.nextInt();
        }
        return tab;
    }

    static int minTab(int[] tab) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tab.length; i++) {
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[i] == tab[j] && tab[i] < min) {
                    min = tab[i];
                }
            }
        }
        return min;
    }

    static void exo7() {
        /*
        System.out.println("Entrer la longueur du tab 1 : ");
        int lg1 = sc.nextInt();
        int[] tab1 = creationTab(lg1);
        System.out.println("Entrer la longueur du tab 1 : ");
        int lg2 = sc.nextInt();
        int[] tab2 = creationTab(lg1);
         */
        int[] tab1 = {1, 1, 1, 2, 3, 4};
        int[] tab2 = {1, 2, 3, 4};

        System.out.println(elemCommun(tab1, tab2));
    }

    static int elemCommun(int[] tab1, int[] tab2) {
        int c = 0;
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab2.length; j++) {
                if (tab1[i] == tab2[j]) {
                    c++;
                    // Pour éviter de compter ce nombre une deuxième fois, vous pouvez marquer l'élément
                    // en le changeant par une valeur spéciale (par exemple -1).
                    tab2[j] = -324465878;
                    break;
                }
            }
        }
        return c;
    }

    static int plusPtitElem(int[] tab) {
        return 4;
    }

    static int communTab(int[] tab1, int[] tab2)  {
        return 5;
    }


    static int minRepetable(int [] t) {
        // static int[] tab1 = {2, 3, 1, 1, 2, 4};
        int min = t[0];
        int minrep = -1;
        int cpt = 0;

        for (int i = 1; i < t.length; i++) {
            if (t[i] < min) {
                min = t[i];
                cpt = 0;
            } else if (t[i] == min) {
                cpt++;
                if (cpt > 0) {
                    minrep = min;
                }
            }
        }

        return minrep;
    }

}