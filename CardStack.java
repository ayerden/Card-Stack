/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstack;

import java.util.Random;
import jsjf.ArrayStack;
import jsjf.exceptions.EmptyCollectionException;

public class CardStack {

    private static ArrayStack<Card> cardStack;
    /**
      * constructor builds and array 52 long 
      * for loop fills array in order Ace-king  clubs, diamonds, hearts, spades
      */
    public CardStack(){
         cardStack = new ArrayStack(52); 
        for (int suit = 1; suit <= 4; suit ++)
        {
            for (int faceNum = 1; faceNum <= 13; faceNum++)
            {
                cardStack.push(new Card(faceNum, suit));
            }
        }
    }
    public Card dealTopCard(){
        
        Card topCard = null;
        
        try{
            topCard = cardStack.pop();
        }catch(EmptyCollectionException ex){
            System.out.println("Unable to deal card due to exception:" + ex.getMessage());
        }
       return topCard;
}
    public int cardsLeftInDeck(){
       return cardStack.size();
}
/**
 * constructor shuffles the array
 * selects 2 cards randomly and switches their position 2000 times
 * prints the card from top of the deck
 */
   public void shuffle()
          
    { 
        
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(1000000)+100000;
        for(int count = 0; count < number; count++){
        
            ArrayStack<Card>firstStack = new ArrayStack(26);
            ArrayStack<Card>secondStack = new ArrayStack(26);
            try {
               
                for(int i = 0; i < 26; i ++){
                    firstStack.push(cardStack.pop());
                }

                for(int i = 0; i < 26; i ++){
                    secondStack.push(cardStack.pop());
                }
                for(int i = 0; i < 26; i ++){
                    cardStack.push(firstStack.pop());
                    cardStack.push(secondStack.pop());
                }
            
            }catch(EmptyCollectionException ex){
                System.out.println("Unable to shuffle deck due to exception:" + 
                        ex.getMessage());
            }
            
        }

    }
   
   public static void main(String[] args){
       
       CardStack deckOfCards = new CardStack();
       
       deckOfCards.shuffle();
       
       while (deckOfCards.cardsLeftInDeck() != 0)
       {
    
            System.out.println("Dealing Card:" + deckOfCards.dealTopCard().toString());
       }
   }
}
           
