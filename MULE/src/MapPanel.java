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
	public MapPanel(boolean random, GameMain frame){
		this.frame=frame;
		this.random = random;
		
		entire = new JPanel();
		sub = new JPanel();
		
		setVisible(true);
		map= new Map(false, frame);
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
		sl = new SaveListener(frame,map,currPN);
		Save.addActionListener(sl);

		this.frame.setContentPane(entire);
	}
	
	public static void setIsDone(boolean isDonex){
		isDone = isDonex;
	}
	
	public boolean getIsDone(){
		return isDone;
	}
	
	public void setCurPlayer(Player p){
		currPN = p.getName();
		sl.setName(currPN);
		curPlayer = GameMain.getCurrPlayer();
		
	}
	
	public Player getCurrPlayer(){
		return curPlayer;
	}
	
	public void nextTurn(){
		currRound++;
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
		return currRound;
	}
	
	public void setCurrPlayerLabel(String name){
		sl.setName(name);
		curPlayerName.setText("Current Player: " + name);
	}
	
	public void setCurrRound(int round){
		currRoundLabel.setText("Current Round: " + round);
	}
	
	public void setRemainTime(int time){
		remainTime.setText("Remaining Time: "+time);
	}
	
	public void setCurrMoney(int money){
		currMoney.setText("Money Amount: " + money);
	}
}

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

class emplaceListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Player p = GameMain.getCurrPlayer();
		p.setEmplace(true);
	}
}

class SaveListener implements ActionListener{

	GameMain frame;
	ArrayList<Player> pl;
	String currPlayer;
	Map map;
	int id;
	public SaveListener(GameMain frame,Map map,String PN){
		this.frame = frame;
		this.map = map;
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
		DatabaseManager dm = new DatabaseManager();
		dm.SaveData(pl, currPlayer, frame, map,id);
	}
	
	public void setName(String PN){
		currPlayer = PN;
	}
}