import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Property extends JPanel{
	private JFrame frame;
	
	private JComboBox purchaseProperty;
	
	private static final int WIDTH = 580;
	private static final int HEIGHT = 600;
    
	private boolean isPlayerTurn = true;
	private boolean successful = false;
	private boolean cont;
	
	private int playerTurn = 0;
	
	private double playerMoney = 1000.0;    //temp
	private double costOfProperty = 300.00;
	
	private ArrayList<String> playerProperty; //temp list type
	private String[] properties = {"Select property (temp)...", "Property 1", "Property 2", "Property 3", 
			"Property 4", "Property 5"}; 
	
	/**
	 * Sets up property purchasing panel
	 * @param frame Jframe frame
	 */
	public Property(JFrame frame) {
		cont = false;
        	this.frame = frame;
	        setVisible(true);
	        setSize(WIDTH, HEIGHT);
	        
	        GroupLayout layout = new GroupLayout(this);
	        frame.setTitle("M.U.L.E. - Buy Property");
	        JPanel entire = new JPanel();
	        entire.setLayout(new GridLayout(3, 1));
	        add(entire);
	        
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 2));
	        entire.add(panel);
	        
	        JLabel purchaseLabel = new JLabel("I would like to purchase: ");

	        purchaseProperty = new JComboBox(properties);
	        purchaseProperty.addActionListener(new propListener());
	        
	        panel.add(purchaseLabel);
	        panel.add(purchaseProperty);
	        entire.add(panel);
	                
	        JButton cont = new JButton("Continue");
	        cont.addActionListener(new continueListener(frame));
	        entire.add(cont);
	        
        	frame.setContentPane(this);
	}	
	
	/**
	 * Calls appropriate method based on which turn is being played
	 * @param property Property wished to be purchased
	 */
	public void buyProperty(String property) {
		if (playerTurn > 2)
			buyWithMoney(property);
		else
			buyWithLandGrants(property);
		playerTurn++;
	}
	
	/**
	 * Buy property with money if after first two turns
	 * @param property Property wished to be purchased
	 */
	public void buyWithMoney(String property) { //temp param type
		if (costOfProperty <= playerMoney) {    //costOfProperty is temp
			playerMoney -= costOfProperty;
			updatePlayerProperty(property);
			successful = true;
		}
	}
	
	/**
	 * Buy property with land grants if during first two turns
	 * @param property Property wished to be purchased
	 */
	public void buyWithLandGrants(String property) { //temp param type
		updatePlayerProperty(property);
		successful = true;
	}
	
	/**
	 * Updates player's owned property array
	 * @param property Property purchased
	 */
	public void updatePlayerProperty(String property) { //param type is temp
		playerProperty.add(property);
	}
	
	/**
	 * Getter for player's property array
	 */
	public ArrayList<String> getPlayerProperty() {
		return playerProperty;
	}
	
	/**
	 * Getter for whether purchase was successful
	 */
	public boolean successfulPurchase() {
		return successful;
	}
	
	/**
	 * Getter for player's turn number
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	/**
	 * Ends player's turn
	 */
	public void endPlayerTurn() {
		isPlayerTurn = false;
	}
	
	/**
	 * Getter for whether it's the player's turn
	 */
	public boolean isPlayerTurn() {
		return isPlayerTurn;
	}
	
	/**
	 * If continue button is pressed...(will cause to move on eventually)
	 */
	private class continueListener implements ActionListener {
        	private JFrame frame;        
		public continueListener(JFrame frame) {
        		this.frame = frame;
        	}
		public void actionPerformed (ActionEvent event) {
        		cont = true;
        	}
    	}
	
	/**
	 * Gets selected property when selected and calls buyProperty method
	 */
	private class propListener implements ActionListener {
        	public void actionPerformed (ActionEvent event) {
        		JComboBox p = (JComboBox)event.getSource();
        		String property = (String)p.getSelectedItem();
            		if (property.equals("Select property (temp)..."))
            			System.out.println("Must select property.");
            		else 
            			buyProperty(property);
        	}
	}
}
