package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import viewListeners.MainBarMenuListener;

public class MainBarMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	//TODO feature to set frame background to satisfy user preferences
	private JMenu menu;
	private JMenuItem toImage;
	private JMenuItem asWallPaper;
	private MainBarMenuListener listener;
	
	public MainBarMenu(){
		menu = new JMenu("Options");
		
		toImage = new JMenuItem("Export as image");
		asWallPaper = new JMenuItem("Set as wallpaper");
		menu.add(toImage);
		menu.add(asWallPaper);
		
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
		
		asWallPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listener != null){
					listener.weekplanAsWallpaper();
				}
			}
		});
	}
	
	public void setMainBarMenuListener(MainBarMenuListener listener){
		this.listener = listener;
	}
}
