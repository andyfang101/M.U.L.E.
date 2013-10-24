import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MapPanel extends JPanel{
	private Map map=null;
	private GridLayout grid=null;
	private boolean random; //implement random maps later
	private JFrame frame;
	private JLabel curPlayerName;
	private JButton done;
	private static boolean isDone;
	private int curTurn;
	protected Player curPlayer;

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
		curPlayerName = new JLabel("Current Player: ");
		add(curPlayerName);
		done = new JButton("Done");
		add(done);
		done.addActionListener((ActionListener) new DListener(curPlayer));
		curTurn = 1;
		this.frame.setContentPane(this);
	}
	
	public static void setIsDone(boolean isDonex){
		isDone = isDonex;
	}
	
	public boolean getIsDone(){
		return isDone;
	}
	
	public void setCurPlayer(Player p){
		curPlayer = p;
		curPlayerName.setText("Current Player: " + p.getName());
	}
	
	public void nextTurn(){
		curTurn++;
	}
	
	public boolean gameOver(){
		if(curTurn<12)
			return false;
		return true;
	}
}

class DListener implements ActionListener{
	private Player curPlayer;
	public DListener (Player p){
		curPlayer=p;
	}
	public void actionPerformed(ActionEvent event) {
		curPlayer.setDone(true);
	}
}
