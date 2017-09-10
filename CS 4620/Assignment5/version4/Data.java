package version4;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class Data
{
	private static ArrayList<String> CareerInterests = new ArrayList<String>();
	
	private static ArrayList<Student> StudentCollection = new ArrayList<Student>();
	
	public Data()
	{
		//stub 5 students
			//Tony Stark
		CareerInterests.add("Technology");
		CareerInterests.add("Women");
		CareerInterests.add("Alcohol");
		
		StudentCollection.add(new Student("Tony Stark", CareerInterests));
		
		CareerInterests.clear();
		
		//Bruce Banner
		CareerInterests.add("Gamma Rays");
		CareerInterests.add("Anger Management");
		CareerInterests.add("The Color Green");
		
		StudentCollection.add(new Student("Bruce Banner", CareerInterests));
		
		CareerInterests.clear();
		
		//Steve Rogers
		CareerInterests.add("America");
		CareerInterests.add("Blue Tights");
		CareerInterests.add("Adamantium Shields");
		
		StudentCollection.add(new Student("Steve Rogers", CareerInterests));
		
		CareerInterests.clear();

		//Hank Pym
		CareerInterests.add("Pym Particles");
		CareerInterests.add("Yellow Tights");
		CareerInterests.add("Atom Riding");
		
		StudentCollection.add(new Student("Hank Pym", CareerInterests));
		
		CareerInterests.clear();
		
		//Peter Parker
		CareerInterests.add("Radioactive Spiders");
		CareerInterests.add("Wrestling");
		CareerInterests.add("Green Goblins");
		
		StudentCollection.add(new Student("Peter Parker", CareerInterests));
		
		CareerInterests.clear();
		
	}
	
	public static Student getStudent(int index)
	{
		return StudentCollection.get(index);
	}
	
	public static Student getStudent(String input)
	{
		for(int x = 0; x < StudentCollection.size(); x++)
		{
			if( input.compareTo(StudentCollection.get(x).getStudentName()) == 0 )
			{
				return StudentCollection.get(x);
			}
		}
		
		return new Student("No Student", new ArrayList<String>());
	}
	
	public static int getIndex(String input)
	{
		for(int x = 0; x < StudentCollection.size(); x++)
		{
			if( input.compareTo(StudentCollection.get(x).getStudentName()) == 0 )
			{
				return x;
			}
		}
		
		return -1;
	}
	
	public static ArrayList<Student> getStudentCollection()
	{
		return StudentCollection;
	}
	
	public static void updateCareerInterests(int index, ArrayList<String> input)
	{
		StudentCollection.get(index).setCareerInterests(input);
	}
	
	public static int getSize()
	{
		return StudentCollection.size();
	}
}
