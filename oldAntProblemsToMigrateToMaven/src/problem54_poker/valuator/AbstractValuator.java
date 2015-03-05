package problem54_poker.valuator;

import java.util.Arrays;
import java.util.Comparator;
import problem54_poker.Card;
import problem54_poker.HandValue;

/**
 *
 * @author StaNov
 */
public abstract class AbstractValuator {

    protected Card[] cards;
    protected HandValue value;

    /**
     * Konstruktor, který vytvoří pětiprvkové pole karet seřazené podle hodnoty
     * od nejnižší po nejvyšší.
     *
     * @param cards
     * @param value
     */
    public AbstractValuator(Card[] cards, HandValue value) {
        this.value = value;
        this.cards = Arrays.copyOf(cards, cards.length);

        Arrays.sort(this.cards, new Comparator<Card>() {

            public int compare(Card o1, Card o2) {
                return o1.getValue() - o2.getValue();
            }

        });
    }

    public AbstractValuator() {
        throw new RuntimeException("Tenhle konstruktor se nepoužívá.");
    }

    /**
     * Testuje, zda karty v ruce tvoří nějakou kombinaci. Pokud ano, do proměnné
     * value.value nastaví hodnotu kombinace vrámci svého testování a vrátí true.
     * Jinak vrátí false a nic nenastaví.
     *
     * @return true, pokud kombinace karet odpovídá testované kombinaci,
     * false jinak
     */
    public abstract boolean valuate();
}
