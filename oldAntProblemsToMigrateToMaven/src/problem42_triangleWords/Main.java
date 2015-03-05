/*
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value.
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word
 * value is a triangle number then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
 * containing nearly two-thousand common English words, how many are triangle
 * words?
 */

package problem42_triangleWords;

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

        SortedSet<String> words = loadWords();
        int count = 0;

        for(String word : words) {
            if(isTriangle(stringToInt(word))) {
                count++;
                System.out.println("New triangle word: " + word + ", " + count +
                        " in total.");
            }
        }

        System.out.println("And the result is " + count + "!!!");

    }

    private static boolean isTriangle(int n) {

        int i = 1;
        int actNum = 2;

        while(i <= n) {

            if(i == n) {
                return true;
            }

            i += actNum;
            actNum++;
        }

        return false;
    }

    private static int stringToInt(String name) {

        int result = 0;
        int charInt;

        //System.out.print(name + " = ");
        for(int i = 0; i < name.length(); i++) {
            charInt = (int) name.charAt(i) - 64;
            result += charInt;
            //System.out.print(charInt + " + ");
        }

        //System.out.println();
        return result;
    }

    private static SortedSet<String> loadWords() throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));

        String loaded = reader.readLine();
        String[] splited = loaded.split("\",\"");

        SortedSet<String> words = new TreeSet<String>();

        for(String s : splited) {
            words.add(s);
        }

        return words;

    }
}
