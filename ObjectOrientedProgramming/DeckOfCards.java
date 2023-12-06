package ObjectOrientedProgramming;
/*
 * Things learnt 
 * Collections.shuffle()
 * Difference between set and a List :  Unlike sets, lists typically allow duplicate elements. More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), and they typically allow multiple null elements if they allow null elements at all.
 * 
 * 
 * When to use Random Class and when to use Math.random()
 * How to put a new Line like endl lol.
 * 
 * Most confusing part is Collections.shuffle()
 * Collections.shuffle() method is used to randomly permute the specified list using a provided source of randomness
 * you can even do it :
 * long seed = System.nanoTime(); // Use current time as a seed
Collections.shuffle(deck, new Random(seed));

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    public static void main(String[] args) {
        // Initialize deck of cards
        List<String> suits = List.of("Clubs", "Diamonds", "Hearts", "Spades");
        List<String> ranks = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
        List<String> deck = initializeDeck(suits, ranks);

        // Shuffle the deck
        shuffleDeck(deck);

        // Distribute cards to 4 players
        String[][] playersCards = distributeCards(deck, 4, 9);

        // Print the cards received by each player
        printPlayersCards(playersCards);
    }

    // Method to initialize the deck of cards
    private static List<String> initializeDeck(List<String> suits, List<String> ranks) {
        List<String> deck = new ArrayList<>();


        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    // Method to shuffle the deck of cards
    private static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck, new Random());
    }

    // Method to distribute cards to players
    private static String[][] distributeCards(List<String> deck, int numPlayers, int cardsPerPlayer) {
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        int cardIndex = 0;
        for (int player = 0; player < numPlayers; player++) {
            for (int card = 0; card < cardsPerPlayer; card++) {
                playersCards[player][card] = deck.get(cardIndex++);
            }
        }

        return playersCards;
    }

    // Method to print the cards received by each player
    private static void printPlayersCards(String[][] playersCards) {
        for (int player = 0; player < playersCards.length; player++) {
            System.out.println("Player " + (player + 1) + " cards:");
            for (int card = 0; card < playersCards[player].length; card++) {
                System.out.println(playersCards[player][card]);
            }
            System.out.println();
        }
    }
}
