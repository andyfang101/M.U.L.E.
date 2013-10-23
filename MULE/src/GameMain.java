import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class GameMain extends JFrame{
	
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
					players.add(pConfig.getPlayer());
				else
					i++;
				if(back){
					game.setContentPane(initial);
					break;
				}
			}
		}
		while(back);
		MapPanel map = new MapPanel(initial.isRandomMap(), game); //CHANGE FALSE TO BOOL RANDOM
		game.validate();
		game.repaint();
		
		//MainScreen mainScreen = new MainScreen(game);
		for(Player p: players){
			System.out.println(p.getName());
		}
		
		do{
			for(Player p : players){
				map.setCurPlayer(p);
				p.takeTurn();
			}
			map.nextTurn();
		}while(!map.gameOver());
	}
}
