package version4;

import java.awt.*;
import javax.swing.*;

import v5response.Student;
import v5response.StudentInfoManager;

import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewStudentInformation_Controller
{
		
	public ViewStudentInformation_Controller()
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
		ArrayList<String> CI = new ArrayList<String>(Data_Controller.getStudent(x).getCareerInterests());
					
		post = Data_Controller.getStudent(x).getStudentName() + "\n";
		for(int y = 0; y < CI.size(); y++)
		{
			post += CI.get(y) + "\n";
		}
					
		//load the appropriate information
		return post;

	}
	
	public static void LoadMainMenu()
  	{
		//create the UI for the Main Menu
		MainMenu_UI mmp = new MainMenu_UI();
	}
		
	
	
}
