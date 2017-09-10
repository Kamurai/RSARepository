package version2;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewStudentInformationPanel extends JPanel
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
	
	//bottom of Page
	private JButton GoToMainMenu = new JButton ("Return to Main Menu");
	private JButton Exit = new JButton ("Exit Program");
	
	//left of Page
	private ArrayList<JButton> buttonlist = new ArrayList<JButton>();
	
	private JPanel EastPanel = new JPanel();
	private JPanel WestPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();
		
	public ViewStudentInformationPanel()
	{
		for(int x = 0; x < DataController.getSize(); x++)
		{
			buttonlist.add(new JButton(DataController.getStudent(x).getStudentName()));
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
		
		WestPanel.setLayout(new GridLayout(DataController.getSize(), 1));
		
		
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
		
		for(int x = 0; x < DataController.getSize(); x++)
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
		
		//add panel to frame
		//frame.getContentPane().add(masterpanel);
		frame.add(masterpanel);
		
		
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
	
	private class StudentListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//check which button was pressed
			for(int x = 0; x < DataController.getSize(); x++)
			{
				//if source is identified
				if( event.getSource() == buttonlist.get(x) )
				{
					String post = "";
					ArrayList<String> CI = new ArrayList<String>(DataController.getStudent(x).getCareerInterests());
					
					post = DataController.getStudent(x).getStudentName() + "\n";
					for(int y = 0; y < CI.size(); y++)
					{
						post += CI.get(y) + "\n";
					}
					
					//load the appropriate information
					Output2.setText(post);
					
					//escape
					x = DataController.getSize();
				}
			
				
			}
			//refresh
			//frame.setVisible(false);
			//frame.setVisible(true);
			frame.validate();
		}
		
	}
	
	private class MainMenuListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			//Load ViewStudentInformation object
			MainMenuPanel mmp = new MainMenuPanel();
			//Force Exit
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
