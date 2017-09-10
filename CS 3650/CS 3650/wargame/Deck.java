package wargame;

import java.util.ArrayList;
import java.util.Random;





public class Deck implements Cloneable
{

	private  ArrayList<Card> cardlist;
	private Deck OLD;

	
	public Deck()
	{
		cardlist = new ArrayList<Card>();
		
		//build deck
			//build suits
		ArrayList<String> suits = new ArrayList<String>();
		suits.add("Diamonds");
		suits.add("Clubs");
		suits.add("Hearts");
		suits.add("Spades");
		
		//build ranks
		ArrayList<String> ranks = new ArrayList<String>();
		
		ranks.add("2");
		ranks.add("3");
		ranks.add("4");
		ranks.add("5");
		ranks.add("6");
		ranks.add("7");
		ranks.add("8");
		ranks.add("9");
		ranks.add("10");
		ranks.add("J");
		ranks.add("Q");
		ranks.add("K");
		ranks.add("A");
		
		//walk through suits
		for(int x = 0; x < suits.size(); x++)
		{
			//walk through ranks
			for(int y = 0; y < ranks.size(); y++)
			{
				cardlist.add( new Card(ranks.get(y), suits.get(x)) );
				//System.out.println(ranks.get(y) + " of " + suits.get(x));
			}
		}
		
		System.out.println("Rank: " + this.drawtop().getRank());
		System.out.println("Suit: " + this.drawtop().getSuit());
		
	}
	
	public Object clone()
	{
		//declare new temp
		Deck temp = new Deck();
		temp.cardlist = new ArrayList<Card>(this.cardlist);
				
		return temp;
		
		
	}
	
	public boolean empty() 
	{
		if(cardlist.size() == 0)
		{
			return true;
		}
		return false;
	}

	public int count() 
	{
		return cardlist.size();
	}

	public Card drawtop() 
	{
		return cardlist.get(cardlist.size()-1);
	}

	public void removetop() 
	{
		cardlist.remove(cardlist.size()-1);
	}

	public void shuffle() 
	{
		ArrayList<Card> temp = new ArrayList<Card>();
		
		Random generator = new Random();
		int index = 0;
		
		//transfer all cards from cardlist to temp
		while(cardlist.size() != 0)
		{
			index = generator.nextInt(cardlist.size()); 
			//add to temp a random card from cardlist
			temp.add(cardlist.get(index));
			//remove that card from cardlist
			cardlist.remove(index);
		}
		
		cardlist = temp;
	}

	public void tuckunder(Card card) 
	{
		cardlist.add(0, card);
	}

	protected boolean drawtop_Precondition() 
	{
		return (!empty());
	}
	
	protected boolean removetop_Precondition() 
	{
		return (!empty());
	}

	protected boolean shuffle_Precondition() 
	{
		return (!empty());
	}

	protected boolean Deck_Postcondition(Void RESULT) 
	{
		return (count() == 52 && !empty() && drawtop().getSuit().compareTo("Spades") == 0 && drawtop().getRank().compareTo("A") == 0);
	}
	
	protected boolean removetop_Postcondition(Void RESULT)
	{
		//this is supposed to prevent the postcondition from failing when drawtop is called
			//on the recently emptied deck
		if(count() > 0)
		{
			return ( drawtop() != OLD.drawtop() && count() == (OLD.count() - 1));
		}
		else
		{
			return ( empty() );
			
			/********************************************
			 * would also be true in this case that the
			 * count has been decreased by 1
			 */
		}
	}

	protected boolean tuckunder_Postcondition(Card card, Void RESULT)
	{
		return (count() == OLD.count() + 1);
	}

	protected boolean _Invariant() 
	{
		if(count() >= 0 && ((empty() == (cardlist.size() == 0)) || (!empty() == cardlist.size() > 0)))
		{
			return true;
		}
		return false;
	}

	protected boolean empty_Postcondition(boolean RESULT) 
	{
		if(cardlist.size() == 0)
		{
			if(RESULT == true)
			{
				return true;
			}
		}
		return false;
	}
	
	protected boolean count_Postcondition(int RESULT) 
	{
		return (RESULT >= 0);
	}

	protected boolean shuffle_Postcondition(Void RESULT) 
	{
		return (count() == OLD.count());
	}

}
