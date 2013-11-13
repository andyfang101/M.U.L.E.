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
		imgm = new ImageIcon("riverm.png");
		setIcon(img);
		cost=500;
		// TODO Auto-generated constructor stub
	}
	
	public void produce(int type, Player p){
		if(type!=Item.SMITHORE && type!=Item.CRYSTITE){
		if(type==Item.FOOD){
			p.gainResources(4,0,0,0,0);

		}
		else if(type==Item.ENERGY){
			p.gainResources(0,2,0,0,0);

		}
		}
	}

}
