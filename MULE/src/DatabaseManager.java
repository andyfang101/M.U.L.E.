import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public abstract class DatabaseManager {
	protected Connection conn;
	protected Statement stat;
	public DatabaseManager(){
		try{
			 Class.forName("org.sqlite.JDBC");
			 conn = DriverManager
				     .getConnection("jdbc:sqlite://MuleData/database.db");
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
}
