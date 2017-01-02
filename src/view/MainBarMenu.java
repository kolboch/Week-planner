package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import viewListeners.MainBarMenuListener;

public class MainBarMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private JMenu menu;
	private JMenuItem toImage;
	private MainBarMenuListener listener;
	
	public MainBarMenu(){
		menu = new JMenu("Options");
		
		toImage = new JMenuItem("Export as image");
		menu.add(toImage);
		
		setActionsForMenuItems();
		
		add(menu);
	}
	
	private void setActionsForMenuItems(){
		toImage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(listener != null){
					listener.weekplanToImage();
				}
			}
		});
	}
	
	public void setMainBarMenuListener(MainBarMenuListener listener){
		this.listener = listener;
	}
}
