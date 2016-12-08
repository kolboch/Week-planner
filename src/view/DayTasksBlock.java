package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DayTasksBlock extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private List<TaskBlock>blocks;
	
	public DayTasksBlock(){
		blocks = new LinkedList<>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addTask(TaskBlock taskBlock){
		blocks.add(taskBlock);
		this.add(taskBlock);
	}
	
	public void removeTask(TaskBlock taskBlock){
		this.remove(taskBlock);
		this.revalidate();
	}
}
