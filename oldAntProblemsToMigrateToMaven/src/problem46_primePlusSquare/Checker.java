package problem46_primePlusSquare;

import help.Primes;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Novák Stanislav
 * @version 5.6.2010
 */
public class Checker implements Runnable {

    private long pauseDuration;
    //uchovává největší nalezené liché číslo
    private int maxFoundNumber;
    //množina čísel, které se mají kontrolovat na přítomnost lichých čísel
    private Set<Long> checkingSet;

    public Checker(long pauseDuration, Set<Long> checkingSet) {
        this.pauseDuration = pauseDuration;
        this.checkingSet = checkingSet;
        this.maxFoundNumber = 9;
    }

    /*
     * počká pauseDuration milisekund
     * najde první liché číslo, které není v množině
     * porovná ho s dříve nalezeným
     * pokud se shodují, vypíše je na výstup a ukončí výpočet
     */
    public void run() {

        while (true) {
            try {
                Thread.sleep(pauseDuration);

                //System.out.print("Starting finding new number...");
                int firstMissingNum = firstNumMissing();
                System.out.println("This time first number missing: " + firstMissingNum);
                if (maxFoundNumber == firstMissingNum) {
                    System.out.println("\nAnd the result is: " + maxFoundNumber + "!!!");
                    System.exit(0);
                }
                maxFoundNumber = firstMissingNum;

            } catch (InterruptedException ex) {
                System.err.println("Thread has been interrupted!" + ex);
            }
        }
    }

    /*
     * vrátí první liché složené číslo, které není v množině
     */
    private int firstNumMissing() {

        for (int i = maxFoundNumber; true; i += 2) {
            if (!Primes.isPrime(i) && !checkingSet.contains((long) i)) {
                return i;
            }
        }
    }
}
