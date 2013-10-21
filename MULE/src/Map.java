import java.awt.Point;
import java.util.Random;

import javax.swing.*;

/*
 * This class is that represents the Map of the game, and it has 
 * both a default layout and also randomized map.
 * 
 */
public class Map {

	private int numRow=5; //number of rows on map
	private int numCol=9; //number of columns
	private JButton map [][] = null;
	private Tile mapTiles[][]=null;
	private boolean random = false;

	public Map(boolean random){
		map = new JButton[numRow][numCol];
		this.random=random;
		mapTiles = new Tile[numRow][numCol];
	}

	/*
	 * This method generates a character map, may be random or not random depending on what was specified.
	 * @return char[][] - a character representation of the map type
	 */
	public char[][] genCharMap(){
		Random rand = new Random();
		final char m= 'm'; //mountain
		final char p= 'p'; //plain
		final char t = 't'; //town
		final char g = 'g'; //grass
		final char rv = 'r'; //river

		if(random){ //creates random map with random town location
			char [][] mapRep= new char [numRow][numCol];
			int townRow = rand.nextInt(numRow);
			int townCol = rand.nextInt(numCol);
			mapRep[townRow][townCol] = t;
			for(int r=0; r<mapRep.length; r++){
				for(int c=0; c<mapRep[r].length; c++){
					if(r!=townRow && c!=townCol){
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
					}
				}
			}
			return mapRep;
		}

		else{ // the default map, with the town in the center
			char[][] mpRep={{g,g,g,m,m,p,rv,p,g},{g,g,g,g,m,m,m,m,g},{g,g,p,p,t,rv,rv,rv,g},{g,g,g,g,g,p,p,g,g},{rv,rv,rv,rv,p,p,g,g,g}};
			return mpRep;
		}
	}
	
	public void createMap(char [][] mapRep){
		for(int r=0; r<mapRep.length; r++){
			for(int c=0; c<mapRep[r].length; c++){
				switch(mapRep[r][c]){
				case 'm': mapTiles[r][c] = new Mountain(new Point(r,c));
				break;
				case 'g': mapTiles[r][c] = new Land(new Point(r,c));
				break;
				case 'p': mapTiles[r][c] = new Plain(new Point(r,c));
				break;
				case 'r': mapTiles[r][c] = new Mountain(new Point(r,c));
				break;
				case 't': mapTiles[r]
				default: mapRep[r][c]= new Land(new Point(r,c));
				}
			}
		}
	}



}
