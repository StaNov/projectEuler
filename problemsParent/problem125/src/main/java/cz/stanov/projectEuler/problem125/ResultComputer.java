package cz.stanov.projectEuler.problem125;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class ResultComputer {

    @Autowired
    private PalindromicNumbersCreator palindromicNumbersCreator;

    public long computeResultForArgument(long argument) {
        List<Long> palindromicNumbers = palindromicNumbersCreator.findPalindromicNumbersBelow(argument);
        return sum(palindromicNumbers);
    }

    private long sum(List<Long> list) {
        long result = 0;

        for(long number : list) {
            result += number;
        }

        return result;
    }
}
