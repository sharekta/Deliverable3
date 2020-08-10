/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import warcardgame.Card.Rank;
import warcardgame.Card.Suit;

/**
 *
 * @author  Group :
 * Ekta Sharma
 * Tajinder Singh
 * Gautam Naman Sharma
 */
public class Deck {
   
    private int cardsUsed;

    private final List<Card> deck = new ArrayList<Card>();

    /**
     *  The deck contains
     * the usual 52 cards
     * The shuffle() method can be called to
     * randomize the order.
     */
  
    public Deck() {
        createDeck();
    }

    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
    
        cardsUsed = 0;
    }

    /**
     * shuffle the deck into a random order.
     */
    public void shuffle() {
          
        Collections.shuffle(this.deck);
    
        
       cardsUsed = 0;
    }

    /**
     * This function returns the number of cards that
     * are still left in the deck. 
     * @return 
     */
    public int cardsLeft() {
        return deck.size()- cardsUsed;
    }

    
    public Card dealCard() {
        if (cardsUsed == deck.size())
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck.get(cardsUsed - 1);
        
    }

 


}
