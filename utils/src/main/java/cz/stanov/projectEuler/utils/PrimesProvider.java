package cz.stanov.projectEuler.utils;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PrimesProvider {

    private static final long DEFAULT_INIT_VALUE = 2;

    private long initValue;
    private long currentPrime;
    private Primes primes;

    public PrimesProvider(Primes primes) {
        this.initValue = DEFAULT_INIT_VALUE;
        this.currentPrime = DEFAULT_INIT_VALUE;
        this.primes = primes;
    }

    public PrimesProvider(Primes primes, long initValue) {
        this.initValue = initValue;
        this.currentPrime = initValue;
        this.primes = primes;
    }

    public long nextPrime() {
        while (! primes.isPrime(currentPrime)) {
            currentPrime++;
        }

        return currentPrime++;
    }

    public void reset() {
        currentPrime = initValue;
    }
}
