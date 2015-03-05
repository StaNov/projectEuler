/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package triangle;

/**
 *
 * @author Novák Stanislav
 */
public class Main {

        public static void main(String[] args) {

        long lgtNum = 1;
        int divNum = 1;
        int iterNo = 1;

        for(int triNum = 1; divNum < 500; triNum += iterNo) {

            int divThis = 1;

            //looks for the smallest divider
            int smDiv = 1;
            for (int i = 2; triNum % i == 0; i++);


            for(int mod = 2; mod <= triNum / smDiv; mod++) {

                if(triNum % mod == 0) divThis++;
            }

            if (divThis > divNum) {
                lgtNum = triNum;
                divNum = divThis;
                System.out.println("BEST: " + triNum + ": " + divThis + " divs");
            }

            iterNo++;

            //System.out.println(triNum + ": " + divThis + " divs, BEST: " + divNum);
            //System.out.println(triNum + ", BEST: " + divNum);
        }

    }

}
