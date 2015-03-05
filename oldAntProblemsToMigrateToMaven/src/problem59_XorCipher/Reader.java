package problem59_XorCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author StaNov
 */
public class Reader {

    /**
     * Přečte soubor a vrátí jej v poli intů.
     *
     * @param file
     * @return
     */
    public static int[] read(File file) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        String message = reader.readLine();
        reader.close();
        
        String[] stringAr = message.split(",");
        int[] result = new int[stringAr.length];
        
        for(int i = 0; i < stringAr.length; i++) {
        //for(String str : stringAr) {
            //char ch = stringAr[i].toCharArray()[0];
            result[i] = Integer.parseInt(stringAr[i]); //(int) ch;
        }
        
        return result;
    }
}
