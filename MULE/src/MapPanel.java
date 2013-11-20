import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MapPanel extends JPanel{
	private Map map=null;
	private GridLayout grid=null;
	private boolean random; //implement random maps later
	private GameMain frame;
	private static String currPN;
	private static JLabel curPlayerName, currRoundLabel, currMoney;
	private static JLabel remainTime;
	private JButton done;
	private static boolean isDone;
	private int currRound;
	protected Player curPlayer;
	private JPanel entire,sub;
	private JButton emplaceMule;
	private JButton Save;
	SaveListener sl;
	public MapPanel(boolean random, GameMain frame, DatabaseManager DbMan){
		this.frame=frame;
		this.random = random;
		
		entire = new JPanel();
		sub = new JPanel();
		
		setVisible(true);
		
		//This decides whether to load a map or create a new one
		if(DbMan.getGameID() == 0)  
			map= new Map(random, frame);
		else
			map = new Map(DbMan, frame);
			
		//System.out.println(this.toString());
		grid = new GridLayout(Map.NUM_ROW, Map.NUM_COL);
		setLayout(grid);
		JButton emplaceMule = new JButton("Emplace a mule!");
		emplaceMule.addActionListener(new emplaceListener());
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
		currRoundLabel = new JLabel("Current Round: ");
		remainTime = new JLabel("Remaining Time: ");
		currMoney = new JLabel("Money amount: ");
		sub.add(curPlayerName);
		sub.add(currRoundLabel);
		sub.add(remainTime);
		sub.add(currMoney);
		done = new JButton("Done");
		Save = new JButton("Save Game");

		sub.add(done);
		sub.add(emplaceMule);
		sub.add(Save);
		done.addActionListener(new DListener(frame));
		currRound = 1;
		entire.add(this);
		entire.add(sub);
		sl = new SaveListener(frame,map,currPN, DbMan);
		Save.addActionListener(sl);

		this.frame.setContentPane(entire);
	}
	
	/**
	 * Sets that the player's turn is done
	 * @param isDonex - whether or not player is done or not
	 */
	public static void setIsDone(boolean isDonex){
		isDone = isDonex;
	}
	
	/**
	 * Getter for whether the player's turn is not done or not
	 * @return isDone - whether or not player is done
	 */
	public boolean getIsDone(){
		return isDone;
	}
	
	/**
	 * Setting current player of game, updates label name
	 * @param p - current Player
	 */
	public void setCurPlayer(Player p){
		currPN = p.getName();
		sl.setName(currPN);
		curPlayer = GameMain.getCurrPlayer();
		
	}
	
	/**
	 * Getting current player
	 * @return curPlayer
	 */
	public Player getCurrPlayer(){
		return curPlayer;
	}
	
	/**
	 * Increasing the turn 
	 * 
	 */
	public void nextTurn(){
		currRound++;
	}
	
	/**
	 * Checking to see if the game is over not
	 * @param currTurn - how many rounds the game has
	 * @return boolean - whether or not game is over yet
	 */
	public boolean gameOver(int currTurn){
		if(currTurn<12)
			return false;
		return true;
	}
	
	public String toString(){
		return "I am a Map Panel";
	}
	/**
	 * Getter for current turn
	 * @return turn - current turn
	 */
	public int getCurrTurn(){
		return currRound;
	}
	
	/**
	 * Setting the current player label
	 * @param name - the name to set it to
	 */
	public void setCurrPlayerLabel(String name){
		sl.setName(name);
		curPlayerName.setText("Current Player: " + name);
	}
	
	/**
	 * Changing the label of the current round
	 * @param - current Round
	 */
	public void setCurrRound(int round){
		currRoundLabel.setText("Current Round: " + round);
	}
	
	/**
	 * Setting remaining time
	 * @param time how many seconds are left
	 */
	public void setRemainTime(int time){
		remainTime.setText("Remaining Time: "+time);
	}
	
	/**
	 * Setting current player's current money
	 * @int money  - how much money player has
	 */
	public void setCurrMoney(int money){
		currMoney.setText("Money Amount: " + money);
	}
}

/**
 * A listener that checks if player is done or not to end the player's turn
 * @author Eileen Wang
 *
 */
class DListener implements ActionListener{
	GameMain frame;
	public DListener(GameMain frame){
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent event) {
		Player p = GameMain.getCurrPlayer();
		p.setDone(true);
		frame.cancelTimer();
	}
}

/**
 * The emplace listener to see if player want's to place the mule on a tile or not
 * @author Eileen Wang
 *
 */
class emplaceListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Player p = GameMain.getCurrPlayer();
		p.setEmplace(true);
	}
}

/**
 * Save button that interacts with database to save game
 * @author Eileen Wang
 *
 */
class SaveListener implements ActionListener{

	GameMain frame;
	ArrayList<Player> pl;
	String currPlayer;
	DatabaseManager DbMan;
	Map map;
	int id;
	public SaveListener(GameMain frame,Map map,String PN, DatabaseManager DbMan){
		this.frame = frame;
		this.map = map;
		this.DbMan = DbMan;
		currPlayer = PN;

		pl = frame.getPlayerList();
		String[] slots= {"Slot 1","Slot 2","Slot 3"};

	}
	public void actionPerformed(ActionEvent arg0) {
		String[] slots= {"Slot 1","Slot 2","Slot 3"};
		int action = JOptionPane.showOptionDialog(null, "Which Slots?", "Slot Selection",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
		        null, slots,slots[0]);
		id = action +1;
		DbMan.SaveData(pl, currPlayer, frame, map,id);
	}
	
	public void setName(String PN){
		currPlayer = PN;
	}
}
