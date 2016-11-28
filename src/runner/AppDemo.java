package runner;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.MainFrame;

public class AppDemo {
	public static void main(String[]args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MainFrame frame = new MainFrame("Week planner");
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setSize(new Dimension(1280, 640));
				frame.setLocation((int)(screenSize.getWidth() - frame.getWidth())/2, (int)(screenSize.getHeight() - frame.getHeight()) / 2);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
