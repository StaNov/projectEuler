package cz.stanov.projectEuler.utils;

import org.springframework.stereotype.Component;

/**
 * @author Stanislav Novak (stanislav.novak@ibacz.eu)
 */
@Component
public class PandigitalCreatorFactory {

    public PandigitalCreator getNewPandigitalCreator(int numberLength) {
        return new PandigitalCreator(numberLength);
    }

    public PandigitalCreator getNewPandigitalCreator(int numberLength, boolean includeZero) {
        return new PandigitalCreator(numberLength, includeZero);
    }
}
