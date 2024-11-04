package JusticeSet;

import java.io.*;
import java.util.Objects;

public class B_UnsunderingArchive {
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
        Card[] deck = new Card[k];
        Card[] bluedeck = new Card[k];
        int ndeck = 0, nbluedeck = 0;

        int redmin = 0; //indexes that store max/min of red
        int bluemin = 0;   //indices that store max/min of blue

        for (int i= 0; i < n; i++) {
            if (Objects.equals(cards[i].color, "red")) {
                if (ndeck > 0 && ndeck < k) {
                    if (cards[i].power < deck[redmin].power)
                        redmin = i;
                    else if (deck[redmin].power < cards[i].power) {
                        deck[ndeck] =  cards[i];
                        ndeck++;
                    }
                } else if (ndeck == 0) {
                    redmin = ndeck;
                    deck[ndeck] =  cards[i];
                    ndeck++;
                }
            }
            else if (Objects.equals(cards[i].color, "blue")) {
                if (nbluedeck > 0 && nbluedeck < k) {
                    if (cards[i].power < bluedeck[bluemin].power)
                        bluemin = i;
                    else if (bluedeck[bluemin].power < cards[i].power) {
                        bluedeck[nbluedeck] =  cards[i];
                        nbluedeck++;
                    }
                } else if (nbluedeck == 0) {
                    bluemin = nbluedeck;
                    bluedeck[nbluedeck] =  cards[i];
                    nbluedeck++;
                }
            }
        }

    }
}

//class Card {
//    public String color;
//    public int power;
//
//    public Card (String color, int power) {
//        this.color = color;
//        this.power = power;
//    }
//}