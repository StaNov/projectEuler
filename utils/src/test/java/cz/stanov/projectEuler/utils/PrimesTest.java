/**
 * ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ $today.year ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * ===========================================================================
 */
package cz.stanov.projectEuler.utils;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PrimesTest {

    @Test
    public void testGeneratePrimes_zero() {
        List<Long> primes = Primes.generatePrimes(0);

        Assert.assertEquals(0, primes.size());
    }

    @Test
    public void testGeneratePrimes_six() {
        List<Long> primes = Primes.generatePrimes(7);
        List<Long> expected = Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L);

        Assert.assertEquals(expected, primes);
    }
}
