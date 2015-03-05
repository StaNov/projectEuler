package problem54_poker.valuator;

import java.util.Arrays;
import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class StraightValuator extends AbstractValuator {

    public StraightValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    public boolean valuate() {

        int[] v = new int[5];
        for(int i = 0; i < 5; i++) v[i] = cards[i].getValue();

        if (v[1] == v[0] + 1
                && v[2] == v[1] + 1
                && v[3] == v[2] + 1
                && v[4] == v[3] + 1) { // nalezena postupka

            value.setValue(v[4]); // nejvyšší karta z postupky
            return true;
        }

        // test na postupku, eso jako jednička
        if(Arrays.equals(v, new int[] {2, 3, 4, 5, 14})) {
            value.setValue(5);
            return true;
        }

        return false; // postupka nenalezena
    }

}
