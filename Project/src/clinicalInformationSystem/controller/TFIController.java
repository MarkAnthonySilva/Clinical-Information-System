package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clinicalInformationSystem.model.*;
import clinicalInformationSystem.view.*;

public class TFIController {

	private SystemFrame frame;
	private VisitModel visit;
	private TFIPanel panel;
	
	public TFIController(SystemFrame frame, VisitModel visit, TFIPanel panel)
	{
		this.frame = frame;
		this.visit = visit;
		this.panel = panel;
		this.panel.setQuestions(TFIModel.TFIQuestionBank);
		if (this.visit.getTFIModel() != null)
		{
			this.panel.setResults(this.visit.getTFIModel().getAllAnswers());
			this.panel.addActionListener(new TFIListener());
		}
		else
		{
			this.panel.addActionListener(new AddTFIListener());
		}
	}

	private class AddTFIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Done"))
			{
				TFIModel TFI = new TFIModel();
				if (panel.omissions() < 7)
				{
					for (int i = 1; i <= TFIModel.TFIQuestionBank.length; i++)
					{
						if(!panel.getAnswer(i).equals(""))
						{
							try {
								int answer = Integer.parseInt(panel.getAnswer(i));
								if(answer < 0 || answer > 10)
								{
									panel.displayErrorMessage(String.format("Question %d has invalid input. Please enter an integer number beween 0 and 10", i));
									return;
								}
								TFI.answerQuestion(i, answer);
							}
							catch (NumberFormatException ex)
							{
								panel.displayErrorMessage(String.format("Question %d has invalid input. Please enter an integer number beween 0 and 10", i));
								return;
							}
						}
						else
						{
							TFI.answerQuestion(i, -1);
						}
					}
					visit.setTFIModel(TFI);
					frame.displayVisit(visit);
				} else
				{
					panel.displayErrorMessage("Please omit less than 7 questions.");
				}
			}
		}
	}
	
	private class TFIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Done"))
				frame.displayVisit(visit);
		}
	}
	
}
