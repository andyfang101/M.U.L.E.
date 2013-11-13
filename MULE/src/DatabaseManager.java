import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseManager {
	protected Connection conn;
	protected Statement stat;
	protected ArrayList<Player> players;
	protected String currentPlayer;
	protected int round;
	protected int timeLeft;
	
	public DatabaseManager(){
		players = new ArrayList<Player>();
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager
				     .getConnection("jdbc:sqlite://home/kushal/database.db");
			 stat = conn.createStatement();
			 try{
				 stat.execute("SELECT Player_Name FROM Player;");
			 	}catch (Exception e) {
					   //if the table is not exist
			 		 stat.executeUpdate
			 		 ("create table Player(Color varchar(20), Player_Name varchar(20), Game_ID int, Race varchar(10),"
			 		 		+ "Money int, Food int, Energy int, Smithore int, Crystite int, Mule int);"); 
			 		 stat.executeUpdate
			 		 ("create table Game(Game_ID int, Current_Player varchar(20),Round int, Time_Left int);"); 
			 		 stat.executeUpdate
			 		 ("create table Property(Type varchar(20), Location int, Game_ID int, Owner varchar(20), Mule_Type varchar(20));"); 
				  }
		}catch (Exception e) {
			   e.printStackTrace();
		  }
	}	
	public void SaveData(ArrayList<Player> players, String currPlayer, GameMain main, Map map, int id){
		     String currName = currPlayer;
		     int round = main.getCurrTurns();
		     int time = main.getTime();
		 
		     try{
		       stat.executeUpdate("DELETE FROM GAME WHERE Game_ID ="+id+";");
		       stat.executeUpdate("insert into Game values("+id+",'"+currName+"',"+round+","+time+");");
		       
		     }catch (Exception e) {
		            e.printStackTrace();
		       }
		     try{
		       stat.executeUpdate("DELETE FROM Property WHERE Game_ID ="+id+";");
		     }catch (Exception e) {
		          e.printStackTrace();
		       }
		     char [][] mapRep = map.getMapRep();
		     for (int i = 0; i <5;i++){
		       for (int j = 0; j<9;j++){
		         char type = mapRep[i][j];
		         int location = (i+1)*10+j+1;
		         try{
		           stat.executeUpdate("insert into Property values("+"'"+type+"',"+location+","+id+","+"'null'"+","+"'null'"+");");
		         }catch (Exception e) {
		              e.printStackTrace();
		           }
		       }
		     }
		     try{
		       stat.executeUpdate("DELETE FROM Player WHERE Game_ID ="+id+";");
		     }catch (Exception e) {
		          e.printStackTrace();
		       }
		     
		     for (Player p: players){
		       String name = p.getName();
		       String race = p.getRace();
		       Color color = p.getColor();
		       String colorName;
		       if (color.equals(Color.RED)){
		         colorName = "Red";
		       }
		       else if (color.equals(Color.YELLOW)){
		         colorName = "Yellow";
		       }
		       if (color.equals(Color.BLUE)){
		         colorName = "Blue";
		       }
		       else
		         colorName = "Green";
		       
		       int money = p.getMoney();
		       int food = p.getFood();
		       int energy = p.getEnergy();
		       int so = p.getSmithore();
		       int crystite = p.getCrystite();
		       int mule = 0;
		       if (p.ownsMule())
		         mule = 1;
		       try{
		         stat.executeUpdate("insert into Player values('"+colorName+"','"+name+"',"+id+",'"+race+"',"+money+","+food+","+energy+","+so+","+crystite+","+mule+");");
		       }catch (Exception e) {
		            e.printStackTrace();
		         }
		     }
	}

	public boolean load(int gameID){
		try{
			
			ResultSet res = stat.executeQuery("SELECT * FROM Player WHERE Game_ID == " + gameID + ";");
			int count = 0;
			while(res.next()){
				players.add(new Player(res.getString("Player_Name"), res.getString("Race"), res.getString("Color")));
				players.get(count).setMoney(res.getInt("Money"));
				players.get(count).setFood(res.getInt("Food"));
				players.get(count).setEnergy(res.getInt("Energy"));
				players.get(count).setSmithore(res.getInt("Smithore"));
				players.get(count).setCrystite(res.getInt("Crystite"));
				players.get(count).setMule(res.getInt("Mule"));
				count++;
			}
			
			res = stat.executeQuery("SELECT * FROM Game WHERE Game_ID == " + gameID + ";");
			while(res.next()){
				currentPlayer = res.getString("Current_Player");
				round = res.getInt("Round");
				timeLeft = res.getInt("Time_Left");
				
			}
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @return the currentPlayer
	 */
	public String getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * @return the timeLeft
	 */
	public int getTimeLeft() {
		return timeLeft;
	}
}
