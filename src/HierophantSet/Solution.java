import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static final int INF = (int)1e9;
    public static final int MOD = (int) 1e9+7;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        // compute and print answer here
        System.out.println(findSol(s, n));

    }
    public static int findSol(String s, int n) {
        int[] methods = new int[n];
        char[] map = s.toCharArray();

        //starts from the back
        for (int i = n-1; i >= 0;i--) {
            if (i == n-1) {         //if last square
                methods[i] = 1;     //base case
            } else if (i + 2 <= n-1 && map[i+1] == '1' && map[i+2] == '1')
                return 0;         //if no solution found (impossible map)
            else {
                if (i + 2 <= n-1 && map[i+2] == '0') {
                    methods[i] = (methods[i] + methods[i+2]) % MOD;
                }
                if (map[i+1] == '0') {
                    methods[i] = (methods[i] + methods[i+1]) % MOD;
                }
            }
        }
        return methods[0];
    }
}