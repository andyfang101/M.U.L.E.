import java.awt.Point;

import javax.swing.ImageIcon;


public class River extends Tile {

	public River(Point location, MapPanel panel) {
		super(location, panel);
		img = new ImageIcon("river.png");
		setIcon(img);
		cost=100;
		// TODO Auto-generated constructor stub
	}

}
