package v5response;


import java.awt.*;
import javax.swing.*;

import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ManageStudentController
{
	
		
	public ManageStudentController()
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
	
	public static void UpdateStudent (ArrayList<String> CI, String input)
	
	/****************************************************
	 * You have the controller tightly coupled to a
	 * particular UI technology.  The controller should
	 * not be coupled to anything in the UI.
	 */
	{
		
		
		StudentInfoManager.updateCareerInterests(StudentInfoManager.getIndex(input), CI);
		
	}

	
	public static void ViewStudent (ArrayList<JButton> buttonlist, ArrayList<JTextField> inputlist, JTextArea Output2, ActionEvent event )
	{
		
		/****************************
		 * same comments
		 */
		//check which button was pressed
		/*for(int x = 0; x < StudentInfoManager.getSize(); x++)
		{
			//if source is identified
			if( event.getSource() == buttonlist.get(x) )
			{
				//load the appropriate information
				Output2.setText(StudentInfoManager.getStudent(x).getStudentName());
				
				ArrayList<String> CI = new ArrayList<String>(StudentInfoManager.getStudent(x).getCareerInterests());
				
				CenterPanel.setLayout(new GridLayout(CI.size(), 1));
				CenterPanel.removeAll();
				inputlist.clear();
				for(int y = 0; y < CI.size(); y++)
				{
					inputlist.add(new JTextField( CI.get(y)));
					CenterPanel.add(inputlist.get(y));			
					
				}
					
				
					
				//escape
				x = StudentInfoManager.getSize();
			}
			
				
		}*/
	}
		
	
	
}
