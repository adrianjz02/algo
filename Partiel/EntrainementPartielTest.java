package Partiel;

public class EntrainementPartielTest {
    public static void main(String[] args) {
        int[] tableau = { 1, 2, 3, 4, 5, 6 };
        int[] tableau2 = { 8, -10, 9, 6, -7, 0, 3, 7, -6, 0 };
        // System.out.println(chercheDansTableauTrie(tableau, 6));
        // afficheTripletsGPT(1000000);
        // afficheTableau(afficheCarreMagique(3));
        // afficherTableauSimple(ordonne3Parties(tableau2));

        int[] t = { 1, 19, 3, 5, 20 }; // Le tableau des distances entre les sommets successifs
        divisePolygone2(t);

    }

    static int chercheDansTableauTrie(int[] t, int x) {
        int debut = 0;
        int fin = t.length - 1;
        while (debut <= fin) {

            int milieu = (debut + fin) / 2;

            System.out.println(debut + " " + fin);

            if (t[milieu] == x) {
                return milieu;
            }

            if (t[milieu] < x) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }

        }
        return -1;
    }

    static void afficheTripletsGPT(int n) {
        for (int x = 1; x <= n; x++) {
            for (int y = x; y <= n; y++) { // Commencer à partir de x pour éviter les doublons
                int zSquared = x * x + y * y;
                int z = (int) Math.sqrt(zSquared);

                // Vérifier si z est un entier et si x^2 + y^2 = z^2
                if (z * z == zSquared && z <= n) {
                    System.out.println("<" + x + "," + y + "," + z + ">");
                }
            }
        }
    }

    static int[][] carreMagique(int n) {
        int[][] t = new int[n][n];
        int l = (n / 2) + 1;
        int c = n / 2;
        t[l][c] = 1;
        for (int i = 2; i <= n * n; i++) {
            if (t[(l + 1) % n][(c + 1) % n] == 0) {
                l = (l + 1) % n;
                c = (c + 1) % n;
                t[l][c] = i;
            } else {
                l = (l + 2) % n;
                t[l][c] = i;
            }
        }
        return t;
    }

    public static int[][] afficheCarreMagique(int n) {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("L'ordre du carré magique doit être impair.");
        }

        int[][] carreMagique = new int[n][n];

        int num = 1;
        int row = n - 1;
        int col = n / 2;
        int currRow, currCol;
        while (num <= n * n) {
            carreMagique[row][col] = num++;
            currRow = row;
            currCol = col;

            // Passer à la case en dessous à droite
            row = (row + 1) % n;
            col = (col + 1) % n;

            // Si la case est déjà remplie ou si on est à la fin d'une diagonale
            if (carreMagique[row][col] != 0) {
                row = (currRow - 1 + n) % n;
                col = currCol;
            }

        }
        return carreMagique;
    }

    public static void afficheTableau(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.println(); // Pour passer à la ligne suivante après chaque rangée
        }
    }

    public static int[] ordonne3Parties(int[] t) {
        int debut = 0;
        int fin = t.length - 1;
        int index = 0;
        while (index <= fin) {
            if (t[index] > 0) {
                int valTemp = t[index];
                t[index] = t[fin];
                t[fin] = valTemp;
                fin--;
            } else if (t[index] < 0) {
                int valTemp = t[index];
                t[index] = t[debut];
                t[debut] = valTemp;
                debut++;
                index++;
            } else {
                index++;
            }
        }
        return t;
    }

    static int perimetre(int[] tab) {
        int s = 0;
        for (int x : tab) {
            s += x;
        }
        return s;
    }

    public static void divisePolygone2(int[] t) {

        int p = perimetre(t);

        int s1 = 0;
        int s2 = 0;

        int diffTemp = 0;
        int diffMin = p;
        int poly1 = 0;
        int poly2 = 0;

        for (int i = 0; i < t.length; i++) {
            int poly1Bis = 0;
            int poly2Bis = 0;

            for (int j = i; j < i + t.length - 1; j++) {

                poly1Bis += t[j % t.length];
                poly2Bis = p - poly1Bis;
                diffTemp = Math.abs(poly1Bis - poly2Bis);

                if (diffTemp < diffMin) {
                    diffMin = diffTemp;
                    s1 = i;
                    s2 = j % t.length + 1;
                    poly1 = poly1Bis;
                    poly2 = poly2Bis;
                }
            }

        }

        System.out.println("(" + s1 + ", " + s2 + ") (" + poly1 + ", " + poly2 + ")");

    }

    static void afficherTableauSimple(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();

    }

}
