package help;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Novák Stanislav
 */
public class Primes {

    public static boolean isPrime(long n) {

        if(n <= 0) {
            throw new IllegalArgumentException("argument can't be negative");
        }

        if(n == 2) {
            return true;
        }

        if(n == 1 || n % 2 == 0) {
            return false;
        }

        long max = (long) Math.sqrt(n);

        for(long i = 3; i <= max; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /*
    sere se to, není sqrt na BigInteger...
     public static boolean isPrime(BigInteger n) {

        if(n.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("argument can't be negative");
        }

        if(n.equals(BigInteger.valueOf(2))) {
            return true;
        }

        if(n.equals(BigInteger.ONE) || n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            return false;
        }

        BigInteger max = (long) Math.sqrt(n.);

        for(long i = 3; i <= max; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }*/

    public static SortedSet<Long> getDivs(long n) {

        SortedSet<Long> set1 = new TreeSet<Long>();
        long sqrt = (long) Math.sqrt(n);

        for(long i = 1; i <= sqrt; i++) {
            if(n % i == 0) {
                set1.add(i);
            }
        }

        SortedSet<Long> set2 = new TreeSet<Long>();

        for(Long i : set1) {
            set2.add(n / i);
        }

        set1.addAll(set2);


        return set1;
    }

    public static long gcd(long a, long b) {

        if(a < 1 || b < 1) {
            return 1;
        }

        if(a == b) {
            return a;
        }

        long newA;
        while (a != b) {
            long min = Math.min(a, b);
            newA = Math.max(a, b) - min;
            b = min;
            a = newA;
        }

        return a;
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {

        if(a.compareTo(BigInteger.ONE) < 0 || a.compareTo(BigInteger.ONE) < 0) return BigInteger.ONE;

        if(a.equals(b)) return a;

        BigInteger newA = max(a, b).subtract(min(a, b));
        BigInteger newB = min(a, b);

        return gcd(newA, newB);
    }

    private static BigInteger max(BigInteger a, BigInteger b) {
        if(a.compareTo(b) < 0) {
            return a;
        }

        return b;
    }

    private static BigInteger min(BigInteger a, BigInteger b) {
        if(a.compareTo(b) < 0) {
            return b;
        }

        return a;
    }
}
