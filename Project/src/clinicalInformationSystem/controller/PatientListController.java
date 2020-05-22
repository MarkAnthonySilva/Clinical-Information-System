package clinicalInformationSystem.controller;

import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import clinicalInformationSystem.view.*;
import clinicalInformationSystem.model.*;

/**
 * Controller for the PatientList
 * @author benja
 *
 */
public class PatientListController implements ActionListener, ListSelectionListener
{
	private PatientListPanel 	panel;
	private SystemFrame			frame;	
	private PatientList			patientList;
	
	/**
	 * Constructs a patientList controller that listen to the actions made at the patientListPanel
	 * @param frame the frame where the panel is
	 * @param patientList the list that is being displayed at the panel
	 * @param panel Panel to display patient list on
	 */
	public PatientListController(SystemFrame frame, PatientList patientList, PatientListPanel panel)
	{
		this.panel 			= panel;
		this.frame 			= frame;
		this.patientList 	= patientList;
		
		panel.addListener(this);
	}
	
	/**
	 * Listens for actions being performed on the patient list
	 */
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("Exit"))
		{
			panel.setVisible(false);
		}
	}
	
	/**
	 * Called when a row is selected in the patient list table
	 */
	public void valueChanged(ListSelectionEvent e)
	{
		if (patientList.getPatientArray()[panel.getSelectedRow()] != null)
		{
			PatientModel patient = patientList.getPatientArray()[panel.getSelectedRow()];
			frame.diplayPatient(patient);
		}
	}
}
