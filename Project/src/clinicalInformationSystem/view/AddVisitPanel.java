package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import clinicalInformationSystem.SpringUtilities;
import clinicalInformationSystem.model.PatientModel;

public class AddVisitPanel extends JPanel
{
	public static final String[] labelList = {"Patient Name", "Date (mm/dd/yyyy)", "Sequence Number"};
	private JTextField[] labelTextFields;
	JButton submit;		
	JButton exit;
	JComboBox<PatientModel> patientDropDown;
	
	public AddVisitPanel(SystemFrame frame)
	{
		this.setLayout(new BorderLayout());
		
		JPanel formPanel = new JPanel(new SpringLayout());
		labelTextFields = new JTextField[labelList.length];
		
		JLabel patientName = new JLabel(labelList[0], JLabel.TRAILING);
		formPanel.add(patientName);
		patientDropDown = new JComboBox<PatientModel>(frame.getPatientList().getPatientArray());
		patientName.setLabelFor(patientDropDown);
		formPanel.add(patientDropDown);
		
		for(int i = 1; i < labelList.length; i++)
		{
			JLabel label = new JLabel(labelList[i], JLabel.TRAILING);
			formPanel.add(label);
			JTextField textField = new JTextField(20);
			label.setLabelFor(textField);
			formPanel.add(textField);
			labelTextFields[i] = textField;
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
				labelList.length, 2, 	//# of rows, # of columns
				5, 5,					//Initial x and y coordinates	
				5, 5);					//Padding between labels and textfield
		
		//Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		submit = new JButton("Submit");		
		exit = new JButton("Exit");
		buttonPanel.add(submit);
		buttonPanel.add(exit);
		
		this.add(formPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void addVisitListener(ActionListener listener)
	{
		submit.addActionListener(listener);
		exit.addActionListener(listener);
	}
	
	public PatientModel getPatient()
	{
		return (PatientModel) patientDropDown.getSelectedItem();
	}
	
	public String getDateText()
	{
		return labelTextFields[1].getText();
	}
	
	public String getSequenceNumberText()
	{
		return labelTextFields[2].getText();
	}
	
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
