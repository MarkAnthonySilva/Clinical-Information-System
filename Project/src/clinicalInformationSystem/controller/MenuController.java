package clinicalInformationSystem.controller;

import clinicalInformationSystem.view.SystemFrame;

import java.awt.event.*;

public class MenuController implements ActionListener
{
	private SystemFrame frame;
	
	public MenuController(SystemFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if(command.equals("Add Patient"))
		{
			frame.displayAddPatient();
		}
		else if(command.equals("View Patient List"))
		{
			frame.displayPatientList();
		}
		// TODO IMPLEMENT THE REST OF THE MENU METHODS LATER
	}

}
