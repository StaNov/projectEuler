package cz.stanov.projectEuler.utils;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PrimesProvider {

    private static final long DEFAULT_INIT_VALUE = 2;

    private long initValue;
    private long currentPrime;

    public PrimesProvider() {
        initValue = DEFAULT_INIT_VALUE;
        currentPrime = DEFAULT_INIT_VALUE;
    }

    public PrimesProvider(long initValue) {
        this.initValue = initValue;
        currentPrime = initValue;
    }

    public long nextPrime() {
        while (! Primes.isPrime(currentPrime)) {
            currentPrime++;
        }

        return currentPrime++;
    }

    public void reset() {
        currentPrime = initValue;
    }
}
