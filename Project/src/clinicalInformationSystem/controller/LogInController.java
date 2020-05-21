package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clinicalInformationSystem.model.AuthorizedUsers;
import clinicalInformationSystem.view.LogInPanel;
import clinicalInformationSystem.view.SystemFrame;

/**
 * Controller to control AuthorizedUsers model with LogInPanel
 * @author benja
 *
 */
public class LogInController
{
	private SystemFrame frame;
	private AuthorizedUsers users;
	private LogInPanel logInPanel;
	
	/**
	 * Create a log in controller with the associated parameters
	 * @param frame SystemFrame that is being worked on
	 * @param users AuthorizedUsers list associated with the frame
	 * @param logInPanel LogInPanel to control and manipulate
	 */
	public LogInController(SystemFrame frame, AuthorizedUsers users, LogInPanel logInPanel)
	{
		this.frame = frame;
		this.users = users;
		this.logInPanel = logInPanel;
		this.logInPanel.addLogInListener(new LogInListener());
	}
	
	/**
	 * ActionListener for LogInController
	 * @author benja
	 *
	 */
	private class LogInListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Log In"))
			{
				String username, password;
				if ((username = logInPanel.getUsername()) != null && (password = logInPanel.getPassword()) != null)
				{
					if (users.isAuthorized(username, password))
					{
						frame.setAuthorized(username, password);
						frame.remove(logInPanel);
						frame.setSize(600, 400);
					}
					else
						logInPanel.displayErrorMessage("Invalid User.\nHint: Default is \"admin\" for username and password.");
				} else
					logInPanel.displayErrorMessage("Please fill in all fields.");
			}
		}
	}
}
