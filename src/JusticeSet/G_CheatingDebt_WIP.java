package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class G_CheatingDebt_WIP {
    static int trailingzeros = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        String num = br.readLine().trim();
        System.out.println(solve(n, m, num));
    }

    public static String solve(int n, int m, String num) {
        int m_nozero = 0;
        StringBuilder newans = new StringBuilder();
        PriorityQueue<PotentialAns> pq = new PriorityQueue<PotentialAns>(new PotentialAnsComparator());     //store the potential answers
        String stored = num;
        num = removeTrailingZeros(num);

        if (m == 0)
            return num;

        for(int j = 0; j < n - trailingzeros; j++) {    //iterate through all digits
            newans.delete(0, newans.length());
            newans.append(num);
            newans.deleteCharAt(j);

            if (newans.charAt(0) != '0') {
                if (pq.size() < m) {
                    pq.add(new PotentialAns(newans.toString(), j));
                    m_nozero++;
                } else if (newans.toString().compareTo(pq.peek().str) < 0) {
                    if (pq.size() == m)
                        pq.poll();

                    pq.add(new PotentialAns(newans.toString(), j));
                }
            }

        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().idx_removed);
        }

        list.sort(Collections.reverseOrder());


        newans.delete(0, newans.length());
        newans.append(num);
        for(int i = 0; i < m_nozero; i++) {
            newans.deleteCharAt(list.get(i));
        }

        String realans = returnTraillingZeros(newans.toString(), m - m_nozero);
        return realans;
    }

    public static String removeTrailingZeros(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int end = str.length() - 1;
        while (end >= 0 && str.charAt(end) == '0') {
            end--;
            trailingzeros++;
        }

        return str.substring(0, end + 1);
    }
    public static String returnTraillingZeros(String str, int nstillneedremove) {
        StringBuilder sb = new StringBuilder(str);
        trailingzeros -= nstillneedremove;
        while (trailingzeros-- > 0) {

            sb.append("0");
        }
        return sb.toString();
    }
}


class PotentialAns {
    public String str;
    public int idx_removed;
    public PotentialAns(String str, int idx_removed) {
        this.str = str;
        this.idx_removed = idx_removed;
    }
}
class PotentialAnsComparator implements Comparator<PotentialAns> {
    public int compare(PotentialAns a, PotentialAns b) {
        return b.str.compareTo(a.str);
    }
}