package clinicalInformationSystem.controller;

import java.awt.event.*;
import java.text.*;
import java.util.*;

import clinicalInformationSystem.view.*;
import clinicalInformationSystem.model.*;

/**
 * Controller for the add patient panel listening for its actions
 * @author masil
 *
 */
public class AddPatientController implements ActionListener
{
	private AddPatientPanel panel;
	private SystemFrame 	frame;
	
	/**
	 * Constructor of a Controller for the AddPatientPanel
	 * @param frame the frame the panel is placed in
	 * @param panel the panel the controller is listening too
	 */
	public AddPatientController(SystemFrame frame, AddPatientPanel panel)
	{
		this.panel = panel;
		this.frame = frame;
		
		panel.addListener(this);
	}

	/**
	 * Performs different actions depending on the input in the add patient panel
	 */
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("Submit"))
		{	
			HashMap<String, String> patientData = panel.getDataMap();
			boolean isFull = true;
			
			// Checks if all the patientData has been filled
			for (String s: patientData.keySet())
			{
				// Ignore Optional Parameters
				if (!s.equals("Occupation") && !s.equals("Work Status") && !s.equals("Educational Degree") && !s.equals("Notes"))
				{
					if (patientData.get(s).equals(""))
					{
						isFull = false;
						break;
					}
				}
			}
			
			if (isFull)
			{
				String dob = patientData.get("Date of Birth (mm/dd/yyyy)*");
				String dor = patientData.get("Register Date (mm/dd/yyyy)*");
				Date formattedDob = null;
				Date formattedDor = null;
				SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM/dd/yyyy");
				try
				{
					formattedDob = standardDateFormat.parse(dob);
				}
				catch (ParseException e1)
				{
					panel.displayErrorMessage("Invalid Date of Birth Format.");
					return;
				}
				
				try
				{
					formattedDor = standardDateFormat.parse(dor);
				}
				catch (ParseException e2)
				{
					panel.displayErrorMessage("Invalid Date of Registration Format.");
					return;
				}
				
				String id = patientData.get("ID Number*").replaceAll("-", "");
				String sn = patientData.get("Social Security Number*").replaceAll("-", "");
				String in = patientData.get("Insurance Number*").replaceAll("-", "");
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
						.withPatientName(patientData.get("Name*"))
						.withIdNumber(parsedID)
						.withDateOfBirth(formattedDob)
						.withGender(patientData.get("Gender*"))
						.withPhoneNumber(patientData.get("Phone Number*"))
						.withAddress(patientData.get("Street Address*") + " " + patientData.get("City*") 
									+ " " + patientData.get("State*") + " " + patientData.get("Zip Code*")
									+ " " + patientData.get("Country*"))
						.withSSN(parsedSN)
						.withInsuranceNumber(parsedIN)
						.withDateOfRegistration(formattedDor)
						.build();
				
				// Optional parameters
				patient.setOccupation(patientData.get("Occupation"));
				patient.setWorking(patientData.get("Work Status"));
				patient.setEducation(patientData.get("Educational Degree"));
				patient.setNotes(patientData.get("Notes"));
				
				frame.getPatientList().addPatient(patientData.get("Name*"), patient);
				frame.displayPatientList();
			}
			else
			{
				panel.displayErrorMessage("Not all required fields have been filled.");
			}
		}
		else if (command.equals("Exit"))
		{
			panel.setVisible(false);
		}
	}
}
