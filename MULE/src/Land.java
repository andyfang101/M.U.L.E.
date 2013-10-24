import java.awt.Point;

import javax.swing.ImageIcon;

public class Land extends Tile {
	
	public Land(Point p, MapPanel panel){
		super(p, panel);
		img = new ImageIcon("grass.png.png");
		setIcon(img);
		cost=30;
	}

}
