package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class DayPanel extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private JLabel dayNameLabel;
	private List<TaskBlock>blocks;
	
	public DayPanel(String dayName){
		blocks = new LinkedList<>();
		
		dayNameLabel = new JLabel(dayName, SwingConstants.CENTER);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border b = BorderFactory.createEtchedBorder();
		dayNameLabel.setBorder(b);
		add(dayNameLabel);
	}
	
	public void addTaskPanel(TaskBlock taskBlock){
		blocks.add(taskBlock);
		this.add(taskBlock);
	}
	
	//TODO delete operation and replacement of left tasks.
	
}
