import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MapPanel extends JPanel{
	private Map map=null;
	private GridLayout grid=null;
	private boolean random= false; //implement random maps later
	
	public MapPanel(){
		map = new Map(random);
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
	}

}
