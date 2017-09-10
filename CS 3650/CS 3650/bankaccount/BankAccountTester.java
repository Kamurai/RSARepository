package bankaccount;

public class BankAccountTester 
{
	public void runTest()
	{
		//test preconditions (negative testing)
		
		BankAccount a = new BankAccount (-300, "Smith");
		System.out.println(a.getBalance());
		
		//test postconditions
	}
}
