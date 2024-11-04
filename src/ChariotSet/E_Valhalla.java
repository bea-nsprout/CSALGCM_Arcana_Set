package ChariotSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E_Valhalla {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split(" ");
        int p = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);
        long sum = 0;
        double[][] towns = new double[n][2];
        for(int i = 0; i < n; i++) {
            towns[i][0] = Integer.parseInt(br.readLine().trim());
            sum += (long) towns[i][0];
        }
        System.out.println(solve(p,n,towns, sum));
    }

    public static int solve(int p, int n, double[][] towns, long sum){
        // solve for answer here
        int max = 0;
        int a;
        for(int i = 0; i < n; i++) {
            towns[i][1] = towns[i][0] / sum;        // the ratio
            a = (int) Math.ceil(towns[i][0]/(p*towns[i][1]));
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
