/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem50_consecutivePrimes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Novák Stanislav
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

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testFindSum() {

        assertEquals(41, Main.findSum(100));
        assertEquals(953, Main.findSum(1000));
    }

}