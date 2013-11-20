import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  The town class that represents a tile ont he map that when clicked on user can go into town
 * @author Eileen Wang
 *@version 2.0
 */
public class TownTile extends Tile{
	
	private Town town;
	private GameMain frame;
	public TownTile(Point p,  GameMain frame) {
		super(p);
		this.frame = frame;
		img = new ImageIcon("town.png");
		setIcon(img);
		for( ActionListener al : getActionListeners() ) {
		        removeActionListener( al );
		  } //clearing the buyListener from this tile since it doesn't apply
		tileListener=new buttonListener();
		addActionListener(tileListener);
	}
	
	/*
	 * This is the button listener class for the town, allows user to enter town
	 */
	private class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!GameMain.getCurrPlayer().hasVisited()){
			town = new Town(frame);
			frame.setContentPane(town);
			GameMain.getCurrPlayer().setVisited(true);
			}
			else{
				JOptionPane.showMessageDialog(null,
					    "Sorry, you already went to town once :( No energy for another trip!");
			}
		}
	}
}
