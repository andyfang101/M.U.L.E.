import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
*@author Eileen Wang
*@Version 1.0 10/23/13
*This class is a panel used to hold the map that the players interact with.
*/

public class MapPanel extends JPanel{
	private Map map=null;
	private GridLayout grid=null;
	private boolean random; //implement random maps later
	private JFrame frame;
	
	/*
	*@random - if the map is to be randomly generated 
	*@frame -the frame the panel is in
	*The constructor for the map panel
	*/
	public MapPanel(boolean random, JFrame frame){
		this.frame=frame;
		this.random = random;
		setVisible(true);
		map = new Map(random, frame);
		grid = new GridLayout(Map.NUM_ROW, Map.NUM_COL);
		setLayout(grid);
		JButton[][] buttons = map.getMap();
		
		for(int r=0; r<buttons.length; r++){
            if(buttons[r]!=null){
           for(int c=0; c<buttons[r].length; c++){
               if(buttons[r][c]!=null){
            	   System.out.println(buttons[r][c].toString());
                   add(buttons[r][c]);
               }
           }
       }
            
	}
	this.frame.setContentPane(this);
}
}
