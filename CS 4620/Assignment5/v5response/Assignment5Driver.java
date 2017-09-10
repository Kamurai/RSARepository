package v5response;


import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;

public class Assignment5Driver 
{
	//private static StudentInfoManager dcontrol = new StudentInfoManager();
	
	/************************************************
	 * Since all the methods in StudentInfoManager
	 * are static, there is no reason to create a
	 * studentInfoManager object.
	 */
	/*
	 * fixed
	 */
	
	public static void main (String[] args)
	{
		MainMenu_UI mmui = new MainMenu_UI();
		
		/*************************************************
		 * I am confused.  The constructor for MainMenu_Controller
		 * is empty so there is nothing to run.
		 */
	}
	
	
}


/***********************************************
Where are the use case controller classes?  I am
assuming that your DataController class is the boundary
class to the persistent storage.  If so, 
You have the UI communicating directly with the
student information boundary class.

Why did you change the model?

18/50

***********************************************/

/************************************************
You have not implemented the appropriate layering
because you have the UI accessing the boundary class
and you have the controllers coupled to the UI.
Please see my comments in your code.

34/50
*/