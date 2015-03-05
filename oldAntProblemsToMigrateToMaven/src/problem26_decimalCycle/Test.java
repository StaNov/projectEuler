package problem26_decimalCycle;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Novák Stanislav
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal bd1 = new BigDecimal(1);
        BigDecimal bd2 = new BigDecimal(9);

        BigDecimal frac = bd1.divide(bd2,100,0);
        String fracStr = frac.toPlainString();
        char[] charAr = fracStr.toCharArray();

        System.out.println(charAr);

        /*BigDecimal fraction = new BigDecimal(new BigInteger("1"), 1000000);

        System.out.println(fraction.toPlainString());*/

    }

}
