package cz.stanov.projectEulero.utils;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class RootAbstractTest {

    protected final Logger LOG = Logger.getLogger(this.getClass());

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        LOG.debug("Mocks initialized.");
    }
}
