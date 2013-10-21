import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class TownTile extends Tile{
	
	private Town town;
	private JFrame frame;
	public TownTile(Point p, JFrame frame) {
		super(p);
		this.frame = frame;
		img = new ImageIcon("town.png");
		setIcon(img);
		// TODO Auto-generated constructor stub
	}
	
	public void actionListener(ActionEvent e){
		town = new Town(frame);
		frame.setContentPane(town);
		System.out.println("TEST"); //TESTING PURPOUSES DELETE
	}
}
