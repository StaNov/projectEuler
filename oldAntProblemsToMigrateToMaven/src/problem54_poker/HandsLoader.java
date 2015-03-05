package problem54_poker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Načítá ze souboru karty.
 *
 * @author StaNov
 */
public class HandsLoader {

    /**
     * Načte karty ze souboru a vrátí pole rukou.
     *
     * @return pole rukou sudé délky, kde sudé prvky (0,2,4,...) jsou karty
     * prvního hráče a liché prvky (1,3,5...) jsou karty druhého hráče.
     */
    public static Hand[] loadHands() {
        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(new File("poker.txt")));
            Hand[] result = new Hand[2000]; // načtené ruce, výsledek


            String line; // právě načtený řádek souboru
            int handCount = 0; // kolik už je uložených rukou v poli result
            
            while ((line = reader.readLine()) != null) {
                
                String[] cardsStr = line.split(" ");

                Hand player1 = new Hand(new Card[] {
                    new Card(cardsStr[0]),
                    new Card(cardsStr[1]),
                    new Card(cardsStr[2]),
                    new Card(cardsStr[3]),
                    new Card(cardsStr[4]),
                });

                Hand player2 = new Hand(new Card[] {
                    new Card(cardsStr[5]),
                    new Card(cardsStr[6]),
                    new Card(cardsStr[7]),
                    new Card(cardsStr[8]),
                    new Card(cardsStr[9]),
                });
                result[handCount]     = player1;
                result[handCount + 1] = player2;

                handCount += 2;
            }

            return result;

        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Soubor neexistuje!", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Čtení se zesralo...", ex);
        }
    }
}
