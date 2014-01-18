package cz.stanov.projecteuler.utils;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * A test class for the help classes.
 *
 * @author Novák Stanislav
 */
// TODO dat pryč, nahradit testem
public class Test {

    private static final Logger LOG = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        PandigitalCreator creator = new PandigitalCreator(9,true);
        List<Long> pandigitals = creator.getPandigitals();

        int size = pandigitals.size();
        LOG.info(size);
        for(int i = size - 200; i < size; i++) {
            LOG.info(pandigitals.get(i));
        }
       
    }

    private Test() {}
}
