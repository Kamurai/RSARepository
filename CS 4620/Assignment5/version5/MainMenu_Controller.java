package version5;

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
	
	public static void LoadViewStudentInformation ()
  	{
		//Load ViewStudentInformation object
		ViewStudentInformation_UI vsi = new ViewStudentInformation_UI();		
	}
	
	public static void LoadManageStudentInformation ()
  	{
		//Load ManageStudentInformation object
		ManageStudentInformation_UI msi = new ManageStudentInformation_UI();
	}
	
	public static void ExitAction (JFrame frame)
  	{
		//Force Exit
		frame.dispose();
	}
	
}
