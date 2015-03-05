package problem54_poker;

import java.util.Arrays;
import problem54_poker.valuator.AbstractValuator;
import problem54_poker.valuator.FlushValuator;
import problem54_poker.valuator.FourOfKindValuator;
import problem54_poker.valuator.FullHouseValuator;
import problem54_poker.valuator.OnePairValuator;
import problem54_poker.valuator.RoyalFlushValuator;
import problem54_poker.valuator.StraightFlushValuator;
import problem54_poker.valuator.StraightValuator;
import problem54_poker.valuator.ThreeOfKindValuator;
import problem54_poker.valuator.TwoPairsValuator;

/**
 * Ohodnocuje ruku podle karet v ní.
 *
 * @author StaNov
 */
class HandValuator {

    private Card[] cards;
    
    public HandValuator(Hand hand) {
        this.cards = hand.getCards();
    }

    /**
     * Vrací hodnotu karet v ruce ve tvaru cvvhh, kde
     *      'c' značí kombinaci karet
     *      'v' značí hodnotu kombinace karet
     *      'h' značí nejvyšší kartu v ruce
     *
     * @return
     */
    public HandValue getValue() {
        HandValue value = new HandValue(createCardValues());
        AbstractValuator valuator = null; // valuator, který se zrovna používá

        for(int i = 9; i > 0; i--) {
            switch (i) {
                case 9:
                    valuator = new RoyalFlushValuator(cards, value);
                    break;
                case 8: 
                    valuator = new StraightFlushValuator(cards, value);
                    break;
                case 7: 
                    valuator = new FourOfKindValuator(cards, value);
                    break;
                case 6: 
                    valuator = new FullHouseValuator(cards, value);
                    break;
                case 5: 
                    valuator = new FlushValuator(cards, value);
                    break;
                case 4: 
                    valuator = new StraightValuator(cards, value);
                    break;
                case 3: 
                    valuator = new ThreeOfKindValuator(cards, value);
                    break;
                case 2: 
                    valuator = new TwoPairsValuator(cards, value);
                    break;
                case 1: 
                    valuator = new OnePairValuator(cards, value);
                    break;
            }

            boolean ok = valuator.valuate();

            if(ok) {
                value.setType(i);
                return value;
            }
        }

        // nenašla se žádná kombinace, hraje se na nejvyšší kartu
        value.setType(0);
        value.setValue(0);
        return value;
    }


    /**
     * Vytvoří pětiprvkové pole hodnot karet v ruce od nejvyšší
     * po nejnižší.
     */
    private int[] createCardValues() {
        int[] cardValues = new int[5];

        for (int i = 0; i < 5; i++) {
            cardValues[i] = cards[i].getValue();
        }

        Arrays.sort(cardValues);

        int[] cardValuesDesc = new int[5];

        for(int i = 0; i < 5; i++) {
            cardValuesDesc[i] = cardValues[4-i];
        }

        return cardValuesDesc;
    }
}
