package foo;

public class Foo<G> implements Cloneable
{
	//Foo's integer value
	int value;
	
	//new: void -> Foo
	public Foo()
	{
		value = 0;
	}
	
	//f1: Foo -> integer
	public int f1()
	{
		return value;
	}
	
	//f2: Foo x integer -> Foo
	public void f2(int num)
	{
		value = num;
	}

	//f3: Foo x Foo -> Foo
	public void f3(Foo foo)
	{
		value = foo.f1();
	}
	
	//f4: Foo x integer -> integer
	public int f4(int num)
	{
		return (value + num);
	}

	

}
