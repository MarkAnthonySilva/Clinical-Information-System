package clinicalInformationSystem.controller;

import java.awt.event.*;
import java.util.HashMap;
import clinicalInformationSystem.view.*;
import clinicalInformationSystem.model.*;

public class AddPatientController implements ActionListener
{
	private AddPatientPanel panel;
	private SystemFrame 	frame;
	
	public AddPatientController(AddPatientPanel panel, SystemFrame frame)
	{
		this.panel = panel;
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if(command.equals("Submit"))
		{	
			HashMap<String, String> patientData = panel.getDataMap();
			PatientModel patient = new PatientModel.Builder()
					.withPatientName(patientData.get("Name"))
					.withGender(patientData.get("Gender"))
					.withAddress(patientData.get("Address"))
					.build();
			
			// TODO add the rest of the parameters for patient
			
			frame.getPatientList().addPatient(patientData.get("Name"), patient);
			frame.displayPatientList();
		}
		else if(command.equals("Exit"))
		{
			panel.setVisible(false);
		}
	}
	
	
}
