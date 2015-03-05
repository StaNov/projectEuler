package problem57_sqrt2;

import help.Primes;
import java.math.BigInteger;

/**
 *
 * @author StaNov
 */
public class Fraction {

    private BigInteger num;
    private BigInteger den;

    public Fraction(BigInteger num, BigInteger den) {
        this.num = num;
        this.den = den;
    }

    public Fraction(long num, long den) {
        this.num = BigInteger.valueOf(num);
        this.den = BigInteger.valueOf(den);
    }

    public void shorten() {
        BigInteger gcd = Primes.gcd(num, den);
        //num /= gcd;
        num = num.divide(gcd);
        //den /= gcd;
        den = den.divide(gcd);
    }

    public Fraction plus(Fraction that) {
        //BigInteger newDen = den * that.den;
        BigInteger newDen = den.multiply(that.den);
        //BigInteger newNum = newDen / den * num + newDen / that.den * that.num;
        BigInteger newNum = (newDen.divide(den).multiply(num)).add(newDen.divide(that.den).multiply(that.num));

        Fraction result = new Fraction(newNum, newDen);
        result.shorten();
        return result;
    }

    public void reverse() {
        BigInteger foo = num;
        num = den;
        den = foo;
    }
    
    public double toDouble() {
        double dNum = num.doubleValue();
        double dDen = den.doubleValue();
        
        return dNum / dDen;
    }

    @Override
    public String toString() {
        return num + " / " + den;
    }

    public boolean hasMoreDigitsInNumerator() {

        return numberOfDigits(num) > numberOfDigits(den);
    }

    private static int numberOfDigits(BigInteger x) {
        int result = 0;

        while(!x.equals(BigInteger.ZERO)) {
            //x /= 10;
            x = x.divide(BigInteger.TEN);
            result++;
        }

        return result;
    }

}
