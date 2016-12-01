package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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
	}
}
