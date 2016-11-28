package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private TaskCreatePanel taskPanel;
	
	public MainFrame(String title){
		super(title);
		taskPanel = new TaskCreatePanel();
		
		
		
		setLayout(new BorderLayout());
		add(taskPanel, BorderLayout.EAST);
	}
}
