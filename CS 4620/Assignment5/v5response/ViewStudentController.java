package v5response;


import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewStudentController
{
		
	public ViewStudentController()
	{
		
	}
	
	public static Student getStudent(int x)
	{
		return StudentInfoManager.getStudent(x);
	}
	
	public static int getStudentCollectionSize()
	{
		return StudentInfoManager.getSize();
	}
	
	public static String ViewStudent(int x)
  	{
		String post = "";
		ArrayList<String> CI = new ArrayList<String>(StudentInfoManager.getStudent(x).getCareerInterests());
					
		post = StudentInfoManager.getStudent(x).getStudentName() + "\n";
		for(int y = 0; y < CI.size(); y++)
		{
			post += CI.get(y) + "\n";
		}
					
		//load the appropriate information
		return post;

	}
	
	
		
	
	
}
