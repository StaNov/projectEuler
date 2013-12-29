package cz.stanov.projectEuler.utils;

import java.util.List;

/**
 * A test class for the help classes.
 *
 * @author Novák Stanislav
 */
public class Test {

    public static void main(String[] args) {

        PandigitalFactory factory = new PandigitalFactory(9,true);
        List<Long> pandigitals = factory.getPandigitals();

        int size = pandigitals.size();
        System.out.println(size);
        for(int i = size - 200; i < size; i++) {
            System.out.println(pandigitals.get(i));
        }
       
    }
}
