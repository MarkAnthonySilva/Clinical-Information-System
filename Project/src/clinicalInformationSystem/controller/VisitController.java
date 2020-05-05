package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clinicalInformationSystem.model.PatientList;
import clinicalInformationSystem.model.PatientModel;
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
	private PatientList patientList;
	private SystemFrame frame;
	
	private VisitModel visit;
	private VisitList visitList;
	private AddVisitPanel addVisitPanel;
	private VisitListPanel visitListPanel;
	private VisitPanel visitPanel;
	
	/**
	 * Create VisitController to control visit panel displaying a single visit
	 * @param visit VisitModel to be displayed
	 * @param visitPanel VisitPanel for VisitModel info to be displayed on
	 */
	public VisitController(VisitModel visit, VisitPanel visitPanel)
	{
		this.visit = visit;
		this.visitPanel = visitPanel;
	}
	
	/**
	 * Create VisitController to control visit panel displaying a list of visits
	 * @param visitList VisitList to be displayed
	 * @param visitListPanel VisitListPanel for VisitList info to be displayed on
	 */
	public VisitController(VisitList visitList, VisitListPanel visitListPanel)
	{
		this.visitList = visitList;
		this.visitListPanel = visitListPanel;
		String[] patientNames = new String[visitList.size()];
		Date[] dateOfVisits = new Date[visitList.size()];
		int[] sequenceNumbers = new int[visitList.size()];
		
		for(int i = 0; i < visitList.size(); i++)
		{
			patientNames[i] = visitList.get(i).getPatient().getPatientName();
			dateOfVisits[i] = visitList.get(i).getDateOfVisit();
			sequenceNumbers[i] = visitList.get(i).getSequenceNumber();
		}
		
		this.visitListPanel.setData(patientNames, dateOfVisits, sequenceNumbers);
		this.visitListPanel.displayData();
		this.visitListPanel.addVisitListListener(new VisitListListener());
	}
	
	/**
	 * Controller to control an AddVisitPanel
	 * @param frame SystemFrame being worked on
	 * @param visitList VisitList to be worked on when VisitModel is added by user
	 * @param addVisitPanel AddVisitPanel to display form to enter details of visit
	 */
	public VisitController(SystemFrame frame, PatientList patientList, VisitList visitList, AddVisitPanel addVisitPanel)
	{
		this.frame = frame;
		this.patientList = patientList;
		this.visitList = visitList;
		this.addVisitPanel = addVisitPanel;
		
		PatientModel[] patients = patientList.getPatientArray();
		String[] patientNames = new String[patients.length];
		
		for (int i = 0; i < patients.length; i++)
		{
			patientNames[i] = patients[i].getPatientName();
		}
		
		this.addVisitPanel.setPatientNames(patientNames);
		this.addVisitPanel.displayPanel();
		
		this.addVisitPanel.addVisitListener(new AddVisitListener());
	}
	
	private class AddVisitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Submit"))
			{
				if (addVisitPanel.getPatient() != null && addVisitPanel.getDateText() != null && addVisitPanel.getSequenceNumberText() != null)
				{
					String date = addVisitPanel.getDateText();
					Date formattedDate = null;
					int seqNumber = 0;
					
					try
					{
						SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM/dd/yyyy");
						formattedDate = standardDateFormat.parse(date);
					} catch (ParseException e1)
					{
						addVisitPanel.displayErrorMessage("Invalid date format.");
						return;
					}
					
					try
					{
						seqNumber = Integer.parseInt(addVisitPanel.getSequenceNumberText());
						if (seqNumber < 0)
							throw (new NumberFormatException());
					} catch (NumberFormatException e2)
					{
						addVisitPanel.displayErrorMessage("Please enter a valid sequence number.");
						return;
					}
					visitList.addVisit(new VisitModel(patientList.getPatient(addVisitPanel.getPatient()), formattedDate, seqNumber));
					frame.displayVisitList();
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
	
	private class VisitListListener implements ActionListener, ListSelectionListener
	{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Exit"))
			{
				visitListPanel.setVisible(false);
			}
		}
		
		public void valueChanged(ListSelectionEvent e) {
			System.out.println("Selected row is " + visitListPanel.getSelectedRow());
		}
	}
}
