package cz.stanov.projectEuler.problem60;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class ResultComputer {

    @Autowired
    private PrimesChecker primesChecker;

    public List<Long> findResultPrimes(int numberOfPrimes) {
        SetOfPrimesGenerator primesGenerator = new SetOfPrimesGenerator(numberOfPrimes);

        List<Long> result;

        do {
            result = primesGenerator.generateNewSetOfPrimes();
        } while (! primesChecker.primesAreWanted(result));

        return result;
    }
}
