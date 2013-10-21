/*
* This is a player class that holds the player information, such as race, color, money amount, and name.
* @author Andy Fang
* Version 1.0 10/7/2013
*/
public class Player{
	private String name;
	private String race;
	private String color;
	private int money;
	
	
	/*
	* This is the constructor that instantiates the Player
	*@name - the name of the player
	*@race - the race of the player
	*@color - the color repesenting that player
	*/

	public Player(String name, String race, String color){
		int i = 0;
		int money=0;
		this.name = name;
		this.race = race;
		this.color = color;
	}
	
	public String getName(){
		return name;
	}
}
