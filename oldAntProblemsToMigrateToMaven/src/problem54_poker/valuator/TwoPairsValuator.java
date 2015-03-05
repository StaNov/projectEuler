package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class TwoPairsValuator extends AbstractValuator {

    public TwoPairsValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    /**
     * Otestuje karty na výskyt dvou dvojic.
     *
     * Předpokládá se, že karty jsou seřazeny od nejnižší po nejvyšší a že byly
     * vyloučeny všechny lepší kombinace, tzn. hlavně trojice a čtveřice.
     *
     * @return true, pokud jsou mezi kartami dvě dvojice, jinak false.
     */
    public boolean valuate() {
        int firstPairValue = 0; // hodnota první nalezené dvojice, 0 pokud
                                // ještě žádná dvojice nebyla nalezena

        for(int i = 0; i < 4; i++) {
            int valuei = cards[i].getValue();
            int valuej = cards[i+1].getValue();

            if (valuei == valuej) { // byla nalezena dvojice
                if (firstPairValue != 0) { // tato nalezená dvojice je již druhá
                    value.setValue(valuei*100 + firstPairValue); // xxyy, kde xx je hodnotavyšší dvojice
                                                                 // a yy je hodnota nižší dvojice
                    return true;
                }

                firstPairValue = valuei; // tato nalezená dvojice je první nalezenou, ulož její hodnotu
            }
        }

        return false; // nebyly nalezeny dvě dvojice
    }

}
