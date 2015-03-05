package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class OnePairValuator extends AbstractValuator {

    public OnePairValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    /**
     * Zjišťuje přítomnost jedné dvojice v ruce. Předpokládá se, že pokud
     * je v ruce jedna dvojice, je tam pouze jedna, tím pádem ta nejvyšší.
     * Dále se předpokládá, že karty v poli cards jsou seřazeny od nejnižší
     * po nejvyšší, což zajišťuje konstruktor.
     *
     * @return true, pokud rozdání obsahuje dvojici, jinak false
     */
    public boolean valuate() {

        for (int i = 0; i < 4; i++) { // pouze po předposlední
            int valuei = cards[i].getValue();
            int valuej = cards[i+1].getValue();
            
            if(valuei == valuej) {
                value.setValue(valuei);
                return true;
            }
        }

        return false; // nebyla nalezena žádná dvojice
    }
}
