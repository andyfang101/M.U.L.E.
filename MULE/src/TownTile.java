import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
* This class represents the town tile on the map
* @author Eileen Wang
* @Version 1.0, 10/20/13
*/

public class TownTile extends Tile{
	
	private Town town;
	private JFrame frame;
	
	
	/*
	*The constructor for the town Tile
	*@Point p - the location of the tile on the map
	*@frame - the frame this tile will be located in 
	*/
	
	public TownTile(Point p, JFrame frame) {
		super(p);
		this.frame = frame;
		img = new ImageIcon("town.png");
		setIcon(img);
		this.addActionListener(new buttonListener());
		// TODO Auto-generated constructor stub
	}
	
	/*
	* Button listener for the town button when pressed in map
	* 
	*/
	private class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			town = new Town(frame); //opens up town panel
			frame.setContentPane(town);
		}
	}
}
