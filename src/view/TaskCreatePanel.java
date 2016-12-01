package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Day;
import viewListeners.TaskCreateListener;

public class TaskCreatePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private final Color[] COLORS = {Color.RED, Color.BLUE, Color.BLACK, Color.YELLOW, Color.GREEN};
	
	private JButton addTaskButton;
	private JComboBox<Day> dayList;
	private JComboBox<Color> colorList;
	private JLabel titleLabel;
	private JTextField titleField;
	private JLabel descriptionLabel;
	private JTextArea descriptionArea;
	private TaskCreateListener listener;
	
	public TaskCreatePanel(){
		addTaskButton = new JButton("Add task");
		addTaskButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					String title = titleField.getText();
					String description = descriptionArea.getText();
					Day day = (Day)dayList.getSelectedItem(); // not sure if correct right now
					Color c = (Color)colorList.getSelectedItem(); // same as above commentary
					listener.addTask(title, description, day, c);
				}
			}
		});
		titleLabel = new JLabel("Title:");
		titleField = new JTextField(20);
		dayList = new JComboBox<>(Day.values());
		colorList = new JComboBox<>(COLORS);
		descriptionLabel = new JLabel("Description:");
		descriptionArea = new JTextArea(3,20);
		descriptionArea.setBorder(titleField.getBorder());
		setComponents();
	}
	
	public void setTaskCreateListener(TaskCreateListener listener){
		this.listener = listener;
	}
	
	private void setComponents(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets basic = new Insets(5,2,5,5);
		gbc.insets = basic;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridx = 1;
		add(dayList, gbc);
		gbc.gridy = 1;
		add(colorList, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		add(titleLabel, gbc);
		gbc.gridx = 1;
		add(titleField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 2;
		add(descriptionLabel, gbc);
		gbc.gridx = 1;
		add(descriptionArea, gbc);
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		add(addTaskButton, gbc);		
	}
}
