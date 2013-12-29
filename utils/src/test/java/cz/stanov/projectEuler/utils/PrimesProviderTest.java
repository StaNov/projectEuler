package cz.stanov.projectEuler.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PrimesProviderTest {

    private PrimesProvider primesProviderInitDefault;
    private PrimesProvider primesProviderInit100;

    @Before
    public void setUp() {
        primesProviderInitDefault = new PrimesProvider();
        primesProviderInit100 = new PrimesProvider(100);
    }


    @Test
    public void testNextPrimeInitDefault() throws Exception {
        assertEquals(2, primesProviderInitDefault.nextPrime());
        assertEquals(3, primesProviderInitDefault.nextPrime());
        assertEquals(5, primesProviderInitDefault.nextPrime());
    }

    @Test
    public void testNextPrimeInit100() throws Exception {
        assertEquals(101, primesProviderInit100.nextPrime());
        assertEquals(103, primesProviderInit100.nextPrime());
        assertEquals(107, primesProviderInit100.nextPrime());
    }

    @Test
    public void testResetInitDefault() throws Exception {
        generateSomePrimes(primesProviderInitDefault);
        primesProviderInitDefault.reset();

        assertEquals(2, primesProviderInitDefault.nextPrime());
    }

    @Test
    public void testResetInit100() throws Exception {
        generateSomePrimes(primesProviderInit100);
        primesProviderInit100.reset();

        assertEquals(101, primesProviderInit100.nextPrime());
    }

    private void generateSomePrimes(PrimesProvider primesProvider) {
        for (int i = 0; i < 20; i++) {
            primesProvider.nextPrime();
        }
    }
}
