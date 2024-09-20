/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Nitika Patel
 * @date 20/09/2024
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); 
            c.setSuit(Card.SUITS[random.nextInt(4)]); 
            magicHand[i] = c;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (1-13): ");
        int userValue = scanner.nextInt();
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();
        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        
        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }
        
        if (luckyFound) {
            System.out.println("You win! The lucky card (2 of Clubs) is in the magic hand.");
        } else {
            System.out.println("You lose. The lucky card (2 of Clubs) is not in the magic hand.");
        }
    }
}
