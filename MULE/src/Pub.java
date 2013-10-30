import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Pub extends Building{

	public Pub(GameMain frame, Player p, JPanel oldPanel) {
		super(frame, p, oldPanel);
		JButton gamble = new JButton("Gamble");
		gamble.addActionListener(new GambleListener(p, frame, oldPanel));
		add(gamble);
		
	}
	

}

/*
 * This is the gamble listener that allows the player 
 */

class GambleListener implements ActionListener{
	Player p;
	GameMain frame;
	JPanel oldpanel;
	public GambleListener(Player p, GameMain frame, JPanel oldpanel){
		this.p=p;
		this.frame=frame;
		this.oldpanel=oldpanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int askGamble = JOptionPane.showConfirmDialog(null,"Willing to take a little risk?" , "GAMBLE", JOptionPane.YES_NO_OPTION);
		if(askGamble==JOptionPane.YES_OPTION){
			int bonus=gambleGame(frame.getTime());
			p.gamble(gambleGame(bonus));
			JOptionPane.showMessageDialog(null,
				    "Not bad, you earned " + bonus);
			
		}
		if(askGamble==JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null,
				    "Hmph. Maybe you'll be man enough to venture a gamble next time.");
		}
		
		p.setDone(true);
		frame.setContentPane(oldpanel);
		
	}
	
	/*
	 * The method that allows the player to gamble a certain mount
	 * @param - amt, the amt of money bet
	 * @param int time- the amount of time the player has left
	 * @return boolean - whether or not player wins
	 */
	private int gambleGame(double timeleft){
		int round = GameMain.getCurrTurns(); //current round
		int time=(int)timeleft;
		int rBonus=0; //round Bound
		int tBonus=0; //time bonus
		Random rand = new Random();
		
		//Round bonus
		if(round<=3){
			rBonus=50;
		}
		else if(round>3 && round<=7){
			rBonus=100;
			
		}
		else if(round>7 && round<=11){
			rBonus=150;
		}
		else{
			rBonus=200;
		}
		
		//Time Bonus
		if(time>=0 && time<=12){
			tBonus=50;
		}
		else if(time>12 && time<=25){
			tBonus=100;
		}
		else if(time>25 && time<=37){
			tBonus=150;
		}
		else{
			tBonus=200;
		}
		
		int bonus = rBonus * (rand.nextInt(tBonus));
		
		if(bonus>250){
			return 250;
		}
		else 
			return bonus;
			
	}
	
}
