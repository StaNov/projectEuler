package euler43_specialpandigitals;

/**
 *
 * @author StaNov
 */
public class TenPowerator {
    
    private static long[] tens = new long[11];
    
    static {
        for(int i = 0; i < 11; i++) {
            tens[i] = (long) Math.pow(10, i);
        }
    }
    
    public static long tenTo(int exp) {
        return tens[exp];
    }
}
