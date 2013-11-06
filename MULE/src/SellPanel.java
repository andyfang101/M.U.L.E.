import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * This is the panel for selling to store
 */
public class SellPanel extends Building{
	private int FoodPrice,EnergyPrice,SmithorePrice,CrystitePrice;
	private JLabel Sell,Food,Energy,Smithore,Crystite;
	private JTextField foodNumber,energyNumber,smithoreNumber,crystiteNumber;
	private JLabel pFood,pEnergy,pSmithore,pCrystite;
	private JLabel pFoodN,pEnergyN,pSmithoreN,pCrystiteN;
	private JPanel top,left,right,bottom,entire;
	public SellPanel(GameMain frame, Player p, JPanel oldPanel) {
		super(frame, p, oldPanel);
		
		top = new JPanel();
		left = new JPanel();
		right = new JPanel();
		bottom = new JPanel();
		entire = new JPanel();
		
		entire.setLayout(new BorderLayout());
		left.setLayout(new GridLayout(0,2));
		right.setLayout(new GridLayout(0,2));
		
		FoodPrice = 20;
		EnergyPrice = 15;
		SmithorePrice = 30;
		CrystitePrice = 50;
		
		Sell = new JLabel("What amount would you like to sell?");
		Food = new JLabel("Food:");
		Energy = new JLabel("Energy:");
		Smithore = new JLabel("Smithore:");
		Crystite = new JLabel("Crystite:");
		
		
		pFood = new JLabel("Your Food:");
		pEnergy = new JLabel("Your Energy:");
		pSmithore = new JLabel("Your Smithore:");
		pCrystite = new JLabel("Your Crystite:");
		
		pFoodN = new JLabel(" " + p.getFood());
		pEnergyN = new JLabel(" " + p.getEnergy());
		pSmithoreN = new JLabel(" " + p.getSmithore());
		pCrystiteN = new JLabel(" " + p.getCrystite());
		
		foodNumber = new JTextField("0");
		energyNumber = new JTextField("0");
		smithoreNumber = new JTextField("0");
		crystiteNumber = new JTextField("0");
		
		JButton sell = new JButton("Sell");
		JButton back = new JButton("Back");
		sell.addActionListener(new SellListener(p, frame, oldPanel));
		back.addActionListener(new BackListener(p, frame, oldPanel));

		top.add(Sell);
		left.add(Food);
		left.add(foodNumber);
		left.add(Energy);
		left.add(energyNumber);
		left.add(Smithore);
		left.add(smithoreNumber);
		left.add(Crystite);
		left.add(crystiteNumber);
		
		right.add(pFood);
		right.add(pFoodN);
		right.add(pEnergy);
		right.add(pEnergyN);
		right.add(pSmithore);
		right.add(pSmithoreN);
		right.add(pCrystite);
		right.add(pCrystiteN);


		bottom.add(sell);
		bottom.add(back);

		entire.add(top,BorderLayout.PAGE_START);
		entire.add(left,BorderLayout.LINE_START);
		entire.add(right,BorderLayout.LINE_END);
		entire.add(bottom,BorderLayout.PAGE_END);
		add(entire);
	}
	/*
	 * This is the action listener for selling
	 */
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
	    	   
	    	   if (fd > p.getFood() || eg > p.getEnergy() || so > p.getSmithore() || co > p.getCrystite()){
	    		   JOptionPane.showMessageDialog(null,
						    "YOU DO NOT HAVE ENOUGH AMOUNT OF RESOURCES");
	    	   }
	    	   else{
	    		   int amount = fd*FoodPrice + eg*EnergyPrice+ so*SmithorePrice+co*CrystitePrice;
	    		   p.sell(fd, eg, so, co, amount);
	    		   JOptionPane.showMessageDialog(null,
						    "DONE!");
	    	   }
	    	   pFoodN.setText(" " + p.getFood());
	    	   pEnergyN.setText(" " + p.getEnergy());
	   		   pSmithoreN.setText(" " + p.getSmithore());
	   		   pCrystiteN.setText(" " + p.getCrystite());

	    	}
	    }
	  /*
	   * This is the panel for back
	   */
		private class BackListener implements ActionListener
	    {
	    	Player p;
	    	GameMain frame;
	    	JPanel oldpanel;
			public BackListener(Player p, GameMain frame, JPanel oldpanel){
	    		this.p=p;
	    		this.frame=frame;
	    		this.oldpanel=oldpanel;
			}
	       public void actionPerformed (ActionEvent event)
	    	{
	    	   frame.setContentPane(oldpanel);
	    	}
	    }
}