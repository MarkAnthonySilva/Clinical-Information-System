package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import clinicalInformationSystem.model.PatientModel;
import clinicalInformationSystem.view.PatientPanel;
import clinicalInformationSystem.view.SystemFrame;

public class PatientController implements ActionListener
{
	private PatientPanel 	panel;
	private SystemFrame 	frame;
	private PatientModel	patient;
	
	public PatientController(SystemFrame frame, PatientModel patient, PatientPanel panel)
	{
		this.panel = panel;
		this.frame = frame;
		this.patient = patient;
		
		panel.addListener(this);
		panel.setDataMap(patient);
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("Edit"))
		{
			panel.setEditable(true);
		}
		else if(command.contentEquals("Delete"))
		{
			frame.getPatientList().getMap().remove(patient.getPatientName());
			frame.displayPatientList();
		}
		else if (command.equals("Submit"))
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
			
			String dob = patientData.get("Date of Birth");		
			String dor = patientData.get("Register Date");			
			Date formattedDob = null;
			Date formattedDor = null;
			
			try
			{
				SimpleDateFormat standardDateFormat = new SimpleDateFormat("MMMM d, yyyy");
				
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
				String id = patientData.get("ID Number").replace("-", "");
				String sn = patientData.get("Social Security Number").replace("-", "");
				String in = patientData.get("Insurance Number").replace("-", "");
						
				PatientModel patient = new PatientModel.Builder()
						.withPatientName(patientData.get("Name"))
						.withIdNumber(Integer.parseInt(id))
						.withDateOfBirth(formattedDob)
						.withGender(patientData.get("Gender"))
						.withPhoneNumber(patientData.get("Phone Number"))
						.withAddress(patientData.get("Address"))
						.withSSN(Integer.parseInt(sn))
						.withInsuranceNumber(Integer.parseInt(in))
						.withDateOfRegistration(formattedDor)
						.build();
				
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
			frame.displayPatientList();
		}
	}
	
	
}
