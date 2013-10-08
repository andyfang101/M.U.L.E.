public class Player{
	private String name;
	private int race;
	private int color;

	public Player(String name, int race, int color){
		int i = 0;
		this.name = name;

		if(race<0 | race>4){//races' values fall between 0 and 4 inclusive. otherwise, defaults to race 0 (human?)
			this.race = 0;
			System.out.println("Invalid race, defaulted to human.");
		}else{
			this.race = race;
		}

		if(color<0 | color>9){//color values fall between 0 and 9 inclusive. otherwise, defaults to blue (color 0)
			this.color = 0;
			System.out.println("Invalid color, defaulted to blue.");
		}else{
			this.color = color;
		}
	}
}