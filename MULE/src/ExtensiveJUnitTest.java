import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *JUnit test cases for M10
 * @author Wei Jiang
 * @version 1.0
 *
 */
public class ExtensiveJUnitTest {

	//Buying property Test
	Player p = new Player("Meow1", "Cats", "Red");
	GameMain frame = new GameMain();
	Map m = new Map(false, frame);
	Random rand = new Random();
	Connection conn;
	Statement stat;
	ResultSet res;
	Pub pub = new Pub(frame,p,new JPanel());

	/**
	 * gamble test (different time)
	 */
	@Test
	public void pubTest(){
		int outcome = 0;
		int sum = 0;
		for (int i=0;i<1000;i++){
			outcome = pub.gambleGame(5,1);
			sum = sum +outcome;
		}
		int average = sum/1000;
		
		int outcome2 = 0;
		int sum2 = 0;
		for (int i=0;i<1000;i++){
			outcome2 = pub.gambleGame(45,1);
			sum2 = sum2 +outcome;
		}
		int average2 = sum2/1000;
		
		Assert.assertTrue(average2>average);
	}
	
	/**
	 * gamble test (different round)
	 */
	@Test
	public void pubTest2(){
		int outcome = 0;
		int sum = 0;
		for (int i=0;i<11000;i++){
			outcome = pub.gambleGame(5,1);
			sum = sum +outcome;
		}
		int average = sum/11000;
		
		int outcome2 = 0;
		int sum2 = 0;
		for (int i=0;i<11000;i++){
			outcome2 = pub.gambleGame(5,12);
			sum2 = sum2 +outcome;
		}
		int average2 = sum2/11000;
		
		Assert.assertTrue(average2>average);
	}
	
	/**
	 * Score test
	 */
	@Test
	public void TestPlayerScore(){
		p.setMoney(9999);
		Assert.assertTrue(p.getScore()==9999);
	}
	
	/**
	 * Assign property test
	 */
	@Test
	public void AssignPropertyTest1(){
		Plain pl = new Plain(new Point(1,1));
		p.assignProperty(pl);
		Assert.assertTrue(p.ownsTile(pl));
	}
	
	/**
	 * Player have enough money to buy a mule
	 */
	@Test
	public void BuyMuleTest1(){
		p.buyMule(0);
		Assert.assertTrue(p.ownsMule());
	}
	
	/**
	 * Player don't have enough money to buy a mule
	 */
	@Test
	public void BuyMuleTest2(){
		p.buyMule(99999);
		Assert.assertFalse(p.ownsMule());
	}
	
	/**
	 * Test is tile is owned after bought(true)
	 */
	@Test
	public void TileOwnTrueTest(){
		Plain pll = new Plain(new Point(1,2));
		pll.isBought(p);
		Assert.assertTrue(pll.isOwned());
	}
	
	/**
	 * Test is tile is owned after bought(False)
	 */
	@Test
	public void TileOwnFalseTest(){
		Plain pll2 = new Plain(new Point(1,3));
		Assert.assertFalse(pll2.isOwned());
	}
	
	/**
	 * Ensure the size of map is 9*5
	 */
	@Test
	public void MapSizeTest(){
		int c = m.getMapRep().length;
		int r = m.getMapRep()[1].length;
		Assert.assertTrue(c==5);
		Assert.assertTrue(r==9);
	}
}