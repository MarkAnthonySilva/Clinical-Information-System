package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import clinicalInformationSystem.SpringUtilities;

/**
 * JPanel to display form for inputting THI answers
 * @author benja
 *
 */
public class THIPanel extends JPanel
{
	private JButton done;
	private String[] questionBank;
	
	private JLabel[] questionLabels;
	private ButtonGroup[] buttonGroups;
	
	/**
	 * Constructor of THIPanel that displays complete TFI form to fill out
	 */
	public THIPanel()
	{
		this.setLayout(new BorderLayout());
		// Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		done = new JButton("Done");		
		buttonPanel.add(done);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Set questions for THI form
	 * @param questions Questions used to evaluate THI Score
	 */
	public void setQuestions(String[] questions)
	{
		this.questionBank = questions;
		
		JPanel formPanel = new JPanel(new SpringLayout());
		
		questionLabels = new JLabel[questionBank.length];
		buttonGroups = new ButtonGroup[questionBank.length];
		for (int i = 0; i < questionBank.length; i++)
		{
			questionLabels[i] = new JLabel(String.format("%d. %s", i+1, questionBank[i]));
			buttonGroups[i] = new ButtonGroup();
			JRadioButton yesButton = new JRadioButton("Yes");
			yesButton.setActionCommand("Yes");
			JRadioButton sometimesButton = new JRadioButton("Sometimes");
			sometimesButton.setActionCommand("Sometimes");
			JRadioButton noButton = new JRadioButton("No");
			noButton.setActionCommand("No");
			buttonGroups[i].add(yesButton);
			buttonGroups[i].add(sometimesButton);
			buttonGroups[i].add(noButton);
			
			formPanel.add(questionLabels[i]);
			formPanel.add(yesButton);
			formPanel.add(sometimesButton);
			formPanel.add(noButton);
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
				questionBank.length, 4, 	// # of rows, # of columns
				5, 5,						// Initial x and y coordinates	
				5, 5);						// Padding between labels and textfield
		
		this.add(formPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Set results to an already filled out THI questionnaire
	 * @param answers Answers to all questions ("Yes", "Sometimes", "No")
	 */
	public void setResults(String[] answers)
	{
		if (questionBank.length == 0 || answers.length > questionBank.length)
			return;
		for (int i = 0; i < answers.length; i++)
		{
			buttonGroups[i].clearSelection();
			Enumeration<AbstractButton> buttons = buttonGroups[i].getElements();
			while (buttons.hasMoreElements()) {
				AbstractButton abstractButton = buttons.nextElement();
				if (answers[i].toLowerCase().equals(abstractButton.getActionCommand().toLowerCase()))
					abstractButton.setSelected(true);
				abstractButton.setEnabled(false);
			}
		}
	}
	
	/**
	 * Get the answer to corresponding question number (starting at 1)
	 * @param questionNumber Number of question starting at #1
	 * @return String corresponding to answer of question
	 */
	public String getAnswer(int questionNumber)
	{
		if (questionNumber > questionBank.length || questionNumber < 1 || buttonGroups[questionNumber - 1].getSelection() == null)
			return null;
		return buttonGroups[questionNumber - 1].getSelection().getActionCommand();
	}
	
	/**
	 * Check that all questions have a selected answer radio button
	 * @return True = all questions answered; False = 1 or more unanswered questions
	 */
	public boolean allAnswered()
	{
		for (ButtonGroup group: buttonGroups)
		{
			if (group.getSelection() == null)
				return false;
		}
		return true;
	}
	
	/**
	 * Add ActionListener on done and back buttons
	 * @param listener ActionListener to be added
	 */
	public void addActionListener(ActionListener listener)
	{
		done.addActionListener(listener);
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
