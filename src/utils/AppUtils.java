package utils;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

public class AppUtils {
	
	public static BufferedImage takeScreenShot(Component c){
		BufferedImage bf = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_BGR);
		c.paint(bf.getGraphics());
		return bf;
	}
	
	public static void writeImageToFile(String dirPath, BufferedImage img) throws IOException{
		Calendar c = Calendar.getInstance();
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);	
		
		String original = dirPath + "\\" + "weekPlan_" + dayOfMonth + month + year;
		int copyNr = 1;
		String path = original;
		while(new File(path + ".png").exists()){
			path = original + "(" + copyNr + ")";
			copyNr++;
		}
		path = path + ".png";
		
		ImageIO.write(img, "png", new File(path));
	}
}
