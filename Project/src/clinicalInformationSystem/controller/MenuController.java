package clinicalInformationSystem.controller;

import clinicalInformationSystem.view.SystemFrame;

import java.awt.event.*;

/**
 * Controller to listen to all interactions on buttons in menu
 * @author Team 9
 *
 */
public class MenuController implements ActionListener
{
	private SystemFrame frame;
	
	/**
	 * Constructor to attach the MenuController to a SystemFrame
	 * @param frame SystemFrame to add MenuController on
	 */
	public MenuController(SystemFrame frame)
	{
		this.frame = frame;
	}
	
	/**
	 * Listens to actions performed on the menu
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (frame.checkAuth())
		{
			String command = e.getActionCommand();
			switch (command)
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
		else
		{
			frame.displayErrorMessage("Log In First.");
		}
	}
}
