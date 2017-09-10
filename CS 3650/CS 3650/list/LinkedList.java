package list;

import java.util.*;

public class LinkedList implements Cloneable
{

	public LinkedList() 
	{
	
	}

	//query if empty
	public boolean empty() 
	{
	
		return false;
	}

	//query how many in container
	public int count() 
	{
		
		return 0;
	}
	
	//query what item at index
	public String item(int index) 
	{
		
		return "";
	}
	
	//query where is first occurrence of item
	public int occurrence(String item) 
	{
		
		return 0;
	}

	//mutate by removing item at index
	public void prune(int index) 
	{
	
	}

	//mutate by putting item at index
	public void put(String item, int index) 
	{
	
	}

	//mutate by replacing item at index with item
	public void replace(int index, String item) 
	{
	
	}

	protected boolean item_Precondition(int index, String RESULT)
	{
		return true;
	}
	
	protected boolean put_Precondition(int index, Void RESULT)
	{
		return true;
	}
	
	protected boolean prune_Precondition(int index, Void RESULT)
	{
		return true;
	}
	
	protected boolean replace_Precondition(int index, String item, Void RESULT)
	{
		return true;
	}
	
	protected boolean LinkedList_Postcondition(Void RESULT)
	{
		return true;
	}

	protected boolean Occurrence_Postcondition(Void RESULT)
	{
		return true;
	}

	protected boolean Put_Postcondition(Void RESULT)
	{
		return true;
	}

	protected boolean Prune_Postcondition(Void RESULT)
	{
		return true;
	}

	protected boolean Replace_Postcondition(Void RESULT)
	{
		return true;
	}

	

}
