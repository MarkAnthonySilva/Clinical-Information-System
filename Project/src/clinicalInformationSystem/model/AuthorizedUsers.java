package clinicalInformationSystem.model;

import java.util.HashMap;

/**
 * Class to store all authorized users in system
 * @author benja
 *
 */
public class AuthorizedUsers
{
	private HashMap<String, String> users;
	
	/**
	 * Create AuthorizedUsers object with an empty HashMap
	 */
	public AuthorizedUsers()
	{
		users = new HashMap<String, String>();
	}
	
	/**
	 * Add an authorized user to the system with corresponding parameters
	 * @param username Username for user
	 * @param password Password for user
	 * @return True = User Added, False = User Not Added (Username already used)
	 */
	public boolean addAuthorizedUser(String username, String password)
	{
		// Username already used = return false
		if (users.containsKey(username))
		{
			return false;
		}
		// User added with username and password = return true
		users.put(username, password);
		return true;
	}
	
	/**
	 * Check if user associated with given parameters is authorized to use the system
	 * @param username Username to check for authorization
	 * @param password Password to check for authorization
	 * @return True = User Authorized; False = User Not Authorized (Incorrect Username + Password combination)
	 */
	public boolean isAuthorized(String username, String password)
	{
		// Check if username is in users database
		if (users.containsKey(username))
		{
			// Return true if password matches corresponding password to username
			if (users.get(username).equals(password))
				return true;
		}
		// Return false if invalid user
		return false;
	}
	
	/**
	 * Change password for user associated with username and old password
	 * @param username Username for user to have password changed
	 * @param oldPassword Current password to be changed
	 * @param newPassword New password to change to
	 * @return True = Password Changed; False = Password Unchanged (Incorrect Username + Password combination)
	 */
	public boolean changePassword(String username, String oldPassword, String newPassword)
	{
		boolean successful;
		// True = successfully replaced; False = not replaced
		successful = users.replace(username, oldPassword, newPassword);
		return successful;
	}
}
