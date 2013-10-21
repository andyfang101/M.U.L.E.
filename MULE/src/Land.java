import java.awt.Point;

import javax.swing.ImageIcon;

public class Land extends Tile {
	
	public Land(Point p){
		super(p);
		img = new ImageIcon("grass.png.png");
		setIcon(img);
		
	}

}
