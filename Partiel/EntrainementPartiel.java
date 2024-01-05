package Partiel;

public class EntrainementPartiel {

    // Version moi
    static void exo1() {
        int[] monTableau = { 1, 2, 3, 4, 5 }; // Exemple de tableau d'entiers
        int valeurAChercher = 1; // Exemple de valeur à chercher dans le tableau

        int resultat = chercheDansTableauTrie2(monTableau, valeurAChercher);

        System.out.println(resultat);
    }

    static int chercheDansTableauTrie(int[] tab, int x) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Version ChatGPT
    /**
     * Recherche un élément dans un tableau trié en utilisant l'algorithme de
     * recherche binaire.
     *
     * @param t le tableau trié dans lequel effectuer la recherche.
     * @param x l'élément à rechercher.
     * @return l'indice de l'élément dans le tableau, ou -1 s'il n'est pas présent.
     */
    public static int chercheDansTableauTrie2(int[] t, int x) {
        int debut = 0;
        int fin = t.length - 1;

        while (debut <= fin) {
            int milieu = debut + (fin - debut) / 2;

            // Vérifier si x est présent au milieu
            if (t[milieu] == x) {
                return milieu;
            }

            // Si x est plus grand, ignorer la moitié gauche
            if (t[milieu] < x) {
                debut = milieu + 1;
            }

            // Si x est plus petit, ignorer la moitié droite
            else {
                fin = milieu - 1;
            }
        }

        // Si nous atteignons ce point, l'élément n'est pas présent
        return -1;
    }

    static void afficheTriplets(int n) {
        for (int x = 1; x <= n; x++) {
            for (int y = x; y <= n; y++) { // Commencer par x pour éviter les doublons
                for (int z = y; z <= n; z++) { // Commencer par y pour éviter les doublons
                    if (x * x + y * y == z * z) {
                        System.out.println("<" + x + "," + y + "," + z + ">");
                    }
                }
            }
        }
    }

    // Version moi
    static int[][] afficheCarreMagique(int n) {
        int[][] tab = new int[n][n];
        int c = n / 2;
        int l = (n / 2) + 1;
        tab[l][c] = 1;
        for (int i = 2; i <= n * n; i++) {
            if (tab[(l + 1) % n][(c + 1) % n] == 0) {
                l = ++l % n;
                c = ++c % n;
                tab[l][c] = i;
            } else {
                l = (l + 2) % n;
                tab[l][c] = i;
            }
        }
        return tab;
    }

    // Version ChatGpt
    static int[][] afficheCarreMagiqueGPT(int n) {
        // Vérifiez que n est impair
        if (n % 2 == 0) {
            throw new IllegalArgumentException("n doit être impair");
        }

        int[][] tab = new int[n][n];
        int num = 1;
        int i = n / 2 + 1; // Commence en bas de la case centrale pour n impaire
        int j = n / 2;
        int dernierI, dernierJ;

        while (num <= n * n) {
            tab[i][j] = num++;
            dernierI = i;
            dernierJ = j;
            i = (i + 1) % n; // Descend d'une ligne (avec comportement circulaire)
            j = (j + 1) % n; // Déplace d'une colonne vers la droite (avec comportement circulaire)

            // Si la cellule est déjà remplie, déplacez-vous une ligne en dessous de la
            // dernière cellule remplie
            if (tab[i][j] != 0) {
                i = (dernierI + 2) % n; // Assurez-vous de rester dans le tableau
                j = dernierJ; // Restez dans la même colonne
            }
        }

        return tab;
    }

    public static void afficheTableau(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.println(); // Pour passer à la ligne suivante après chaque rangée
        }
    }

    static int[] ordonne3Parties(int[] tableau) {
        int start = 0;
        int end = tableau.length - 1;
        int index = 0;

        while (index <= end) {
            if (tableau[index] < 0) {
                // Échangez tableau[start] et tableau[index]
                int temp = tableau[start];
                tableau[start] = tableau[index];
                tableau[index] = temp;
                start++;
                index++;
            } else if (tableau[index] > 0) {
                // Échangez tableau[end] et tableau[index]
                int temp = tableau[end];
                tableau[end] = tableau[index];
                tableau[index] = temp;
                end--;
            } else {
                index++;
            }
        }
        return tableau;
    }

    static void afficherTableauSimple(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }

    static int perimetre(int[] tab) {
        int s = 0;
        for (int x : tab) {
            s += x;
        }
        return s;
    }

    static void divisePolygone(int[] t) {
        int p = perimetre(t);
        int nb = t.length / 2;

        int s1 = 0;
        int s2 = 0;
        int poly1 = 0;
        int poly2 = 0;

        int poly1bis = 0;
        int poly2bis = 0;

        int min = p;

        for (int i = 0; i < t.length; i++) {
            poly1bis += t[i];
            int j = i;
            int count = nb - 1;
            while (count-- > 0) {
                j = (j + 1 == t.length) ? 0 : j + 1;
                poly1bis += t[j];
            }

            poly2bis = p - poly1bis;
            int minTemp = Math.abs(poly1bis - poly2bis);
            if (minTemp < min) {
                min = minTemp;
                s1 = i;
                s2 = ++j;
                poly1 = poly1bis;
                poly2 = poly2bis;
            }

            poly1bis = 0;
            poly2bis = 0;

        }

        System.out.println(s1 + " " + s2 + " " + poly1 + " " + poly2 + " ");
    }

    public static void divisePolygoneKhera(int[] t) {
        int perimetre = perimetre(t);
        int nb = t.length / 2;
        int s1 = 0;
        int s2 = 0;
        int poly1 = 0;
        int poly2 = 0;
        int poly1Bis = 0;
        int poly2Bis = 0;
        int min = perimetre;
        int minBis = 0;

        for (int i = 0; i < t.length; i++) {
            poly1Bis += t[i];
            int j = i;
            int count = nb - 1;

            while (count-- > 0) {
                j = (j + 1 == t.length) ? 0 : j + 1;
                poly1Bis += t[j];
            }

            poly2Bis = perimetre - poly1Bis;
            minBis = Math.abs(poly1Bis - poly2Bis);
            if (minBis < min) {
                min = minBis;
                s1 = i;
                s2 = ++j;
                poly1 = poly1Bis;
                poly2 = poly2Bis;
            }

            poly1Bis = 0;
            poly2Bis = 0;

        }

        System.out.println(
                "La paire de sommet est (" + s1 + "," + s2 + ") avec pour longueurs " + poly1 + " et " + poly2 + ".");
    }

    public static void main(String[] args) {
        int[] tableau = { 8, -10, 9, 6, -7, 0, 3, 7, -6, 0 };
        // exo1();
        // afficheTriplets(20);
        // afficheTableau(afficheCarreMagique(5));
        // afficherTableauSimple(ordonne3Parties(tableau));
        int[] polygone = { 5, 8, 1, 3, 3 };

        divisePolygone(polygone);

        divisePolygoneKhera(polygone);
        // afficherTableauSimple(trouverPaireDeSommets(polygone));
    }

}
