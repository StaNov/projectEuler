package problem54_poker;

/**
 * Karta.
 *
 * @author StaNov
 */
public class Card {

    public static final int MAX_VALUE = 14;

    // 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 (Jack), 12 (Queen), (13) King, (14) Ace
    private int value;

    private CardSuit suit;

    public Card(String cardStr) {
        value = getValue(cardStr.charAt(0));
        suit = getSuit(cardStr.charAt(1));
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String valueStr;
        switch (value) {
            case 10:
                valueStr = "T";
                break;
            case 11:
                valueStr = "J";
                break;
            case 12:
                valueStr = "Q";
                break;
            case 13:
                valueStr = "K";
                break;
            case 14:
                valueStr = "A";
                break;
            default:
                valueStr = "" + value;
                break;
        }

        String suitStr = null;
        switch (suit) {
            case clubs:
                suitStr = "♣";
                break;
            case diamonds:
                suitStr = "♦";
                break;
            case hearts:
                suitStr = "♥";
                break;
            case spades:
                suitStr = "♠";
                break;
        }

        return valueStr + suitStr;
    }





    /**
     * Vrátí hodnotu karty podle znaku v argumentu.
     *
     * @param charr
     * @return
     */
    private static int getValue(char charr) {
        switch (charr) {
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
        }

        int val = Integer.parseInt(String.valueOf(charr));

        if(val < 2 || val > 9)
            throw new RuntimeException("Hodnota musí být mezi 2 a 10!");
        
        return val;

    }

    /**
     * Vrátí typ karty podle znaku vloženém v argumentu.
     *
     * @param charr
     * @return
     */
    private static CardSuit getSuit(char charr) {
        switch (charr) {
            case 'C':
                return CardSuit.clubs;
            case 'D':
                return CardSuit.diamonds;
            case 'H':
                return CardSuit.hearts;
            case 'S':
                return CardSuit.spades;
            default:
                throw new RuntimeException("Označení karty nebylo rozpoznáno!");

        }
    }
}
