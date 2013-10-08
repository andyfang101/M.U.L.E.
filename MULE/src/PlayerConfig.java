import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class PlayerConfig extends JFrame {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;
	
	private JTextField chooseName;
	private JComboBox chooseRace, chooseColor;
	private String playerName, playerRace, color;
	private Color playerColor;
	
	private String[] races = {"Select race...", "Flapper","Human","Others"}; 
	private String[] colors = {"Select color...", "Red", "Orange", "Yellow", "Green", "Blue", "Cyan"};
	
	public static void main(String[]args) {
		PlayerConfig newPlayer = new PlayerConfig();
		newPlayer.setVisible(true);
	}
	
	public PlayerConfig() {
		setTitle("M.U.L.E. - Player Configuration");
		setSize(WIDTH, HEIGHT);
		GroupLayout layout = new GroupLayout(this.getContentPane());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel entire = new JPanel();
		entire.setLayout(new GridLayout(3, 1));
		add(entire);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		entire.add(panel);
		
		/*
		ImageIcon mulePic = new ImageIcon("mule.gif");
		JLabel pic = new JLabel(mulePic);
		entire.add(pic);
		*/
		
		JLabel nameLabel = new JLabel("Player name: ");
	 	JLabel raceLabel = new JLabel("Player race: ");
        	JLabel colorLabel = new JLabel("Player color: ");
        
	        chooseRace = new JComboBox(races);
	        chooseRace.addActionListener(new raceListener());
	        
	        chooseColor = new JComboBox(colors);
	        chooseColor.addActionListener(new colorListener());
	        
	        chooseName = new JTextField();
	        /*
	        chooseName.addActionListener(new nameListener());
	        */
	        
	        panel.add(nameLabel);
	        panel.add(chooseName);
		panel.add(raceLabel);
		panel.add(chooseRace);
		panel.add(colorLabel);
		panel.add(chooseColor);
		entire.add(panel);
		
		setName();
        
	        JButton cont = new JButton("Continue");
	        cont.addActionListener(new continueListener());
	        entire.add(cont);
	}
	
	public Color setColor(String color) {
		if (color.equals("Red"))
 			playerColor = Color.RED;
	 	else if (color.equals("Orange"))
	 		playerColor = Color.ORANGE;
	 	else if (color.equals("Yellow"))
	 		playerColor = Color.YELLOW;
	 	else if (color.equals("Green"))
	 		playerColor = Color.GREEN;
	 	else if (color.equals("Blue"))
	 		playerColor = Color.BLUE;
	 	else if (color.equals("Cyan"))
	 		playerColor = Color.CYAN;
	 	else if (color.equals("Select color..."))
	 		System.out.println("Must select color.");	
	 	else
	 		System.out.println("Error with color selection.");	
		
		return playerColor;
	}
	
	public String setName() {
		playerName = chooseName.getText();
		return playerName;
	}
	
	private class raceListener implements ActionListener {
       		public void actionPerformed (ActionEvent event) {
    	   		JComboBox r = (JComboBox)event.getSource();
           		playerRace = (String)r.getSelectedItem();
           		if (playerRace.equals("Select race..."))
        	   		System.out.println("Must select race.");
    	}
    }
	
	private class colorListener implements ActionListener {
	       public void actionPerformed (ActionEvent event) {
	    	   JComboBox c = (JComboBox)event.getSource();
	    	   color = (String)c.getSelectedItem();
	    	   setColor(color);   
	    }
	}
	
	/*
	public class nameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setName();
		}
	}
	*/
	
	private class continueListener implements ActionListener {
       		public void actionPerformed (ActionEvent event) {
		    	/**
		    	* Temporary
		    	*/
    	   		System.out.println("Continue clicked.");
	    		System.out.println("Player name: " + setName());
	    	   	System.out.println("Player race: " + playerRace);
	    	   	System.out.println("Player color: " + color);
    	}
    }

}
