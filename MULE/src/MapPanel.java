import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private static boolean isDone;//Tells if a turn is done
	private int curTurn;
	private static int round;
	private static int turnNumber;
	private static int playerNumber;
	private Player curPlayer;
	private static final int WIDTH = 580;
	private static final int HEIGHT = 600;
	private JPanel WholePanel,SubPanel,player1panel,player2panel,player3panel,player4panel,CurrentPlayerPanel;//All panel
	private JLabel player1info,player2info,player3info,player4info,currentPlayerName;
	private static JLabel Round;

	public MapPanel(boolean random, JFrame frame){
		this.frame=frame;
		this.random = random;
		setVisible(true);
		
		turnNumber = 0;
		round = 0;
		isDone = false;
		done = new JButton("Done");
		done.addActionListener(new DListener());
		
		this.setPreferredSize(new Dimension(580,333));//Set the size of Map Panel
		WholePanel = new JPanel();
		SubPanel = new JPanel();//Sub panel dispays Player's info
		player1panel= new JPanel();
		player2panel= new JPanel();
		player3panel= new JPanel();
		player4panel= new JPanel();
		CurrentPlayerPanel = new JPanel();
		
		player1info = new JLabel("Player1 Info: ");
		player2info = new JLabel("Player2 Info: ");
		player3info = new JLabel("Player3 Info: ");
		player4info = new JLabel("Player4 Info: ");
		Round = new JLabel("ROUND: ");
		currentPlayerName = new JLabel("current player");
		
		player1panel.add(player1info);
		player2panel.add(player2info);
		player3panel.add(player3info);
		player4panel.add(player4info);
		CurrentPlayerPanel.add(currentPlayerName);
		CurrentPlayerPanel.add(Round);
		
		SubPanel.setLayout(new FlowLayout());
		SubPanel.add(player1panel);
		SubPanel.add(player2panel);
		SubPanel.add(player3panel);
		SubPanel.add(player4panel);
		SubPanel.add(CurrentPlayerPanel);
		SubPanel.add(done);
		
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
		//add(curPlayerName);
		//add(done);
		//done.addActionListener((ActionListener) new DListener());
		//curPlayerName.setText("Current Player: ");
		//curTurn = 0;
		WholePanel.add(this);
		WholePanel.add(SubPanel);
		this.frame.setContentPane(WholePanel);
	}
	
	public static void setIsDone(boolean isDonex){
		isDone = isDonex;
	}
	
	public boolean getIsDone(){
		return isDone;
	}
	
	public static void reset(){
		isDone = false;
	}
	
	public void setPlayerNumber(int playernumber){
		playerNumber = playernumber;
	}
	
	public static int getPlayerNumber(){
		return playerNumber;
	}
	
	public void setCurPlayer(Player p){
		curPlayer = p;
		currentPlayerName.setText(curPlayer.getName());
	}
	
	public static void nextTurn(){
		turnNumber++;
	}
	
	public static int getTurnNumber(){
		return turnNumber;
	}
	
	public static void resetTurn(){
		turnNumber = 0;
	}
	
	public static void RefreshRoundNumber(){
		round++;
		Round.setText("Round: "+round);
	}
	
	public boolean gameOver(){
		if(curTurn<12)
			return false;
		return true;
	}
}

/*
 * Go to next player if player click done
 */
class DListener implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		MapPanel.setIsDone(true);
		MapPanel.reset();
		MapPanel.nextTurn();
		if (MapPanel.getPlayerNumber() == MapPanel.getTurnNumber()){
			MapPanel.RefreshRoundNumber();
			MapPanel.resetTurn();
		}
		
	}
}
