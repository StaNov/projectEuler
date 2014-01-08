package cz.stanov.projecteuler.problem60;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");

        ResultComputer resultComputer = (ResultComputer) applicationContext.getBean("resultComputer");

        List<Long> resultPrimes = resultComputer.findResultPrimes(i);

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
