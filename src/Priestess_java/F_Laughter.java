package Priestess_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class F_Laughter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        long k = Long.parseLong(parts[1]);
        System.out.println(solve(n,k));
    }

    public static char solve(int n, long k) {
        // solve answer here. Return correct answer
        long[] fibo = dp_fibo(n);

        while (n > 1) {
            if (k < fibo[n-2])
                n -= 2;
            else {
                k -= fibo[n-2];
                n -= 1;
            }
        }
        if (n == 0)
            return 'H';
        else
            return 'A';

    }

    public static long[] dp_fibo(int n) {
        long[] fibo = new long[n + 1];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo;
    }
}