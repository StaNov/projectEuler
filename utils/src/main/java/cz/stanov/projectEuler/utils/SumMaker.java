package cz.stanov.projectEuler.utils;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class SumMaker {

    public long sum(List<Long> list) {
        long result = 0;

        for(long number : list) {
            result += number;
        }

        return result;
    }
}
