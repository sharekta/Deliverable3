/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcardgame;

/**
 *
 * @author  Group :
 * Ekta Sharma
 * Tajinder Singh
 * Gautam Naman Sharma
 */
public class Card {
    
   public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
     public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
 
    final Rank rank;
    final Suit suit;
 

     public Card (final Rank rank, final Suit suit) {
       this.rank = rank;
      this.suit = suit;
   }
   

    /**
     * Returns the suit of this card.
     * @return the suit,
     */
    public Suit getSuit() {
      return suit;
    }

    /**
     * Returns the rank of this card.
     * @return the rank
     */
    public Rank getValue() {
        return rank;
    }


}
