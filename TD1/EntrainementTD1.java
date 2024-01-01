package TD1;

import java.util.Scanner;

public class EntrainementTD1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // exo1();
        exo2();
    }

    static void exo1() {
        int x1 = sc.nextInt();
        int x2= sc.nextInt();

        int var = x2;
        x2 = x1;
        x1 = var;

        System.out.println(x1 + "  " + x2);

    }

    static void exo2() {
        int x1 = sc.nextInt();
        int x2= sc.nextInt();

        x1 = x2 + x1;
        x2 = x1 - x2;
        x1 = x1 - x2;

        System.out.println(x1 + " " + x2);
    }

    static void exo3() {

    }

}
