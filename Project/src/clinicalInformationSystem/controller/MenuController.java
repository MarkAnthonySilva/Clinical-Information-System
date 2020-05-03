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
		switch(command)
		{
		case "Add Patient":
			frame.displayAddPatient();
			break;
		case "View Patient List":
			frame.displayPatientList();
			break;
		case "Add Visit":
			frame.displayAddVisit();
			break;
		case "View Visit List":
			frame.displayVisitList();
			break;
		}
	}

}
