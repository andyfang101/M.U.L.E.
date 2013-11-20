import java.awt.Point;
import java.util.Random;

import javax.swing.*;

/*
 * This class is that represents the Map of the game, and it has 
 * both a default layout and also randomized map.
 * 
 */
public class Map {

	public final static int NUM_ROW=5; //number of rows on map
	public final static int NUM_COL=9; //number of columns
	private static Tile[][] map = null;
	private boolean random = false;
	private GameMain frame;
	static char [][] mapRep = null;
	public Town town;

	public Map(boolean random, GameMain frame){
		this.random=random;
		this.frame=frame;
		this.map = createMap();
	}
	
	//this constructor is used for loading a map
	public Map(char[][] mapRep, GameMain frame){
		this.frame = frame;
		this.mapRep = mapRep;
		this.map = createMap();
	}

	/*
	 * This method generates a character map, may be random or not random depending on what was specified.
	 * @return char[][] - a character representation of the map type
	 */
	private char[][] genCharMap(){
		Random rand = new Random();
		final char m= 'm'; //mountain
		final char p= 'p'; //plain
		final char t = 't'; //town
		final char g = 'g'; //grass
		final char rv = 'r'; //river

		if(random){ //creates random map with random town location
			char [][] mapRep= new char [NUM_ROW][NUM_COL];
			int townRow = rand.nextInt(NUM_ROW);
			int townCol = rand.nextInt(NUM_COL);
			

			for(int r=0; r<mapRep.length; r++){
				for(int c=0; c<mapRep[r].length; c++){
						int tileType = rand.nextInt(4);
						switch(tileType){
						case 0: mapRep[r][c] = m;
						break;
						case 1: mapRep[r][c] = g;
						break;
						case 2: mapRep[r][c] = p;
						break;
						case 3: mapRep[r][c] = rv;
						break;
						default: mapRep[r][c]=g;
						}
						mapRep[townRow][townCol] = t;

				}
			}
			return mapRep;
		}

		else{ // the default map, with the town in the center
			char[][] mpRep={{g,g,g,m,m,p,rv,p,g},{g,g,g,g,m,m,m,m,g},{g,g,p,p,t,rv,rv,rv,g},{g,g,g,g,g,p,p,g,g},{rv,rv,rv,rv,p,p,g,g,g}};
			return mpRep;
		}
	}
	
	/*
	*This method takes the character representation of the map andc creates the JButtons associated with the tile.
	*@return JButton[][] - the 2d aray of JButtons of the map
	*/
	private Tile[][] createMap(){
		if(mapRep == null)
			mapRep=genCharMap();
		map = new Tile[NUM_ROW][NUM_COL];
		for(int r=0; r<mapRep.length; r++){
			for(int c=0; c<mapRep[r].length; c++){
				switch(mapRep[r][c]){
				case 'm': map[r][c] = new Mountain(new Point(r,c));
				break;
				case 'g': map[r][c] = new Land(new Point(r,c));
				break;
				case 'p': map[r][c] = new Plain(new Point(r,c));
				break;
				case 'r': map[r][c] = new River(new Point(r,c));
				break;
				case 't': map[r][c] = new TownTile(new Point(r,c),frame);
				break;
				default: map[r][c]= new Land(new Point(r,c));
				}
			}
		}
		
		return map;
	}
	
	/*
	*A getter for the map of JButtons
	*@return - Jbutton [][] - the 2-d array of JButtons of the map
	*/
	public char[][] getMapRep(){
		return mapRep;
	}
	
	public Tile[][] getMap(){
		return this.map;
	}
	

}
