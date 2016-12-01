package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.Day;
import model.Task;

public class Schedule extends JPanel {
	//TODO possible improvement ( task for more than one day)
	private static final long serialVersionUID = 1L;
	private DayPanel[] daysPanels;
	
	public Schedule(){
		initDayPanels();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		for(int i = 0; i < daysPanels.length; i++){
			add(daysPanels[i], gbc);
			gbc.gridx++;
		}
	}
	
	public void addTask(Task task){
		
	}
	
	public void initDayPanels(){
		daysPanels = new DayPanel[7];
		Day[]days = Day.values();
		String[]dayNames = new String[7];
		for(int i = 0; i < days.length; i++){
			dayNames[i] = days[i].getDayName();
			daysPanels[i] = new DayPanel(dayNames[i]);
		}
	}
	
}
