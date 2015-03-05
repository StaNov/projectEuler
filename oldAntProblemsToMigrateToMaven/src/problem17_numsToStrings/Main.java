/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four,
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written
 * out in words, how many letters would be used?
 *
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred
 * and forty-two) contains 23 letters and 115 (one hundred and fifteen)
 * contains 20 letters. The use of "and" when writing out numbers is in
 * compliance with British usage.
 */

package problem17_numsToStrings;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        int sum = 0;
        String numStr;

        for(int i = 1; i <= 1000; i++) {
            numStr = intToString(i);
            sum += numStr.length();

            System.out.println(i
                    + ": "
                    + numStr);

        }

        System.out.println("And the sum is: " + sum);

    }

    private static String intToString(int n) {

        String result = "";

        result += thousandsToString(n);
        result += hundredsToString(n);
        result += tensToString(n);

        return result;
    }

    private static String thousandsToString(int n) {

        int noOfThousands = (n % 10000) / 1000;

        if(noOfThousands == 0) {
            return "";
            //return unitsToString(noOfThousands) + "tisíc";
        }
        
        if(noOfThousands == 1) {
            return "tisíc";
        }

        return "tisíce";
    }

    private static String hundredsToString(int n) {

        int noOfHundreds = (n % 1000) / 100;

        if(noOfHundreds == 0) {
            return "";
        }
        
        if(noOfHundreds == 1) {
            return "sto";
        }
        
        /*if(noOfHundreds > 0) {
            String result = unitsToString(noOfHundreds) + "sto";

            if(n % 100 != 0) {
                //result += "and";
            }

            return result;
        }*/

        return unitsToString(noOfHundreds) + "stě";
    }

    private static String tensToString(int n) {

        int units = n % 100;
        int tens = units / 10;

        if(tens == 0) {
            return unitsToString(units);
        }

        if(tens == 1) {
            return teensToString(units);
        }

        if(tens == 2) {
            return "dvacet" + unitsToString(units);
        }

        if(tens == 3) {
            return "třicet" + unitsToString(units);
        }

        if(tens == 4) {
            return "čtyřicet" + unitsToString(units);
        }

        if(tens == 5) {
            return "padesát" + unitsToString(units);
        }

        if(tens == 6) {
            return "šedesát" + unitsToString(units);
        }

        if(tens == 7) {
            return "sedmdesát" + unitsToString(units);
        }

        if(tens == 8) {
            return "osmdesát" + unitsToString(units);
        }

        if(tens == 9) {
            return "devadesát" + unitsToString(units);
        }

        throw new IllegalArgumentException("Something happened...");

    }

    private static String unitsToString(int n) {

        int units = n % 10;

        if(units == 1) {
            return "jedna";
        }

        if(units == 2) {
            return "dva";
        }

        if(units == 3) {
            return "tři";
        }

        if(units == 4) {
            return "čtyři";
        }

        if(units == 5) {
            return "pět";
        }

        if(units == 6) {
            return "šest";
        }

        if(units == 7) {
            return "sedm";
        }

        if(units == 8) {
            return "osm";
        }

        if(units == 9) {
            return "devět";
        }

        return "";
    }

    private static String teensToString(int n) {

        if(n == 10) {
            return "deset";
        }

        if(n == 11) {
            return "jedenáct";
        }

        if(n == 12) {
            return "dvanáct";
        }

        if(n == 13) {
            return "třináct";
        }

        if(n == 14) {
            return "čtrnáct";
        }

        if(n == 15) {
            return "patnáct";
        }

        if(n == 16) {
            return "šestnáct";
        }

        if(n == 17) {
            return "sedmnáct";
        }

        if(n == 18) {
            return "osmnáct";
        }

        if(n == 19) {
            return "devatenáct";
        }

        throw new IllegalArgumentException("argument is not teen");
    }
}
