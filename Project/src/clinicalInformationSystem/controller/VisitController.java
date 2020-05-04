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
import clinicalInformationSystem.view.VisitListPanel;
import clinicalInformationSystem.view.VisitPanel;

/**
 * Controller to control interaction between visit panels and visit model
 * @author Team 9
 *
 */
public class VisitController
{
	private SystemFrame frame;
	private VisitList visitList;
	private AddVisitPanel addVisitPanel;
	private VisitListPanel visitListPanel;
	
	/**
	 * Create VisitController to control visit panel displaying a single visit
	 * @param frame SystemFrame that is being worked on
	 * @param visit VisitModel to be displayed
	 * @param visitPanel VisitPanel for VisitModel info to be displayed on
	 */
	public VisitController(SystemFrame frame, VisitModel visit, VisitPanel visitPanel)
	{
		this.frame = frame;
	}
	
	/**
	 * Create VisitController to control visit panel displaying a list of visits
	 * @param frame SystemFrame that is being worked on
	 * @param visitList VisitList to be displayed
	 * @param visitListPanel VisitListPanel for VisitList info to be displayed on
	 */
	public VisitController(SystemFrame frame, VisitList visitList, VisitListPanel visitListPanel)
	{
		this.frame = frame;
		this.visitList = visitList;
		this.visitListPanel = visitListPanel;
		this.visitListPanel.addVisitListListener(new VisitListListener());
	}
	
	/**
	 * Controller to control an AddVisitPanel
	 * @param frame SystemFrame that is being worked on
	 * @param visitList VisitList to be worked on when VisitModel is added by user
	 * @param addVisitPanel AddVisitPanel to display form to enter details of visit
	 */
	public VisitController(SystemFrame frame, VisitList visitList, AddVisitPanel addVisitPanel)
	{
		this.frame = frame;
		this.visitList = visitList;
		this.addVisitPanel = addVisitPanel;
		this.addVisitPanel.addVisitListener(new AddVisitListener());
	}
	
	private class AddVisitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if(command.equals("Submit"))
			{
				if (addVisitPanel.getPatient() != null && addVisitPanel.getDateText() != null && addVisitPanel.getSequenceNumberText() != null)
				{
					String date = addVisitPanel.getDateText();
					Date formattedDate = null;
					int seqNumber = 0;
					
					try
					{
						seqNumber = Integer.parseInt(addVisitPanel.getSequenceNumberText());
						
					} catch (NumberFormatException e2)
					{
						addVisitPanel.displayErrorMessage("Please enter a valid number.");
					}
					
					try
					{
						SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM/dd/yyyy");
						formattedDate = standardDateFormat.parse(date);
						visitList.addVisit(new VisitModel(addVisitPanel.getPatient(), formattedDate, seqNumber));
						frame.displayVisitList();
					} catch (ParseException e1)
					{
						addVisitPanel.displayErrorMessage("Invalid date format.");
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
	
	private class VisitListListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command.equals("Edit"))
			{
				
			}
			else if(command.equals("Exit"))
			{
				visitListPanel.setVisible(false);
			}
		}
		
	}
}
