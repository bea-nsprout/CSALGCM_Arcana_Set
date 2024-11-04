package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G_CheatingDebt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        String num = br.readLine().trim();
        System.out.println(solve(n, m, num));
    }

    public static String solve(int n, int m, String num) {
        StringBuilder newans = new StringBuilder();
        String ans = num;
        String lowestans;

        if (m == 0)                     // early termination in case nothing to remove
            return ans;

        for (int i = 0; i < m; i++) {       //number of stuff to remove
            lowestans = ans;
            n = lowestans.length();
            for(int j = 0; j < n; j++) {    //iterate through all digits
                newans.delete(0, newans.length());
                newans.append(lowestans);
                newans.deleteCharAt(j);

                if (newans.charAt(0) != '0')
                    if(newans.toString().compareTo(ans) < 0)
                        ans = newans.toString();
            }
        }
        return ans;
    }
}
