package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class FourOfKindValuator extends AbstractValuator {

    public FourOfKindValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    public boolean valuate() {

        int[] v = new int[] {
            cards[0].getValue(),
            cards[1].getValue(),
            cards[2].getValue(),
            cards[3].getValue(),
            cards[4].getValue(),
        };

        for(int i = 0; i < 2; i++) { // jen dvě možnosti
            if (v[i] == v[i+1]
                    && v[i] == v[i+2]
                    && v[i] == v[i+3]
                    ) { // nalezena čtveřice
                value.setValue(v[i]);
                return true;
            }
        }

        return false;
    }

}
