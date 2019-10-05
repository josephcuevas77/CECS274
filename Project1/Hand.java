package Project1;

import java.util.ArrayList;

/**
 * Hand Object
 * Created by and ArrayList of Cards
 * Various functions such as populatingHand, playing a Card,
 * retrieving Hand size or a card
 * @author Joseph 02/07/2019
 *
 */
public class Hand {
	
	private ArrayList<Card> Hand = new ArrayList<Card>();
	
	/**
	 * Default Constructor for Hand 
	 */
	public Hand() {
		Hand = new ArrayList<Card>();
	}
	
	/**
	 * Adds card to ArrayList of cards in Hand 
	 * populating the hand
	 * @param c - card to be added to the Hand
	 */
	public void populateHand(Card c) {
		Hand.add(0,c);
	}
	
	/**
	 * Returns the size of the Hand in order to track it every time its updated
	 * @return size of the Hand
	 */
	public int getHandSize() {
		return Hand.size();
	}
	
	/**
	 * Retrieves certain card within hand
	 * @param cardNumber - number of card to be retrieved
	 * @return the card and info
	 */
	public Card getCard(int cardNumber) {
		return Hand.get(cardNumber);
	}
	
	/**
	 * Displays hand of player or bot
	 */
	public void displayHand() {
		for(int i = 0; i < Hand.size();i++) {
			System.out.println(Hand.get(i));
		}
	}
	
	/**
	 * Simulates the playing of a card off the top of the player or
	 * bot's cards and takes it out of the hand
	 * @return the Card to be played
	 */
	public Card playCard() {
		Card temp = Hand.get(Hand.size()-1);
		Hand.remove(Hand.size()-1);
		return temp;
	}
}
