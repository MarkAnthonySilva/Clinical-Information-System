package clinicalInformationSystem.view;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

import clinicalInformationSystem.SpringUtilities;
import clinicalInformationSystem.controller.*;

@SuppressWarnings("serial")
public class AddPatientPanel extends JPanel
{
	private AddPatientController 	controller;
	HashMap<String, JTextField>		patientData;	//Key Data name, Value JTextField related to Data name
		
	public static final String[] labelList = {"First Name", 
											"Last Name",
											"ID Number", 
											"Date of Birth (mm/dd/yyyy)",
											"Gender", 
											"Phone Number", 
											"Street Address", 
											"City",
											"State",
											"Zip Code",
											"Country",
											"Social Security Number", 
											"Insurance Number",
											"Register Date (mm/dd/yyyy)"};
	
	// TODO Add Optional Parameters to labelList
	
	public AddPatientPanel(SystemFrame frame)
	{	
		this.setLayout(new BorderLayout());
		
		//Construct Form Panel of Spring layout
		JPanel formPanel = new JPanel();
		SpringLayout layout =  new SpringLayout();
		formPanel.setLayout(layout);
		
		//Construct all label and text fields for the form panel
		patientData = new HashMap<>();
		for (int i = 0; i < labelList.length; i++)
		{
			JLabel label = new JLabel(labelList[i], JLabel.TRAILING);
			formPanel.add(label);
			JTextField textField = new JTextField(20);
			label.setLabelFor(textField);
			formPanel.add(textField);
			
			patientData.put(labelList[i], textField);
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
										labelList.length, 2, 	//# of rows, # of columns
										5, 5,					//Initial x and y coordinates
										5, 5);					//Padding between labels and textfield
	
		this.add(formPanel, BorderLayout.NORTH);
		
		//Create button panel
		JPanel buttonPanel 	= new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton submit 	 	= new JButton("Submit");		
		JButton exit	 	= new JButton("Exit");
		
		buttonPanel.add(submit);
		buttonPanel.add(exit);
		
		controller = new AddPatientController(this, frame);
		submit.addActionListener(controller);
		exit.addActionListener(controller);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	public HashMap<String, String> getDataMap()
	{
		HashMap<String, String> patientDataString = new HashMap<>();
		for (int i = 0; i < labelList.length; i++)
		{
			patientDataString.put(labelList[i], patientData.get(labelList[i]).getText());
		}
		return patientDataString;
	}
	
	/**
	 * Display error message on panel
	 * @param errorMessage Error message to be displayed
	 */
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
