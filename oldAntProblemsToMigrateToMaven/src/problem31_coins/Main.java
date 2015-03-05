/*
 * In England the currency is made up of pound, £, and pence, p, and there are
 * eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1£1 + 150p + 220p + 15p + 12p + 31p
 * How many different ways can £2 be made using any number of coins?
 */

package problem31_coins;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

    public static void main(String[] args) {

        //coin[0] = 2L
        //coin[1] = 1L
        //coin[2] = 50p
        //coin[3] = 20p
        //coin[4] = 10p
        //coin[5] = 5p
        //coin[6] = 2p
        //coin[7] = 1p

        int[] coin = new int[8];
        int count = 0;

        for(int x2L = 0; value(coin) <= 200; x2L++) {
            coin[0] = x2L;
            for(int x1L = 0; value(coin) <= 200; x1L++) {
                coin[1] = x1L;
                for(int x50p = 0; value(coin) <= 200; x50p++) {
                    coin[2] = x50p;
                    for(int x20p = 0; value(coin) <= 200; x20p++) {
                        coin[3] = x20p;
                        for(int x10p = 0; value(coin) <= 200; x10p++) {
                            coin[4] = x10p;
                            for(int x5p = 0; value(coin) <= 200; x5p++) {
                                coin[5] = x5p;
                                for(int x2p = 0; value(coin) <= 200; x2p++) {
                                    coin[6] = x2p;
                                    for(int x1p = 0; value(coin) <= 200; x1p++) {
                                        coin[7] = x1p;

                                        if(value(coin) == 200) {
                                            count++;
                                            //System.out.println(count + ". combination: " + coinsToString(coin) + value(coin));
                                        }

                                    }
                                    coin[7] = 0;
                                }
                                coin[6] = 0;
                            }
                            coin[5] = 0;
                        }
                        coin[4] = 0;
                    }
                    coin[3] = 0;
                }
                coin[2] = 0;
            }
            coin[1] = 0;
        }

        System.out.println("And the result is: " + count + "!!!");
    }

    private static int value(int[] coin) {
        return coin[0] * 200 +
               coin[1] * 100 +
               coin[2] * 50 +
               coin[3] * 20 +
               coin[4] * 10 +
               coin[5] * 5 +
               coin[6] * 2 +
               coin[7] * 1;
    }

    private static String coinsToString(int[] coin) {

        String result = "";

        for(int i = 0; i < coin[0]; i++) {
            result += "2L ";
        }

        for(int i = 0; i < coin[1]; i++) {
            result += "1L ";
        }

        for(int i = 0; i < coin[2]; i++) {
            result += "50p ";
        }

        for(int i = 0; i < coin[3]; i++) {
            result += "20p ";
        }

        for(int i = 0; i < coin[4]; i++) {
            result += "10p ";
        }

        for(int i = 0; i < coin[5]; i++) {
            result += "5p ";
        }

        for(int i = 0; i < coin[6]; i++) {
            result += "2p ";
        }

        for(int i = 0; i < coin[7]; i++) {
            result += "1p ";
        }

        return result;
    }

}
