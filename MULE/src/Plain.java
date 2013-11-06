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
		imgm = new ImageIcon("plainm.png");
		setIcon(img);
		cost=160;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void produce(int type, Player p){
		if(type==Item.FOOD)
			p.gainResources(2,0,0,0,0);
		else if(type==Item.ENERGY)
			p.gainResources(0,3,0,0,0);
		else if(type==Item.SMITHORE){
			p.gainResources(0, 0, 1,0,0);
		}
		else if(type==Item.CRYSTITE){
			int crystite= (GameMain.getCurrTurns()/ 3) +2;
			p.gainResources(0, 0, 0, crystite, 0);
		}
	}

}
