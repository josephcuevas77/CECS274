package Project1;

/**
 * Card Object
 * Contains values of cards like rank and suit
 * @author Joseph 02/07/2019
 *
 */
public class Card {

	private String nameOfCard;
	private String suit;
	private int rank;
	
	/**
	 * Default Constructor for Card
	 */
	public Card() {
		rank = 0;
		suit = "N/A";
		
	}
	
	/**
	 * Overloaded constructor for Card
	 * @param ranks - rank of Card
	 * @param suits - suit of Card
	 */
	public Card(int ranks, String suits) {
		rank = ranks;
		suit = suits;
		
		if(rank == 14) nameOfCard = "Ace of " + suit;
		
		else if(rank == 13) nameOfCard = "King of " + suit;
		
		else if(rank == 12)	nameOfCard = "Queen of " + suit;
		
		else if(rank == 11) nameOfCard = "Jack of " + suit;
		
		else nameOfCard = rank + " of " + suit;		
		
	}
	
	/**
	 * Retrieves rank of Card for comparison
	 * @return Card rank
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Retrieves suit of Card
	 * @return Card suit
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * Converts Card to String to be printed
	 */
	public String toString() {
		return nameOfCard;
	}
	
}
