import java.io.BufferedReader;
import java.io.InputStreamReader;
public class B_DodgeSpikesEasy {
    public static final int INF = (int)1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        // compute and print answer here
        System.out.println(findSol(s, n));

    }
    public static int findSol(String s, int n) {
        int jumps = 0;
        char[] map = s.toCharArray();
        for (int i = 0; i < n-1;) {
            if (i == n-2) {         //if last square
                jumps++;
                i++;
            } else if (map[i+1] == '1' && map[i+2] == '1')
                return -1;         //if no solution found
            else if (map[i+2] == '0'){
                jumps ++;
                i+=2;              //jumps two space
            } else {
                jumps++;
                i++;               //jumps one space
            }
        }
        return jumps;
    }
}