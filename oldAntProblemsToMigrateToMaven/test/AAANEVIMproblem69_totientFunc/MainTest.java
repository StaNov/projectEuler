/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AAANEVIMproblem69_totientFunc;

import AAAPOMALEproblem69_totientFunc.Main;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author StaNov
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testFi() {

        assertEquals(Main.fi(2), 1);
        assertEquals(Main.fi(3), 2);
        assertEquals(Main.fi(4), 2);
        assertEquals(Main.fi(5), 4);
        assertEquals(Main.fi(6), 2);
        assertEquals(Main.fi(7), 6);
        assertEquals(Main.fi(8), 4);
        assertEquals(Main.fi(9), 6);
        assertEquals(Main.fi(10), 4);
    }

}