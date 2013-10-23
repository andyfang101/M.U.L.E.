import java.awt.Point;
import javax.swing.ImageIcon;

/*
* This class represents the Mountain tile on the map
* @author Eileen Wang
* @Version 1.0, 10/20/13
*/

public class Mountain extends Tile {
	
	/*
	*The constructor for the Mountain Tile
	*@Point p - the location of the tile on the map
	*/
	public Mountain(Point p){
		super(p);
		img = new ImageIcon("mountain.png");
		setIcon(img);
		
	}
	
	

}
