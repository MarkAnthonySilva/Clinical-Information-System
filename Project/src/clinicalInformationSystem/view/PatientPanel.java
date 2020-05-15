package clinicalInformationSystem.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.*;

import clinicalInformationSystem.SpringUtilities;
import clinicalInformationSystem.controller.AddPatientController;
import clinicalInformationSystem.model.PatientModel;

/**
 * A Class that creates a panel that displays the information of a Patient
 * @author marksilvajr
 *
 */
public class PatientPanel extends JPanel
{
	private JButton edit;
	private JButton delete;
	private JButton exit;
	
	HashMap<String, JTextField>		patientData;	//Key Data name, Value JTextField related to Data name
	
	public static final String[] labelList = {"Name",
											"ID Number", 
											"Date of Birth",
											"Gender", 
											"Phone Number", 
											"Address", 
											"Social Security Number", 
											"Insurance Number",
											"Register Date"};
	
	// TODO Add Optional Parameters to labelList
	
	/**
	 * Constructor of a patient panel that display information of a patient
	 */
	public PatientPanel()
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
		edit 	 	= new JButton("Edit");	
		delete		= new JButton("Delete");
		exit	 	= new JButton("Exit");
		
		buttonPanel.add(edit);
		buttonPanel.add(delete);
		buttonPanel.add(exit);
		
		this.setEditable(false);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	/**
	 * Get a map representation of all the inputed values of the text field
	 * @return a map representation of all the inputed values of the text field
	 */
	public HashMap<String, String> getDataMap()
	{
		HashMap<String,String>	patientDataString = new HashMap<>();
		for (int i = 0; i < labelList.length; i++)
		{
			patientDataString.put(labelList[i], patientData.get(labelList[i]).getText());
		}
		return patientDataString;
	}
	
	/**
	 * Set the data map of this panel to the information within this patient
	 * @param patient the patient that will establish the information within this map
	 */
	public void setDataMap(PatientModel patient)
	{
		for (int i = 0; i < labelList.length; i++)
		{	
			String patientString = patient.getMap().get(labelList[i]);
			JTextField textField = patientData.get(labelList[i]);
			textField.setText(patientString);
			
			if(labelList[i].equals("Address"))
			{
				patientData.get(labelList[i]).setColumns(patientString.length());
			}
		}
	}
	
	/**
	 * Set the text fields to be either be editable or non-editable depending on the parameter
	 * @param isEditable the parameter that determines if the text field are editable. True means that the
	 * text fields are editable. Otherwise, the text fields are not editable
	 */
	public void setEditable(boolean isEditable)
	{
		for(int i = 0; i < labelList.length; i++)
		{
			patientData.get(labelList[i]).setEditable(isEditable);
		}
		
		if (isEditable)
		{
			edit.setText("Submit");
		}
		else
		{
			edit.setText("Edit");
		}
	}
	
	/**
	 * Display error message on panel
	 * @param errorMessage Error message to be displayed
	 */
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	/**
	 * Add listeners to the buttons on this panel
	 * @param listener the listener listing to all the actions by this panel
	 */
	public void addListener(ActionListener listener)
	{
		edit.addActionListener(listener);
		delete.addActionListener(listener);
		exit.addActionListener(listener);
	}
	
}
