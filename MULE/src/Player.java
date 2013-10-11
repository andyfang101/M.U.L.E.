/*
* This is a player class that holds the player information, such as race, color, money amount, and name.
* @author Andy Fang
* Version 1.0 10/7/2013
*/
public class Player{
	private String name;
	private int race;
	private int color;
	private int money;
	
	
	/*
	* This is the constructor that instantiates the Player
	*@name - the name of the player
	*@race - the race of the player
	*@color - the color repesenting that player
	*/

	public Player(String name, int race, int color){
		int i = 0;
		int money=0;
		this.name = name;

		if(race<0 | race>4){//races' values fall between 0 and 4 inclusive. otherwise, defaults to race 0 (human?)
			this.race = 0;
			System.out.println("Invalid race, defaulted to human.");
		}else{
			this.race = race;
		}

		if(color<0 | color>9){//color values fall between 0 and 9 inclusive. otherwise, defaults to blue (color 0)
			this.color = 0;
			System.out.println("Invalid color, defaulted to blue.");
		}else{
			this.color = color;
		}
	}
}
