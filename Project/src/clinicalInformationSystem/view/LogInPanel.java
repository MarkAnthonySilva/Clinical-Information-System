package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import clinicalInformationSystem.SpringUtilities;

/**
 * Panel to display fields and button for Log In JPanel (default panel upon starting system)
 * @author benja
 *
 */
public class LogInPanel extends JPanel
{
	private JButton logIn;
	private JTextField username;
	private JTextField password;
	
	/**
	 * Create a log in panel to be displayed on SystemFrame
	 */
	public LogInPanel()
	{
		this.setLayout(new BorderLayout());
		
		JPanel inputPanel = new JPanel(new SpringLayout());
		
		JLabel usernameLabel = new JLabel("Username:", JLabel.TRAILING);
		inputPanel.add(usernameLabel);
		username =  new JTextField(20);
		usernameLabel.setLabelFor(username);
		inputPanel.add(username);
		
		JLabel passwordLabel = new JLabel("Password:", JLabel.TRAILING);
		inputPanel.add(passwordLabel);
		password =  new JPasswordField(20);
		passwordLabel.setLabelFor(password);
		inputPanel.add(password);
		
		SpringUtilities.makeCompactGrid(inputPanel, 
				2, 2, 					// # of rows, # of columns
				5, 5,					// Initial x and y coordinates	
				5, 5);					// Padding between labels and textfield
		
		// Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		logIn = new JButton("Log In");
		buttonPanel.add(logIn);
		
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Get username entered in username text field
	 * @return Username
	 */
	public String getUsername()
	{
		return username.getText();
	}
	
	/**
	 * Get password entered in password text field
	 * @return Password
	 */
	public String getPassword()
	{
		return password.getText();
	}
	
	/**
	 * Add ActionListener object on LogIn button
	 * @param listener ActionListener to be added on LogIn button
	 */
	public void addLogInListener(ActionListener listener)
	{
		logIn.addActionListener(listener);
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
