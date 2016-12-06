package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import model.Task;
import viewListeners.TaskCreateListener;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private TaskCreatePanel taskPanel;
	private Schedule weekSchedule;
	private MainBarMenu menuBar;
	
	public MainFrame(String title){
		super(title);
		taskPanel = new TaskCreatePanel();
		weekSchedule = new Schedule();
		menuBar = new MainBarMenu();
		
		setJMenuBar(menuBar);
		setLayout(new BorderLayout());
		add(weekSchedule, BorderLayout.CENTER);
		add(taskPanel, BorderLayout.EAST);
		
		taskPanel.setTaskCreateListener(new TaskCreateListener(){

			@Override
			public void addTask(Task task, Color colorOfTask) {
				weekSchedule.addTaskPanel(task, colorOfTask);
				weekSchedule.getParent().revalidate();
			}
			
		});
	}
}
