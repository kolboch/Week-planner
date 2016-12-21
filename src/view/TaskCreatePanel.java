package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import model.Day;
import model.Task;
import viewListeners.TaskCreateListener;

public class TaskCreatePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static Image[] images;
	public static final Color[] COLORS = {Color.RED, Color.BLUE, Color.BLACK, Color.YELLOW, Color.GREEN};
	private final String[] COLORS_NAMES = {"RED", "BLUE", "BLACK", "YELLOW", "GREEN"};
	
	private JButton addTaskButton;
	private JComboBox<Day> dayList;
	private JComboBox<Color> colorList;
	private JLabel titleLabel;
	private JTextField titleField;
	private JLabel descriptionLabel;
	private JTextArea descriptionArea;
	private JScrollPane descriptionScrollPane;
	private TaskCreateListener listener;
	
	public TaskCreatePanel(){
		try {
			setImages();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("Error occured when loading images");
			System.exit(1);
		}
		
		addTaskButton = new JButton("Add task");
		addTaskButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					String title = titleField.getText();
					String description = descriptionArea.getText();
					Day day = (Day)dayList.getSelectedItem();
					Color colorOfTask = (Color)colorList.getSelectedItem();
					Task taskToAdd = new Task(title, description, day);
					listener.addTask(taskToAdd, colorOfTask);
				}
			}
		});
		titleLabel = new JLabel("Title:");
		titleField = new JTextField(20);
		dayList = new JComboBox<>(Day.values());
		
		colorList = new JComboBox<>(COLORS);
		ColorComboBoxRenderer renderer = new ColorComboBoxRenderer(colorList);
		renderer.setColors(COLORS);
		renderer.setColorNames(COLORS_NAMES);
		colorList.setOpaque(true);
		colorList.setRenderer(renderer);
		
		descriptionLabel = new JLabel("Description:");
		
		descriptionArea = new JTextArea(5,10);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setLineWrap(true);
		descriptionScrollPane = new JScrollPane(descriptionArea);
		
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
		add(descriptionScrollPane, gbc);
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		add(addTaskButton, gbc);		
	}
	
	
	class ColorComboBoxRenderer extends JPanel implements ListCellRenderer<Color>{
		
		private static final long serialVersionUID = 1L;
		private Color[]colors;
		private String[] colorNames;
		private JComboBox<Color> comboBox;
		
		JPanel textPanel;
		JLabel text;
		
		public ColorComboBoxRenderer(JComboBox<Color> combo) {
			this.comboBox = combo;
			textPanel = new JPanel();
	        textPanel.add(this);
	        text = new JLabel();
	        text.setOpaque(true);
	        text.setFont(combo.getFont());
	        textPanel.add(text);
	    }
		
		public void setColors(Color[]colors){
			this.colors = colors;
		}
		
		public void setColorNames(String[]colorNames){
			this.colorNames = colorNames;
		}
		
		public Color[] getColors(){
			return colors;
		}
		
		public String[] getColorNames(){
			return colorNames;
		}
		
		@Override
		public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (isSelected){
				list.setSelectionBackground(colors[list.getSelectedIndex()]);
				comboBox.setBackground(colors[list.getSelectedIndex()]);
				comboBox.getComponent(0).setBackground(new JButton().getBackground());
			}
	        else
	        {
	        }
			
			if(colors.length != colorNames.length){
				System.out.println("colors.length doesn't match colorNames.length");
				return this;
			}
			else if(colors == null){
				System.out.println("Set colors by setColors first.");
				return this;
			}
			else if(colorNames == null){
				System.out.println("Set colorNames by setColorNames first.");
				return this;
			}
			
			text.setText(" ");
			
			if(index > -1){
				text.setBackground(colors[index]);
			}
			
			return text;
		}
	}
	
	private void setImages() throws IOException{
		images = new Image[COLORS.length];
		images[0] = ImageIO.read(getClass().getResource("/resources/red.jpg"));
		images[1] = ImageIO.read(getClass().getResource("/resources/blue.jpg"));
		images[2] = ImageIO.read(getClass().getResource("/resources/black.jpg"));
		images[3] = ImageIO.read(getClass().getResource("/resources/yellow.jpg"));
		images[4] = ImageIO.read(getClass().getResource("/resources/green.jpg"));
	}
	
}
