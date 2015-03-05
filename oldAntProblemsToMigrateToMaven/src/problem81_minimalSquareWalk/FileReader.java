package problem81_minimalSquareWalk;

import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author StaNov
 */
public class FileReader {

    public static int[][] readMatrix() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(new File("matrix.txt")));
            int[][] rows = null;
            
            String line;
            int rowNumber = 0;
            while((line = reader.readLine()) != null) {
                String[] numbersString = line.split(",");
                if(rows == null) rows = new int[numbersString.length][numbersString.length];
                int[] lineNumbers = new int[numbersString.length];
                for(int i = 0; i < numbersString.length; i++) {
                    lineNumbers[i] = Integer.parseInt(numbersString[i]);
                }
                rows[rowNumber] = lineNumbers;
                rowNumber++;
            }

            return rows;

        } catch (Exception ex) {
            System.err.println("ZESRALO SE NACITANI!!! " + ex);
        }

        throw new RuntimeException("Něco se zesralo");
        
    }

}
