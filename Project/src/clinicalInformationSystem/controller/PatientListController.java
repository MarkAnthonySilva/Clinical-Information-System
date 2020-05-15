package clinicalInformationSystem.controller;

import java.awt.event.*;
import clinicalInformationSystem.view.*;
import clinicalInformationSystem.model.*;

public class PatientListController implements ActionListener
{
	private PatientListPanel 	panel;
	private SystemFrame			frame;	
	
	public PatientListController(SystemFrame frame, PatientListPanel panel)
	{
		this.panel = panel;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("Edit"))
		{	
			//TODO Add function to edit
		}
		else if (command.equals("Exit"))
		{
			panel.setVisible(false);
		}
		
	}
	
}
