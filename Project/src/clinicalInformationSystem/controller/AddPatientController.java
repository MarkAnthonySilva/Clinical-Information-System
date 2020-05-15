package clinicalInformationSystem.controller;

import java.awt.event.*;
import java.text.*;
import java.util.*;

import clinicalInformationSystem.view.*;
import clinicalInformationSystem.model.*;

public class AddPatientController implements ActionListener
{
	private AddPatientPanel panel;
	private SystemFrame 	frame;
	
	public AddPatientController( SystemFrame frame, AddPatientPanel panel)
	{
		this.panel = panel;
		this.frame = frame;
		
		panel.addListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("Submit"))
		{	
			HashMap<String, String> patientData = panel.getDataMap();
			ArrayList<String> valuesList = new ArrayList<>(patientData.values());
			boolean isFull = true;
			
			//Checks if all the patientData has been filled
			for(String s: valuesList)
			{
				if(s.contentEquals(""))
				{
					isFull = false;
					break;
				}
			}
			
			String dob = patientData.get("Date of Birth (mm/dd/yyyy)");		
			String dor = patientData.get("Register Date (mm/dd/yyyy)");			
			Date formattedDob = null;
			Date formattedDor = null;
			
			try
			{
				SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM/dd/yyyy");
				
				formattedDob = standardDateFormat.parse(dob);
				formattedDor = standardDateFormat.parse(dor);
			}
			catch (ParseException e1)
			{
				panel.displayErrorMessage("Invalid Date Format");
				return;
			}
			
			if(isFull)
			{
				String id = patientData.get("ID Number").replaceAll("-", "");
				String sn = patientData.get("Social Security Number").replaceAll("-", "");
				String in = patientData.get("Insurance Number").replaceAll("-", "");
						
				PatientModel patient = new PatientModel.Builder()
						.withPatientName(patientData.get("Name"))
						.withIdNumber(Integer.parseInt(id))
						.withDateOfBirth(formattedDob)
						.withGender(patientData.get("Gender"))
						.withPhoneNumber(patientData.get("Phone Number"))
						.withAddress(patientData.get("Street Address") + " " + patientData.get("City") 
									+ " " + patientData.get("State") + " " + patientData.get("Zip Code")
									+ " " + patientData.get("Country"))
						.withSSN(Integer.parseInt(sn))
						.withInsuranceNumber(Integer.parseInt(in))
						.withDateOfRegistration(formattedDor)
						.build();
				
				patient.setNotes(patientData.get("Notes"));
				// TODO add the rest of optional parameter
				
				frame.getPatientList().addPatient(patientData.get("Name"), patient);
				frame.displayPatientList();
			}
			else
			{
				panel.displayErrorMessage("Not all fields have been filled");
			}
		}
		else if (command.equals("Exit"))
		{
			panel.setVisible(false);
		}
	}
	
	
}
