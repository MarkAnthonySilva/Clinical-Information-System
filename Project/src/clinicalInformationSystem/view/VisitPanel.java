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
import clinicalInformationSystem.THIScoreGrade;

/**
 * Create VisitPanel to display information for a specific visit
 * @author benja
 *
 */
public class VisitPanel extends JPanel
{
	private JPanel visitPanel;
	private JButton edit;
	private JButton viewTHI;
	private JButton viewTFI;
	private JButton delete;
	private JButton exit;
	private JButton backToVisits;
	
	private String patientName;
	private Date date;
	private int seqNumber;
	private int THIScore;
	private int TFIScore;
	
	private JTextField patientNameTextField;
	private JTextField dateTextField;
	private JTextField seqNumberTextField;
	private JTextField THIScoreTextField;
	private JTextField TFIScoreTextField;
	
	/**
	 * Create VisitPanel
	 */
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
		
		JLabel THIScoreLabel = new JLabel("THI Score", JLabel.TRAILING);
		visitPanel.add(THIScoreLabel);
		THIScoreTextField = new JTextField(10);
		THIScoreLabel.setLabelFor(THIScoreTextField);
		visitPanel.add(THIScoreTextField);
		
		JLabel TFIScoreLabel = new JLabel("TFI Score", JLabel.TRAILING);
		visitPanel.add(TFIScoreLabel);
		TFIScoreTextField = new JTextField(10);
		TFIScoreLabel.setLabelFor(TFIScoreTextField);
		visitPanel.add(TFIScoreTextField);
		
		SpringUtilities.makeCompactGrid(visitPanel, 
				5, 2, 					// # of rows, # of columns
				5, 5,					// Initial x and y coordinates	
				5, 5);					// Padding between labels and textfield
		
		// Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		JPanel buttonPanelRow1 = new JPanel();
		JPanel buttonPanelRow2 = new JPanel();
		buttonPanelRow1.setLayout(new FlowLayout());
		buttonPanelRow2.setLayout(new FlowLayout());
		edit = new JButton("Edit");
		viewTHI = new JButton("View THI");
		viewTFI = new JButton("View TFI");
		delete = new JButton("Delete");
		exit = new JButton("Exit");
		backToVisits = new JButton("Back to Visits");
		buttonPanelRow1.add(edit);
		buttonPanelRow1.add(viewTHI);
		buttonPanelRow1.add(viewTFI);
		buttonPanelRow2.add(delete);
		buttonPanelRow2.add(exit);
		buttonPanelRow2.add(backToVisits);
		
		buttonPanel.add(buttonPanelRow1, BorderLayout.NORTH);
		buttonPanel.add(buttonPanelRow2, BorderLayout.SOUTH);
		
		setEditable(false);
		
		this.add(visitPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Set data for visit to be displayed in the panel
	 * @param patientName Name of patient corresponding to visit
	 * @param date Date of visit
	 * @param seqNumber Sequence number of visit
	 * @param THIScore THIScore of visit
	 * @param TFIScore TFIScore of visit
	 */
	public void setVisitData(String patientName, Date date, int seqNumber, int THIScore, int TFIScore)
	{
		this.patientName = patientName;
		this.date = date;
		this.seqNumber = seqNumber;
		this.THIScore = THIScore;
		this.TFIScore = TFIScore;
		
		patientNameTextField.setText(this.patientName);
		dateTextField.setText(VisitListPanel.formatDate(this.date));
		seqNumberTextField.setText(Integer.toString(this.seqNumber));
		THIScoreTextField.setText(String.format("%d (%s)", this.THIScore, THIScoreGrade.getGrade(this.THIScore).getDescription()));
		TFIScoreTextField.setText(Integer.toString(this.TFIScore));
	}
	
	/**
	 * Get patient name filled in text box
	 * @return Patient name
	 */
	public String getPatientName()
	{
		return patientNameTextField.getText();
	}
	
	/**
	 * Get date filled in text box
	 * @return Date
	 */
	public String getDateText()
	{
		return dateTextField.getText();
	}
	
	/**
	 * Get sequence number filled in text box
	 * @return Sequence number
	 */
	public String getSeqNumberText()
	{
		return seqNumberTextField.getText();
	}
	
	/**
	 * Set if panel is editable
	 * @param isEditable True = fields can be edited, False = fields uneditable
	 */
	public void setEditable(boolean isEditable)
	{
		patientNameTextField.setEditable(false);
		THIScoreTextField.setEditable(false);
		TFIScoreTextField.setEditable(false);
		
		dateTextField.setEditable(isEditable);
		seqNumberTextField.setEditable(isEditable);
		if (isEditable)
			edit.setText("Done");
		else
			edit.setText("Edit");
	}
	
	/**
	 * Add ActionListener on all buttons
	 * @param listener ActionListener to be added on all buttons
	 */
	public void addVisitListener(ActionListener listener)
	{
		edit.addActionListener(listener);
		viewTHI.addActionListener(listener);
		viewTFI.addActionListener(listener);
		delete.addActionListener(listener);
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
