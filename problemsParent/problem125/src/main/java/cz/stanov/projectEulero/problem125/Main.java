package cz.stanov.projectEulero.problem125;


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
        long result = getResultForArgument(100000000L);

        LOG.info("And the result is: " + result + "!!!");
    }

    private static long getResultForArgument(long i) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");

        ResultComputer resultComputer = (ResultComputer) applicationContext.getBean("resultComputer");

        return resultComputer.computeResultForArgument(i);
    }
}
