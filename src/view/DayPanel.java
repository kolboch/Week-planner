package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import viewListeners.TaskBlockListener;

public class DayPanel extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private JLabel dayNameLabel;
	private DayTasksBlock tasksBlock;
	
	public DayPanel(String dayName){
		dayNameLabel = new JLabel(dayName, SwingConstants.CENTER);
		Border b = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		dayNameLabel.setBorder(b);
		
		tasksBlock = new DayTasksBlock();
		
		setComponents();
	}
	
	public void addTaskPanel(TaskBlock task){
		task.setTaskBlockListener(new TaskBlockListener(){
			@Override
			public void deleteTask() {
				tasksBlock.removeTask(task);
			}
		});
		tasksBlock.addTask(task);
	}
	
	private void setComponents(){
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		add(dayNameLabel, gbc);
		
		gbc.gridy = 1;
		add(tasksBlock, gbc);
	}
}
