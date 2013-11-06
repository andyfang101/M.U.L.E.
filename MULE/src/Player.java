import java.awt.Color;
import java.util.ArrayList;

/*
* This is a player class that holds the player information, such as race, color, money amount, and name.
* @author Andy Fang
* Version 1.0 10/7/2013
*/
public class Player{
	private String name;
	private String race;
	private Color color;
	private int money,food,energy,smithore,crystite,score;
	private boolean done;
	private ArrayList<Tile> propertyOwned;
	private boolean hasVisitedTown;
	private ArrayList<Mule> mulesOwned; //mules on property
	private Mule preMule; //Mule that still has not be used
	private boolean emplace;
	
	/*
	* This is the constructor that instantiates the Player
	*@name - the name of the player
	*@race - the race of the player
	*@color - the color repesenting that player
	*/

	public Player(String name, String race, Color color){
		int i = 0;
		
		this.name = name;
		this.race = race;
		this.color = color;
		done=false;
		hasVisitedTown=false;
		mulesOwned = new ArrayList<Mule>();
		propertyOwned = new ArrayList<Tile>();
		
		if (race == "Flapper"){
			money = 1600;
		}
		else if (race == "Human"){
			money = 600;
		}
		else
			money = 1000;
		
		food = 8;
		energy = 4;
		smithore = 0;
		crystite = 0;
	}
	
	/*
	* Getter for player name
	* @return Player name
	*/
	public String getName(){
		return name;
	}
	/*
	 * This method is to calculate player's time of turn based on resource
	 */
	public int getTurnTime(int round){
		int time = 50;
		int foodRequire = (int)(Math.floor((round-1)/4) +3);
		if (food == 0){
			time = 5;
		}
		else if (food < foodRequire){
			time = 30;
		}
		return time;
	}
	
	/*
	* Getter for player score
	* @return Player score
	*/
	public int getScore(){
		score = money;
		return score;
	}
	
	/*
	* Setter for player score
	*/
	public void setScore(int score){
		this.score = score;
	}
	
	/*
	* Setter for whether player's turn is done
	*/
	public void setDone(boolean done){
		this.done = done;
	}
	
	/*
	* Getter for player color
	* @return Player color
	*/
	public Color getColor(){
		return color;
	}
	
	/*
	* Getter for whether player's turn is done
	*/
	public boolean isDone(){
		return done;
	}
	
	/*
	* Handles the buying of property by each plater
	* @param cost Cost of property
	* @param tile Type of property
	* @return A boolean value indicating whether property purchase was successful
	*/
	public boolean buyProperty(int cost, Tile tile){
		if(cost<=money && tile.isOwned()==false){
			money-=cost;
			propertyOwned.add(tile);
			tile.isBought(this);
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/*
	* toString() method to return player name, race, and color
	* @return Player name
	* @return Player race
	* @return Player color
	*/
	public String toString(){
		return "Player name: " + name  + " Player race: " + race + " Player color: " + color.toString();
	}
	
	/*
	* Getter for player money
	* @return Player money
	*/
	public int getMoney(){
		return money;
	}

	public int getFood(){
		return food;
	}
	
	public int getEnergy(){
		return energy;
	}
	
	public int getSmithore(){
		return smithore;
	}
	
	public int getCrystite(){
		return crystite;
	}
	/*
	* Adds money earned from gambling to player money
	*/
	public void gamble(int gambleGame) {
		money+=gambleGame;
		
	}
	
	public void sell(int foodNumber,int energyNumber,int smithoreNumber, int crystiteNumber,int amount){
		food = food - foodNumber;
		energy = energy - energyNumber;
		smithore = smithore - smithoreNumber;
		crystite = crystite - crystiteNumber;
		money = money + amount;
		System.out.println("Food"+food);
	}
	/*
	* Whether player has visited town
	* @return Boolean indicating whether player has visited town
	*/ 
	public boolean hasVisited(){
		return hasVisitedTown;
	}
	
	/*
	* Setter for whether player has visited town
	*/
	public void setVisited(boolean visit){
		hasVisitedTown=visit;
	}
	
	public void gainResources(int foodNum, int energyNum, int smithNum, int crysNum, int amt){
		food+=foodNum;
		energy+=energyNum;
		smithore+=smithNum;
		crystite+=crysNum;
		money+=amt;
	}
	
	public boolean emplaceMule(Tile tile){
		if(preMule!=null){
			preMule.emplace(tile);
			mulesOwned.add(preMule);
			preMule=null;
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean buyMule(int amt){
		if(money>=amt){
			money-=amt;
			preMule=new Mule();
		}
			return false;
		
	}
	
	public void setEmplace(boolean emplace){
	 this.emplace=emplace;
	}
	public boolean getWantEmplace(){
		return emplace;
	}
}
