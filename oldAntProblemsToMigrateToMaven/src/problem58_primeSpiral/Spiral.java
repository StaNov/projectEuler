package problem58_primeSpiral;

import help.Primes;

/**
 *
 * @author StaNov
 */
public class Spiral {

    private int sideLength;
    private int nums;
    private int primes;
    private int lastNumber;
    private double ratio;

    public Spiral() {
        sideLength = 0;
        nums = 1;
        primes = 0;
        lastNumber = 1;
        ratio = 0;
    }

    public void enlarge() {
        sideLength += 2;

        for(int i = 0; i < 4; i++) {
            lastNumber += sideLength;
            nums ++;
            if(Primes.isPrime(lastNumber)) primes++;
        }

        ratio = (double)primes / nums * 100;
    }

    public double getRatio() {
        return ratio;
    }

    public int getSideLength() {
        return sideLength + 1;
    }

    @Override
    public String toString() {
        return "Spiral: SideLength: " + getSideLength() + ", lastNumber: " + lastNumber + ", ratio: " + ratio + ".";
    }
}
