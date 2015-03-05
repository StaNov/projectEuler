package euler43_specialpandigitals;

import java.util.Arrays;
import static euler43_specialpandigitals.Main.*;

/**
 *
 * @author StaNov
 */
public class PandigitalArray implements Pandigital {
    
    private final int[] digits;
    
    
    public PandigitalArray(int[] digitsInput) {
        if(digitsInput.length != DIGITS) {
            throw new RuntimeException("Vstupní pole musí obsahovat " + DIGITS + " číslic!");
        }
        
        digits = Arrays.copyOf(digitsInput, DIGITS);
    }
    
    
    /**
     * Vrací TRUE, pokud splňuje následující podmínky:
     * 
     * d2d3d4=406 is divisible by 2
     * d3d4d5=063 is divisible by 3
     * d4d5d6=635 is divisible by 5
     * d5d6d7=357 is divisible by 7
     * d6d7d8=572 is divisible by 11
     * d7d8d9=728 is divisible by 13
     * d8d9d10=289 is divisible by 17
     */
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
        int testingNumber = 100 * digits[startIndex - 1] +
                            10  * digits[startIndex + 0] +
                            1   * digits[startIndex + 1];
        
        return testingNumber % divisor == 0;
    }
    
    
    @Override
    public long toLong() {
        long result = 0;
        
        for(int i = 0; i < DIGITS; i++) {
            result += digits[i] * Math.pow(10, DIGITS - (i + 1));
        }
        
        return result;
    }
    
    
    @Override
    public String toString() {
        return String.valueOf(toLong());
    }
    
    
    @Override
    public boolean startsWithZero() {
        return digits[0] == 0;
    }

    @Override
    public int getDigitAtIndex(int index) {
        return digits[index];
    }
    
}
