package cz.stanov.projectEuler.problem125;

import java.util.List;

import cz.stanov.projectEuler.utils.SumMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class ResultComputer {

    @Autowired
    private PalindromicNumbersCreator palindromicNumbersCreator;

    @Autowired
    private SumMaker sumMaker;

    public long computeResultForArgument(long argument) {
        List<Long> palindromicNumbers = palindromicNumbersCreator.findPalindromicNumbersBelow(argument);
        return sumMaker.sum(palindromicNumbers);
    }
}
