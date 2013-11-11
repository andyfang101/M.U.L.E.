import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

/*
 * A class that represents a Tile on the map
 */
public abstract	class Tile extends JButton{
	
	protected ImageIcon img;
	protected ImageIcon imgm; //img with mule
	protected Point location; 
	protected boolean isOwned;
	protected Player owner;
	protected int cost;
	protected MapPanel panel;
	protected ActionListener tileListener;
	
	public Tile(Point location){
		this.location=location;
		cost = 20;
		tileListener = new buyListener(this);
		imgm = new ImageIcon("mountainm.png");
		addActionListener(tileListener);
		isOwned=false;
		
	}
	
	/*
	 * Setting the tile to bought
	 * @param p - setting the player as owner
	 */
	public void isBought(Player p){
		owner = p;
		isOwned=true;
	}
	
	/*
	 * getter for whether or not tile is owned
	 * @boolean - whether or not tile is owned
	 */
	public boolean isOwned(){
		return isOwned;
	}
	
	/*
	 * checking if two tiles ar equal to each other
	 * @boolean - checking if the tile is the same as the one being checked with
	 */
	public boolean equals(Tile tile){
	 if(tile.getLocation().equals(location))
		 return true;
	 else
		 return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#getLocation()
	 */
	public Point getLocation(){
		return location;
	}
	
	/*
	 * Changing the Image of the tile to one where the mule is placed on it
	 */
	public void changeImageMule(){
		setIcon(imgm);
	}

	/*
	 * The Actionlistener that either places a mule on the tile or
	 * allows the player to buy the mule depending on what the
	 * player intends to do
	 */
 class buyListener implements ActionListener{
	 private Tile tile;
	 private Player p;
	 private String [] muleTypes = {"Smithore", "Energy", "Food", "Crystite"};
	 
	 public buyListener(Tile tile){
		 this.tile=tile;
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		p=GameMain.getCurrPlayer();
		if(p.getWantEmplace()){
			if(p.ownsTile(tile)){
			if(p.ownsMule()){  
				int action = JOptionPane.showOptionDialog(null, "What will you do?", "action",
				        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				        null, muleTypes, muleTypes[0]);
				p.emplaceMule(tile, action);
				tile.changeImageMule();
				
			}else{
				JOptionPane.showMessageDialog(null,
					    "Sorry...first you need a mule!");
			}
			}
			else{
				p.lostMule();
				JOptionPane.showMessageDialog(null,
					    "You don't own this tile.. Can't put a mule on it, so you lost you mule");
			}

			p.setEmplace(false);
		}
		else{
		if(!isOwned){ //note to fix
			int askBuy=0;
			if(GameMain.getCurrTurns()<=2){
				askBuy = JOptionPane.showConfirmDialog(null,"Would you like to buy this property?", "Buy this time?", JOptionPane.YES_NO_OPTION);
			}
			else{
				askBuy= JOptionPane.showConfirmDialog(null,"Would you like to buy this property? It costs " + cost , "Buy this time?", JOptionPane.YES_NO_OPTION);
			}
			if(askBuy==JOptionPane.YES_OPTION){
					if(GameMain.getCurrTurns()<=2){
						if(p.buyProperty(0, tile)){
							JOptionPane.showMessageDialog(null,
								    "Congratulations! You got it!");
							tile.setBackground(p.getColor());
							isBought(p);
						}
					
					else{
						if(p.buyProperty(cost, tile)){
							JOptionPane.showMessageDialog(null,
								    "Congratulations! You got it!");
							tile.setBackground(p.getColor());
							isBought(p);
						}
					}
				}
				else 
				{
					if(p.buyProperty(cost, tile)){
						JOptionPane.showMessageDialog(null,
							    "Congratulations! You got it!");
						tile.setBackground(p.getColor());
						isBought(p);
					}
					else
						JOptionPane.showMessageDialog(null,
						    "You're too poor for this land.");
				}
				
			}
		}
		else{
			JOptionPane.showMessageDialog(null,
				    "This tile is already owned by or you are too poor to buy it. Better luck next time");
		}
		
	}
	}
	 
 }

public void produce(int type, Player p) {
	
}

}
