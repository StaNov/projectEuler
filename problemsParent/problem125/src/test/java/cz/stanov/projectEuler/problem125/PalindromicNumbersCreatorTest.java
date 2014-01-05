package cz.stanov.projectEuler.problem125;

import java.util.List;

import cz.stanov.projectEuler.utils.SumMaker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class PalindromicNumbersCreatorTest extends AbstractTest {

    @Autowired
    private PalindromicNumbersCreator palindromicNumbersCreator;

    @Autowired
    private SumMaker sumMaker;

    @Test
    public void testFindPalindromicNumbersBelow() {
        List<Long> palindromicNumbersBelow1000 = palindromicNumbersCreator.findPalindromicNumbersBelow(1000);

        assertEquals(11, palindromicNumbersBelow1000.size());
        assertEquals(4164, sumMaker.sum(palindromicNumbersBelow1000));
    }
}
