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

	public Player(String name, String race, String color){
		int i = 0;
		
		this.name = name;
		this.race = race;
		
		if (color.equals("Red"))
 			this.color = Color.RED;
	 	else if (color.equals("Yellow"))
	 		this.color = Color.YELLOW;
	 	else if (color.equals("Green"))
	 		this.color = Color.GREEN;
	 	else if (color.equals("Blue"))
	 		this.color = Color.BLUE;
	 	
		
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
	* causes random events
	* @param isLast whether or not this player is currently in last
	* @param m is the value based on the round number
	* @return the message to be displayed
	*/
	public String startRandomEvent(boolean isLast, int m){
		int randomNum = (int)(Math.random()*100);
		int eventNum;
		String returnMessage = "NO EVENT!";
		if(randomNum <=27){
			if(isLast){
				//if the player in question is in last place, no bad things will happen
				eventNum = (int)(Math.random()*5);
				switch(eventNum){
					case 1: returnMessage = "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";
						food += 3;
						energy += 2;
						break;
					case 2: returnMessage = "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
						smithore +=2;
						break;
					case 3: returnMessage = "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m.";
						money += 8*m;
						break;
					case 4: returnMessage = "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m.";
						money += 2*m;
						break;
					case 5: returnMessage = "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m.";
						money += 4*m;
						break;
					default: returnMessage = "NO EVENT";
						System.out.println("randomevent error (switch broke)");
						break;
				}
			}else{
				//if the player isn't in last place, bad things can happen
				eventNum = (int)(Math.random()*7);
				switch(eventNum){
					case 1: returnMessage = "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";
						food += 3;
						energy += 2;
						break;
					case 2: returnMessage = "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
						smithore += 2;
						break;
					case 3: returnMessage = "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ 8*m.";
						money += 8*m;
						break;
					case 4: returnMessage = "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m.";
						money += 2*m;
						break;
					case 5: returnMessage = "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m.";
						money += 4*m;
						break;
					case 6: returnMessage = "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
						food = (int)(food/2);
						break;
					case 7: returnMessage = "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6*m TO CLEAN IT UP.";
						money -= 6*m;
						if(money < 0)
							money = 0;
						break;
					default: returnMessage = "NO EVENT";
						System.out.println("randomevent error (switch broke)");
						break;
				}
			}
		}
		return returnMessage;
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
	 * Setter for the player's money
	 */
	public void setMoney(int money){
		this.money = money;
	}
	
	/*
	 * Setter for the player's food
	 */
	public void setFood(int food){
		this.food = food;
	}
	
	/**
	 * setter for the player's energy
	 * 
	 */
	public void setEnergy(int energy){
		this.energy = energy;
	}
	
	/*
	 * Setter for the player's Smithore
	 */
	public void setSmithore(int smithore){
		this.smithore = smithore;
	}
	
	/*
	 * Setter for Crystite
	 */
	public void setCrystite(int crystite){
		this.crystite = crystite;
	}
	
	/*
	 * setter for the player's mules
	 */
	public void setMule(int mule){
		if(mule != 0)
			this.preMule = new Mule();
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
	 * Assigns a property to this player
	 * Only use for loading map from database
	 * @param tile which property to add
	 * @return a boolean indicating if the property was successfully assigned
	 */
	public boolean assignProperty(Tile tile){
		if(!tile.isOwned){
			propertyOwned.add(tile);
			tile.isBought(this);
			return true;
		}
		else
			return false;
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

	/*
	* Adds money earned from gambling to player money
	*/
	public void gamble(int gambleGame) {
		money+=gambleGame;
		
	}
	
	/**
	 * Allows player to sell this amount of resources
	 * @param foodNum - how much food
	 * @param energyNum - how much energy
	 * @param smithNum - how much smithore
	 * @param crysNum - how much crystite
	 * @param amt - how much money
	 */
	public void sell(int foodNumber,int energyNumber,int smithoreNumber, int crystiteNumber,int amount){
		food = food - foodNumber;
		energy = energy - energyNumber;
		smithore = smithore - smithoreNumber;
		crystite = crystite - crystiteNumber;
		money = money + amount;
	}
	
	/**
	 * Allows player to but this amount of resources
	 * @param foodNum - how much food
	 * @param energyNum - how much energy
	 * @param smithNum - how much smithore
	 * @param crysNum - how much crystite
	 * @param amt - how much money
	 */
	public void buy(int foodNumber,int energyNumber,int smithoreNumber, int crystiteNumber,int amount){
		food = food + foodNumber;
		energy = energy + energyNumber;
		smithore = smithore + smithoreNumber;
		crystite = crystite + crystiteNumber;
		money = money - amount;
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
	
	/*
	 * Allows player to gain these resources
	 * @param foodNum - how much food
	 * @param energyNum - how much energy
	 * @param smithNum - how much smithore
	 * @param crysNum - how much crystite
	 * @param amt - how much money
	 */
	public void gainResources(int foodNum, int energyNum, int smithNum, int crysNum, int amt){
		food+=foodNum;
		energy+=energyNum;
		smithore+=smithNum;
		crystite+=crysNum;
		money+=amt;
	}
	
	/**
	 * Checking whether or not a player owns a mule to be emplaced
	 * @return whether or not player owns a mule
	 */
	public boolean ownsMule(){
		if(preMule!=null)
			return true;
		else
			return false;
	}
	
	/**
	 * Placing a mule on a tile
	 * @param tile - the tile the mule is to be placed on
	 * @param type - the type of mule the player whats it to be
	 * @return - whether or not the player was successful
	 */
	public boolean emplaceMule(Tile tile, int type){
		if(preMule!=null){
			preMule.emplace(tile);
			preMule.setMuleType(type);
			if (type == 0){
				money = money -75;
			}
			if (type == 1){
				money = money -25;
			}
			if (type == 2){
				money = money -50;
			}
			if (type == 3){
				money = money -100;
			}
			mulesOwned.add(preMule);
			preMule=null;
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Player buys a mule
	 * @param amt how much the mule costs
	 * @return if purchase was successful
	 */
	public boolean buyMule(int amt){
		if(money>=amt){
			money-=amt;
			preMule=new Mule();
			preMule.setOwner(this);
		}
			return false;
		
	}
	
	/**
	 * setting the player as wanting to emplace a mule
	 * @param emplace - whether or not player wnats to emplace a mule
	 */
	public void setEmplace(boolean emplace){
	 this.emplace=emplace;
	}
	public boolean getWantEmplace(){
		return emplace;
	}
	
	public void lostMule(){
		preMule = null;
	}
	
	public void setMuleType(int price){
		money = money - price;
	}
	/**
	 * Getter for food
	 * @int - how much food player has
	 */
	
	public String getRace(){
		return race;
	}
	public int getFood(){
		return food;
	}
	
	/**
	 * getter for energy
	 * @int - energy amount
	 */
	public int getEnergy(){
		return energy;
	}
	
	/**
	 * Getter for smithore
	 * @return how much smithore
	 */
	public int getSmithore(){
		return smithore;
	}
	
	/**
	 * Getter for crystite
	 * @return how much crystite
	 */
	public int getCrystite(){
		return crystite;
	}
	
	/**
	 * Checking if the player owns that tile
	 * @param tile
	 * @return - wehther or not if that player owns that tile
	 */
	public boolean ownsTile(Tile tile){
		for(Tile t: propertyOwned){
			if(tile.equals(t)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Has all the mules produce that the player owns
	 */
	public void produceFromMules(){
		for(Mule m: mulesOwned){
			m.produce();
		}
	}
}
