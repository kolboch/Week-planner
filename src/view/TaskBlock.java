package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class TaskBlock extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel titleLabel;
	private JLabel descriptionLabel;
	
	public TaskBlock(String title, String description, Color c){
		titleLabel = new JLabel("<html>" + title + "</html>");
		descriptionLabel = new JLabel("<html>" + description + "</html>");		
		
		setBackground(c);
		
		if(c.getRed() * 0.2126 + c.getGreen() * 0.7152 + c.getBlue() * 0.0722 < 60){
			titleLabel.setForeground(Color.WHITE);
			descriptionLabel.setForeground(Color.WHITE);
		}
		
		
		setLayout(new BorderLayout());
		add(titleLabel, BorderLayout.NORTH);
		add(descriptionLabel, BorderLayout.CENTER);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
}
