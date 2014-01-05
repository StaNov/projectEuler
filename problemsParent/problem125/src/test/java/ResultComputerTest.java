import cz.stanov.projectEuler.problem125.ResultComputer;
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
    public void testResultComputer() {
        Assert.assertEquals(5, resultComputer.computeResultForArgument(5));
        // TODO
    }
}
