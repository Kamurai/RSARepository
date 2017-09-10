package wargame;

import java.util.ArrayList;




public class WarHand implements Cloneable
{

	private ArrayList<Card> cardlist;
	private WarHand OLD;

	public WarHand() 
	{
		cardlist = new ArrayList<Card>();
	}
	
	public Object clone()
	{
		
		//declare new temp
		WarHand temp = new WarHand();
		
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

	protected boolean WarHand_Postcondition(Void RESULT) 
	{
		return (empty() && count() == 0);
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
		}
		
	}

	protected boolean tuckunder_Postcondition(Card card, Void RESULT)
	{
		return (count() == OLD.count() + 1);
	}

	protected boolean _Invariant() 
	{
		return count() >= 0;
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
