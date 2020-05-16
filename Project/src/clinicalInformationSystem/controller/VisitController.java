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
	private SystemFrame frame;
	
	private PatientList patientList;
	private VisitModel visit;
	private VisitList visitList;
	
	private AddVisitPanel addVisitPanel;
	private VisitListPanel visitListPanel;
	private VisitPanel visitPanel;
	
	/**
	 * Create VisitController to control visit panel displaying a single visit
	 * @param frame SystemFrame being worked on
	 * @param visit VisitModel to be displayed
	 * @param visitPanel VisitPanel for VisitModel info to be displayed on
	 */
	public VisitController(SystemFrame frame, VisitModel visit, VisitList visitList, VisitPanel visitPanel)
	{
		this.frame = frame;
		this.visit = visit;
		this.visitList = visitList;
		this.visitPanel = visitPanel;
		this.visitPanel.setVisitData(this.visit.getPatient().getPatientName(), this.visit.getDateOfVisit(), this.visit.getSequenceNumber(), this.visit.getTHIModel().calculateSeverity(), -1);
		this.visitPanel.addVisitListener(new VisitListener());
	}
	
	/**
	 * Create VisitController to control visit panel displaying a list of visits
	 * @param frame SystemFrame being worked on
	 * @param visitList VisitList to be displayed
	 * @param visitListPanel VisitListPanel for VisitList info to be displayed on
	 */
	public VisitController(SystemFrame frame, VisitList visitList, VisitListPanel visitListPanel)
	{
		this.frame = frame;
		this.visitList = visitList;
		this.visitListPanel = visitListPanel;
		String[] patientNames = new String[visitList.size()];
		Date[] dateOfVisits = new Date[visitList.size()];
		int[] sequenceNumbers = new int[visitList.size()];
		int[] THIScores = new int[visitList.size()];
		int[] TFIScores = new int[visitList.size()];
		
		for(int i = 0; i < visitList.size(); i++)
		{
			patientNames[i] 		= this.visitList.get(i).getPatient().getPatientName();
			dateOfVisits[i] 		= this.visitList.get(i).getDateOfVisit();
			sequenceNumbers[i] 		= this.visitList.get(i).getSequenceNumber();
			THIScores[i] 			= this.visitList.get(i).getTHIModel().calculateSeverity();
			TFIScores[i] 			= 0;	//TODO Implement way to calculate TFI Scores
		}
		
		if(visitList == frame.getVisitList())
		{
		this.visitListPanel.setData(patientNames, dateOfVisits, sequenceNumbers);
		}
		else
		{
		this.visitListPanel.setData(dateOfVisits, THIScores, TFIScores, sequenceNumbers);
		}
		
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
	
	/**
	 * Action Listener to listen to input and actions on VisitPanel
	 * @author benja
	 *
	 */
	private class VisitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Edit"))
			{
				visitPanel.setEditable(true);
			}
			else if (command.equals("View THI"))
			{
				frame.THI(visit);
			}
			else if (command.equals("View TFI"))
			{
				
			}
			else if (command.equals("Delete"))
			{
				visitList.remove(visit);
				frame.displayVisitList();
			}
			else if (command.equals("Done"))
			{
				String patientName = visitPanel.getPatientName();
				String dateText = visitPanel.getDateText();
				String seqNumberText = visitPanel.getSeqNumberText();
				
				Date formattedDate;
				int seqNumber;
				
				if (patientName != null && dateText != null && seqNumberText != null)
				{
					formattedDate = null;
					try
					{
						SimpleDateFormat standardDateFormat = new SimpleDateFormat("MMMM d, yyyy");
						formattedDate = standardDateFormat.parse(dateText);
					} catch (ParseException e1)
					{
						visitPanel.displayErrorMessage("Invalid date format.");
						return;
					}
					
					try
					{
						seqNumber = Integer.parseInt(seqNumberText);
						if (seqNumber < 0)
							throw (new NumberFormatException());
					} catch (NumberFormatException e2)
					{
						visitPanel.displayErrorMessage("Please enter a valid sequence number.");
						return;
					}
					visit.setDateOfvisit(formattedDate);
					visit.setSequenceNumber(seqNumber);
					visitPanel.setEditable(false);
				} else
				{
					visitPanel.displayErrorMessage("Please fill in all fields.");
				}
			}
			else if (command.equals("Back to Visits"))
			{
				frame.displayVisitList();
			}
			else if (command.equals("Exit"))
			{
				visitPanel.setVisible(false);
			}
		}
	}
	
	/**
	 * Action Listener to listen to input and actions on VisitListPanel
	 * @author benja
	 *
	 */
	private class VisitListListener implements ActionListener, ListSelectionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Exit"))
			{
				visitListPanel.setVisible(false);
			}
		}
		
		public void valueChanged(ListSelectionEvent e)
		{
			if (visitList.get(visitListPanel.getSelectedRow()) != null)
			{
				visit = visitList.get(visitListPanel.getSelectedRow());
				frame.displayVisit(visit);
			}
		}
	}
	
	/**
	 * Action Listener to listen to input and actions on AddVisitPanel
	 * @author benja
	 *
	 */
	private class AddVisitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Add THI/TFI"))
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
					VisitModel visitToAdd = new VisitModel(patientList.getPatient(addVisitPanel.getPatient()), formattedDate, seqNumber);
					visitList.add(visitToAdd);
					frame.THI(visitToAdd);
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
