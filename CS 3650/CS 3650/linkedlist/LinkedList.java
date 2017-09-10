package linkedlist;

public class LinkedList<G> implements Cloneable
{

	private int num;

	private int currentIndex;

	private Linkable<G> active;

	private Linkable<G> previous;
	private Linkable<G> next;

	private Linkable<G> zerothElement;
	
	private Linkable<G> endElement;

	private LinkedList<G> OLD;

	public LinkedList()
	{
		//tracks size of list
		num = 0;
		//tracks "current" index
		currentIndex = 0;
		//marker element for "before" position
		zerothElement = new Linkable<G>(null, null, null);
		//marker element for "after" position
		endElement = new Linkable<G>(zerothElement, null, null);
		//pointer to current's previous
		previous = null;
		//element that is "active" or exists at currentIndex
		active = zerothElement;
		//set beginning's right to end
		active.setRight(endElement);
		//pointer to current's next
		next = endElement;
		
	}

	
	

	//insert an element "behind" of "active" element
	public void putLeft(G g)
	{
		//create a new linkable inbetween previous and active
		Linkable<G> temp = new Linkable<G>(previous, g, active);
		//link active to temp
		active.setLeft(temp);
		//link previous to temp
		previous.setRight(temp);
		//set previous
		previous = temp;
		
				
		//increase size
		num++;
		//move past new element to previously current element
		currentIndex++;
	}

	//insert an element "ahead" of "active" element
	public void putRight(G g)
	{
		//create a new linkable inbetween active and next
		Linkable<G> temp = new Linkable<G>(active, g, next);
		//link active to temp
		active.setRight(temp);
		//link next to temp
		next.setLeft(temp);
		//set next
		next = temp;
		
		
		
		//increase size
		num++;
	}

	
	//replaces the "active" element with a G item
	public void replace(G g)
	{
		active.setG(g);
	}

	//removes "active" element and reconnects links
	public void prune()
	{
		previous.setRight(active.getRight());
		active = previous.getRight();
		next = active.getRight();
		
		//reduce size
		num--;
	}

	

	

	

	//	"go" to before the first element of list
	public void goBefore()
	{
		previous = null;
		active = zerothElement;
		next = active.getRight();
		currentIndex = 0;
	}
	
	//	go to beginning of list
	public void goStart()
	{
		currentIndex = 1;
		previous = zerothElement;
		active = previous.getRight();
		next = active.getRight();
	}
	
	//"go" to the previous index
	public void goBack()
	{
		//if next is after last
		if( previous == zerothElement )
		{
			goBefore();
		}
		else
		{
			next = active;
			active = active.getLeft();
			previous = active.getLeft();
			currentIndex--;
			//go(index() - 1);
		}
	}

	//"go" to particular index
	public void go(int i)
	{
		//if "i" is less than index()
		if( i < index() )
		{
			//a) if "i" is closer to start
			if( i < (index()/2) )
			{
				//go to Start
				goStart();
				//walk forward to "i"
				while (index() < i)
				{
					goForth();
				}
				
			}
			//b) else if "i" is closer to index()
			else if( i >= (index()/2) )
			{
				//walk backwards to "i"
				while (index() > i)
				{
					goBack();
				}
			}
		}
		//else if "i" is more than index()
		else if( i > index() )
		{
			//c) if "i" is closer to index()
			if( i <= ((count() - index())/2) + index() )
			{
				//walk forward to "i"
				while (index() < i)
				{
					goForth();
				}
			}
			//d) else if "i" is closer to end
			else if( i > ((count() - index())/2) + index() )
			{
				//go to end
				goFinish();
				//walk bacwards to "i"
				while (index() > i)
				{
					goBack();
				}
			}
		}
		//"i" is equal to index
	}

	//	"go" to index where element g exists
	public void occurrence(G g)
	{
		if (isBefore())
		{
			goForth();
		}
		while (!isAfter() && !item().equals(g))
		{
			goForth();
		}
	}

	//	move current index and active element to the next item
	public void goForth()
	{
		//if next is after last
		if( next == endElement )
		{
			goAfter();
		}
		else
		{
			
			previous = active;
			active = active.getRight();
			next = active.getRight();
			currentIndex++;
			
			//go(index() + 1);
		}
	}

	//	"go" to last element of list
	public void goFinish()
	{
		currentIndex = count();
		next = endElement;
		active = endElement.getLeft();
		previous = active.getLeft();
	}
	
	//"go" to end of list
	public void goAfter()
	{
		currentIndex = count() + 1;
		next = null;
		active = endElement;
		previous = endElement.getLeft();
	}

	
	
	
	
	//	queries current index
	public int index()
	{
		return currentIndex;
	}
	
	//	queries tracked size of the list
	public int count()
	{
		return num;
	}

	//queries which item is active
	public G item()
	{
		return active.getG();
	}
	
	//	queries if list is empty
	public boolean isEmpty()
	{
		return num == 0;
	}

	//queries if current index is 0
	public boolean isBefore()
	{
		return currentIndex == 0;
	}

	
	//queries if current index is at first element of list
	public boolean isFirst()
	{
		return currentIndex == 1;
	}

	//queries if current index is at last element
	public boolean isLast()
	{
		return currentIndex == count();
	}
	
	//	queries if current index is at end of list
	public boolean isAfter()
	{
		return currentIndex == count() + 1;
	}


	//queries if current index is between first index and last index (inclusive)
	public boolean isReadable()
	{
		return currentIndex >= 1 && currentIndex <= count();
	}

	
	protected boolean item_Precondition()
	{
		return isReadable();
	}

	protected boolean occurrence_Precondition(G g)
	{
		return !isAfter();
	}

