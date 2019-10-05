package Project1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * War Class created to simulate game of War between Player and Bot
 * @author Joseph 02/07/2019
 *
 */
public class War {

	/**
	 * Sets up game and starts a new instance of the game for the user to play.
	 * @param args arguments taken in 
	 */
	public static void main(String[] args) {
		initializeGame();
		newGame();
	}
	static Scanner nani = new Scanner(System.in);
	private static Hand Player;
	private static Hand Bot;
	private static ArrayList<Card> pile;
	private static int turnCounter = 1;

	/**
	 * Initializes deck and hands of both player and bot in order to
	 * create new instance of the game populating both player's and bot's hand
	 */
	public static void initializeGame() {
		Deck deck = new Deck();
		Player = new Hand();
		Bot = new Hand();
		pile = new ArrayList<Card>();
		deck.shuffle();

		for(int i = 0; i < 26; i++) {
			Player.populateHand(deck.deal());
			Bot.populateHand(deck.deal());
		}
	}

	/**
	 * Handles logic of game and gives user option to either battle check the hand sizes
	 * of each player or quit the game in the midst of it.
	 */
	public static void newGame() {
		System.out.println("-WELCOME TO WAR-");

		while(Player.getHandSize() != 0 && Bot.getHandSize() != 0) {
			System.out.println("Turn: " + turnCounter);
			System.out.println("Time to decide your fate.");
			System.out.println("1.Check Hand Sizes\n2.Battle\n3.Quit");
			int input = nani.nextInt();
			while(input < 1 || input > 3) {
				System.out.println("Incorrect input! Try again!");
				System.out.println("1.Check hand sizes\n2.Quit\nOr press enter to continue onto the battle!");
				input = nani.nextInt();
			}
			if(input == 1) {
			System.out.println("Your hand size: " + Player.getHandSize());
			System.out.println("Bot's hand size: " + Bot.getHandSize() + "\n");
			}else if(input == 2) {
				battle();
			}else {
				System.out.println("Player quit. Humanity ceases to exist.");
				break;
			}
			turnCounter++;
				
		}
		if(Player.getHandSize() == 0) {
			System.out.println("The Bot wins! Humanity ceases to exist.");
			System.out.println("Mission failed, you lost!");
		}else if(Bot.getHandSize() == 0) {
			System.out.println("Humans save the day once again!");
			System.out.println("Congratulations, you won!");
		}else {
			System.out.println("Program has terminated, thanks for Playing!");
		}
	}

	/**
	 * Simulates the playing of a card from both the player and the bot and then
	 * runs through comparisons of the two and decides if one wins or go to war
	 */
	public static void battle() {
		Card playerC = Player.playCard();
		Card botC = Bot.playCard();
		pile.add(playerC);
		pile.add(botC);
		
		System.out.println("Your played card: " + playerC);
		System.out.println("VS.");
		System.out.println("Bot's played card: " + botC + "\n");
		
		if(playerC.getRank() == botC.getRank()) {
			war();
		}else if(playerC.getRank() > botC.getRank()) {
			System.out.println("Bot will play another Card!" + "\n");
			Card botC2 = Bot.playCard();
			pile.add(botC2);
			System.out.println("Second Card played by Bot: " + botC2 + "\n");
			if(botC.getRank() + botC2.getRank() < playerC.getRank()) {
				System.out.println("The (ro)bot(s) took over the navy! Bot wins!" + "\n");
				payoutCards(Bot);
			}else if(botC.getRank() + botC2.getRank() > playerC.getRank()) {
				System.out.println("Humanity survives another day! Player wins!" + "\n");
				payoutCards(Player);
			}else {
				war();
			}
		}else if(playerC.getRank() < botC.getRank()) {
			if(Player.getHandSize() >= 1) {
				System.out.println("1.Play second card\n2.Hand over cards" + "\n");
				int decision = nani.nextInt();
				while(decision < 1 || decision > 2) {
					System.out.println("Invalid choice! Please select a valid option");
					System.out.println("1. Play second card\n2.Hand over cards");
					decision = nani.nextInt();
				}
				if(decision == 1) {
					Card playerC2 = Player.playCard();
					pile.add(playerC2);
					System.out.println("Second Card: " + playerC2);
					if(playerC.getRank() + playerC2.getRank() < botC.getRank()) {
						System.out.println("Player wins!" + "\n");
						payoutCards(Player);
					}else if(playerC.getRank() + playerC2.getRank() > botC.getRank()) {
						System.out.println("Bot wins!" + "\n");
						payoutCards(Bot);
					}else {
						war();
					}
				}else if(decision == 2) {
					System.out.println("That's unfortunate, the Bot wins!" + "\n");
					payoutCards(Bot);
				}
			}
		}
	}

	/**
	 * Simulates the win conditions of a tie between played cards of the player and bot
	 * then decides next outcome depending on burning 3 cards then playing next card
	 */
	public static void war() {
		if(Player.getHandSize() == 0 || Bot.getHandSize() == 0) {return;}
		for(int i = 0; i < 3; i++) {
			if(Player.getHandSize() != 1) { pile.add(Player.playCard()); }
			if(Bot.getHandSize() != 1) { pile.add(Bot.playCard()); }

			Card playerC = Player.playCard();
			Card botC = Bot.playCard();
			pile.add(playerC);
			pile.add(botC);

			if(playerC.getRank() > botC.getRank()) { 
				System.out.println("Player wins!" + "\n");
				payoutCards(Player);
			}else if(botC.getRank() > playerC.getRank()) {
				System.out.println("Bot wins!" + "\n");
				payoutCards(Bot);
			}else {
				war();
			}
		}

	}

	/*
	 * Whomever wins a round, this function gives the pile of cards
	 * created by each player playing cards to the winner
	 */
	public static void payoutCards(Hand hand) {
		for(Card c:pile) {
			hand.populateHand(c);
		}
		pile.clear();
	}
}