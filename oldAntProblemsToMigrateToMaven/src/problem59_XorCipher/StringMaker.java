package problem59_XorCipher;

/**
 *
 * @author StaNov
 */
public class StringMaker {

    public static String makeString(int[] input) {
        StringBuilder sb = new StringBuilder();
        for(int i : input) {
            char ch = (char) i;
            sb.append(ch);
        }

        return sb.toString();
    }

}
