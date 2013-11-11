import java.awt.Point;

import javax.swing.ImageIcon;

/*
* This class represents the Land tile on the map
* @author Eileen Wang
* @Version 1.0, 10/20/13
*/

public class Land extends Tile {
	
	/*
	*The constructor for the Land Tile
	*@Point p - the location of the tile on the map
	*/
	public Land(Point p){
		super(p);
		img = new ImageIcon("grass.png.png");
		imgm = new ImageIcon("mountainm.png");
		setIcon(img);
		cost=120;
	}
	
	@Override 
	public void produce(int type, Player p){
		if(type==Item.FOOD)
			p.gainResources(1,0,0,0,0);
		else if(type==Item.ENERGY)
			p.gainResources(0,1,0,0,0);
		else if(type==Item.SMITHORE){
			p.gainResources(0, 0,1,0,0);
		}
		else if(type==Item.CRYSTITE){
			p.gainResources(0, 0, 0, 1, 0);
		}
	}

}
