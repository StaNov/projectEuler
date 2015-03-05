/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem67_hugeTriangel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.print("Starting making the tree...");
        int[][] tree = makeTree();
        System.out.println(" OK\n");


        for (int i = 99; i >= 0; i--) {
            System.out.print("Removing line " + (i + 1) + "...");
            removeLine(i, tree);
            System.out.println(" OK");
        }

        System.out.println("\nAnd the result is: " + tree[0][0] + "!!!");

    }

    private static int[][] makeTree() throws FileNotFoundException, IOException {

        int[][] tree = new int[100][100];
        BufferedReader reader = new BufferedReader(new FileReader("triangle67.txt"));

        // 'i' je radek, 'j' je sloupec
        for (int i = 0; i < 100; i++) {
            String[] values = (reader.readLine()).split(" ");

            for (int j = 0; j <= i; j++) {
                tree[i][j] = Integer.parseInt(values[j]);
            }
        }


        return tree;
    }

    private static void removeLine(int line, int[][] tree) {

        for(int i = 0; i < line; i++) {
            tree[line - 1][i] += Math.max(tree[line][i], tree[line][i + 1]);
        }
    }
}
