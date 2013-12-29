package cz.stanov.projectEuler.euler60;

import java.util.List;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class Main {

    public static void main(String[] args) {
        getResultForArgument(5);
    }

    public static long getResultForArgument(int i) {
        List<Long> resultPrimes = ResultComputer.findResultPrimes(i);

        return sumList(resultPrimes);
    }

    private static long sumList(List<Long> numbers) {
        long result = 0;

        for (Long number : numbers) {
            result += number;
        }

        return result;
    }

}
