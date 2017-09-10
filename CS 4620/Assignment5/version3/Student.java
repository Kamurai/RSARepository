package version3;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class Student
{
	private String StudentName;
	private ArrayList<String> CareerInterests = new ArrayList<String>();
	
	public Student( String iName, ArrayList<String> iCar)
	{
		StudentName = iName;
		CareerInterests = new ArrayList<String>(iCar);
		/*
		for(int x = 0; x < iCar.size(); x++)
		{
			CareerInterests.add(iCar.get(x));
		}
		*/
	}
	
	public String getStudentName()
	{
		return StudentName;
	}
	
	public ArrayList<String> getCareerInterests()
	{
		return CareerInterests;
	}
	
	public void setStudentName(String input)
	{
		StudentName = input;
	}
	
	public void setCareerInterests(ArrayList<String> input)
	{
		CareerInterests = new ArrayList<String>(input);
	}
	
	
}
