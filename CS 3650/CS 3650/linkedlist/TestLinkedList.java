package linkedlist;


public class TestLinkedList
{

	public static void main(String[] args)
	{
		//initial testing
		LinkedList<String> l = new LinkedList<String>();
		l.putRight("abc");
		l.putRight("def");
		l.goForth();
		l.putLeft("xyz");
		l.goAfter();
		l.putLeft("sss");
		l.goBefore();
		l.occurrence("aaa");
		System.out.println ("Index: " + l.index());
		displayList (l);
		System.out.println (l);
		
		//secondary testing
		l.goFinish();
		l.goBack();
		l.putLeft("123");
		l.go(6);
		l.putRight("456");
		displayList (l);
		System.out.println (l);
		reversedisplayList (l);
		System.out.println (l);
		
	}

	private static void displayList(LinkedList<String> l)
	{
		int location = l.index();
		l.goBefore();
		System.out.println("Before: " + l.item());
		l.goStart();
		System.out.println("Start: " + l.item() + "\n");
		for (int i = 0; i < l.count(); i++)
		{
			System.out.println ((i+1) + ": " + l.item());
			l.goForth();
		}
		l.go(location);
	}
	
	private static void reversedisplayList(LinkedList<String> l)
	{
		int location = l.index();
		l.goAfter();
		System.out.println("After: " + l.item());
		l.goFinish();
		System.out.println("Start: " + l.item() + "\n");
		for (int i = l.count(); i > 0; i--)
		{
			System.out.println ((i) + ": " + l.item());
			l.goBack();
		}
		l.go(location);
	}
}
