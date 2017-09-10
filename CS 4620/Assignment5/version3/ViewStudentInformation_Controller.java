package version3;

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
	
		
	public static void ViewStudent(JFrame frame, ArrayList<JButton> buttonlist, JTextArea Output2, ActionEvent event)
  	{
			//check which button was pressed
			for(int x = 0; x < Data_Controller.getSize(); x++)
			{
				//if source is identified
				if( event.getSource() == buttonlist.get(x) )
				{
					String post = "";
					ArrayList<String> CI = new ArrayList<String>(Data_Controller.getStudent(x).getCareerInterests());
					
					post = Data_Controller.getStudent(x).getStudentName() + "\n";
					for(int y = 0; y < CI.size(); y++)
					{
						post += CI.get(y) + "\n";
					}
					
					//load the appropriate information
					Output2.setText(post);
					
					//escape
					x = Data_Controller.getSize();
				}
			
				
			}
			//refresh
			//frame.setVisible(false);
			//frame.setVisible(true);
			frame.validate();		
	}
	
	public static void LoadMainMenu(JFrame frame)
  	{
		//create the UI for the Main Menu
		MainMenu_UI mmp = new MainMenu_UI();
		ExitAction(frame);
	}
		
	
	public static void ExitAction (JFrame frame)
  	{
		//Force Exit
		frame.dispose();
	}
	
	
}
