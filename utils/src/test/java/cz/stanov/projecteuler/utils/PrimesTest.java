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
package cz.stanov.projecteuler.utils;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PrimesTest extends AbstractTest {

    @Autowired
    private Primes primes;

    @Test
    public void testGeneratePrimes_zero() {
        List<Long> primesList = primes.generatePrimes(0);

        Assert.assertEquals(0, primesList.size());
    }

    @Test
    public void testGeneratePrimes_six() {
        List<Long> primesList = primes.generatePrimes(7);
        List<Long> expected = Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L);

        Assert.assertEquals(expected, primesList);
    }
}
