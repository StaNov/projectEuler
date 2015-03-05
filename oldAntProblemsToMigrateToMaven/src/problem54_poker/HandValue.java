package problem54_poker;

/**
 *
 * @author StaNov
 */
public class HandValue implements Comparable<HandValue> {

    /**
     * Typ kombinace karet. 0 pro nejvyšší kartu, 9 pro royal flush.
     */
    private int type;

    /**
     * Hodnota kombinace.
     *
     * U dvou dvojic je zapotřebí uchovat informaci o dvou hodnotách - vyšší
     * a nižší, tedy je ve tvaru xxyy, kde xx je hodnota vyšší váhy a yy je hodnota
     * váhy nižší.
     *
     * Významnější hodnota je uvedena dříve.
     */
    private int value;

    /**
     * Hodnoty karet od nejvyšší po nejnižší.
     */
    private int[] highest;


    public HandValue(int[] highest) {
        this.highest = highest;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int compareTo(HandValue o) {
        /*
         * 1. Porovnat podle typu
         * 2. Porovnat podle hodnot
         * 3. Porovnat podle nejvyšších karet
         */
        if (type != o.type)  return type - o.type;  // (1)

        if (value != o.value)  return value - o.value; // (2)

        for (int i = 0; i < highest.length; i++) {  // (3)
            if(highest[i] != o.highest[i])  return highest[i] - o.highest[i];
        }

        throw new RuntimeException("Hodnoty jsou stejné, to by se nemělo stát.");
    }

    @Override
    public String toString() {
        String result = null;

        switch (type) {
            case 9:
                result = "Royal Flush";
                break;
            case 8:
                result = "Straight Flush";
                break;
            case 7:
                result = "Čtyři stejné";
                break;
            case 6:
                result = "Full House";
                break;
            case 5:
                result = "Flush";
                break;
            case 4:
                result = "Postupka";
                break;
            case 3:
                result = "Trojice";
                break;
            case 2:
                result = "Dvě dvojice";
                break;
            case 1:
                result = "Jedna dvojice";
                break;
            case 0:
                result = "Nejvyšší karta";
                break;
        }

        result += ", " + value;

        return result;
    }

}
