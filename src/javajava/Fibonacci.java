package javajava;
import java.text.DecimalFormat;

public class Fibonacci {

    public static void fibonacci() {
        final DecimalFormat decimalFormat = new DecimalFormat("#");
        int n = 10, t1 = 0, t2 = 1;
        String lancuch = decimalFormat.format(n);        
        System.out.println("Pierwsze " + lancuch + " czesci: ");

        for (int i = 1; i <= n; ++i) {
            lancuch = "" + t1;//decimalFormat.format(t1);
            System.out.println(lancuch);

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }
}
