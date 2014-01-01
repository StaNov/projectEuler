package cz.stanov.projectEuler.euler60;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public class ResultComputerTest {

    @Autowired
    private ResultComputer resultComputer;

    @Test
    public void testGetResultForArgument_4() throws Exception {
        List<Long> result = resultComputer.findResultPrimes(4);

        Assert.assertEquals(Arrays.asList(3L, 7L, 109L, 673L), result);
    }
}
