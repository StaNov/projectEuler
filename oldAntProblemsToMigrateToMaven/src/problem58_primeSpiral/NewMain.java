package problem58_primeSpiral;

/**
 *
 * @author StaNov
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Spiral spiral = new Spiral();
        System.out.println(spiral);
        spiral.enlarge();
        System.out.println(spiral);

        while (spiral.getRatio() > 10) {
            spiral.enlarge();
            System.out.println(spiral);
        }

        System.out.println("\nAnd the result is " + spiral.getSideLength() + "!!!");

    }

}
