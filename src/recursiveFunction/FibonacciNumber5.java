package recursiveFunction;

import java.io.*;

public class FibonacciNumber5 {

    static int sum;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sum =0;
        count =0;


        System.out.println(fibo(n));

    }

    static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibo(n-1) + fibo(n-2);

    }
}
