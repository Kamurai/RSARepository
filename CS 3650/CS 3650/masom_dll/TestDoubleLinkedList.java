package masom_dll;

public class TestDoubleLinkedList
{

	public static void main(String[] args)
	{
		DoublyLinkedList<String> l = new DoublyLinkedList<String>();
		l.putRight("masom");
		l.putRight("laila");
		l.goForth();
		l.putLeft("randa");
		l.goAfter();
		l.putLeft("samir");
		l.goBefore();
		l.occurrence("laila");
		System.out.println ("The index of the occurence of 'laila' is at index #" + l.index());
		displayList (l);
		System.out.println ("The entire list: [" + l + "]");
		l.prune();
		System.out.println ("The entire list after pruning 'laila': [" + l + "]");
		l.putRight("laila");
		l.putLeft("raffi");
		System.out.println ("The entire list after adding 'laila' and 'raffi': [" + l + "]");
		l.occurrence("masom");
		l.replace("Masom_Hamadeh");
		System.out.println ("The entire list after going to 'masom' and replacing [" + l + "]");
	}

	private static void displayList(DoublyLinkedList<String> l)
	{
		int location = l.index();
		l.goStart();
		for (int i = 0; i < l.count(); i++)
		{
			System.out.println (l.item());
			l.goForth();
		}
		l.go(location);
	}
}
