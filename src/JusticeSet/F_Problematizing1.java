package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 20mins - 10/30/2024
 * i love priority queue
 */
public class F_Problematizing1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int t = Integer.parseInt(parts[1]);
        int[][] problems = new int[n][2];

        for(int i = 0; i < n; i++) {
            parts = br.readLine().trim().split(" ");
            for(int j = 0; j < 2; j++){
                problems[i][j] = Integer.parseInt(parts[j]);
            }
        }
        System.out.println(solve(n,t,problems));
    }

    public static String solve(int n, int t, int[][] problems){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int solved = 0;
        // compute and return answer here
        for(int i = 0; i < n; i++){
            if(problems[i][0] != -1)
                pq.add(problems[i][0]);
        }

        while (!pq.isEmpty()) {
            if (t-pq.peek() >= 0) {
                t -= pq.poll();
                solved ++;
            }
            else
                break;
        }

        if(solved > 0) {
            return String.valueOf(solved);
        } else
            return "This exam is impossible!";
    }
}