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
	private JLabel currTurnLabel;
	private JButton done;
	private static boolean isDone;
	private int currTurn;
	protected Player curPlayer;

	public MapPanel(boolean random, JFrame frame){
		this.frame=frame;
		this.random = random;
		setVisible(true);
		map = new Map(random, frame, this);
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
		currTurnLabel = new JLabel("Current Turn: " + currTurn);
		add(curPlayerName);
		add(currTurnLabel);
		done = new JButton("Done");
		add(done);
		done.addActionListener((ActionListener) new DListener(curPlayer,this));
		currTurn = 1;
		this.frame.setContentPane(this);
	}
	
	public static void setIsDone(boolean isDonex){
		isDone = isDonex;
	}
	
	public boolean getIsDone(){
		return isDone;
	}
	
	public void setCurPlayer(Player p){
		System.out.println("I am settings!!!");
		curPlayer = p;
		curPlayerName.setText("Current Player: " + p.getName());
	}
	
	public Player getCurrPlayer(){
		return curPlayer;
	}
	
	public void nextTurn(){
		currTurn++;
	}
	
	public boolean gameOver(){
		if(currTurn<12)
			return false;
		return true;
	}
	
	public String toString(){
		return "I am a Map Panel";
	}
	
	public int getCurrTurn(){
		return currTurn;
	}
}

class DListener implements ActionListener{
	private Player curPlayer;
	private MapPanel panel;
	public DListener (Player p, MapPanel panel){
		curPlayer=p;
		this.panel=panel;
	}
	public void actionPerformed(ActionEvent event) {
		curPlayer.setDone(true);
		panel.nextTurn();
	}
}
