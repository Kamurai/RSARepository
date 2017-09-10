package version3;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;

public class MainMenu_UI
{
	private JFrame frame = new JFrame("Assignment5");
	private JPanel masterpanel = new JPanel();
	
	//Top of Page
	private JPanel NorthPanel = new JPanel();
	private JTextArea Output1 = new JTextArea("");
	private String Introduction;
	
	//Middle of Page
	private JPanel CenterPanel = new JPanel();
	private JButton GoToViewStudentInformation = new JButton ("View Student Information");
	private JButton GoToManageStudentInformation = new JButton ("Manage Student Information");
	
	//bottom of Page
	private JButton Exit = new JButton ("Exit Program");
	
	private JPanel EastPanel = new JPanel();
	private JPanel WestPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();
	
	public MainMenu_UI()
	{
		//Set Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//End Frame
		frame.pack();
		
		frame.setVisible(true);

		//set variables
		Introduction = "Welcome Administrator.\n";
		Introduction += "Please select the action you would like to take below.\n";
	
		//set Border Layout
		masterpanel.setLayout( new BorderLayout() );
		//frame.setLayout( new BorderLayout() );
		
		//organize buttons vertically
		CenterPanel.setLayout(new GridLayout(2,1));
		
		
		
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
		
		//Add Objects to Panels
		NorthPanel.add(Output1);
		CenterPanel.add(GoToViewStudentInformation);
		CenterPanel.add(GoToManageStudentInformation);
		SouthPanel.add(Exit);
		
		//Set Text Area
		Output1.setBackground(Color.white);
		
		//Add Listeners to Buttons
		GoToViewStudentInformation.addActionListener( new ViewStudentInformationListener() );
		GoToManageStudentInformation.addActionListener( new ManageStudentInformationListener() );
		Exit.addActionListener(new ExitListener());
		//add panel to frame
		//frame.getContentPane().add(masterpanel);
		frame.add(masterpanel);
		
		
		GoToViewStudentInformation.setPreferredSize(new Dimension(200, 100));
		GoToManageStudentInformation.setSize(200, 100);
		
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
	
	private class ViewStudentInformationListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Load ViewStudentInformation object
			MainMenu_Controller.LoadViewStudentInformation(frame);
		}
		
	}
	
	private class ManageStudentInformationListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Load View Student Information screen
			MainMenu_Controller.LoadManageStudentInformation(frame);
			//frame.dispose();
  		}
	}
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Call Exit Action
			MainMenu_Controller.ExitAction(frame);
			//frame.dispose();
  		}
	}
	
	
}
