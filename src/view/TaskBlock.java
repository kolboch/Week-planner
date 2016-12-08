package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;

import viewListeners.TaskBlockListener;

public class TaskBlock extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel titleLabel;
	private JLabel descriptionLabel;
	private TaskBlockListener listener;
	private JPopupMenu deleteMenu;
	
	public TaskBlock(String title, String description, Color c){
		titleLabel = new JLabel("<html>" + title + "</html>");
		descriptionLabel = new JLabel("<html>" + description + "</html>");		
		
		setBackground(c);
		
		if(c.getRed() * 0.2126 + c.getGreen() * 0.7152 + c.getBlue() * 0.0722 < 60){
			titleLabel.setForeground(Color.WHITE);
			descriptionLabel.setForeground(Color.WHITE);
		}
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		add(titleLabel, BorderLayout.NORTH);
		add(descriptionLabel, BorderLayout.CENTER);
		
		
		deleteMenu = new JPopupMenu();
		JMenuItem item = new JMenuItem("Delete task");
		item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					listener.deleteTask();
				}
			}
		});
		deleteMenu.add(item);
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e){
				if(e.getButton() == MouseEvent.BUTTON3){ // right mouse button
					doPop(e);
				}
			}
			
			private void doPop(MouseEvent e){
				deleteMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
		
	}
	
	public void setTaskBlockListener(TaskBlockListener listener){
		this.listener = listener;
	}
}
