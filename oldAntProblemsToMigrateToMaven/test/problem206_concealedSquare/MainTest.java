/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problem206_concealedSquare;

import AAASLOWproblem206_concealedSquare.Main;
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
     * Test of isResult method, of class Main.
     */
    /*@Test
    public void testIsResult() {

        assertTrue(Main.isResult(1020304050607080900L));
        assertTrue(Main.isResult(1728374857647284910L));
        assertFalse(Main.isResult(1728375857647284910L));
        assertFalse(Main.isResult(1728374857647204910L));
    }*/

    @Test
    public void testGetSquare() {

        assertEquals(1122334455667788990L, Main.getSquare(123456789));
        assertEquals(1928374655647382910L, Main.getSquare(987654321));
    }

}