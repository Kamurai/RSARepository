package version3;

import java.awt.*;

import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;

public class MainMenu_Controller
{
	
	
	public MainMenu_Controller()
	{
		
	}
	
	public static void LoadViewStudentInformation (JFrame frame)
  	{
		//Load ViewStudentInformation object
		ViewStudentInformation_UI vsi = new ViewStudentInformation_UI();
		ExitAction(frame);
		
	}
	
	public static void LoadManageStudentInformation (JFrame frame)
  	{
		//Load ManageStudentInformation object
		ManageStudentInformation_UI msi = new ManageStudentInformation_UI();
		ExitAction(frame);
	}
	
	public static void ExitAction (JFrame frame)
  	{
		//Force Exit
		frame.dispose();
	}
	
}
