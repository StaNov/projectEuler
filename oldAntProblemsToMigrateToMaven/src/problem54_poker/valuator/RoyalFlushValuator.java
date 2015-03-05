package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.CardSuit;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class RoyalFlushValuator extends AbstractValuator {

    public RoyalFlushValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    public boolean valuate() {

        CardSuit[] s = new CardSuit[5];
        int[] v = new int[5];
        fillArrays(s, v);

        for(int i = 1; i < 5; i++) { // test na stejnou barvu
            if(s[i] != s[0]) return false; // barvy se liší, není to flush
        }

        for(int i = 1; i < 5; i++) { // test na postupku
            if(v[i] != v[0] + i) return false; // není to postupka
        }

        if(v[4] != Card.MAX_VALUE) {
            return false; // není to royal = nejvyšší možná
        }

        value.setValue(v[4]); // nejvyšší karta v postupce
        return true;
    }



    private void fillArrays(CardSuit[] s, int[] v) {
        for(int i = 0; i < 5; i++) {
            s[i] = cards[i].getSuit();
            v[i] = cards[i].getValue();
        }
    }

}
