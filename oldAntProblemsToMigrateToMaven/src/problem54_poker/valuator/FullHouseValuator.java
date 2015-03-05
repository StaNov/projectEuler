package problem54_poker.valuator;

import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public class FullHouseValuator extends AbstractValuator {

    public FullHouseValuator(Card[] cards, HandValue value) {
        super(cards, value);
    }

    /**
     * Zkouší, zda karty tvoří full house. Pokud ano, do proměnné value uloží
     * dvojprvkové pole tvořené hodnotou trojice a hodnotou dvojice.
     *
     * @return true, pokud karty tvoří full house, jinak false
     */
    public boolean valuate() {

        int value1 = cards[0].getValue();
        int value2 = cards[1].getValue();
        int value3 = cards[2].getValue();
        int value4 = cards[3].getValue();
        int value5 = cards[4].getValue();

        if ((value1 == value2
                && value1 == value3
                && value4 == value5) // trojice a dvojice
             ||
                (value1 == value2
                && value3 == value4
                && value3 == value5) // dvojice a trojice

            ) { // je to full house

            value.setValue(value3);

            return true;
        }

        return false; // není to full house
    }

}
