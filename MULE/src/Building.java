import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * This is a building class that represents all the different buildings in the town
 * Like: Assay Office, Pub, and is a JPanel
 * @author Eileen Wang
 * @Version 1.0 10/22/13
 * 
 */
public abstract class Building extends JPanel {
	
	protected static final int WIDTH = 1220;
	protected static final int HEIGHT = 650;
	protected JFrame frame;
	protected JPanel oldpanel;//The panel that holds old panel
	protected Player p;
	
	/**
	* Handles different building in town
	* @param frame Window frame
	* @param p Player instance
	* @param oldpanel Panel that holds old panel
	*/
	public Building(JFrame frame, Player p, JPanel oldPanel){
		this.p = p;
		this.frame=frame;
		this.oldpanel = oldPanel;
		setVisible(true);
		setSize(WIDTH, HEIGHT);
	}
		

}
