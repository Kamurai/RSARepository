package wargame;

import java.lang.String;

public class Card {

	private String Rank;
	private String Suit;
	
	/********************************************************
	 * Your implementation would be "cleaner" if you used
	 * enumerated types instead of strings.
	 */
	public Card(String Rank, String Suit) 
	{
		this.Rank = Rank;
		this.Suit = Suit;
	}
	public String getSuit() 
	{
		return Suit;
	}
	public String getRank() 
	{
		return Rank;
	}
	protected boolean Card_Precondition(String Rank, String Suit)
	{
		return (Suit.compareTo("Diamonds") == 0 || Suit.compareTo("Clubs") == 0 || Suit.compareTo("Hearts") == 0 || Suit.compareTo("Spades") == 0);
		
	}
	
	protected boolean Card_Postcondition(String Rank, String Suit, Void RESULT) 
	{
		return (Rank.compareTo("2") == 0 ||
				Rank.compareTo("3") == 0 ||
				Rank.compareTo("4") == 0 ||
				Rank.compareTo("5") == 0 ||
				Rank.compareTo("6") == 0 ||
				Rank.compareTo("7") == 0 ||
				Rank.compareTo("8") == 0 ||
				Rank.compareTo("9") == 0 ||
				Rank.compareTo("10") == 0 ||
				Rank.compareTo("J") == 0 ||
				Rank.compareTo("Q") == 0 ||
				Rank.compareTo("K") == 0 ||
				Rank.compareTo("A") == 0);
	}
	
	/**********************************************
	 * should be a precondition
	 */
	
	protected boolean getRank_Postcondition(Void RESULT) 
	{
		return (Rank.compareTo("2") == 0 ||
				Rank.compareTo("3") == 0 ||
				Rank.compareTo("4") == 0 ||
				Rank.compareTo("5") == 0 ||
				Rank.compareTo("6") == 0 ||
				Rank.compareTo("7") == 0 ||
				Rank.compareTo("8") == 0 ||
				Rank.compareTo("9") == 0 ||
				Rank.compareTo("10") == 0 ||
				Rank.compareTo("J") == 0 ||
				Rank.compareTo("Q") == 0 ||
				Rank.compareTo("K") == 0 ||
				Rank.compareTo("A") == 0);
	}
	
	protected boolean getSuit_Postcondition(Void RESULT) 
	{
		return (Suit.compareTo("Diamonds") == 0 || Suit.compareTo("Clubs") == 0 || Suit.compareTo("Hearts") == 0 || Suit.compareTo("Spades") == 0);
	}

}
