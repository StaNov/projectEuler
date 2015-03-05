package problem46_primePlusSquare;

import help.Primes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Novák Stanislav
 * @version 5.6.2010
 */
public class Generator implements Runnable {

    private Set<Long> checkingSet;
    private List<Long> primes = Collections.synchronizedList(new ArrayList<Long>());

    public Generator(Set<Long> checkingSet) {
        this.checkingSet = checkingSet;
    }

    /*
     * do nekonečna generuj prvočísla
     * do nekonečna přidávej do množiny čísla x + 2×y^2, kde x je prvočíslo z
     *     primes a y je cokoli
     */
    public void run() {

        Thread primeGenerator = new Thread(new PrimeGenerator(primes));
        primeGenerator.setName("Prime generator");
        primeGenerator.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int sum = 1; true; sum++) {
            for(int i = 0; i < sum; i++) {
                long x = primes.get(i);
                long y = sum - i;
                //System.out.println("Adding to checkingSet: " + x + " + 2*" + y + "^2...");
                checkingSet.add(x + 2 * (long)Math.pow(y, 2));
            }
        }
    }

}

/**
 * Generátor seznamu prvočísel. Nekonečný.
 * 
 * @author Novák Stanislav
 */
class PrimeGenerator implements Runnable {

    private List<Long> primes;

    public PrimeGenerator(List<Long> primes) {
        this.primes = primes;
    }

    public void run() {

        primes.add(2L);
        for(long i = 3; i < Long.MAX_VALUE; i += 2) {
            if(Primes.isPrime(i)) {
                //System.out.println("Adding to primes: " + i);
                primes.add(i);
            }
        }
    }

}