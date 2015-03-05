package euler43_specialpandigitals;

/**
 *
 * @author StaNov
 */
public interface Pandigital {

    
    
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
    public boolean isSpecial();
    
    
    public long toLong();
    
    
    @Override
    public String toString();
    
    /**
     * Indexuje se od nuly.
     */
    public int getDigitAtIndex(int index);
    
    
    public boolean startsWithZero();
}