	protected boolean prune_Precondition()
	{
		return isReadable();
	}

	protected boolean putLeft_Precondition(G g)
	{
		return !isBefore();
	}

	protected boolean putRight_Precondition(G g)
	{
		return !isAfter();
	}

	protected boolean goForth_Precondition()
	{
		return !isAfter();
	}

	protected boolean goBack_Precondition()
	{
		return !isAfter();
	}

	protected boolean go_Precondition(int i)
	{
		return 0 <= i && i <= count() + 1;
	}

	protected boolean replace_Precondition(G g)
	{
		return isReadable();
	}

	protected boolean LinkedList_Postcondition(Void RESULT)
	{
		return isEmpty();
	}

	protected boolean putLeft_Postcondition(char g, Void RESULT)
	{
		boolean valid = count() == OLD.count() + 1;
		if (valid)
		{
			valid = index() == OLD.index() + 1;
			if (valid)
			{
				int location = index();
				goStart();
				OLD.goStart();
				while (index() < location - 1 && item().equals(OLD.item()))
				{
					goForth();
					OLD.goForth();
				}
				valid = index() == location - 1;
				if (valid)
				{
					valid = item().equals(g);
					if (valid)
					{
						goForth();
						while (index() <= count() && item().equals(OLD.item()))
						{
							goForth();
							OLD.goForth();
						}
						valid = index() > count();
					}
				}
				go(location);
			}
		}

		return valid;
	}

	protected boolean putRight_Postcondition(char g, Void RESULT)
	{
		boolean valid = count() == OLD.count() + 1;
		if (valid)
		{
			valid = index() == OLD.index();
			if (valid)
			{
				int location = index();
				goStart();
				OLD.goStart();
				while (index() < location && item().equals(OLD.item()))
				{
					goForth();
					OLD.goForth();
				}
				valid = index() == location;
				if (valid)
				{
					valid = item().equals(g);
					if (valid)
					{
						goForth();
						while (index() <= count() && item().equals(OLD.item()))
						{
							goForth();
							OLD.goForth();
						}
						valid = index() > count();
					}
				}
				go(location);
			}
		}

		return valid;

	}

	protected boolean occurrence_Postcondition(G g, Void RESULT)
	{
		boolean valid;
		if (isAfter())
		{
			go(OLD.index());
			if (isBefore())
				goForth();
			while (!isAfter() && !item().equals(g))
				goForth();
			valid = isAfter();
			goAfter();
		}
		else
		{
			valid = item().equals(g);
			if (valid)
			{
				int location = index();
				go(OLD.index());
				if (isBefore())
					goForth();
				while (index() < location && !item().equals(g))
					goForth();
				valid = index() == location;
				go(location);
			}
		}
		return valid;
	}

	protected boolean replace_Postcondition(G g, Void RESULT)
	{
		boolean valid = count() == OLD.count() && index() == OLD.index();
		if (valid)
		{
			int location = index();
			goStart();
			OLD.goStart();
			while (index() < location && item().equals(OLD.item()))
			{
				goForth();
				OLD.goForth();
			}
			valid = index() == location;
			if (valid)
			{
				valid = item().equals(g);
				if (valid)
				{
					goForth();
					OLD.goForth();
					while (index() <= count() && item().equals(OLD.item()))
					{
						goForth();
						OLD.goForth();
					}
					valid = index() > count();
				}
			}
			go(location);
		}
		return valid;
	}

	protected boolean prune_Postcondition(Void RESULT)
	{
		boolean valid = count() == OLD.count() - 1 && index() == OLD.index();
		if (valid)
		{
			int location = index();
			goStart();
			OLD.goStart();
			while (index() < location && item().equals(OLD.item()))
			{
				goForth();
				OLD.goForth();
			}
			valid = index() == location;
			if (valid)
			{
				OLD.goForth();
				while (index() <= count() && item().equals(OLD.item()))
				{
					goForth();
					OLD.goForth();
				}
				valid = index() > count();
			}
			go(location);
		}
		return valid;
	}

	protected boolean goStart_Postcondition(Void RESULT)
	{
		return isFirst();
	}

	protected boolean goFinish_Postcondition(Void RESULT)
	{
		return isLast();
	}

	protected boolean goForth_Postcondition(Void RESULT)
	{
		return index() == OLD.index() + 1;
	}

	protected boolean goBack_Postcondition(Void RESULT)
	{
		return index() == OLD.index() - 1;
	}

	protected boolean go_Postcondition(int i, Void RESULT)
	{
		return index() == i;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		//declare new list
		LinkedList<G> temp = new LinkedList<G>();
		//copy size to temp
		temp.num = num;
		//copy current index
		temp.currentIndex = currentIndex;
		Linkable<G> node = new Linkable<G>(null, null, null);
		temp.previous = null;
		temp.zerothElement = node;
		temp.endElement = node;
		temp.active = node;
		int location = index();
		goStart();
		Linkable<G> prev = null;
		Linkable<G> current = new Linkable<G>(null, item(), null);
		while (index() < Math.min(location, num))
		{
			goForth();
			prev = current;
			current = new Linkable<G>(null, item(), null);
			prev.setRight(current);
		}
		temp.previous = prev;
		temp.active = current;
		while (index() < num)
		{
			goForth();
			prev = current;
			current = new Linkable<G>(null, item(), null);
			prev.setRight(current);
		}
		go(location);

		return temp;
	}

	@Override
	public String toString()
	{
		String s = "";
		Linkable<G> current = zerothElement.getRight();
		for (int i = 0; i < count(); i++)
		{
			s += current.getG() + " ";
			current = current.getRight();
		}
		return s;
	}

}
