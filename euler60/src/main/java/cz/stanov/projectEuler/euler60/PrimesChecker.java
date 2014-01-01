package cz.stanov.projectEuler.euler60;

import java.util.List;

import org.springframework.stereotype.Component;

import static cz.stanov.projectEuler.utils.Primes.isPrime;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class PrimesChecker {

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

        return isPrime(composedPrime1) && isPrime(composedPrime2);
    }
}
