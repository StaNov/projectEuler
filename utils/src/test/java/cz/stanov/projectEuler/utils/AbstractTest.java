package cz.stanov.projectEuler.utils;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/utils-context.xml")
public abstract class AbstractTest {

    protected final Logger LOG = Logger.getLogger(this.getClass());

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        LOG.debug("Mocks initialized.");
    }
}
