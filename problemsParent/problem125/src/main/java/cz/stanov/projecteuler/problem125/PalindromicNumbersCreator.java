package cz.stanov.projecteuler.problem125;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.stanov.projecteuler.utils.Palindromes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class PalindromicNumbersCreator {

    private static final Logger LOG = Logger.getLogger(PalindromicNumbersCreator.class);

    @Autowired
    private Palindromes palindromes;

    public List<Long> findPalindromicNumbersBelow(long upperBound) {
        Set<Long> result = new HashSet<Long>();

        for (long firstNumber = 1; canThisNumberBeFirstNumberOfSquareSequence(firstNumber, upperBound); firstNumber++) {
            LOG.debug("new first number: " + firstNumber);

            for (long sequenceLength = 2; true; sequenceLength++) {
                LOG.debug("new sequence length: " + sequenceLength);

                long sum = 0;

                for (long currentNumber = firstNumber; currentNumber < firstNumber + sequenceLength; currentNumber++) {
                    LOG.debug("adding number " + currentNumber + "^2");
                    sum += currentNumber * currentNumber;
                }

                LOG.debug("Current sum is: " + sum);

                if (sum > upperBound) {
                    break;
                }

                if (palindromes.isPalindrome(sum)) {
                    LOG.debug("New palindrome number: " + sum);
                    LOG.debug("Created from: firstNumber=" + firstNumber + ", sequenceLength=" + sequenceLength + "\n");
                    result.add(sum);
                }
            }
        }

        return new ArrayList<Long>(result);
    }

    private boolean canThisNumberBeFirstNumberOfSquareSequence(long firstNumber, long upperBound) {
        return firstNumber * firstNumber + (firstNumber+1) * (firstNumber+1) < upperBound;
    }
}
