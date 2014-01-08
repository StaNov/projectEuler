package cz.stanov.projectEulero.problem60;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public class ResultComputerTest {

    @Autowired
    @InjectMocks
    private ResultComputer resultComputer;

    @Mock
    private PrimesChecker primesChecker;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(primesChecker.primesAreWanted(anyList())).thenReturn(true); // TODO
    }

    @Test
    public void testGetResultForArgument_4() throws Exception {
        List<Long> result = resultComputer.findResultPrimes(4);

        Assert.assertEquals(Arrays.asList(3L, 7L, 109L, 673L), result);
    }
}
