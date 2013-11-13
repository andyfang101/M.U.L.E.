import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
		// TODO Auto-generated constructor stub
	}
	
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
