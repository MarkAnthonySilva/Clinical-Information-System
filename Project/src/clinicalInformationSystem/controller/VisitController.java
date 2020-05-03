package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import clinicalInformationSystem.model.VisitList;
import clinicalInformationSystem.model.VisitModel;
import clinicalInformationSystem.view.AddVisitPanel;
import clinicalInformationSystem.view.SystemFrame;
import clinicalInformationSystem.view.VisitPanel;

public class VisitController
{
	private SystemFrame frame;
	private AddVisitPanel addVisitPanel;
	
	/**
	 * Controller to control visit panel displaying a list of visits
	 * @param frame
	 * @param visitList
	 * @param visitPanel
	 */
	public VisitController(SystemFrame frame, VisitList visitList, VisitPanel visitPanel)
	{
		this.frame = frame;
	}
	
	/**
	 * Controller to control an AddVisitPanel
	 * @param frame
	 * @param visitList
	 * @param addVisitPanel
	 */
	public VisitController(SystemFrame frame, VisitList visitList, AddVisitPanel addVisitPanel)
	{
		this.frame = frame;
		this.addVisitPanel = addVisitPanel;
		this.addVisitPanel.addVisitListener(new AddVisitListener());
	}
	
	private class AddVisitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command.equals("Submit"))
			{
				if (addVisitPanel.getPatient() != null && addVisitPanel.getDateText() != null && addVisitPanel.getSequenceNumberText() != null)
				{
					SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM/dd/yyyy");
					String date = addVisitPanel.getDateText();
					try
					{
						Date d = standardDateFormat.parse(date);
						frame.getVisitList().addVisit(new VisitModel(addVisitPanel.getPatient(), d, Integer.parseInt(addVisitPanel.getSequenceNumberText())));
					} catch (ParseException e1)
					{
						addVisitPanel.displayErrorMessage("Invalid date format");
					}
				} else
				{
					addVisitPanel.displayErrorMessage("Please fill in all fields.");
				}
					
				
			}
			else if(command.equals("Exit"))
			{
				addVisitPanel.setVisible(false);
			}
		}
	}
}
