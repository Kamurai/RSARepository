package v5response;


import java.awt.*;

import javax.swing.*;

import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ManageStudentInformation_UI
{
	//private DataController dcontrol = new DataController();
	private ManageStudentController msc = new ManageStudentController();
	
	private JFrame frame = new JFrame("Assignment5");
	private JPanel masterpanel = new JPanel();
	
	//Top of Page
	private JPanel NorthPanel = new JPanel();
	private JTextArea Output1 = new JTextArea("");
	private JTextArea Output2 = new JTextArea("");
	private String Introduction;
	
	//Middle of Page
	private JPanel CenterPanel = new JPanel();
	private JButton GoToViewStudentInformation = new JButton ("View Student Information");
	private JButton GoToManageStudentInformation = new JButton ("Manage Student Information");
	private ArrayList<JTextField> inputlist = new ArrayList<JTextField>();
	
	//bottom of Page
	private JButton GoToMainMenu = new JButton ("Return to Main Menu");
	private JButton Exit = new JButton ("Exit Program");
	
	//left of Page
	private ArrayList<JButton> buttonlist = new ArrayList<JButton>();
	
	//right of Page
	private JButton UpdateStudentInformation = new JButton("Update Student Information");
	
	private JPanel EastPanel = new JPanel();
	private JPanel WestPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();
		
	public ManageStudentInformation_UI()
	{
		for(int x = 0; x < StudentInfoManager.getSize(); x++)
		{
			buttonlist.add(new JButton(ManageStudentController.getStudent(x).getStudentName()));
			/***********************************************
			 * You have the UI directly accessing the
			 * boundary class.
			 */
			/*
			 * fixed
			 */
		}
		
		//Set Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//End Frame
		frame.pack();
		
		frame.setVisible(true);

		//set variables
		Introduction = "Welcome Administrator.\n";
		Introduction += "Please select a student.\n";
 		Introduction += "That student's information will be displayed.\n";
	
		//set Border Layout
		masterpanel.setLayout( new BorderLayout() );
		//frame.setLayout( new BorderLayout() );
		
		//organize buttons vertically
		SouthPanel.setLayout(new GridLayout(2,1));
		
		WestPanel.setLayout(new GridLayout(ManageStudentController.getStudentCollectionSize(), 1));
		
		/***************
		 * same comment
		 */
		/*
		 * fixed
		 */
		
		
		//set Subsequent Panels
		masterpanel.add( NorthPanel, BorderLayout.NORTH);
		masterpanel.add( CenterPanel, BorderLayout.CENTER);
		//frame.add( NorthPanel, BorderLayout.NORTH);
		//frame.add( CenterPanel, BorderLayout.CENTER);
		
		masterpanel.add( EastPanel, BorderLayout.EAST);
		masterpanel.add( WestPanel, BorderLayout.WEST);
		masterpanel.add( SouthPanel, BorderLayout.SOUTH);
		//frame.add( EastPanel, BorderLayout.EAST);
		//frame.add( WestPanel, BorderLayout.WEST);
		//frame.add( SouthPanel, BorderLayout.SOUTH);
	
		//Add Variables to Objects
		Output1.setText(Introduction);
		Output1.setEditable(false);
		
		Output2.setEditable(false);
		
		
		//Add Objects to Panels
		NorthPanel.add(Output1);
		CenterPanel.add(Output2);
		//CenterPanel.add(GoToViewStudentInformation);
		//CenterPanel.add(GoToManageStudentInformation);
		SouthPanel.add(GoToMainMenu);
		SouthPanel.add(Exit);
		EastPanel.add(UpdateStudentInformation);
		
		for(int x = 0; x < ManageStudentController.getStudentCollectionSize(); x++)
		{
			WestPanel.add(buttonlist.get(x));
			buttonlist.get(x).addActionListener(new StudentListener());
		}
		
		//Set Text Area
		Output1.setBackground(Color.white);
		
		//Add Listeners to Buttons
		//GoToViewStudentInformation.addActionListener( new ViewStudentInformationListener() );
		//GoToManageStudentInformation.addActionListener( new ManageStudentInformationListener() );
		GoToMainMenu.addActionListener(new MainMenuListener());
		Exit.addActionListener(new ExitListener());
		UpdateStudentInformation.addActionListener(new UpdateStudentListener());
		
		//add panel to frame
		frame.getContentPane().add(masterpanel);
		//frame.add(masterpanel);
		
		
		//GoToViewStudentInformation.setPreferredSize(new Dimension(200, 100));
		//GoToManageStudentInformation.setSize(200, 100);
		
		//Set Panel
		//masterpanel.setBackground(Color.white);
		//masterpanel.setPreferredSize(new Dimension(400, 200));
		//frame.setBackground(Color.white);
		//frame.setPreferredSize(new Dimension(400, 200));
		frame.setSize(500, 250);
		//frame.setBounds(200, 200, 500, 250);
		//frame.repaint();
		
		//refresh
		//frame.setVisible(false);
		//frame.setVisible(true);
		frame.validate();
	}
	
	private class UpdateStudentListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			ArrayList<String> CI = new ArrayList<String>();
			
			for(int x = 0; x < inputlist.size(); x++ )
			{
				CI.add(inputlist.get(x).getText());
			}
			
			//load the appropriate information
			ManageStudentController.UpdateStudent(CI, Output2.getText());
					
			
			frame.validate();
		}
	}
	
	private class StudentListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//check which button was pressed
			for(int x = 0; x < ManageStudentController.getStudentCollectionSize(); x++)
			{
				//if source is identified
				if( event.getSource() == buttonlist.get(x) )
				{
					//load the appropriate information
					Output2.setText(ManageStudentController.getStudent(x).getStudentName());
					
					ArrayList<String> CI = new ArrayList<String>(ManageStudentController.getStudent(x).getCareerInterests());
					
					CenterPanel.setLayout(new GridLayout(CI.size(), 1));
					CenterPanel.removeAll();
					inputlist.clear();
					for(int y = 0; y < CI.size(); y++)
					{
						inputlist.add(new JTextField( CI.get(y) ));
						CenterPanel.add(inputlist.get(y));			
						
					}
						
					//escape
					//x = StudentInfoManager.getSize();
					break;
				}
				
				/***********************************************
				 * You should terminate the loop as soon as you
				 * find the button that was selected.
				 */
				/*
				 * this does do this
				 * setting x to the less than conditional breaks the loop
				 * replaced it with a "break"
				 */
			}
			frame.validate();
		}
		
	}
	
	
	
	private class MainMenuListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Load Main Menu
			MainMenu_UI mmui = new MainMenu_UI();
			frame.dispose();
		}
		
	}
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Force Exit
			frame.dispose();
  		}
	}
	
	
}
