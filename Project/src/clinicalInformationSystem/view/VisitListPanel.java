package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

import clinicalInformationSystem.DataTableModel;

/**
 * Create VisitListPanel to display information for a list of visits
 * @author benja
 *
 */
public class VisitListPanel extends JPanel
{
	public static final String[] columnNames 	= {"Patient Name", "Date", "Sequence Number"};	
	public static final String[] columnNames1 	= {"Date", "THI Score", "TFI Score", "Sequence Number"};
	JTable table;
	JButton exit;
	String[][] data;
	
	/**
	 * Create VisitListPanel
	 */
	public VisitListPanel()
	{
		this.setLayout(new BorderLayout());
		
		//Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		exit = new JButton("Exit");
		buttonPanel.add(exit);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Set data of visits to be displayed in panel
	 * @param patientNames Patient name for each visit
	 * @param dateOfVisits Date of each visit
	 * @param sequenceNumbers Sequence number of each visit
	 */
	public void setData(String[] patientNames, Date[] dateOfVisits, int[] sequenceNumbers)
	{
		data = new String[patientNames.length][columnNames.length];
		
		for (int row = 0; row < patientNames.length; row++)
		{
			for (int col = 0; col < columnNames.length; col++)
			{
				switch(col)
				{
				case 0:
					data[row][col] = patientNames[row];
					break;
				case 1:
					data[row][col] = formatDate(dateOfVisits[row]);
					break;
				case 2:
					data[row][col] = Integer.toString(sequenceNumbers[row]);
					break;
				}
			}
		}
		
		JPanel allVisitsPanel = new JPanel();
		
		table = new JTable(data, columnNames);
		DataTableModel model = new DataTableModel(data, columnNames);
		table.setModel(model);
		table.setBounds(30, 40, this.getWidth() , this.getHeight());
		
		JScrollPane sp = new JScrollPane(table);
		allVisitsPanel.add(sp);
		
		this.add(allVisitsPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Set data of visits to be displayed in panel
	 * @param patientNames Patient name for each visit
	 * @param dateOfVisits Date of each visit
	 * @param sequenceNumbers Sequence number of each visit
	 */
	public void setData(Date[] dateOfVisits, int[] THIScores, int[] TFIScores, int[] sequenceNumbers)
	{
		data = new String[dateOfVisits.length][columnNames1.length];
		
		for (int row = 0; row < dateOfVisits.length; row++)
		{
			for (int col = 0; col < columnNames1.length; col++)
			{
				switch(col)
				{
				case 0:
					data[row][col] = formatDate(dateOfVisits[row]);
					break;
				case 1:
					data[row][col] = Integer.toString(THIScores[row]);
					break;
				case 2:
					data[row][col] = Integer.toString(TFIScores[row]);
					break;
				case 3:
					data[row][col] = Integer.toString(sequenceNumbers[row]);
					break;
				}
			}
		}
		
		JPanel allVisitsPanel = new JPanel();
		
		table = new JTable(data, columnNames1);
		DataTableModel model = new DataTableModel(data, columnNames1);
		table.setModel(model);
		table.setBounds(30, 40, this.getWidth() , this.getHeight());
		
		JScrollPane sp = new JScrollPane(table);
		allVisitsPanel.add(sp);
		
		this.add(allVisitsPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Get the selected row in the table
	 * @return Selected row
	 */
	public int getSelectedRow()
	{
		return table.getSelectedRow();
	}
	
	/**
	 * Format date as "MMMM d, yyyy" with passed in date
	 * @param d Date to be formatted
	 * @return Formatted date as String
	 */
	public static String formatDate(Date d)
	{
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("MMMM d, yyyy");
		String date = standardDateFormat.format(d);
		return date;
	}
	
	/**
	 * Add ActionListener on exit button
	 * @param listener ActionListener to be added on exit button
	 */
	public void addVisitListListener(EventListener listener)
	{
		table.getSelectionModel().addListSelectionListener((ListSelectionListener) listener);
		exit.addActionListener((ActionListener) listener);
	}
}
