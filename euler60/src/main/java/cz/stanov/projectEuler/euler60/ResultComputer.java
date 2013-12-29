package cz.stanov.projectEuler.euler60;

import java.util.List;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class ResultComputer {

    public static List<Long> findResultPrimes(int numberOfPrimes) {
        SetOfPrimesGenerator primesGenerator = new SetOfPrimesGenerator(numberOfPrimes);

        List<Long> result;

        do {
            result = primesGenerator.generateNewSetOfPrimes();
        } while (! PrimesChecker.primesAreWanted(result));

        return result;
    }
}
