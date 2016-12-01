package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainBarMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	//TODO feature to set frame background to satisfy user preferences
	private JMenu menu;
	
	public MainBarMenu(){
		menu = new JMenu("Options");
		JMenuItem toImage = new JMenuItem("Export as image");
		JMenuItem asWallPaper = new JMenuItem("Set as wallpaper");
		menu.add(toImage);
		menu.add(asWallPaper);
		
		add(menu);
	}
}
