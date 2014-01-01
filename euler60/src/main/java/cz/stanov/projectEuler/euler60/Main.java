package cz.stanov.projectEuler.euler60;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.debug("Starting computing!");

        long result = getResultForArgument(5);

        LOG.info("And the result is: " + result + "!!!");
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
