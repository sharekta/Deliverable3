/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcardgame;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Group :
 * Ekta Sharma
 * Tajinder Singh
 * Gautam Naman Sharma
 */
public class WarCardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
         System.out.println("It's a war of cards!\n" +
                "This Game ends when one player has all 52 cards.\n" +
                "It's you against the CPU.\n");
    
        System.out.println("Please enter your name.");
        String name = in.nextLine();
        System.out.println("click Enter to start the game");

         Player humanPlayer = new Player(name);
       Player computer = new Player("Computer");

        System.out.println("Let's Begin!");
        
        Deck deck = new Deck();
        
        deck.shuffle();

        humanPlayer.setHand(new Hand());
        computer.setHand(new Hand());

       for(int i = 0; i < 26; i++)
    {
        humanPlayer.getHand().addCardToTop(deck.dealCard());
        computer.getHand().addCardToTop(deck.dealCard());
    }


       

       
    try
    {   
        do
        {
           
            Card player1RemovedTopCard = humanPlayer.getHand().getCard();
            humanPlayer.getHand().removeCardFromTop();
            
            Card player2RemovedTopCard = computer.getHand().getCard();

            
            if((player1RemovedTopCard.getValue().ordinal())>(player2RemovedTopCard.getValue().ordinal()))
            {
                System.out.println(name+" " + player1RemovedTopCard + " Computer " + player2RemovedTopCard);
                System.out.println(name+" is the Winner");
                humanPlayer.getHand().addCardToBottom(player1RemovedTopCard);
                humanPlayer.getHand().addCardToBottom(player2RemovedTopCard);
    
                System.out.println(name + " has :" + humanPlayer.getHand().handSize() + " cards left.");
                System.out.println("Computer has:" + computer.getHand().handSize()  + " cards left.");
                System.out.println("\n");
           
            }
            
            else if((player1RemovedTopCard.getValue().ordinal())<(player2RemovedTopCard.getValue().ordinal()))
            {
                System.out.println(name+" " + player1RemovedTopCard + " Computer : " + player2RemovedTopCard);
                System.out.println("Computer is the Winner");
                computer.getHand().addCardToBottom(player1RemovedTopCard);
                computer.getHand().addCardToBottom(player2RemovedTopCard);
    
                System.out.println(name+" " + humanPlayer.getHand().handSize() + " cards left.");
                System.out.println("Computer has:" + computer.getHand().handSize()  + " cards left.");
                System.out.println("\n");
            }
            //The following code handles the war
            else
            {
                System.out.println(name+" " + player1RemovedTopCard + " Computer : " + player2RemovedTopCard);
                System.out.println("WAR!!!!!!!");
                //War if the player has only 4 cards left.
                if(humanPlayer.getHand().handSize() == 1 || computer.getHand().handSize() == 1)
                {
                    Card player1RemovedTopCard2 = humanPlayer.getHand().getCard();
                    humanPlayer.getHand().removeCardFromTop();

                    Card player2RemovedTopCard2 = computer.getHand().getCard();
                    computer.getHand().removeCardFromTop();
                    System.out.println(name+"'s 2nd card is: " + player1RemovedTopCard2 + "Computer's 2nd card is: " + player2RemovedTopCard2);
                    if((player1RemovedTopCard.getValue().ordinal())>(player2RemovedTopCard.getValue().ordinal()))
                    {
                        System.out.println(name+" is the winner of the War! ");
                        humanPlayer.getHand().addCardToBottom(player1RemovedTopCard);
                        humanPlayer.getHand().addCardToBottom(player1RemovedTopCard2);
                        humanPlayer.getHand().addCardToBottom(player2RemovedTopCard);
                        humanPlayer.getHand().addCardToBottom(player2RemovedTopCard2);
                        System.out.println(name+" has: " + humanPlayer.getHand().handSize() + " cards left.");
                        System.out.println("Computer has: " + computer.getHand().handSize() + " cards left.");
                        System.out.println("\n");
                    }
                    else if((player1RemovedTopCard.getValue().ordinal())<(player2RemovedTopCard.getValue().ordinal()))
                    {
                        System.out.println("Computer is the winner of the War! ");
                        computer.getHand().addCardToBottom(player1RemovedTopCard);
                        computer.getHand().addCardToBottom(player1RemovedTopCard2);
                        computer.getHand().addCardToBottom(player2RemovedTopCard);
                        computer.getHand().addCardToBottom(player2RemovedTopCard2);
                        System.out.println(name+" has: " + humanPlayer.getHand().handSize() + " cards left.");
                        System.out.println(name+" has: " + computer.getHand().handSize() + " cards left.");
                        System.out.println("\n");
                    }
                    else
                    {
                        if(computer.getHand().getCardCount() == 0)
                        {
                            humanPlayer.getHand().addCardToBottom(player2RemovedTopCard2);
                             humanPlayer.getHand().addCardToBottom(player2RemovedTopCard);
                             humanPlayer.getHand().addCardToBottom(player1RemovedTopCard2);
                             humanPlayer.getHand().addCardToBottom(player1RemovedTopCard);
                        }
                        else
                        {
                           computer.getHand().addCardToBottom(player2RemovedTopCard2);
                            computer.getHand().addCardToBottom(player2RemovedTopCard);
                           computer.getHand().addCardToBottom(player1RemovedTopCard2);
                            computer.getHand().addCardToBottom(player1RemovedTopCard);
                        }
                    }
                }
              
            }
         
        
        }while( humanPlayer.getHand().handSize() > 0 || computer.getHand().handSize() > 0);
    }

   
    catch (IndexOutOfBoundsException theException) 
        {
            if(humanPlayer.getHand().handSize()== 0)
            {
                System.out.println("Winner is the Computer" );
            }
            else
            System.out.println("You Win!!" );

        
    }
}}
