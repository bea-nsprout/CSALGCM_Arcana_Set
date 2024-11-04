package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E_FriendlyRhythmGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int r = Integer.parseInt(parts[1]);

        long[][] times = new long[n][2];

        for(int i = 0; i < n; i++){
            parts = br.readLine().trim().split(" ");
            for(int j = 0; j < 2; j++) {
                times[i][j] = Long.parseLong(parts[j]);
            }
        }
        solve(n,r,times,sb);
        System.out.println(sb);
    }

    /**
     * Parameters:
     * n : int - number of notes
     * r : int - the target accuracy
     * times : array-like of size (n,2) - list of button inputs. Each contains a list with (t_i,p_i)
     */
    public static void solve(int n, int r, long[][] times, StringBuilder sb){
        PriorityQueue<Long> pq = new PriorityQueue<Long>(new reverseComparator());
        long nPerfect = (long) Math.ceil(((double) (r * n) / 100));
        // compute and append answer to StringBuilder here
        for(int i = 0; i < n; i++){
            if (times[i][0] != -1 && times[i][1] != -1 && pq.size() < nPerfect) {
                pq.add(Math.abs(times[i][0] - times[i][1]));
            }
        }

        if (!pq.isEmpty())
            sb.append(pq.poll());
        else
            sb.append("It's impossible!");
    }
}

class reverseComparator implements Comparator<Long> {
    public int compare(Long a, Long b) {
        if (a < b)
            return 1;
        if (a > b)
            return -1;
        return 0;
    }
}