import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.ArrayList;
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
	
	
	//Tests for genCharMap in Map class
	/**
	 * creates a new, map with default layout and checks validity
	 * @author kushal
	 */
	@Test
	public void genDefaultCharMap(){
		char[][] mpRep={{'g','g','g','m','m','p','r','p','g'},{'g','g','g','g','m','m','m','m','g'},{'g','g','p','p','t','r','r','r','g'},{'g','g','g','g','g','p','p','g','g'},{'r','r','r','r','p','p','g','g','g'}};
		Map map = new Map(false, frame);
		char[][] mapRep = map.getMapRep();
		boolean hasTown = false, hasOneTown = false, mapsMatch = false;
		if(mapRep.length == mpRep.length && mapRep[0].length == mpRep[0].length){
			mapsMatch = true;
			for(int i = 0; i < mapRep.length; i++){
				for(int j = 0; j < mapRep[i].length; j++){
					if(mapRep[i][j] != mpRep[i][j])
						mapsMatch = false;
					if(mapRep[i][j] == 't' && hasTown == false){
						hasOneTown = true;
						hasTown = true;
					}
					else if(mapRep[i][j] == 't' && hasTown == true)
						hasOneTown = false;
					
				}
			}
		}
		Assert.assertTrue(hasOneTown && mapsMatch);
	}
	
	/**
	 * creates a new, map with random layout and checks validity
	 * @author kushal
	 */
	@Test
	public void genRandomCharMap(){
		
		ArrayList<Character> mapRepTypes = new ArrayList<Character>();
		mapRepTypes.add('m');
		mapRepTypes.add('g');
		mapRepTypes.add('t');
		mapRepTypes.add('r');
		mapRepTypes.add('p');
			
		Map map = new Map(true, frame);
		char[][] mapRep = map.getMapRep();
		boolean hasTown = false, hasOneTown = false, mapsMatch = false;
		if(mapRep.length == map.NUM_ROW && mapRep[0].length == Map.NUM_COL){
			mapsMatch = true;
			for(int i = 0; i < mapRep.length; i++){
				for(int j = 0; j < mapRep[i].length; j++){
					if(!mapRepTypes.contains(mapRep[i][j]))
						mapsMatch = false;
					if(mapRep[i][j] == 't' && hasTown == false){
						hasOneTown = true;
						hasTown = true;
					}
					else if(mapRep[i][j] == 't' && hasTown == true)
						hasOneTown = false;
					
				}
			}
		}
		Assert.assertTrue(hasOneTown && mapsMatch);
	}
}
