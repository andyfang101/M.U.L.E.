import java.awt.Point;

import javax.swing.ImageIcon;


public class Mountain extends Tile {
	
	public Mountain(Point p){
		super(p);
		img = new ImageIcon("mountain.png");
		setIcon(img);
		
	}
	
	

}
