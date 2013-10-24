import java.awt.Point;

import javax.swing.ImageIcon;


public class Plain extends Tile {

	public Plain(Point location, MapPanel panel) {
		super(location, panel);
		img = new ImageIcon("plain.png");
		setIcon(img);
		cost=40;
		// TODO Auto-generated constructor stub
	}

}
