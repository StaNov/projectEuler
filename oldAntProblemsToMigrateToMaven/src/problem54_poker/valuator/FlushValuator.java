package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class FlushValuator extends AbstractValuator {

    public FlushValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    /**
     * Zkouší, zda jsou všechny karty stejného druhu.
     *
     * @return true, pokud ano, false jinak
     */
    public boolean valuate() {
        for (int i = 1; i < 5; i++) { // od druhé do poslední
            if (cards[i].getSuit() != cards[0].getSuit()) // nultá a i-tá karta jsou jiného druhu
                return false;
        }

        value.setValue(0); // všechny jsou stejného druhu
        return true;
    }

}
