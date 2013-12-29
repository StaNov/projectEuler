package cz.stanov.projectEuler.euler60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class SetOfPrimesGenerator {

    private int numberOfPrimes;

    public SetOfPrimesGenerator(int numberOfPrimes) {
        this.numberOfPrimes = numberOfPrimes;
    }

    public List<Long> generateNewSetOfPrimes() {
        return new ArrayList<Long>(Arrays.asList(3L, 7L, 109L, 673L));  // TODO
    }
}
