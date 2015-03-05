package problem54_poker;

/**
 * Karty v ruce.
 *
 * @author StaNov
 */
public class Hand implements Comparable<Hand> {

    private Card[] cards;

    public Hand (Card[] cards) {
        if(cards.length != 5)
            throw new RuntimeException(
                    "Parametr cards musi byt petiprvkove pole! "
                    + "Snazis se ulozit pole " + cards + ".");

        this.cards = cards;
    }

    public Hand (String handStr) {
        String[] cardsStr = handStr.split(" ");

        if (cardsStr.length != 5) throw new RuntimeException("Řetězec musí mít pět prvků!");

        cards = new Card[5];

        for(int i = 0; i < 5; i++) {
            cards[i] = new Card(cardsStr[i]);
        }
    }

    public Card[] getCards() {
        return cards;
    }

    public HandValue getValue() {
        HandValuator valuator = new HandValuator(this);
        return valuator.getValue();
    }

    public int compareTo(Hand o) {
        return getValue().compareTo(o.getValue());
    }

    @Override
    public String toString() {
        String result = "[" + cards[0];

        for (int i = 1; i < 5; i++) {
            result += ", " + cards[i];
        }

        result += "] - " + getValue();

        return result;
    }
}




