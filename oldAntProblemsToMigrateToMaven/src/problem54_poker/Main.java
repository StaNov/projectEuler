/*
 * Zadání: http://projecteuler.net/index.php?section=problems&id=54
 * Je docela dlouhé, tak se mi to sem nechtělo kopírovat.
 */

package problem54_poker;

/**
 * Prostě main, vyřeší úlohu.
 *
 * @author StaNov
 */
public class Main {

    public static void main(String[] args) {
        /*
         * 1. načti karty ze souboru
         * 2. porovnej mezi sebou jednotlivé páry rukou
         * 3. vypiš výsledek
         */
        Hand[] hand = HandsLoader.loadHands();

        int result = 0; // počet her, které vyhrál první hráč

        for (int i = 0; i < 2000; i += 2) {

            boolean p1wins = hand[i].compareTo(hand[i+1]) > 0; // vyhrál první hráč

            System.out.println("Hráč 1: " + hand[i]  +  "\tHráč 2: " + hand[i+1] + "\tVyhrál " + (p1wins ? "první" : "druhý") + " hráč.");

            if(p1wins) result++;
        }

        System.out.println("První hráč vyhrál celkem " + result + " krát!!!");
    }

}
