import java.awt.Point;

import javax.swing.ImageIcon;


public class Mountain extends Tile {
	
	public Mountain(Point p, MapPanel panel){
		super(p, panel);
		img = new ImageIcon("mountain.png");
		setIcon(img);
		cost=70;
	}
	
	

}
