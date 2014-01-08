package cz.stanov.projectEulero.problem60;

import java.util.List;

import cz.stanov.projectEulero.utils.Primes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class PrimesChecker {

    @Autowired
    private Primes primes;

    public boolean primesAreWanted(List<Long> primes) {

        for (int i = 0; i + 1 < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {

                if (primesAreWanted(primes.get(i), primes.get(j))) {
                    return true;
                }

            }
        }

        return false;
    }

    private boolean primesAreWanted(long prime1, long prime2) {
        long composedPrime1 = Long.parseLong(prime1 + "" + prime2);
        long composedPrime2 = Long.parseLong(prime2 + "" + prime1);

        return primes.isPrime(composedPrime1) && primes.isPrime(composedPrime2);
    }
}
