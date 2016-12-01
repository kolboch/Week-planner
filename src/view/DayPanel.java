package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class DayPanel extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private JLabel dayNameLabel;
	private GridBagConstraints gbc;
	
	public DayPanel(String dayName){
		dayNameLabel = new JLabel(dayName);
		setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		Border b = BorderFactory.createLineBorder(Color.BLACK, 2);
		setBorder(b);
		add(dayNameLabel, gbc);
	}
	
	public void addTaskPanel(TaskBlock taskBlock){
		gbc.gridy++;
		this.add(taskBlock, gbc);
	}
	
}
