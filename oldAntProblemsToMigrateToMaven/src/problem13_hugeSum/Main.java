/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem13_hugeSum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int[] sum = new int[100];
        Arrays.fill(sum, 0);

        int[] num = new int[100];
        Arrays.fill(num, 0);

        BufferedReader reader = new BufferedReader(new FileReader("numbersToSum.data"));
        String line;

        for(int j = 0; j < 100; j++) {

            line = reader.readLine();

            for(int i = 50; i < 100; i++) {
                num[i] = Integer.parseInt(line.charAt(i-50) + "");
            }

            sum = sum(sum,num);
        }


        System.out.print("And the answer is: ");

        int beginIndex = 0;
        for(int i = 0; sum[i] == 0; i++) {
            beginIndex = i + 1;
        }

        for(int i = beginIndex; i < beginIndex + 10; i++) {
            System.out.print(sum[i]);
        }

        System.out.println("!");
        
    }

    private static int[] sum(int[] sum, int[] num) {

        for(int i = 99; i > 0; i--) {
            sum[i] += num[i];
            if(sum[i] > 9) {
                sum[i]   -= 10;
                sum[i-1] +=  1;
            }
        }

        return sum;
    }


}
