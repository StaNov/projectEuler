package euler43_specialpandigitals;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import static euler43_specialpandigitals.Main.*;
        
/**
 *
 * @author StaNov
 */
class PandigitalFactory {
    
    public static final int PANDIGITALS = 3628800;
    int[] current;
    
    public PandigitalFactory() {
        current = new int[DIGITS];
        for(int i = 0; i < DIGITS; i++) { // naplní pole prvním číslem
            current[i] = i;
        }
    }

    public List<Pandigital> createPandigitals() {
        List<Pandigital> result = new LinkedList<Pandigital>();
        
        Pandigital next = new PandigitalLong(current); // vloží první číslo do seznamu
        result.add(next);
        //System.out.println(next);
        
        while((next = getNextPandigital()) != null) {
            result.add(next);
            //System.out.println(next);
        }
        
        System.out.print("Odmazávám začínající nulou...");
        while(result.get(0).startsWithZero()) { // odmaže ty, co začínají nulou
            result.remove(0);
        }
        System.out.println(" OK");
        
        return result;
    }
    
    /**
     * Vrací buď další číslo nebo null, pokud už další neexistuje.
     */
    public Pandigital getNextPandigital() {
        int index = getIndex(); // index prvního zprava nerostoucího čísla
        
        if(index == -1) { // posloupnost je zprava seřazená - maximální číslo
            return null;
        }
        
        int minimumIndex = minimumIndex(index, current[index]);
        
        // vyměň číslo na pozici index za číslo na pozici minimumIndex
        int pom = current[index];
        current[index] = current[minimumIndex];
        current[minimumIndex] = pom;
        
        // seřaď posloupnost vzestupně od pozice index + 1
        Arrays.sort(current, index + 1, DIGITS);
        
        // vrať aktuálně uložené číslo
        return new PandigitalLong(current);
    }

    /**
     * Vrátí index nejpravějšího čísla, které není zprava rostoucí.
     * Pokud je celá posloupnost zprava rostoucí, vrátí -1.
     */
    private int getIndex() {
        for(int i = DIGITS - 1; i >= 1; i--) {
            if(current[i-1] < current[i]) {
                return i-1;
            }
        }
        
        return -1;
    }
    
    
    /**
     * Vrátí index nejmenšího čísla, které je napravo od pozice index 
     * a je větší než atLeast.
     */
    private int minimumIndex(int index, int atLeast) {
        int result = index + 1;
        
        for(int i = index + 1; i < DIGITS; i++) {
            if(current[i] > atLeast && current[i] < current[result]) {
                result = i;
            }
        }
        
        return result;
    }    
}
