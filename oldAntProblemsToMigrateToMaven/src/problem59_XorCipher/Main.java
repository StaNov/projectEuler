package problem59_XorCipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author StaNov
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
         * 1. Vygeneruj všechny možné zprávy
         * 2. Na výstup vypiš jen ty, které obsahují podřetězec "the"
         */
        System.out.print("Reading text...");
        int[] message = Reader.read(new File("cipher1.txt"));
        System.out.println(" OK");

        System.out.println("Searching for the sentence...");
        for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                for (char ch3 = 'a'; ch3 <= 'z'; ch3++) {
                    int[] key = new int[] {(int) ch1, (int) ch2, (int) ch3};
                    int[] xored = Xorer.xor(message, key);
                    String deciphredMessage = StringMaker.makeString(xored);

                    if(isMadeFromLetters(deciphredMessage)) {
                        System.out.println("key " + ch1 + "" + ch2 + "" + ch3 + ": " + deciphredMessage + "\n    sum: " + getSumOfMessageChars(xored));
                    }
                    
                }
            }
        }
    }

    private static boolean isMadeFromLetters(String input) {

        char[] charAr = input.toCharArray();
        for(char ch : charAr) {
            if(ch < ' ' || ch > 'z') {
                return false;
            }
        }
        return true;
    }

    private static int getSumOfMessageChars(int[] input) {

        int result = 0;

        for(int i : input) {
            result += i;
        }

        return result;
    }
}
