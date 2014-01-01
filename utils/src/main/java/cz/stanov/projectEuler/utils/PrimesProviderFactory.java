package cz.stanov.projectEuler.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class PrimesProviderFactory {

    @Autowired
    private Primes primes;

    public PrimesProvider getNewPrimesProvider() {
        return new PrimesProvider(primes);
    }

    public PrimesProvider getNewPrimesProvider(long initValue) {
        return new PrimesProvider(primes, initValue);
    }
}
