/*
 * It was proposed by Christian Goldbach that every odd composite number can be
 * written as the sum of a prime and twice a square.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum
 * of a prime and twice a square?
 */
package problem46_primePlusSquare;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    /*
     * První představy:
     * * pojedou dvě vlákna
     * * první vlákno bude generovat čísla, která se dají poskládat podle
     *   způsobu popsaného výše
     * * druhé vlánko bude periodicky zjišťovat, jaké nejmenší liché číslo
         v generované kolekci není obsaženo
     * * pokud druhé vlákno najde dvakrát stejné číslo, dá jej na výstup jako
     *   výsledek a skončí
     */
    public static void main(String[] args) {

        Set<Long> generatedNumbers =
                Collections.synchronizedSet(new HashSet<Long>());

        Thread generator = new Thread(new Generator(generatedNumbers));
        generator.setName("Generator");
        Thread checker = new Thread(new Checker(500, generatedNumbers));
        checker.setName("Checker");

        System.out.println("Starting generator...");
        generator.start();
        checker.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Starting checker...");
        checker.start();
    }

}
