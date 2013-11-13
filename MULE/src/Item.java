import javax.swing.ImageIcon;

public abstract class Item {
	protected int value;
	protected ImageIcon image;
	public final static int SMITHORE = 0;
	public final static int ENERGY =1;
	public final static int FOOD=2; 
	public final static int CRYSTITE=3;
	protected int type;
	
	public Item(){
		value= 100;
		type=1;
	}
	
	public Item(int type){
		this.type=type;
		value=100;
	}

}
