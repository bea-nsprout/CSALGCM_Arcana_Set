package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 30mins - 10/30/2024
 * reading comprehension takes too long
 */
public class D_ChainMemories {
    public static final int NUM_CARDS = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] parts = br.readLine().trim().split(" ");
        int[] cards = new int[NUM_CARDS];
        for(int i = 0; i < NUM_CARDS; i++) {
            cards[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(solve(cards));
    }

    public static int solve(int[] cards) {
        // TODO: Compute and return answer here
        int cardidx = 1;    //start at 1
        int nmaxvisits = 0;

        while (cardidx < NUM_CARDS) {
            if (cards[cardidx] > 0) {
                cards[cardidx]--;
                nmaxvisits++;
            }

            //increment
            cardidx++;
            if (cardidx == 10 && cards[0] > 0) {
                cardidx = 0;
            }
        }

        return nmaxvisits;
    }
}