import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * A class that represents a Tile on the map
 */
public abstract	class Tile extends JButton{
	
	protected ImageIcon img;
	protected Point location; 
	
	public Tile(Point location){
		this.location=location;
		
	}
	
	public Tile(){
	}
	
	public void actionPerformed(ActionEvent e){
		//some action
	}

}
