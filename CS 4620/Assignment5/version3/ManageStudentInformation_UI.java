package version3;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ManageStudentInformation_UI
{
	//private DataController dcontrol = new DataController();
	
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
		for(int x = 0; x < Data_Controller.getSize(); x++)
		{
			buttonlist.add(new JButton(Data_Controller.getStudent(x).getStudentName()));
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
		
		WestPanel.setLayout(new GridLayout(Data_Controller.getSize(), 1));
		
		
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
		
		for(int x = 0; x < Data_Controller.getSize(); x++)
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
			ManageStudentInformation_Controller.UpdateStudent(frame, inputlist, Output2);
		}
	}
	
	private class StudentListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			ManageStudentInformation_Controller.ViewStudent(frame, CenterPanel, buttonlist, inputlist, Output2, event);
		}
		
	}
	
	
	
	private class MainMenuListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Load Main Menu
			ManageStudentInformation_Controller.LoadMainMenu(frame);
		}
		
	}
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Force Exit
			ViewStudentInformation_Controller.ExitAction(frame);
  		}
	}
	
	
}
