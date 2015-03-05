package problem02_fibonacci;

public class MainGyntr {

    public static void main(String[] args) {
        int f1=1, f2=2, f3, sum=0;

        while(f2<400000000) {
            sum+=f2;
            f3 = f1 + f2;
            f1 = f2 + f3;
            f2 = f3 + f1;
        }

        System.out.println("\nAnd the final sum is "+sum);
    }
}
