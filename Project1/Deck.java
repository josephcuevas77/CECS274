package Project1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck Object
 * Creates deck and does functions such as: 
 * shuffle, display, and deal cards of deck
 * @author Joseph 02/07/2019
 *
 */
public class Deck {

	private ArrayList<Card> deck;
	private ArrayList<String> suits;

	/**
	 * Constructor for Deck and fills suits ArrayList then creates the deck
	 */
	public Deck() {
		suits = new ArrayList<String>();
		suits.add("Spades");
		suits.add("Clubs");
		suits.add("Hearts");
		suits.add("Diamonds");
		deck = new ArrayList<Card>();
		makeDeck();
	}

	/**
	 * Function to make the deck and fill it with 52 cards
	 * Brand new deck created is unshuffled
	 */
	public void makeDeck() {
		for(int i = 0; i <= 3; i ++) {
			for(int j = 2; j <= 14; j++) {
				deck.add(new Card(j,suits.get(i)));
			}
		}
	}

	/**
	 * Shuffles the order of cards in deck
	 */
	public void shuffle() { Collections.shuffle(deck);}

	/**
	 * Displays the deck for viewing
	 */
	public void DisplayDeck() {
		System.out.println(deck);
	}
	
	/**
	 * Converts deck to String so that it
	 * is able to be printed later
	 */
	public String toString() {
		String deckString = "";
		for(int i = 0; i < deck.size(); i++)
			deckString += deck.get(i).toString() + "\n";
		return deckString;
	}
	
	/**
	 * Deals a card to a Hand
	 * @return Card to be dealt
	 */
	public Card deal() {
		Card temp = deck.get(deck.size() - 1);
		deck.remove(deck.size() - 1);
		return temp;
	}

}
