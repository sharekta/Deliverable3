/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcardgame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group:
 * Ekta Sharma
 * Tajinder Singh
 * Gautam Naman Sharma
 */
public class Hand {
        private ArrayList<Card> hand;   // The cards in the hand.

    /**
     * Create a hand that is initially empty.
     */
    public Hand() {
        hand = new ArrayList<>();
    }

    /**
     * Remove all cards from the hand, leaving it empty.
     */
    public void clear() {
        hand.clear();
    }

    /**
     * Add a card to the hand. \
     * @param c the non-null card to be added.
     * @throws NullPointerException if the parameter c is null.
     */
  public void addCardToTop(Card c) {
        if (c == null) {
            throw new NullPointerException("Can't add a null card to a cards.");
        }
        hand.add(c);
    }

    /**
     * adds more than one card at a time to hand
     *
     * @param cds cards added to hand as array
     */
    public void addCardsToTop(List<Card> cds) {
        this.hand.addAll(cds);
    }

    /**
     * @param c single Card object added to beginning of Array
     */
    public void addCardToBottom(Card c) {
        hand.add(0, c);
    }

    /**
     * removes the card from the last index of the array
     */
    public Card removeCardFromTop() {
        if (handSize() < 1) {
            return null;
        }
        return hand.remove(handSize() - 1);
    }

    /**
     * removes card from the first index of the array
     */
    public Card removeCardFromBottom() {
        if (handSize() < 1) {
            return null;
        }
        return hand.remove(0);
    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position 
     * @throws IllegalArgumentException if the position does not exist in
     * the hand
     */
    public void removeCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        hand.remove(position);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int getCardCount() {
        return hand.size();
    }

    /**
     * Gets the card at the top in the hand.
     */
    public Card getCard() {
       
        return hand.get(getCardCount()-1);
    }

   

public int handSize() {
        return hand.size();
    }
    
}
