package euler43_specialpandigitals;

import static euler43_specialpandigitals.Main.*;

/**
 *
 * @author StaNov
 */
public class PandigitalLong implements Pandigital {
    
    private final long value;

    public PandigitalLong(int[] digits) {
        long valueTmp = 0L;
        
        for(int i = 0; i < DIGITS; i++) {
            valueTmp += digits[i] * TenPowerator.tenTo(DIGITS - (i + 1));
        }
        
        value = valueTmp;
    }

    @Override
    public boolean isSpecial() {
        return
                hasSpecialProperty(2, 2 ) &&
                hasSpecialProperty(3, 3 ) &&
                hasSpecialProperty(4, 5 ) &&
                hasSpecialProperty(5, 7 ) &&
                hasSpecialProperty(6, 11) &&
                hasSpecialProperty(7, 13) &&
                hasSpecialProperty(8, 17) ;
    }
    
    
    /**
     * Vrátí TRUE, pokud je trojciferné číslo začínající na pozici startIndex
     * dělitelné číslem divisor. Indexuje se podle zadání, tedy od 1.
     */
    private boolean hasSpecialProperty(int startIndex, int divisor) {
        int testingNumber = 100 * getDigitAtIndex(startIndex - 1) +
                            10  * getDigitAtIndex(startIndex + 0) +
                            1   * getDigitAtIndex(startIndex + 1);
        
        return testingNumber % divisor == 0;
    }

    @Override
    public long toLong() {
        return value;
    }

    @Override
    public boolean startsWithZero() {
        //long firstDigit = value / TenPowerator.tenTo(DIGITS - 1);
        
        //return firstDigit == 0;
        
        return value < 1000000000L;
    }

    @Override
    public int getDigitAtIndex(int index) {
        long head = value / TenPowerator.tenTo(DIGITS - (index + 1));
        
        return (int) (head % 10);
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
}
