import javax.swing.*;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

/*
 * This is the main class
 */
public class GameMain extends JFrame{
	public static boolean loadedGame = false;
	public static int loadedTimeLeft = 0;
	private static Player currPlayer;
	private static int currRounds;
	static Timer timer;
	//private static JLabel currTurnLabel; //change
	//private static JLabel currPlayerLabel;
	private static int startSeconds,currSeconds;
	private static ArrayList<Player> players;
	/**
	 * Main method
	 */
	public static void main(String[] args){
		players = new ArrayList<Player>();
		DatabaseManager DbMan = new DatabaseManager();
		
		GameMain game = new GameMain();
		game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Initial initial;
		boolean back;
		int gameID = 1;
		
		do{
			back = false;
			initial = new Initial(game);
			while(!initial.getContinue()){
				game.repaint();
			}
			gameID = initial.getLoadGameID();
			if(gameID != 0) 
				loadedGame = true;
			if(loadedGame){ //if the game is loaded, load the appropriate data
				DbMan.load(gameID);
				loadedTimeLeft = DbMan.getTimeLeft();
				players = DbMan.getPlayers();
			}
			else{ //if game is not loaded, switch to the player config options
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
		}
	
		while(back);
		MapPanel map;
		if(loadedGame)
			currRounds = DbMan.getRound() - 1;
		map = new MapPanel(initial.isRandomMap(), game, DbMan); 
		game.validate();
		game.repaint();
		
		boolean isLast;
		
		do{
			currRounds++;
			int m;//this variable is for the random events calculation
			switch(currRounds){
				case 1: m = 25;
					break;
				case 2: m = 25;
					break;
				case 3: m = 25;
					break;
				case 4: m = 50;
					break;
				case 5: m = 50;
					break;
				case 6: m = 50;
					break;
				case 7: m = 50;
					break;
				case 8: m = 75;
					break;
				case 9: m = 75;
					break;
				case 10: m = 75;
					break;
				case 11: m = 75;
					break;
				case 12: m = 100;
					break;
				default: m = 0;
					break;
			}
			//This will reorder the players from lowest score to highest
			for(int i=0; i<players.size(); i++){ 
				for(int j=i-1; j>=0; j--){
					if(players.get(i).getScore()<players.get(j).getScore()){
						players.add(j, players.get(i));
						players.remove(i+1);
					}
					else
						break;
				}
			}
			for(Player p : players){
				if(loadedGame == true && !p.getName().equals(DbMan.getCurrentPlayer()));
				else{
					currPlayer = p;
					map.setCurrRound(currRounds);
					map.setCurrPlayerLabel(currPlayer.getName());
					map.setCurrMoney(currPlayer.getMoney());
	
					Calendar calendar = Calendar.getInstance();
					startSeconds = calendar.get(Calendar.SECOND);
					//System.out.println("start time: " + startSeconds);
					game.turnTimer();
					
	
					//Cycle through playerlist, while!done\
					map.setCurPlayer(p);
					
					game.repaint();
					//p.takeTurn();
					p.produceFromMules();
					//}
					while(!p.isDone()){
						map.setRemainTime(game.getTime());
						game.repaint();
						map.setCurrMoney(currPlayer.getMoney());
					}
					p.setDone(false);
					p.setEmplace(false);
					p.setVisited(false);
					game.repaint();
					if(map.gameOver(currRounds))
						break;
					isLast = true;

					if(!(players.get(0).equals(p)))
						isLast = false;
					JOptionPane.showMessageDialog(null, p.startRandomEvent(isLast,m));
					if(loadedGame)
						loadedGame = false;
				}
			}
			map.nextTurn();
		}while(!map.gameOver(currRounds ));
		
	}
	
	/**
	 * Handles timer
	 */
	public void turnTimer() {
			int turnTime;
			System.out.println(loadedGame + " " + loadedTimeLeft);
			if(loadedGame)
				turnTime = loadedTimeLeft;
			else
				turnTime = currPlayer.getTurnTime(currRounds);
    		timer = new Timer();
    		timer.schedule(new RunTask(), turnTime*1000);
    	}
	
	public void cancelTimer(){
		timer.cancel();
	}
	class RunTask extends TimerTask {
        public void run() {
        	currPlayer.setDone(true);
            timer.cancel(); //Terminate the timer thread
        }
    }
	/*
	 * This method is to get player's time left
	 */
	public int getTime(){
		int pastTime,remainTime;
		int totalTime;
		if(loadedGame)
			totalTime= loadedTimeLeft;
		else
			totalTime  = currPlayer.getTurnTime(currRounds);
		Calendar calendar = Calendar.getInstance();
		currSeconds = calendar.get(Calendar.SECOND);

		if (currSeconds > startSeconds){
			pastTime = currSeconds-startSeconds;
		}
		else
			pastTime = (60-startSeconds)+currSeconds;
		remainTime = totalTime - pastTime;
		if (remainTime < 0){
			remainTime = currPlayer.getTurnTime(currRounds);
		}
		return remainTime;
	}
	
	/**
	 * Getter for current player
	 * @return Current player
	 */
	public static Player getCurrPlayer(){
		return currPlayer;
	}
	
	public ArrayList<Player> getPlayerList(){
		return players;
	}
	/**
	 * Getter for current turns
	 * @return Current turns
	 */
	public static int getCurrTurns(){
		return currRounds;
	}
}
