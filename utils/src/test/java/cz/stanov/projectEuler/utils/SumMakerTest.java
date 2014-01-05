package cz.stanov.projectEuler.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
public class SumMakerTest extends AbstractTest {

    public static final List<Long> TEST_LIST = Arrays.asList(1L,2L,3L,4L,5L);
    public static final List<Long> EMPTY_LIST = new ArrayList<Long>();

    @Autowired
    private SumMaker sumMaker;

    @Test
    public void testSum() {
        assertEquals(15, sumMaker.sum(TEST_LIST));
    }

    @Test
    public void testSumEmptyList() {
        assertEquals(0, sumMaker.sum(EMPTY_LIST));
    }
}
