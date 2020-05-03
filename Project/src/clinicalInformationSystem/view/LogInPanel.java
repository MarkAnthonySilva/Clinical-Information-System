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

public class LogInPanel extends JPanel
{
	SystemFrame frame;
	JButton logIn;
	JTextField username;
	JTextField password;
	
	/**
	 * Create a LogIn panel to be displayed
	 */
	public LogInPanel(SystemFrame frame)
	{
		this.frame = frame;
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
				2, 2, 					//# of rows, # of columns
				5, 5,					//Initial x and y coordinates	
				5, 5);					//Padding between labels and textfield
		
		// Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		logIn = new JButton("Log In");
		buttonPanel.add(logIn);
		
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public String getUsername()
	{
		return username.getText();
	}
	
	public String getPassword()
	{
		return password.getText();
	}
	
	public void addLogInListener(ActionListener listener)
	{
		logIn.addActionListener(listener);
	}
	
	/**
	 * Display login error on panel
	 */
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
