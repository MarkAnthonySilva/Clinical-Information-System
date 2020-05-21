package clinicalInformationSystem.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import clinicalInformationSystem.SpringUtilities;
import java.util.*;

/**
 * JPanel to display form for inputting TFI answers
 * @author benja
 *
 */
public class TFIPanel extends JPanel{
	
	private final int SPACES = 340;
	
	private JButton done;
	private String[] questionBank;
	private JLabel[] questionLabels;
	private JTextField[] textGroup;
	private JTextField[] scoreGroup;
	
	public static final String[] labelList = {"I: INTRUSIVE (unpleasantness, intrusiveness, persistence) #1-#3",
											  "SC: SENSE OF CONTROL (reduced sense of control) #4-#6", 
											  "C: COGNITIVE (cognitive interference) #7-#9",
											  "SL: SLEEP (sleep disturbance) #10-#12", 
											  "A: AUDITORY (auditory difficulties attributed to tinnitus) #13-#15", 
											  "R: RELAXATION (interference with relaxation) #16-#18", 
											  "Q: QUALITY OF LIFE (QOL) (quality of life reduced) #19-#22", 
											  "E: EMOTIONAL (emotional distress) #23-#25",
											  "Overall Score"};
	
	/**
	 * Constructor of TFIPanel that displays complete TFI form to fill out
	 */
	public TFIPanel()
	{
		this.setLayout(new BorderLayout());
		// Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		done = new JButton("Done");		
		buttonPanel.add(done);
		
		
		// Construct score Panel of Spring layout
		JPanel scorePanel = new JPanel();
		SpringLayout layout =  new SpringLayout();
		scorePanel.setLayout(layout);
				
		// Construct all labels and text fields for the score panel
		scoreGroup = new JTextField[labelList.length];
		for (int i = 0; i < labelList.length; i++)
		{
			JLabel label = new JLabel(labelList[i], JLabel.LEFT);
			scorePanel.add(label);
			scoreGroup[i] = new JTextField(5);
			scoreGroup[i].setEditable(false);
			label.setLabelFor(scoreGroup[i]);
			scorePanel.add(scoreGroup[i]);
			
			String space = ""; int numberOfSpaces = SPACES;
			for(int j = 0; j < numberOfSpaces; j++)
				space += " ";
			JLabel blank = new JLabel(space);
			scorePanel.add(blank);
		}
				
			SpringUtilities.makeCompactGrid(scorePanel, 
											labelList.length, 3, 	// # of rows, # of columns
											5, 5,					// Initial x and y coordinates
											5, 5);					// Padding between labels and textfield
			
		this.add(scorePanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);	
	}
	
	/**
	 * Set questions for TFI form
	 * @param questions Questions used to evaluate TFI Score
	 */
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
				questionBank.length, 2, 	// # of rows, # of columns
				5, 5,						// Initial x and y coordinates	
				5, 5);						// Padding between labels and textfield
		
		this.add(formPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Set scores for each question
	 * @param scores Scores for each question
	 */
	public void setScores(int[] scores)
	{
		for(int i = 0; i < labelList.length; i++)
		{
			scoreGroup[i].setText(String.format("%d", scores[i]));
		}
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
			textGroup[i].setEditable(false);
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
