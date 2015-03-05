/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem23_abundants;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {
        
        SortedSet<Integer> result = new TreeSet<Integer>();
        
        for(int i = 1; i <= 28123; i++) {
            result.add(i);
        }

        SortedSet<Integer> abuns = getAbundants();

        for(int i : abuns) {
            for(int j : abuns) {

                result.remove(i + j);
                //System.out.println(i+j + " removed");
            }
        }

        int sum = 0;

        for(int i : result) {
            sum += i;
        }

        System.out.println("And the result is: " + sum + "!!!");
    }

    private static SortedSet<Integer> getAbundants() {

        SortedSet<Integer> result = new TreeSet<Integer>();

        for(int i = 1; i < 28123; i++) {
            if(isAbundant(i)) {
                result.add(i);
                //System.out.println(i);
            }
        }

        return result;
    }

    private static boolean isAbundant(int n) {

        int sumOfDivs = 0;

        for(long i : help.Primes.getDivs(n)) {
            sumOfDivs += i;
        }

        sumOfDivs -= n;

        return n < sumOfDivs;
    }

}
