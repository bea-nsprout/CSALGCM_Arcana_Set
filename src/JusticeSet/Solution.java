package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        String num = br.readLine().trim();
        // build your answer in the StringBuilder to avoid TLE




        System.out.println(solve(n, m, num));
    }

    public static String solve(int n, int m, String num) {
        StringBuilder sb = new StringBuilder();
        int delete = m;
        int i;
        char next, top;
        boolean lastis0 = false;

        sb.append(num.charAt(0));

        for (i = 1; delete > 0 && i < n - delete; i++) {
            next = num.charAt(i);
            top = sb.toString().charAt(sb.length() - 1);

            if (next == '0') {
                while (top > next && delete > 0 && sb.length() > 1) {
                    sb.deleteCharAt(sb.length()-1);
                    delete--;
                    if (sb.length() > 1)
                        top = sb.toString().charAt(sb.length() - 1);
                }
                sb.append(next);
                lastis0 = true;
            }
            else if (lastis0) {
                if (sb.toString().charAt(0) > next
                    && (n-i+1) >= n-delete) {
                    delete -= sb.length();
                    sb.delete(0, sb.length());
                    sb.append(next);
                } else
                    delete--;
            }
            else if (top > next) {
                do {
                    sb.deleteCharAt(sb.length()-1);
                    delete--;
                    if (sb.length() > 0)
                        top = sb.toString().charAt(sb.length() - 1);
                } while (top > next && delete > 0 && sb.length() > 0);
                sb.append(next);
            } else
                sb.append(next);

        }
        for(; i < n - delete; i++) {
            sb.append(num.charAt(i));
        }

        return sb.toString();
    }
}