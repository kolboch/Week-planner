package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Task;
import utils.AppUtils;
import viewListeners.MainBarMenuListener;
import viewListeners.TaskCreateListener;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private TaskCreatePanel taskPanel;
	private Schedule weekSchedule;
	private MainBarMenu menuBar;
	private final JFileChooser fileChooser;
	
	public MainFrame(String title){
		super(title);
		taskPanel = new TaskCreatePanel();
		weekSchedule = new Schedule();
		menuBar = new MainBarMenu();
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Select directory for weekPlan image.");
		
		setJMenuBar(menuBar);
		setLayout(new BorderLayout());
		add(weekSchedule, BorderLayout.CENTER);
		add(taskPanel, BorderLayout.EAST);
		
		taskPanel.setTaskCreateListener(new TaskCreateListener(){

			@Override
			public void addTask(Task task, Color colorOfTask) {
				weekSchedule.addTaskPanel(task, colorOfTask);
				weekSchedule.getParent().revalidate();
			}
			
		});
		
		menuBar.setMainBarMenuListener(new MainBarMenuListener(){
			@Override
			public void weekplanToImage() {
				BufferedImage toSave = AppUtils.takeScreenShot(weekSchedule);
				try{
					if(fileChooser.showSaveDialog(menuBar.getParent()) == JFileChooser.APPROVE_OPTION){
						String currentDir = fileChooser.getSelectedFile().getPath();
						AppUtils.writeImageToFile(currentDir, toSave);
					}
				}
				catch(IOException e){
					JOptionPane.showConfirmDialog(menuBar.getParent(), e.getMessage());
				}
			}
		});
	}
}
