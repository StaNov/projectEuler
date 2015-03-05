package euler43_specialpandigitals;

/**
 *
 * @author StaNov
 */
public class Test {
    
    public static void main(String[] args) {
        Pandigital number = new PandigitalLong(new int[] {0,1,2,3,4,5,6,7,8,9});
        
        System.out.println(number.getDigitAtIndex(5));
    }
}
