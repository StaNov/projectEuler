package problem50_consecutivePrimes;

import help.Primes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int result = findSum(1000000);

        System.out.println("\nAnd the result is: " + result + "!!!");
    }

    public static int findSum(int max) {

        //vytvoří seznam prvočísel
        System.out.print("Vytvářím seznam prvočísel...");
        List<Integer> primes = Collections.unmodifiableList(createPrimesListBelow(max));
        System.out.println(" OK");

        System.out.print("Hledám výsledek...");
        //celkově nejlepší sumy
        int maxSum = 0;
        int maxCount = 0;
        //projeď všechny prvočísla, jako začátky posloupností
        for(int i = 0; i < primes.size() - 1; i++) {

            //suma po sobě jdoucích prvočísel počínaje primes[i]
            int sum = primes.get(i);
            //suma nejdelší posloupnosti po sobě jdoucích prvočísel, která je
            //sama prvočíslem
            int goodSum = 0;
            //největší počet přičtených prvočísel, který dává prvočíslo
            int count = 0;
            //přičítej prvočísla tak dlouho, dopokavaď je sum < max
            boolean continueTest = true;
            for(int j = i + 1; continueTest; j++) {
                if(Primes.isPrime(sum)) {
                    count = j - i;
                    goodSum = sum;
                }

                //pokud po přičtení dalšího prvočísla k sumě nepřekročíš max,
                //pokračuj ve výpočtu, jinak zastav cyklus
                int tryIsBiggerThanMax = sum + primes.get(j);
                if(tryIsBiggerThanMax < max) {
                    sum = tryIsBiggerThanMax;
                } else {
                    continueTest = false;
                }
            }

            //pokud našels prvočíslo tvořené delší posloupností, updatuj maxy
            if(count > maxCount) {
                maxCount = count;
                maxSum = goodSum;
            }
        }
        System.out.println(" OK");

        return maxSum;

    }






    private static List<Integer> createPrimesListBelow(int max) {

        List<Integer> primes = new ArrayList<Integer>(max);
        for(int i = 2; i <= max; i++) {
            if(Primes.isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

}
