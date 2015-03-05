package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class ThreeOfKindValuator extends AbstractValuator {

    public ThreeOfKindValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    /**
     * Hledá tři karty stejné hodnoty.
     *
     * Předpokládá seřazení karet a neexistenci lepší kombinace (čtveřice)
     *
     * @return true, pokud jsou mezi kartami tři stejné, jinak false
     */
    public boolean valuate() {

        for (int i = 0; i < 3; i++) { // pouze tři možnosti
            int valuei = cards[i].getValue();
            int valuej = cards[i+1].getValue();
            int valuek = cards[i+2].getValue();

            if (valuei == valuej && valuei == valuek) { // nalezena trojice
                value.setValue(valuei);
                return true;
            }
        }

        return false;
    }

}
