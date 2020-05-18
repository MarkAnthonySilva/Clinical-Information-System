package clinicalInformationSystem;
import javax.swing.JFrame;

import clinicalInformationSystem.view.SystemFrame;

//testt
public class SystemTester
{
	
	public static void main(String args[])
	{
		SystemFrame frame = new SystemFrame();
		
		frame.addUser("admin", "admin");
		//frame.addUser("", "");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
