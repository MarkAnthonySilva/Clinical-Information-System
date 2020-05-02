package clinicalInformationSystem.view;

import java.awt.*;
import javax.swing.*;

import clinicalInformationSystem.SpringUtilities;
import clinicalInformationSystem.model.PatientModel;

public class AddPatientPanel extends JPanel
{
	private SystemFrame frame;
	private PatientModel patient;
	
	public AddPatientPanel(SystemFrame frame)
	{
		this.frame = frame;	
		
		String[] labelList = {"Name", "Gender", "Address", "ID Number", "Phone Number", "Social Security Number", "Insurance Number"};
		SpringLayout layout =  new SpringLayout();
		this.setLayout(layout);
		
		for(int i = 0; i < labelList.length; i++)
		{
			JLabel label = new JLabel(labelList[i], JLabel.TRAILING);
			this.add(label);
			JTextField textField = new JTextField(20);
			label.setLabelFor(textField);
			this.add(textField);
		}
		
		SpringUtilities.makeCompactGrid(	this, 
											labelList.length, 2, 	//# of rows, # of columns
											5, 5,					//Initial x and y coordinates	
											5, 5);					//Padding between labels and textfield	
		
	}	
}
