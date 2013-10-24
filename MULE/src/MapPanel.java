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
	private static boolean isDone;
	private int curTurn;
	private Player curPlayer;
	private static final int WIDTH = 580;
	private static final int HEIGHT = 600;
	private JPanel WholePanel,SubPanel,player1panel,player2panel,player3panel,player4panel;
	private JLabel player1info,player2info,player3info,player4info;

	public MapPanel(boolean random, JFrame frame){
		this.frame=frame;
		this.random = random;
		setVisible(true);
		
		this.setPreferredSize(new Dimension(580,333));//Set the size of Map Panel
		WholePanel = new JPanel();
		SubPanel = new JPanel();//Sub panel dispays Player's info
		player1panel= new JPanel();
		player2panel= new JPanel();
		player3panel= new JPanel();
		player4panel= new JPanel();
		
		player1info = new JLabel("Player1 Info: ");
		player2info = new JLabel("Player2 Info: ");
		player3info = new JLabel("Player3 Info: ");
		player4info = new JLabel("Player4 Info: ");

		player1panel.add(player1info);
		player2panel.add(player2info);
		player3panel.add(player3info);
		player4panel.add(player4info);

		SubPanel.setLayout(new FlowLayout());
		SubPanel.add(player1panel);
		SubPanel.add(player2panel);
		SubPanel.add(player3panel);
		SubPanel.add(player4panel);

		
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
	
	public void setCurPlayer(Player p){
		//curPlayer = p;
		//curPlayerName.setText("Current Player: " + curPlayer.getName());
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
	public void actionPerformed(ActionEvent event) {
		MapPanel.setIsDone(true);
	}
}
