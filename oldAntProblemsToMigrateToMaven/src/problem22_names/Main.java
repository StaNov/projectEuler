/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem22_names;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        SortedSet<String> names = loadNames();

        int index = 1;
        int sum   = 0;
        int intFromString;

        for(String s : names) {
            intFromString = stringToInt(s);
            sum += index * intFromString;
            System.out.println("Added " + s + " with value " + index + " * " + intFromString + " = " + index * intFromString);
            index++;
        }



        System.out.println("And the sum is " + sum + "!!!");

    }

    private static SortedSet<String> loadNames() throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("names.txt"));

        String loaded = reader.readLine();
        String[] splited = loaded.split("\",\"");

        SortedSet<String> names = new TreeSet<String>();

        for(String s : splited) {
            names.add(s);
        }

        return names;

    }


    private static int stringToInt(String name) {

        int result = 0;
        int charInt;

        System.out.print(name + " = ");
        for(int i = 0; i < name.length(); i++) {
            charInt = (int) name.charAt(i) - 64;
            result += charInt;
            System.out.print(charInt + " + ");
        }

        System.out.println();
        return result;
    }

}
