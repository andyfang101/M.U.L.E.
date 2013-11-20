import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for sell method
 * @author Wei Jiang
 *
 */
public class SellTest {
	int FoodPrice = 20;
	int EnergyPrice = 15;
	int SmithorePrice = 30;
	int CrystitePrice = 50;
	Player p = new Player("Batman","Human","Blue");
	
	/**
	 * True test (Food)
	 */
	@Test
	public void Selltest1() {
		int fd = 1;
		int eg = 0;
		int so = 0;
		int co = 0;
		int originalFood = p.getFood();
 	   if (fd > p.getFood() || eg > p.getEnergy() || so > p.getSmithore() || co > p.getCrystite()){
		   JOptionPane.showMessageDialog(null,
				    "YOU DO NOT HAVE ENOUGH AMOUNT OF RESOURCES");
	   }
	   else{
		   int amount = fd*FoodPrice + eg*EnergyPrice+ so*SmithorePrice+co*CrystitePrice;
		   p.sell(fd, eg, so, co, amount);
	   }
 	   int expectedFood = originalFood-fd;
 	  Assert.assertEquals(p.getFood(),expectedFood);
	}

	/**
	 * False test (Food)
	 */
	@Test
	public void Selltest2() {
		int fd = 99;
		int eg = 0;
		int so = 0;
		int co = 0;
		int originalFood = p.getFood();
 	   if (fd > p.getFood() || eg > p.getEnergy() || so > p.getSmithore() || co > p.getCrystite()){

	   }
	   else{
		   int amount = fd*FoodPrice + eg*EnergyPrice+ so*SmithorePrice+co*CrystitePrice;
		   p.sell(fd, eg, so, co, amount);
	   }
 	   int unexpectedFood = originalFood-fd;
 	  Assert.assertFalse((p.getFood())==unexpectedFood);
	}
	
	
	/**
	 * True test (Energy)
	 */
	@Test
	public void Selltest3() {
		int fd = 0;
		int eg = 1;
		int so = 0;
		int co = 0;
		int originalEnergy = p.getEnergy();
 	   if (fd > p.getFood() || eg > p.getEnergy() || so > p.getSmithore() || co > p.getCrystite()){
		   JOptionPane.showMessageDialog(null,
				    "YOU DO NOT HAVE ENOUGH AMOUNT OF RESOURCES");
	   }
	   else{
		   int amount = fd*FoodPrice + eg*EnergyPrice+ so*SmithorePrice+co*CrystitePrice;
		   p.sell(fd, eg, so, co, amount);
	   }
 	   int expectedEnergy = originalEnergy-eg;
 	  Assert.assertEquals(p.getEnergy(),expectedEnergy);
	}

	/**
	 * False test (Energy)
	 */
	@Test
	public void Selltest4() {
		int fd = 0;
		int eg = 9;
		int so = 0;
		int co = 0;
		int originalEnergy = p.getEnergy();
 	   if (fd > p.getFood() || eg > p.getEnergy() || so > p.getSmithore() || co > p.getCrystite()){

	   }
	   else{
		   int amount = fd*FoodPrice + eg*EnergyPrice+ so*SmithorePrice+co*CrystitePrice;
		   p.sell(fd, eg, so, co, amount);
	   }
 	   int unexpectedEnergy = originalEnergy-eg;
 	  Assert.assertFalse((p.getFood())==unexpectedEnergy);
	}
}
