package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import clinicalInformationSystem.SpringUtilities;

public class VisitPanel extends JPanel
{
	JPanel visitPanel;
	JButton edit;		
	JButton exit;
	JButton backToVisits;
	String patientName;
	Date date;
	int seqNumber;
	
	JTextField patientNameTextField;
	JTextField dateTextField;
	JTextField seqNumberTextField;
	
	public VisitPanel()
	{
		this.setLayout(new BorderLayout());
		visitPanel = new JPanel(new SpringLayout());
		
		JLabel patientNameLabel = new JLabel("Patient Name", JLabel.TRAILING);
		visitPanel.add(patientNameLabel);
		patientNameTextField = new JTextField(20);
		patientNameLabel.setLabelFor(patientNameTextField);
		visitPanel.add(patientNameTextField);
		
		JLabel dateLabel = new JLabel("Date of Visit", JLabel.TRAILING);
		visitPanel.add(dateLabel);
		dateTextField = new JTextField(20);
		dateLabel.setLabelFor(dateTextField);
		visitPanel.add(dateTextField);
		
		JLabel seqNumberLabel = new JLabel("Sequence Number", JLabel.TRAILING);
		visitPanel.add(seqNumberLabel);
		seqNumberTextField = new JTextField(10);
		seqNumberLabel.setLabelFor(seqNumberTextField);
		visitPanel.add(seqNumberTextField);
		
		SpringUtilities.makeCompactGrid(visitPanel, 
				3, 2, 	//# of rows, # of columns
				5, 5,					//Initial x and y coordinates	
				5, 5);					//Padding between labels and textfield
		
		//Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		edit = new JButton("Edit");		
		exit = new JButton("Exit");
		backToVisits = new JButton("Back to Visits");
		buttonPanel.add(edit);
		buttonPanel.add(exit);
		buttonPanel.add(backToVisits);
		
		setEditable(false);
		
		this.add(visitPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void setVisitData(String patientName, Date date, int seqNumber)
	{
		this.patientName = patientName;
		this.date = date;
		this.seqNumber = seqNumber;
		
		patientNameTextField.setText(this.patientName);
		dateTextField.setText(VisitListPanel.formatDate(this.date));
		seqNumberTextField.setText(Integer.toString(this.seqNumber));
	}
	
	public String getPatientName()
	{
		return patientNameTextField.getText();
	}
	
	public String getDateText()
	{
		return dateTextField.getText();
	}
	
	public String getSeqNumberText()
	{
		return seqNumberTextField.getText();
	}
	
	public void setEditable(boolean isEditable)
	{
		patientNameTextField.setEditable(false);
		dateTextField.setEditable(isEditable);
		seqNumberTextField.setEditable(isEditable);
		if (isEditable)
			edit.setText("Done");
		else
			edit.setText("Edit");
	}
	
	public void addVisitListener(ActionListener listener)
	{
		edit.addActionListener(listener);
		exit.addActionListener(listener);
		backToVisits.addActionListener(listener);
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
