import java.util.Arrays;
import java.util.List;

import cz.stanov.projectEuler.problem125.PalindromicNumbersCreator;
import cz.stanov.projectEuler.problem125.ResultComputer;
import cz.stanov.projectEuler.utils.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.*;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@ContextConfiguration("/context.xml")
public class ResultComputerTest extends AbstractTest {

    private static final List<Long> MOCKED_RESULT = Arrays.asList(1L, 2L, 3L);
    private static final long MOCKED_RESULT_SUM = 6;

    @Autowired
    @InjectMocks
    private ResultComputer resultComputer;

    @Mock
    private PalindromicNumbersCreator palindromicNumbersCreator;

    @Before
    public void before() {
        when(palindromicNumbersCreator.findPalindromicNumbersBelow(anyLong())).thenReturn(MOCKED_RESULT);
    }

    @Test
    public void testResultComputer() {
        Assert.assertEquals(MOCKED_RESULT_SUM, resultComputer.computeResultForArgument(10));
    }
}
