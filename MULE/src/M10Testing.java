import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 *
 * @author Eileen Wang
 * @version 1.0
 *
 */
public class M10Testing {

	//Buying property Test
	Player p = new Player("Meow", "Cats", "Red");
	GameMain frame = new GameMain();
	Map m = new Map(false, frame);
	Random rand = new Random();
	
	@Test
	public void buyProperty () {
		int row = rand.nextInt(Map.NUM_ROW);
		int col = rand.nextInt(Map.NUM_COL);
		Tile t= m.getMap()[row][col];
		p.buyProperty(, tile);
	}

}
