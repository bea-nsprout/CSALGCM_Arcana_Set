import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_FastFurious {
    public static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] parts = br.readLine().trim().split(" ");
        int q = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        int[] F = preprocess(n, a);


        for(int i = 0; i < q; i++) {
            int k = Integer.parseInt(br.readLine().trim());
            sb.append(solve(k,F)).append("\n");
        }
        System.out.print(sb);
    }

    public static int solve(int k, int[] F){
        // compute and return answer here
        return F[k];
    }
    public static int[] preprocess(int max, int[] a) {
        int[] F = new int[max];        //initialize the dp array to store F answers

        for (int i = 0; i < max; i++) {
            F[i] = a[i] % MOD;
            for(int k = 0; k < i; k++) {
                F[i] = ( F[i] + F[k] ) % MOD;
            }
        }
        return F;
    }
}