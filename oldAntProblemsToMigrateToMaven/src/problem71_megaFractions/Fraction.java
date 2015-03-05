package problem71_megaFractions;

/**
 *
 * @author StaNov
 */
public class Fraction implements Comparable<Fraction> {

    private int num; // numerator
    private int den; // denominator

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    public int compareTo(Fraction o) {
        if(((double)num)/den > ((double)o.num)/o.den) {
            return 1;
        }

        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        if (this.num != other.num) {
            return false;
        }
        if (this.den != other.den) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.num;
        hash = 37 * hash + this.den;
        return hash;
    }

}
