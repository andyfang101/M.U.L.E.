import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

/**
 *JUnit test cases for M10
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
	
	/**
	 * Buys Random property from the map and assures that the Player is the owner
	 */
	@Test
	public void boughtProp1 () {
		int row = rand.nextInt(Map.NUM_ROW);
		int col = rand.nextInt(Map.NUM_COL);
		Tile t= m.getMap()[row][col];
		p.buyProperty(t.getCost(), t);
		Assert.assertTrue(p.ownsTile(t));
	}
	
	@Test
	public void boughtProp2(){
		int row = rand.nextInt(Map.NUM_ROW);
		int col = rand.nextInt(Map.NUM_COL);
		Tile t= m.getMap()[row][col];
		p.buyProperty(t.getCost(), t);
		Assert.assertTrue(p.ownsTile(t));
	}
	
	@Test
	public void boughtProp3(){
		int row = rand.nextInt(Map.NUM_ROW);
		int col = rand.nextInt(Map.NUM_COL);
		Tile t= m.getMap()[row][col];
		p.buyProperty(t.getCost(), t);
		Assert.assertEquals(p,t.getOwner());
	}
	
	/**
	 * Tests a situation where the player won't have enough money to buy Property
	 */
	@Test
	public void notEnoughMoney1(){
		p.buy(0,0,0,0,p.getMoney()); //sets player money to zero
		int row = rand.nextInt(Map.NUM_ROW);
		int col = rand.nextInt(Map.NUM_COL);
		Tile t= m.getMap()[row][col];
		p.buyProperty(t.getCost(), t);
		Assert.assertFalse(p.buyProperty(t.getCost(), t));
	}
	
	public void notEnoughMoney2(){
		p.buy(0,0,0,0,p.getMoney()); //sets player money to zero
		int row = rand.nextInt(Map.NUM_ROW);
		int col = rand.nextInt(Map.NUM_COL);
		Tile t= m.getMap()[row][col];
		p.buyProperty(t.getCost(), t);
		Assert.assertFalse(p.buyProperty(t.getCost(), t));
	}
	

}
