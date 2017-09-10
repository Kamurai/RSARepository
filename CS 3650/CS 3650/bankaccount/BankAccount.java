package bankaccount;

import java.lang.String;

public class BankAccount implements Cloneable
{

	private double balance;
	private String holder;
	private BankAccount OLD;

	public BankAccount(double amount, String holder) 
	{
		this.balance = amount;
		this.holder = holder;
	}

	
	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getHolder() {
		return holder;
	}


	public void setHolder(String holder) {
		this.holder = holder;
	}


	public void deposit(double amount) 
	{
		balance = balance + amount;
	}

	public void withdraw(double amount) 
	{
		balance = balance - amount;
	}


	protected boolean BankAccount_Precondition(double amount, String holder) 
	{
		return amount >= 0;
	}


	protected boolean deposit_Precondition(double amount) 
	{
		return amount > 0;
	}


	protected boolean withdraw_Precondition(double amount) 
	{
		return amount > 0;
	}


	protected boolean BankAccount_Postcondition(double amount, String holder,
			Void RESULT) 
	{
		return (amount == balance) && (holder == this.holder);
	}


	protected boolean deposit_Postcondition(double amount, Void RESULT) 
	{
		return balance == OLD.balance + amount;
	}


	protected boolean withdraw_Postcondition(double amount, Void RESULT) 
	{
		return balance == OLD.balance - amount;
	}


	protected boolean setHolder_Postcondition(String holder, Void RESULT) 
	{
		return this.holder == holder;
	}


	protected boolean _Invariant() 
	{
		return balance >= 0;
	}

}
