package problem59_XorCipher;

/**
 *
 * @author StaNov
 */
public class Xorer {

    /**
     * zXORuje zprávu a klíč, vrátí zXORovanou zprávu.
     * 
     * @param message
     * @param key
     * @return
     */
    public static int[] xor(int[] message, int[] key) {

        int[] result = new int[message.length];

        for(int i = 0; i < message.length; i++) {
            result[i] = message[i] ^ key[i % key.length];
        }

        return result;
    }
}
