/**
 * This is the Mule class that represents the Mule, which 
 * lets the player produce resources.
 * @author Eileen Wang
 * @Version 1.0 
 */
import javax.swing.*;
public class Mule extends Item{
	
	protected ImageIcon image;
	protected int type;
	protected Tile tileType;
	protected Player owner;
	
	public Mule(){
		type=Item.FOOD;
		
	}
	

	/**
	 * This produces resources based on the tile the Mule is located at.
	 */
	public void produce(){
		tileType.produce(type, owner);
	}
	
	/**
	 * This method sets the mule type when the player uses the mule. 
	 * @param type - the type of mule the user wants it to be
	 */
	public void setMuleType(int type){
		this.type=type;
		System.out.print(type);
	}
	
	/**
	 * Adding the value of the price of the mule
	 * @param value, how much more the price goes up of mule
	 */
	public void addValue(int value){
		if(value>=0){
			this.value+=value;
		}
	}
	
	/**
	 * Specifies the tile the mule is at
	 * @tile - the tile the mule is on
	 */
	public void emplace(Tile tile){
		tileType=tile;
	}
	
	/**
	 * Sets the owner of the mule
	 * @param p - the player who owns the mule
	 */
	public void setOwner(Player p){
		owner=p;
	}

}
