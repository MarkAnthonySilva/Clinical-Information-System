package clinicalInformationSystem.model;

import java.util.HashMap;

public class AuthorizedUsers
{
	private HashMap<String, String> users;
	
	public AuthorizedUsers()
	{
		users = new HashMap<String, String>();
	}
	
	public boolean addAuthorizedUser(String username, String password)
	{
		// Username already used = return false
		if(users.containsKey(username))
		{
			return false;
		}
		// User added with username and password = return true
		users.put(username, password);
		return true;
	}
	
	public boolean isAuthorized(String username, String password)
	{
		// Check if username is in users database
		if(users.containsKey(username))
		{
			// Return true if password matches corresponding password to username
			if(users.get(username).equals(password))
				return true;
		}
		// Return false if invalid user
		return false;
	}
	
	public boolean changePassword(String username, String oldPassword, String newPassword)
	{
		boolean successful;
		// True = successfully replaced; False = not replaced
		successful = users.replace(username, oldPassword, newPassword);
		return successful;
	}
}
