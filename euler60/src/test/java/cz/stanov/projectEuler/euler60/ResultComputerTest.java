package cz.stanov.projectEuler.euler60;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class ResultComputerTest {
    @Test
    public void testGetResultForArgument_4() throws Exception {
        List<Long> result = ResultComputer.findResultPrimes(4);

        Assert.assertEquals(Arrays.asList(3L, 7L, 109L, 673L), result);
    }
}
