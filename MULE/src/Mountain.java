import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

/*
 * This class represents the Mountain tile on the map
 * @author Eileen Wang
 * @Version 1.0, 10/20/13
 */

public class Mountain extends Tile {

	private int mntType; //gives differing amt of Ore for mule

	/*
	 *The constructor for the Mountain Tile
	 *@Point p - the location of the tile on the map
	 */
	public Mountain(Point p){
		super(p);
		Random rand = new Random();
		img = new ImageIcon("mountain.png");
		imgm = new ImageIcon("mountainm.png");
		setIcon(img);
		cost=200;
		mntType=rand.nextInt(2);
	}

	@Override 
	public void produce(int type, Player p){
		if(type==Item.FOOD)
			p.gainResources(1,0,0,0,0);
		else if(type==Item.ENERGY)
			p.gainResources(0,1,0,0,0);
		else if(type==Item.SMITHORE){
			int ore=0;
			switch(mntType){
			case 0: ore=2;
			break;
			case 1: ore= 3;
			break;
			case 2: ore=4;
			break;
			default:ore=2;
			break;
			}
			p.gainResources(0, 0,ore,0,0);
		}
		else if(type==Item.CRYSTITE){
			int crystite= (GameMain.getCurrTurns()/ 3) +1;
			p.gainResources(0, 0, 0, crystite, 0);
		}
	}



}
