import java.awt.Point;
import javax.swing.ImageIcon;

/*
* This class represents the Plain tile on the map
* @author Eileen Wang
* @Version 1.0, 10/20/13
*/

public class Plain extends Tile {
	
	/*
	*The constructor for the plain Tile
	*@Point p - the location of the tile on the map
	*/
	public Plain(Point location) {
		super(location);
		img = new ImageIcon("plain.png");
		setIcon(img);
		cost=40;
		// TODO Auto-generated constructor stub
	}

}
