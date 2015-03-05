package AAAPOMALEproblem69_totientFunc;

import help.Primes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author StaNov
 */
public class Main {

    private static List<Integer> primes; // = makePrimes(1000000);
    private static List<Integer>[] relPrimes; // ke každému číslu jsou uchovány jeho relativ primes

    public static void main(String[] args) {
        int result = findMax(1000000);
        System.out.println("\nAnd the result is: " + result + "!!!");
    }

    private static int findMax(int limit) {
        /*
         * 1. Udělej prvočísla od 1 do limit
         * 2. Ke každému číslu spočítej n/fí(n)
         * 3. Vrať max
         */
        System.out.print("Making primes...");
        primes = makePrimes(limit); //(1)
        System.out.println(" OK");
        relPrimes = new List[limit];
        int maxNum = 0;
        double maxVal = 0.0;
        
        for(int i = 2; i <= limit; i++) {
            System.out.println(i);
            //System.out.print(i + ", ");
            int fi = fi(i);
            //System.out.print(fi + ", ");
            double nDivFi = i / fi;
            //System.out.println(nDivFi); //(2)

            if(nDivFi > maxVal) {
                maxVal = nDivFi;
                maxNum = i;
            }
        }

        return maxNum;
    }

    private static List<Integer> makePrimes(int limit) {
        List<Integer> result = new ArrayList<Integer>();
        //result.add(1);

        for(int i = 2; i <= limit; i++) {
            if(Primes.isPrime(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static int fi(int n) {
        int result = 1;

        for(int i = 0; primes.get(i) < n; i++) {

        }

        return result;
    }

}
