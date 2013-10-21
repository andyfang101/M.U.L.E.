import java.awt.Point;

import javax.swing.ImageIcon;

/*
 * A class that represents a Tile on the map
 */
public abstract	 class Tile {
	
	protected ImageIcon img;
	protected Point location; 
	
	public Tile(Point location){
		this.location=location;
		
	}
	
	public Tile(){
	}
	
	public ImageIcon getImage(){
		return img;
	}

}
