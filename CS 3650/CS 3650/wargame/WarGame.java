package wargame;



import java.util.ArrayList;



public class WarGame {

	private Deck startingdeck;
	private ArrayList<WarHand> Player;
	private int warcounter;
	
	public WarGame() 
	{
		warcounter = 0;
		startingdeck = new Deck();
		
		//test deck draw
		//System.out.println(startingdeck.drawtop().getRank() + " of " + startingdeck.drawtop().getSuit());
		
		Player = new ArrayList<WarHand>();
		
		Player.add(new WarHand());
		Player.add(new WarHand());
		
		deal();
		play();
	}
	
	public void deal() 
	{
		int tracker = 0;
		startingdeck.shuffle();
		
		//deal all cards into player hands
		for(int x = 0; x < startingdeck.count(); x++)
		{
			Player.get(tracker).tuckunder(startingdeck.drawtop());
			startingdeck.removetop();
			
			if(tracker == 0)
			{
				tracker = 1;
			}
			else if(tracker == 1)
			{
				tracker = 0;
				
				/**************************************
				 * boolean would be a better choice for
				 * tracker
				 */
				/*
				 * I specifically left this as int in order to allow more people to be added to the game.
				 */
			}
		}
		
		//System.out.println("MOO");
		
		//test loop for player 1
		//for(int x = 0; x < Player.get(0).count(); x++)
		//{
			//print card
			//System.out.println(Player.get(0).drawtop().getRank() + " of " + Player.get(0).drawtop().getSuit());
			//copy card to bottom of deck
			//Player.get(0).tuckunder(Player.get(0).drawtop());
			//remove duplicate card
			//Player.get(0).removetop();
		//}
	}
	
	public void play() 
	{
		boolean end = false;
		
		//while game is still on
		while(!end)
		{
			//compare cards
			compare();
			
			//check if game is over
			if(Player.get(0).count() == 0 && Player.get(1).count() == 0)
			{
				//draw
				System.out.println("DRAW!");
				end = true;
				
				/*********************************
				 * how can this happen?
				 */
				/*
				 * I was honestly covering all possible bases without thinking about it too much.
				 * Theorectically the only way this would happen is if both players played the 
				 * exact ranks against one another for the entire game
				 * This is because this system does not compare suits as having value
				 */
			}
			else if(Player.get(0).count() == 0)
			{
				//player 1 wins
				System.out.println("Player 2 WINS!");
				end = true;
				
			}
			else if(Player.get(1).count() == 0)
			{
				//player 2 wins
				System.out.println("Player 1 WINS!");
				end = true;
				
			}
			
		}
		
	}
	
	public void compare() 
	{
		//comparision integers
		int a = 0;
		int b = 0;
		
		//compare cards from the WarHands
		
		a = translaterank(Player.get(0).drawtop().getRank());
		System.out.println("Player 1: " + Player.get(0).drawtop().getRank() + " of " + Player.get(0).drawtop().getSuit());
		b = translaterank(Player.get(1).drawtop().getRank());
		System.out.println("Player 2: " + Player.get(1).drawtop().getRank() + " of " + Player.get(1).drawtop().getSuit());
		
		
		//if a is greater than b
		if( a > b || (a == b && Player.get(1).count() == 1))
		{
			//resolve win
				//transfer both cards to the bottom of the winning player
			Player.get(0).tuckunder(Player.get(0).drawtop());
			Player.get(0).tuckunder(Player.get(1).drawtop());
			
			System.out.println("Goes to Player 1");
			
			
			
			//remove duplicate cards
			Player.get(0).removetop();
			Player.get(1).removetop();
			
			//resolve "war()"
			for(int x = warcounter; x > 0; x--)
			{
				Player.get(0).tuckunder(startingdeck.drawtop());
				startingdeck.removetop();
				warcounter--;
			}
			
		}
		//else if b is greater than a
		else if( b > a || (a == b && Player.get(0).count() == 1))
		{
			//resolve win
				//transfer both cards to the bottom of the winning player
			Player.get(1).tuckunder(Player.get(1).drawtop());
			Player.get(1).tuckunder(Player.get(0).drawtop());
		
			System.out.println("Goes to Player 2");
		
		
		
			//remove duplicate cards
			Player.get(0).removetop();
			Player.get(1).removetop();
			
			//resolve "war()"
			for(int x = warcounter; x > 0; x--)
			{
				Player.get(1).tuckunder(startingdeck.drawtop());
				startingdeck.removetop();
				warcounter--;
			}
		}
		//else if a == b AND not on last card on either deck
		else if( a == b && Player.get(0).count() != 1 && Player.get(1).count() != 1)
		{
			System.out.println("War!");
			
			//then implement war()
			war();
		}
		
		
		
	}
	
	public void war() 
	{
		//move top card of each WarHand to Deck
		startingdeck.tuckunder(Player.get(0).drawtop());
		startingdeck.tuckunder(Player.get(1).drawtop());
		warcounter += 2;
	
		Player.get(0).removetop();
		Player.get(1).removetop();
		
		//move next three of each WarHand to Deck
		for(int x = 0; x < 3; x++)
		{
			if(Player.get(0).count() != 1)
			{
				startingdeck.tuckunder(Player.get(0).drawtop());
				System.out.println("Player 1: " + Player.get(0).drawtop().getRank() + " of " + Player.get(0).drawtop().getSuit());
				Player.get(0).removetop();
				warcounter += 1;
				
			}
			
			if(Player.get(1).count() != 1)
			{
				startingdeck.tuckunder(Player.get(1).drawtop());
				System.out.println("Player 2: " + Player.get(1).drawtop().getRank() + " of " + Player.get(1).drawtop().getSuit());
				Player.get(1).removetop();
				warcounter += 1;
			}
				
			
			
		}
		
		//call compare
		compare();
	}

	public int translaterank(String rank) 
	{
		if(rank.compareTo("J") == 0)
		{
			return 11;
		}
		else if(rank.compareTo("Q") == 0)
		{
			return 12;
		}
		else if(rank.compareTo("K") == 0)
		{
			return 13;
		}
		else if(rank.compareTo("A") == 0)
		{
			return 14;
		}
		else
		{
			if(Integer.parseInt(rank) >= 2 && Integer.parseInt(rank) <= 10)
			{
				return Integer.parseInt(rank);
			}
			else
			{
				return -1;
			}
		}
	}

}
