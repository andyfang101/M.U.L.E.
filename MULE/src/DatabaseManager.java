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
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
}
