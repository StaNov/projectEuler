package problem33_fractions;

import help.Primes;

/**
 * Fraction.
 *
 * @author Novák Stanislav
 * @version 27.2.2010
 */
public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {

        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be zero!");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {

        if(! (o instanceof Fraction)) {
            return false;
        }

        Fraction that = (Fraction) o;

        Fraction f1 = this.shorten();
        Fraction f2 = that.shorten();

        return f1.numerator == f2.numerator &&
                f1.denominator == f2.denominator;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.numerator;
        hash = 41 * hash + this.denominator;
        return hash;
    }

    public Fraction shorten() {

        int gcd = (int)Primes.gcd(numerator, denominator);

        int a = numerator / gcd;
        int b = denominator / gcd;

        return new Fraction(a,b);
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Unortodoxly shortens the fraction.
     *
     * @return shortened fraction if exists, null otherwise
     */
    public Fraction unortodoxShorten() {

        try {
            Fraction left = tryShortenLeft();

            if(left != null) {
                return left;
            }

            return tryShortenRight();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Fraction tryShortenLeft() {

        int up = numerator / 10;
        int down = denominator % 10;

        if(up == down) {

            return new Fraction(numerator % 10, denominator / 10);
        }

        return null;
    }

    private Fraction tryShortenRight() {

        int up = numerator % 10;
        int down = denominator / 10;

        if(up == down) {

            return new Fraction(numerator / 10, denominator % 10);
        }

        return null;
    }

    public Fraction multiplyBy(Fraction frac) {

        int num = numerator * frac.numerator;
        int den = denominator * frac.denominator;

        return new Fraction(num, den);
    }

    @Override
    public String toString() {

        return numerator + " / " + denominator;
    }
}
