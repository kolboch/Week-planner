package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import viewListeners.TaskCreateListener;

public class TaskCreatePanel extends JPanel {
	
	private JButton addButton;
	private JComboBox dayList;
	private JLabel titleLabel;
	private JTextField title;
	private JLabel descriptionLabel;
	private JTextArea description;
	private TaskCreateListener listener;
	
	public TaskCreatePanel(){
		
	}
	
	public void setTaskCreateListener(TaskCreateListener listener){
		this.listener = listener;
	}
}
