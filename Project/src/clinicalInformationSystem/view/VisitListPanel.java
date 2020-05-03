package clinicalInformationSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import clinicalInformationSystem.DataTableModel;

public class VisitListPanel extends JPanel
{
	public static final String[] columnNames = {"Patient Name", "Date", "Sequence Number"};
	JButton edit;		
	JButton exit;
	
	public VisitListPanel(SystemFrame frame)
	{
		this.setLayout(new BorderLayout());
		
		JPanel allVisitsPanel = new JPanel();
		String[][] data = new String[frame.getVisitList().size()][columnNames.length];
		
		for(int row = 0; row < frame.getVisitList().size(); row++)
		{
			for(int col = 0; col < columnNames.length; col++)
			{
				switch(col)
				{
				case 0:
					data[row][col] = frame.getVisitList().get(row).getPatient().getPatientName();
					break;
				case 1:
					data[row][col] = formatDate(frame.getVisitList().get(row).getDateOfVisit());
					break;
				case 2:
					data[row][col] = Integer.toString(frame.getVisitList().get(row).getSequenceNumber());
				}
			}
		}
		
		JTable table = new JTable(data, columnNames);
		DataTableModel model = new DataTableModel(data, columnNames);
		table.setModel(model);
		table.setBounds(30, 40, this.getWidth() , this.getHeight());
		
		
		JScrollPane sp = new JScrollPane(table);
		allVisitsPanel.add(sp);
		
		//Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		edit = new JButton("Edit");		
		exit = new JButton("Exit");
		buttonPanel.add(edit);
		buttonPanel.add(exit);
		
		this.add(allVisitsPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private String formatDate(Date d)
	{
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("MMMM d, yyyy");
		String date = standardDateFormat.format(d);
		return date;
	}
	
	public void addVisitListListener(ActionListener listener)
	{
		edit.addActionListener(listener);
		exit.addActionListener(listener);
	}
}
