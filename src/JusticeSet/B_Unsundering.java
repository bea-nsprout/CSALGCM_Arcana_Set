package JusticeSet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class B_Unsundering {
    public static int r;
    public static long tp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        Card[] cards = new Card[n];

        for(int i = 0; i < n; i++) {
            parts = br.readLine().trim().split(" ");
            int power = Integer.parseInt(parts[1]);
            cards[i] = new Card(parts[0],power);
        }

        solve(n,k,cards);
        System.out.printf("%d %d",r, tp);
    }

    /*
    Solves a test case.

    Parameters:
    n : int - number of cards available
    k : int - number of cards to include in Jason's deck
    cards : array-like - string list of shape (n,2). Each element has two elements:
    the first is a string containing the color (either "red" or "blue"). The second
    is a string containing the power of the card.

    Save the answers to the static variables r and tp where:
    r  : int - number of red cards added
    tp : int - total power of cards in your deck
    */
    public static void solve(int n, int k, Card[] cards) {
        // TODO
        QuickSelect qs = new QuickSelect();
        ArrayList<Card> redCards = new ArrayList<>(),
                blueCards = new ArrayList<>();
        Card[] redcards;
        Card[] bluecards;

        splitCards(cards, redCards, blueCards);
        redcards = redCards.toArray(new Card[0]);
        bluecards = blueCards.toArray(new Card[0]);





        //get all red cards
        r = 0;
        tp = 0;
        int ndeck = 0;

        //if redcards is not more than
        if (redcards.length <= k)
            for(int i = redcards.length-1; i >= 0 && ndeck < k; i--) {
                tp += redcards[i].power;
                r++;
                ndeck++;
            }
        else {
            qs.findKthLargest(redcards, k);
            for(int i = redcards.length-1; i >= 0 && ndeck < k; i--) {
                tp += redcards[i].power;
                r++;
                ndeck++;
            }
        }


        if (ndeck < k) {
            qs.findKthLargest(bluecards, k-ndeck);
        }
        for(int i = bluecards.length-1; i >= 0 && ndeck < k; i--) {
            tp += bluecards[i].power;
            ndeck++;
        }

    }


    public static void splitCards(Card[] cards, List<Card> redCards, List<Card> blueCards) {
        for (Card card : cards) {
            if ("red".equals(card.color)) {
                redCards.add(card);
            } else if ("blue".equals(card.color)) {
                blueCards.add(card);
            }
        }
    }

}

class Card {
    public String color;
    public int power;

    public Card (String color, int power) {
        this.color = color;
        this.power = power;
    }
}



class QuickSelect {
    Card[] cards;

    public void swap(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    public int partition(int start, int end, int pivotIndex) {
        int pivot = cards[pivotIndex].power;
        // Move pivot to the end of the array
        swap(end, pivotIndex);
        int startIndex = start;
        for (int i = start; i < end; i++) {
            if (cards[i].power < pivot) {
                swap(i, startIndex);
                startIndex++;
            }
        }
        // Move pivot element from the end of the array to its position
        swap(end, startIndex);
        return startIndex;
    }

    public int findKthLargest(Card[] cards, int k) {
        this.cards = cards;
        Card pivotCard = quickselect(0, cards.length - 1, cards.length - k);
        return pivotCard.power;
    }

    public Card quickselect(int start, int end, int k) {
        if (start == end) {
            return cards[start];
        }
        Random random = new Random();
        int pivotIndex = start + random.nextInt(end - start + 1);
        pivotIndex = partition(start, end, pivotIndex);
        if (pivotIndex == k) {
            return cards[pivotIndex];
        } else if (pivotIndex < k) {
            return quickselect(pivotIndex + 1, end, k);
        } else {
            return quickselect(start, pivotIndex - 1, k);
        }
    }
}
