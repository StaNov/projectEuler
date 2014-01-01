package cz.stanov.projectEuler.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for pandigital numbers.
 *
 * @author Novák Stanislav
 * @version 24.5.2010
 */
public class PandigitalCreator {

    private int n;
    private boolean includeZero;
    //počet číslic v pandigitálním čísle
    private int length;

    /**
     * Constructor.
     *
     * @param numberLength make n-pandigital numbers without zero
     */
    public PandigitalCreator(int numberLength) {
        this.n = numberLength;
        this.includeZero = false;
        this.length = numberLength;
    }

    /**
     * Constructor.
     *
     * @param numberLength make n-pandigital numbers
     * @param includeZero indicates if zero should be included
     */
    public PandigitalCreator(int numberLength, boolean includeZero) {
        
        this.includeZero = includeZero;
        this.n = numberLength;
        this.length = numberLength;
        if (includeZero) {
            length++;
        }
    }

    public List<Long> getPandigitals() {

        List<Long> result = new ArrayList<Long>();
        int[] number = new int[length];

        List<Integer> numsToFill = new ArrayList<Integer>();
        if(includeZero) {
            numsToFill.add(0);
        }
        for(int i = 1; i <= n; i++) {
            numsToFill.add(i);
        }
        makePandigitalFromPosition(0, number, numsToFill, result);

        return result;
    }

    /**
     *
     * @param position pozice ze které se má začít generovat číslo
     * @param number pole číslic reprezentující pandigitální číslo
     * @param numbersToFill číslice, které ještě nebyly použity
     * @param list seznam čísel, do kterého mají být ukládány pandigitální čísla
     */
    private void makePandigitalFromPosition(
            int position, int[] number, List<Integer> numbersToFill, List<Long> list) {

        if(position == length - 1) {
            //konec pole
            //na poslední číslice se uloží jediná poslední zbývající číslice
            number[length - 1] = numbersToFill.get(0);
            long newPandigital = arrayToInt(number);
            //pokud pole začíná nulou, číslo nepřidávej
            if(number[0] != 0) {
                //TODO opravit: poslední nenullový prvek: 3265919
                Long adding = (Long)newPandigital;
                if(adding == null) {
                    System.out.println("Bacha: " + newPandigital);
                }
                list.add(adding);
                //list.add((Long)newPandigital);
                if(newPandigital < 0) {
                    System.out.println("Bacha: " + newPandigital);
                }
            }
            //System.out.println(newPandigital);
        } else {
            //prostředek pole
            /* na position vloží postupně všechny číslice z numbersToFill
             * vytvoří pole čísel, které se budou doplňovat dále
             * doplní zbytek pole rekurzivním voláním
             */
            for(int i : numbersToFill) {
                number[position] = i;
                List<Integer> newNumbersToFill = makeNewNumbersToFill(numbersToFill, i);
                makePandigitalFromPosition(position + 1, number, newNumbersToFill, list);

            }
        }
    }



    /**
     * Vytvoří z pole číslic int.
     *
     * @param number pole číslic
     * @return int s hodnotou pole číslic
     */
    private long arrayToInt(int[] number) {

        long result = 0;

        long tens = 1;
        for(int i = number.length; i > 0; i--) {
            result += number[i - 1] * tens;
            tens *= 10;
        }

        return result;
    }

    /**
     * Vrátí aktuální pole čísel k dosazování.
     *
     * @param oldNumbersToFill stará čísla
     * @param newNumber nové číslo, které se má přidat
     * @return pole nových čísel k dosazování
     */
    private List<Integer> makeNewNumbersToFill(
            List<Integer> oldNumbersToFill, int usedNumber) {
        /*
         * vytvoří nové pole dlouhé o jedna menší než staré
         * zkopíruje staré, kromě čísla usedNumber
         */
        List<Integer> result = new ArrayList<Integer>(oldNumbersToFill);

        result.remove((Integer) usedNumber);

        return result;
    }

    /**
     * Smaže ze seznamu prvních x čísel, která začínají nulou.
     * 
     * @param result seznam pandigitálních čísel
     */
    /*private void extractNumsBeginningWithZero(List<Long> result) {
        long countOfZeros = (long) Math.pow(10, length - 1);

        while(result.get(0) / countOfZeros == 0) {
            result.remove(0);
        }
    }*/
}
