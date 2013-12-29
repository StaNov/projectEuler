package cz.stanov.projectEuler.euler60;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class MainTest {
    @Test
    public void testGetResultForArgument_4() throws Exception {
        long result = Main.getResultForArgument(4);

        Assert.assertEquals(792, result);
    }
}
