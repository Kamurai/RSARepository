//Masom Hamadeh
//CS3650 - Final Exam: Question #4

package masom_dll;

public class DoublyLinkedList<G> implements Cloneable
{
	//NOTE: I am assuming that this is NOT a circularly doubly linked list...
	
	private int num;

	private int currentIndex;

	private Linkable<G> active;

	private Linkable<G> previous; //**will use this to hold the node that previous to active/current node

	private Linkable<G> zerothElement;

	private DoublyLinkedList<G> OLD;

	public DoublyLinkedList() //new LinkedList
	{
		num = 0;
		currentIndex = 0;
		previous = null;
		zerothElement = new Linkable<G>(null, null, null); //edited constructor
		active = zerothElement;
	}

	public boolean isEmpty()
	{
		return num == 0;
	}

	public int count()
	{
		return num;
	}

	public G item()
	{
		return active.getG();
	}

	//edited to allow for doubly linked
	public void putLeft(G g) {
		Linkable<G> temp = new Linkable<G>(g, null, null);
		previous.setRight(temp);
		temp.setBehind(previous);
		temp.setRight(active);
		num++;
		currentIndex++;
	}

	//edited to allow for doubly linked
	public void putRight(G g) {
		Linkable<G> temp = new Linkable<G>(g, null, null);
		temp.setRight(active.getRight());
		temp.setBehind(active); 
		active.setRight(temp);		
		num++;
	}

	public void occurrence(G g)
	{
		if (isBefore())
			goForth();
		while (!isAfter() && !item().equals(g))
			goForth();
	}

	public void replace(G g)
	{
		active.setG(g);
	}

	//edited to allow for doubly linked
	public void prune() {
		previous.setRight(active.getRight());
		active.getRight().setBehind(previous); 
		active = previous.getRight();
		num--;
	}

	public int index()
	{
		return currentIndex;
	}

	public void goStart()
	{
		currentIndex = 1;
		previous = zerothElement;
		active = previous.getRight();
	}

	public void goFinish()
	{
		go(count());
	}

	public void goForth()
	{
		previous = active;
		active = active.getRight();
		currentIndex++;
	}

	public void goBack()
	{
		go(index() - 1);
	}

	public void go(int i)
	{
		if (i < index())
			goBefore();
		while (index() < i)
			goForth();
	}

	public void goBefore()
	{
		previous = null;
		active = zerothElement;
		currentIndex = 0;
	}

	public void goAfter()
	{
		go(count() + 1);
	}

	public boolean isBefore()
	{
		return currentIndex == 0;
	}

	public boolean isAfter()
	{
		return currentIndex == count() + 1;
	}

	public boolean isFirst()
	{
		return currentIndex == 1;
	}

	public boolean isLast()
	{
		return currentIndex == count();
	}

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
		DoublyLinkedList<G> temp = new DoublyLinkedList<G>();
		temp.num = num;
		temp.currentIndex = currentIndex;
		Linkable<G> node = new Linkable<G>(null, null, null); //edited constructors
		temp.previous = null;
		temp.zerothElement = node;
		temp.active = node;
		int location = index();
		goStart();
		Linkable<G> prev = null;
		Linkable<G> current = new Linkable<G>(item(), null, null); //edited constructors
		while (index() < Math.min(location, num))
		{
			goForth();
			prev = current;
			current = new Linkable<G>(item(), null, null); //edited constructors
			prev.setRight(current);
		}
		temp.previous = prev;
		temp.active = current;
		while (index() < num)
		{
			goForth();
			prev = current;
			current = new Linkable<G>(item(), null, null); //edited constructors
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
