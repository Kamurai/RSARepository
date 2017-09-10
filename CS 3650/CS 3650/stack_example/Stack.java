package stack_example;

import java.util.ArrayList;


public class Stack<G>
{

	private ArrayList<G> data;
	
	public Stack()
	{
		data = new ArrayList<G>();
	}

	public boolean empty()
	{
		return data.isEmpty();
	}

	public G item()
	{
		return data.get(data.size() - 1);
	}

	public void remove()
	{
		data.remove(data.size() - 1);
	}

	public void put(G datum)
	{
		data.add(datum);
	}

	protected boolean remove_Precondition()
	{
		return !empty();
	}

	protected boolean item_Precondition()
	{
		return !empty();
	}

	protected boolean put_Postcondition(G datum, Void RESULT)
	{
		return !empty() && datum.equals(item());  // datum == item()
	}

	protected boolean Stack_Postcondition(Void RESULT)
	{
		return empty();
	}
	

}
