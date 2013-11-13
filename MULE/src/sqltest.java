import java.io.File;
import java.sql.*;
public class sqltest {
	static Connection conn;
	static Statement stat;
	public static void main(String[] args) {
		try{
		 Class.forName("org.sqlite.JDBC");
		 conn = DriverManager
			     .getConnection("jdbc:sqlite://c:/MuleData/database.db");
		 stat = conn.createStatement();
		 try{
			 stat.execute("SELECT Player_Name FROM Player;");
		 	}catch (Exception e) {
		 		stat.executeUpdate
		 		 ("create table Player(Player_Name varchar(20), Game_ID int, Race varchar(10),"
		 		 		+ "Money int, Food int, Energy int, Smithore int, Crystite int, Mule int);"); 
		 		 stat.executeUpdate
		 		 ("create table Game(Game_ID int, Current_Player varchar(20),Round int, Time_Left int);"); 
		 		 stat.executeUpdate
		 		 ("create table Property(Type varchar(20), Location int, Game_ID int, Owner varchar(20), Mule_Type varchar(20));");
			  }
		 
		 //stat.executeUpdate("insert into Player values('Player 2', 1,'Flapper',1600,10,5,0,0,0);");
		 //stat.executeUpdate("insert into Game values(1,'Player 1',1,50);");
		 /*
		 stat.executeUpdate("insert into Property values('p',11,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',12,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m1',13,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',14,1,'null','null');");
		 stat.executeUpdate("insert into Property values('r',15,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',16,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m3',17,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',18,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',19,1,'null','null');");

		 stat.executeUpdate("insert into Property values('p',21,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m1',22,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',23,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',24,1,'null','null');");
		 stat.executeUpdate("insert into Property values('r',25,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',26,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',27,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',28,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m3',29,1,'null','null');");

		 stat.executeUpdate("insert into Property values('m',31,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',32,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',33,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',34,1,'null','null');");
		 stat.executeUpdate("insert into Property values('t',35,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',36,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',37,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',38,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m',39,1,'null','null');");
		 
		 stat.executeUpdate("insert into Property values('p',41,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m',42,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',43,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',44,1,'null','null');");
		 stat.executeUpdate("insert into Property values('r',45,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',46,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m',47,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',48,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',49,1,'null','null');");
		 
		 stat.executeUpdate("insert into Property values('p',51,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',52,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m',53,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',54,1,'null','null');");
		 stat.executeUpdate("insert into Property values('r',55,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',56,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',57,1,'null','null');");
		 stat.executeUpdate("insert into Property values('p',58,1,'null','null');");
		 stat.executeUpdate("insert into Property values('m2',59,1,'null','null');");
		 */
		}catch (Exception e) {
			   e.printStackTrace();
		  }
		
	}
}
