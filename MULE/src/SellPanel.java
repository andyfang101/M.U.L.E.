import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SellPanel extends Building{
	private int FoodPrice,EnergyPrice,SmithorePrice,CrystitePrice;
	private JLabel Sell,Food,Energy,Smithore,Crystite;
	private JTextField foodNumber,energyNumber,smithoreNumber,crystiteNumber;
	public SellPanel(GameMain frame, Player p, JPanel oldPanel) {
		super(frame, p, oldPanel);
		
		FoodPrice = 20;
		EnergyPrice = 15;
		SmithorePrice = 30;
		CrystitePrice = 50;
		
		Sell = new JLabel("What amount would you like to sell?");
		Food = new JLabel("Food:");
		Energy = new JLabel("Energy:");
		Smithore = new JLabel("Smithore:");
		Crystite = new JLabel("Crystite:");
		
		foodNumber = new JTextField("0");
		energyNumber = new JTextField("0");
		smithoreNumber = new JTextField("0");
		crystiteNumber = new JTextField("0");
		
		JButton sell = new JButton("Sell");
		JButton Back = new JButton("Back");
		sell.addActionListener(new SellListener(p, frame, oldPanel));
		add(Sell);
		add(Food);
		add(foodNumber);
		add(Energy);
		add(energyNumber);
		add(Smithore);
		add(smithoreNumber);
		add(Crystite);
		add(crystiteNumber);
		add(sell);
		
	}
	  private class SellListener implements ActionListener
	    {
	    	Player p;
	    	GameMain frame;
	    	JPanel oldpanel;
		  public SellListener(Player p, GameMain frame, JPanel oldpanel){
	    		this.p=p;
	    		this.frame=frame;
	    		this.oldpanel=oldpanel;
		  }
	       public void actionPerformed (ActionEvent event)
	    	{
	    	   int fd = Integer.parseInt(foodNumber.getText());
	    	   int eg = Integer.parseInt(energyNumber.getText());
	    	   int so = Integer.parseInt(smithoreNumber.getText());
	    	   int co = Integer.parseInt(crystiteNumber.getText());
	    	   
	    	   int amount = fd*FoodPrice + eg*EnergyPrice+ so*SmithorePrice+co*CrystitePrice;
	    	   p.sell(fd, eg, so, co, amount);
	    	}
	    }
}