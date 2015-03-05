/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("d:/product.lol"));
            String numbers = "";

            String readline;
            while((readline = reader.readLine()) != null) {
                numbers += readline;
            }

            int x1 = Integer.parseInt("" + numbers.charAt(0));
            int x2 = Integer.parseInt("" + numbers.charAt(1));
            int x3 = Integer.parseInt("" + numbers.charAt(2));
            int x4 = Integer.parseInt("" + numbers.charAt(3));
            int x5 = Integer.parseInt("" + numbers.charAt(4));

            int max = x1 * x2 * x3 * x4 * x5;

            for (int i = 5; i < 1000; i++) {
                x1 = x2;
                x2 = x3;
                x3 = x4;
                x4 = x5;
                x5 = Integer.parseInt("" + numbers.charAt(i));

                if (x1 * x2 * x3 * x4 * x5 > max) {
                    max = x1 * x2 * x3 * x4 * x5;
                }
            }

            System.out.println("And the winnering product is: " + max);

        } catch (FileNotFoundException ex) {
            System.err.println("File not found kurva!");
        } catch (IOException ex) {
            System.err.println("IOException occured...");
        }

    }
}
