import java.awt.Point;
import javax.swing.ImageIcon;


public class TownTile extends Tile{

	public TownTile(Point p) {
		super(p);
		img = new ImageIcon("town.png");
		setIcon(img);
		// TODO Auto-generated constructor stub
	}

}
