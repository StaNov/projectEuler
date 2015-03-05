/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem25_fibonacci;

import java.util.Arrays;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        System.out.print("Creating arrays...");
        int[][] array = new int[3][1001];

        Arrays.fill(array[0], 0);
        Arrays.fill(array[1], 0);
        Arrays.fill(array[2], 0);

        array[0][1000] = 1;
        array[1][1000] = 1;
        array[2][1000] = 2;
        System.out.println(" OK");

        int index = 2;

        while (array[index % 3][1] == 0) {
            index++;
            array[index % 3] = sumArrays(array[(index + 1) % 3], array[(index + 2) % 3]);
            System.out.println("Tried index " + (index+1) + " with value " + arrayToString(array[index % 3]));
        }

        System.out.println("And the winning index is " + (index+1) + "!!!");
    }


    public static int[] sumArrays(int[] a1, int[] a2) {

        if (a1.length != a2.length) {
            return null;
        }

        int[] result = new int[a1.length];

        for(int i = a1.length - 1; i >= 0; i--) {
            result[i] = a1[i] + a2[i] + result[i];
            if (result[i] > 9) {
                (result[i-1])++;
                result[i] -= 10;
            }
        }

        return result;

    }


    public static String arrayToString(int[] array) {

        int begin = 0;
        String result = "";

        while(begin < array.length && array[begin] == 0) begin++;

        if (begin == array.length) return "0";

        for(int i = begin; i < array.length; i++) {
            result += array[i];
        }

        return result;
    }

}
