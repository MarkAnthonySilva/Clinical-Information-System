package clinicalInformationSystem.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import clinicalInformationSystem.SpringUtilities;
import java.util.*;

public class TFIPanel extends JPanel{
	
	private JButton done;
	private String[] questionBank;
	private JLabel[] questionLabels;
	private JTextField[] textGroup;
	
	public TFIPanel()
	{
		this.setLayout(new BorderLayout());
		//Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		done = new JButton("Done");		
		buttonPanel.add(done);
		
		this.add(buttonPanel, BorderLayout.SOUTH);	
	}
	
	public void setQuestions(String[] questions)
	{
		this.questionBank = questions;
		
		JPanel formPanel = new JPanel(new SpringLayout());
		questionLabels = new JLabel[questionBank.length];
		textGroup = new JTextField[questionBank.length];
		for (int i = 0; i < questionBank.length; i++)
		{
			questionLabels[i] = new JLabel(String.format("%d. %s", i+1, questionBank[i]));
			textGroup[i] = new JTextField(5);
			formPanel.add(questionLabels[i]);
			questionLabels[i].setLabelFor(textGroup[i]);
			formPanel.add(textGroup[i]);		
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
				questionBank.length, 2, 	//# of rows, # of columns
				5, 5,						//Initial x and y coordinates	
				5, 5);						//Padding between labels and textfield
		
		this.add(formPanel, BorderLayout.NORTH);
		
		
		/*
		//Construct all label and text fields for the form panel
		JLabel title = new JLabel("For each question, enter a number between one 1 and 10");
		this.add(title, BorderLayout.NORTH);
		tfiData = new HashMap<>();
		for (int i = 0; i < labelList.length; i++)
		{
			JLabel label = new JLabel(labelList[i], JLabel.LEFT);
			formPanel.add(label);
			JTextField textField = new JTextField(5);
			label.setLabelFor(textField);
			formPanel.add(textField);
			
			tfiData.put(labelList[i], textField);
		}
		
		SpringUtilities.makeCompactGrid(formPanel, 
										labelList.length, 2, 	//# of rows, # of columns
										5, 5,					//Initial x and y coordinates
										5, 5);					//Padding between labels and textfield
	
		this.add(formPanel, BorderLayout.CENTER);
		
		//Create button panel
		JPanel buttonPanel 	= new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		submit	 	= new JButton("Submit");	
		exit	 	= new JButton("Exit");
		
		buttonPanel.add(submit);
		buttonPanel.add(exit);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		*/
	}
	
	/**
	 * Set results to an already filled out THI questionnaire
	 * @param answers Answers to all questions ("Severity scale 0-10")
	 */
	public void setResults(int[] answers)
	{
		if (questionBank.length == 0 || answers.length > questionBank.length)
			return;
		for (int i = 0; i < answers.length; i++)
		{
			if(answers[i] != -1)
				textGroup[i].setText(String.format("%d", answers[i]));
			textGroup[i].setEnabled(false);
		}
	}
	
	/**
	 * Get the answer to corresponding question number (starting at 1)
	 * @param questionNumber Number of question starting at #1
	 * @return String corresponding to answer of question
	 */
	public String getAnswer(int questionNumber)
	{
		if (questionNumber > questionBank.length || questionNumber < 1) // || textGroup[questionNumber - 1].getText() == null)
			return null;
		return textGroup[questionNumber - 1].getText();
	}
	
	/**
	 * Return number of omissions
	 * @return number of omissions
	 */
	public int omissions()
	{
		int omissions = 0;
		for (JTextField text: textGroup)
		{
			if (text.getText().equals(""))
				omissions++;
		}
		return omissions;
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
	public void addActionListener(ActionListener listener)
	{
		done.addActionListener(listener);
	}
	
	
}
