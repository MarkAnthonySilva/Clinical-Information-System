package clinicalInformationSystem;
import javax.swing.JFrame;

import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.view.*;

public class SystemTester
{
	
	public static void main(String args[])
	{
		SystemFrame frame = new SystemFrame();
		
		//Create Controllers
		MenuController menuController = new MenuController(frame);
		
		frame.registerListeners(menuController);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
