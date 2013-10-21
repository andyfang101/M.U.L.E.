import java.awt.Point;

import javax.swing.ImageIcon;


public class Plain extends Tile {

	public Plain(Point location) {
		super(location);
		img = new ImageIcon("plain.png");
		setIcon(img);
		// TODO Auto-generated constructor stub
	}

}
