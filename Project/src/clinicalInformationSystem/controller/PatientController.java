package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import clinicalInformationSystem.model.PatientModel;
import clinicalInformationSystem.model.VisitList;
import clinicalInformationSystem.view.PatientPanel;
import clinicalInformationSystem.view.SystemFrame;

public class PatientController implements ActionListener
{
	private PatientPanel 	panel;
	private SystemFrame 	frame;
	private PatientModel	patient;
	private VisitList		visitList;
	
	public PatientController(SystemFrame frame, PatientModel patient, PatientPanel panel)
	{
		this.panel = panel;
		this.frame = frame;
		this.patient = patient;
		this.visitList = frame.getVisitList();
		
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
			for (String s: patientData.keySet())
			{
				if (patientData.get(s).equals(""))
				{
					isFull = false;
					break;
				}
			}
			
			if (isFull)
			{
				String dob = patientData.get("Date of Birth (mm/dd/yyyy)");		
				String dor = patientData.get("Register Date (mm/dd/yyyy)");			
				Date formattedDob = null;
				Date formattedDor = null;
				System.out.println("FULL");
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
				
				String id = patientData.get("ID Number").replaceAll("-", "");
				String sn = patientData.get("Social Security Number").replaceAll("-", "");
				String in = patientData.get("Insurance Number").replaceAll("-", "");
				int parsedID, parsedSN, parsedIN;
				
				try
				{
					parsedID = Integer.parseInt(id);
					parsedSN = Integer.parseInt(sn);
					parsedIN = Integer.parseInt(in);
				}
				catch (NumberFormatException e2)
				{
					panel.displayErrorMessage("Please enter a valid number");
					return;
				}
				
				PatientModel patient = new PatientModel.Builder()
						.withPatientName(patientData.get("Name"))
						.withIdNumber(parsedID)
						.withDateOfBirth(formattedDob)
						.withGender(patientData.get("Gender"))
						.withPhoneNumber(patientData.get("Phone Number"))
						.withAddress(patientData.get("Street Address") + " " + patientData.get("City") 
									+ " " + patientData.get("State") + " " + patientData.get("Zip Code")
									+ " " + patientData.get("Country"))
						.withSSN(parsedSN)
						.withInsuranceNumber(parsedIN)
						.withDateOfRegistration(formattedDor)
						.build();
				
				patient.setNotes(patientData.get("Notes"));
				// TODO add the rest of optional parameter
				
				frame.getPatientList().addPatient(patientData.get("Name"), patient);
				frame.displayPatientList();
			}
			else
			{
				panel.displayErrorMessage("Not all required fields have been filled");
			}
		}
		else if (command.equals("Visits"))
		{
			if(this.visitList.getVisitsByPatient(patient).size() != 0)
			{
				frame.displayVisitList(visitList.getVisitsByPatient(patient));
			}
			else
			{
				panel.displayErrorMessage("This patient does not have visits yet");
			}
		}
		else if (command.equals("Exit"))
		{
			frame.displayPatientList();
		}
	}
	
	
}
