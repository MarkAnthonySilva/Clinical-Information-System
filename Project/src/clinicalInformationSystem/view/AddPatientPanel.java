package clinicalInformationSystem.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

import clinicalInformationSystem.SpringUtilities;
import clinicalInformationSystem.controller.*;

@SuppressWarnings("serial")
public class AddPatientPanel extends JPanel
{
	private JButton submit;
	private JButton exit;
	
	HashMap<String, JTextComponent>		patientData;	//Key Data name, Value JTextField related to Data name
		
	public static final String[] labelList = {"Name",
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
	
	/**
	 * Constructs an AddPatientPanel that allows the input of 
	 */
	public AddPatientPanel()
	{	
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
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
			JTextField textField = new JTextField(15);
			label.setLabelFor(textField);
			formPanel.add(textField);
			
			patientData.put(labelList[i], textField);
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
										labelList.length, 2, 	//# of rows, # of columns
										5, 5,					//Initial x and y coordinates
										5, 5);					//Padding between labels and textfield
	
		this.add(formPanel, BorderLayout.WEST);
		
		//Create button panel
		JPanel buttonPanel 	= new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		submit 	 	= new JButton("Submit");		
		exit	 	= new JButton("Exit");
		
		buttonPanel.add(submit);
		buttonPanel.add(exit);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		JTextArea textarea = new JTextArea(20, 20);
		textarea.setLineWrap(true);
		JLabel label = new JLabel("Notes");
		label.setLabelFor(textarea);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setSize(textarea.getWidth() ,this.getHeight() / 2);
		panel1.add(label, BorderLayout.NORTH);
		panel1.add(textarea, BorderLayout.CENTER);
		patientData.put("Notes" , textarea);
		
		//TODO Add scroll panes as necessary (form, textarea)
		
		this.add(panel1, BorderLayout.EAST);
	}

	/**
	 * Get a map representation of all the inputted values to the text field
	 * @return
	 */
	public HashMap<String, String> getDataMap()
	{
		HashMap<String, String> patientDataString = new HashMap<>();
		for (int i = 0; i < labelList.length; i++)
		{
			patientDataString.put(labelList[i], patientData.get(labelList[i]).getText());
		}
		
		patientDataString.put("Notes", patientData.get("Notes").getText().trim());
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
	
	/**
	 * Add listeners to the buttons on this panel
	 * @param listener the listener listing to all the actions by this panel
	 */
	public void addListener(ActionListener listener)
	{
		submit.addActionListener(listener);
		exit.addActionListener(listener);
	}
	
}
