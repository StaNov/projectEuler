/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem11_crossword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) throws IOException {

        int[][] cword = fillCrossWord();

        int max = 0;

        int horizontalSum = calcHorizontal(cword);
        if (horizontalSum > max) max = horizontalSum;

        int verticalSum = calcVertical(cword);
        if (verticalSum > max) max = verticalSum;

        int diagRSum = calcDiagR(cword);
        if (diagRSum > max) max = diagRSum;

        int diagLSum = calcDiagL(cword);
        if (diagLSum > max) max = diagLSum;

        System.out.println("And the result is: " + max);

    }


    private static int[][] fillCrossWord() throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("crossword.data"));

        String line;
        String[] values;
        int[][] result = new int[20][20];

        //i je radek, j je sloupec
        for(int i = 0; i < 20; i++) {
            line = reader.readLine();
            values = line.split(" ");

            for(int j = 0; j < 20; j++) {
                result[i][j] = Integer.parseInt(values[j]);
            }
        }


        return result;
    }

    private static int calcRow(int[] row) {

        int max = 0;
        int sum;

        for (int i = 0; i < 17; i++) {
            sum = row[i] * row[i+1] * row[i+2] * row[i+3];
            if(sum > max) max = sum;
        }

        return max;

    }

    private static int calcColumn(int[][] cword, int j) {

        int max = 0;
        int sum;

        for (int i = 0; i < 17; i++) {
            sum = cword[i][j] * cword[i+1][j] * cword[i+2][j] * cword[i+3][j];
            if(sum > max) max = sum;
        }

        return max;
    }

    private static int calcHorizontal(int[][] array) {

        int max = 0;
        int sum;

        for(int i = 0; i < 20; i++) {
            sum = calcRow(array[i]);
            if(sum > max) max = sum;
        }

        return max;

    }

    private static int calcVertical(int[][] cword) {

        int max = 0;
        int sum;

        for(int j = 0; j < 20; j++) {
            sum = calcColumn(cword,j);
            if(sum > max) max = sum;
        }

        return max;
    }

    private static int calcDiagL(int[][] cword) {

        int max = 0;
        int sum;

        for(int i = 0; i < 17; i++) {
            for(int j = 0; j < 17; j++) {

                sum = cword[i][j+3] * cword[i+1][j+2] * cword[i+2][j+1] * cword[i+3][j];
                if(sum > max) max = sum;
            }
        }

        return max;
    }

    private static int calcDiagR(int[][] cword) {

        int max = 0;
        int sum;

        for(int i = 0; i < 17; i++) {
            for(int j = 0; j < 17; j++) {

                sum = cword[i][j] * cword[i+1][j+1] * cword[i+2][j+2] * cword[i+3][j+3];
                if(sum > max) max = sum;
            }
        }

        return max;
    }

}
