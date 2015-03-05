/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem10_primes;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        /*System.out.print("Creating list...");
        //SortedSet<Long> list = new TreeSet<Long>();
        Set<Long> list = new HashSet<Long>();

        list.add((long)2);
        for(long i = 3; i <= 2000000; i += 2) {
            list.add(i);
        }

        System.out.println(" OK");

        long current = 2;
        

        for(long index = 1; index < list.size(); index++) {
            //current = list.get(index);
            while(! list.contains(++current));

            System.out.print("Getting number " + current + " off the list...");
            for(long i = current*current; i <= 2000000; i += current) {
                list.remove((Long) i);
            }
            System.out.println(" OK");
        }


        System.out.print("Sumarizing list...");
        long sum = 0;
        for(Long n : list) {
            sum += n;
        }
        System.out.println(" OK");

        System.out.println("And the result is: " + sum);*/

        long sum = 0;

        System.out.print("Adding primes...");

        for(int i = 1; i < 2000000; i++) {
            if(help.Primes.isPrime(i)) {
                sum += i;
            }
        }

        System.out.println(" OK");

        System.out.println("Sum: " + sum);

    }

}
