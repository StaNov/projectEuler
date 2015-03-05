/*
 * An irrational decimal fraction is created by concatenating the positive
 * integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value
 * of the following expression.
 *
 * d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000
 */

package problem40_decimalNumbers;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder(1000000);

        for(int i = 0; builder.length() <= 1000000; i++) {
            builder.append(i);
        }

        long sum = 1;

        sum *= Integer.parseInt(builder.charAt(1) + "");
        sum *= Integer.parseInt(builder.charAt(10) + "");
        sum *= Integer.parseInt(builder.charAt(100) + "");
        sum *= Integer.parseInt(builder.charAt(1000) + "");
        sum *= Integer.parseInt(builder.charAt(10000) + "");
        sum *= Integer.parseInt(builder.charAt(100000) + "");
        sum *= Integer.parseInt(builder.charAt(1000000) + "");

        System.out.println("Result: " + sum);
        
    }

}
