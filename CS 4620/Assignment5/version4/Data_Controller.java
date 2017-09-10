package version4;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class Data_Controller
{
	//this is the database stub
	private static Data Information = new Data();
	
	public Data_Controller()
	{
		
	}
	
	public static ArrayList<Student> getAllStudents()
	{
		
		return Information.getStudentCollection();
	}
	
	public static Student getStudent(int index)
	{
		return Information.getStudent(index);
	}
	
	public static Student getStudent(String input)
	{
		return Information.getStudent(input);
	}
	
	public static int getIndex(String input)
	{
		return Information.getIndex(input);
	}
	
	public static void updateCareerInterests(int index, ArrayList<String> input)
	{
		Information.updateCareerInterests(index, input);
	}
	
	public static int getSize()
	{
		return Information.getSize();
	}
	
}
