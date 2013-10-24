import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/*
 * 
 */
public class GameMain extends JFrame{
	private static Player currPlayer;
	private static int currTurns;
	private static JLabel currTurnLabel;
	private static JLabel currPlayerLabel;
	public static void main(String[] args){
		ArrayList<Player> players = new ArrayList<Player>();
		JFrame game = new JFrame();
		Initial initial;
		boolean back;
		
		do{
			back = false;
			initial = new Initial(game);
			while(!initial.getContinue()){
				game.repaint();
			}
			for(int i = initial.getNumPlayers(); i>0; i--){
				PlayerConfig pConfig = new PlayerConfig(game);
				while(!pConfig.getContinue()){
					game.repaint();
					if(pConfig.getBack()){
						i++;
						if(i>initial.getNumPlayers())
							back = true;
						else
							players.remove(initial.getNumPlayers() - i);
						break;
					}
				}
				if(!pConfig.getBack())
					players=pConfig.getPlayers();
				else
					i++;
				if(back){
					game.setContentPane(initial);
					break;
				}
			}
		}
		while(back);
		
		
		MapPanel map = new MapPanel(false, game); //CHANGE FALSE TO BOOL RANDOM
		game.validate();
		game.repaint();
		
		do{
			for(Player p : players){
				while(!p.isDone()){

				currPlayer = p;
				currTurnLabel = new JLabel("Current Turn: " + currTurns);
				currPlayerLabel = new JLabel("Current Player: " + currPlayer.getName());
				//Cycle through playerlist, while!done\
				map.setCurPlayer(p);
				game.repaint();
				p.takeTurn();
				}

				currTurns++;
			}
			currTurnLabel.setText("Current Turn: " + currTurns);
			currPlayerLabel.setText("Current Player: " + currPlayer.getName());
			map.nextTurn();
		}while(!map.gameOver());
		
	}
	
	public static Player getCurrPlayer(){
		return currPlayer;
	}
	
	public static int getCurrTurns(){
		return currTurns;
	}
}
