import java.awt.Point;

import javax.swing.ImageIcon;


public class River extends Tile {

	public River(Point location) {
		super(location);
		img = new ImageIcon("river.png");
		setIcon(img);
		cost=100;
		// TODO Auto-generated constructor stub
	}

}
