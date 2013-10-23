import java.awt.Point;

import javax.swing.ImageIcon;
/*
* This class represents the river tile on the map
* @author Eileen Wang
* @Version 1.0, 10/20/13
*/

public class River extends Tile {
	
	/*
	*The constructor for the river Tile
	*@Point p - the location of the tile on the map
	*/
	public River(Point location) {
		super(location);
		img = new ImageIcon("river.png");
		setIcon(img);
		// TODO Auto-generated constructor stub
	}

}
