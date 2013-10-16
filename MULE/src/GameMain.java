import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class GameMain extends JFrame{
	
	public static void main(String[] args){
		ArrayList<Player> players = new ArrayList<Player>();
		
		JFrame game = new JFrame();
		Initial initial = new Initial(game);
		while(!initial.getContinue()){
			game.repaint();
		}
		for(int i = initial.getNumPlayers(); i>0; i--){
			PlayerConfig pConfig = new PlayerConfig(game);
			while(!pConfig.getContinue()){
				game.repaint();
			}
			players .add(pConfig.getPlayer());
		}
		MainScreen mainScreen = new MainScreen(game);
		for(Player p: players){
			System.out.println(p.getName());
		}
	}
}
