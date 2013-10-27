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
	private static JLabel curPlayerName;
	private static JLabel currTurnLabel;
	private JButton done;
	private static boolean isDone;
	private int currTurn;
	protected Player curPlayer;
	private JPanel entire,sub;

	public MapPanel(boolean random, JFrame frame){
		this.frame=frame;
		this.random = random;
		
		entire = new JPanel();
		sub = new JPanel();
		
		setVisible(true);
		map= new Map(false, frame);
		//System.out.println(this.toString());
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
		curPlayerName = new JLabel("Current Player: " );
		currTurnLabel = new JLabel("Current Round: ");
		
		sub.add(curPlayerName);
		sub.add(currTurnLabel);
		done = new JButton("Done");
		sub.add(done);
		done.addActionListener(new DListener());
		currTurn = 1;
		entire.add(this);
		entire.add(sub);
		this.frame.setContentPane(entire);
	}
	
	public static void setIsDone(boolean isDonex){
		isDone = isDonex;
	}
	
	public boolean getIsDone(){
		return isDone;
	}
	
	public void setCurPlayer(Player p){
		System.out.println("I am settings!!!");
		curPlayer = GameMain.getCurrPlayer();
		
	}
	
	public Player getCurrPlayer(){
		return curPlayer;
	}
	
	public void nextTurn(){
		currTurn++;
	}
	
	public boolean gameOver(int currTurn){
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
	
	public void setCurrPlayerLabel(String name){
		curPlayerName.setText("Current Player: " + name);
	}
	
	public void setCurrTurn(int turn){
		currTurnLabel.setText("Current Round: " + turn);
	}
}

class DListener implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		Player p = GameMain.getCurrPlayer();
		p.setDone(true);
	}
}
