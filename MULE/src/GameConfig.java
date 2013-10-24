/*
* This is main configuration class for the M.U.L.E class. It holds various Game settings, including 
* difficulty, setting the map size, and player number.
* @author Wei Jiang
* Version 1.0 10/7/2013
* 
*/

public class GameConfig{
	private int difficulty;
	private int mapSize;
	private int numPlayers;
	
	/*
	* This is the constructor that instantiates the Game with a certain difficulty and sets a map.
	* @difficulty - The difficulty of the game, ranging from 0, 1, 2. 
	* @mapSize - The larger the mapSize value, the larger the map
	* @numPlayers - The number of plays in the game 
	*/

	public GameConfig(int difficulty, int mapSize, int numPlayers){//Difficulty: 0=beginner, 1=intermediate, 2=expert -- (premade)Map: 0=Small, 1=medium, 2=large
		//sets difficulty
		if(difficulty>2 | difficulty<0){
			this.difficulty=0;//if invalid, automatically sets difficulty to beginner
			System.out.println("Invalid difficulty value, defaulted to beginner.");
		}else{
			this.difficulty = difficulty;
		}

		//sets map
		if(mapSize>2 | mapSize<0){
			this.mapSize=0;//if invalid, automatically sets map to the small map
			System.out.println("Invalid map value, defaulted to small map.");
		}else{
			this.mapSize = mapSize;
		}

		if(numPlayers>2 | numPlayers<0){
			this.numPlayers=0;//player number values fall between 0 and 4 inclusive. otherwise, defaults to 1 (color 0)
			System.out.println("Invalid number value, defaulted to 1 player.");
		}else{
			this.numPlayers = numPlayers;
		}
	}
	
	public int getNumPlayers(){
		return numPlayers;
	}
}
