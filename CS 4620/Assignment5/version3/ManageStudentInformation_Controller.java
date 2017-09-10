package version3;

import java.awt.*;
import javax.swing.*;

import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ManageStudentInformation_Controller
{
	
		
	public ManageStudentInformation_Controller()
	{
		
	}
	
	public static void UpdateStudent (JFrame frame, ArrayList<JTextField> inputlist, JTextArea Output2)
	{
		//identify the student to update
		int index = Data_Controller.getIndex(Output2.getText());
		//update that student with a temporary list
		//ArrayList<String> CI = new ArrayList<String>(dcontrol.getStudent(index).getCareerInterests());
		ArrayList<String> CI = new ArrayList<String>();
		
		for(int x = 0; x < inputlist.size(); x++ )
		{
			CI.add(inputlist.get(x).getText());
		}
		
		Data_Controller.updateCareerInterests(index, CI);
		
		//refresh
		//frame.setVisible(false);
		//frame.setVisible(true);
		frame.validate();
	}

	
	public static void ViewStudent (JFrame frame, JPanel CenterPanel, ArrayList<JButton> buttonlist, ArrayList<JTextField> inputlist, JTextArea Output2, ActionEvent event )
	{
		//check which button was pressed
		for(int x = 0; x < Data_Controller.getSize(); x++)
		{
			//if source is identified
			if( event.getSource() == buttonlist.get(x) )
			{
				//load the appropriate information
				Output2.setText(Data_Controller.getStudent(x).getStudentName());
				
				ArrayList<String> CI = new ArrayList<String>(Data_Controller.getStudent(x).getCareerInterests());
				
				CenterPanel.setLayout(new GridLayout(CI.size(), 1));
				CenterPanel.removeAll();
				inputlist.clear();
				for(int y = 0; y < CI.size(); y++)
				{
					inputlist.add(new JTextField( CI.get(y)));
					CenterPanel.add(inputlist.get(y));			
					
				}
					
				
					
				//escape
				x = Data_Controller.getSize();
			}
			
				
		}
		//refresh
		//frame.setVisible(false);
		//frame.setVisible(true);
		frame.validate();
	}
		

	
	
	
	public static void LoadMainMenu(JFrame frame )
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
