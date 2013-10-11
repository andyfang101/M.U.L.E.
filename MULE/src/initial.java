import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

/*
* This is a initial class that lets the user select the options, difficulty, map size, and player nunmber.
* This class is the screen that comes after the main screen.
* @author Wei Jiang, Eileen Wang
* @ Version 1.0 10/7/2013
*/

public class initial extends JFrame{

	
	
    public static void main(String[] args) {
    	initial f = new initial();
    }
    
    
    

    JLabel label1; //Logo
    JLabel label2; //Diffficulty
    JLabel label3; // Type of Map
    JLabel label4; //Number of Players
    
    JComboBox diff;
    JComboBox map;
    JComboBox playerno;

    JButton bt1;
    
    String selectedDifficulty;
    String selectedMap;
    String selectedPN;
    
	private static final int WIDTH = 580;
	private static final int HEIGHT = 600;
	ImageIcon logo = new ImageIcon("logo.png");
	String[] difficulty = {"Beginner","Standard","Tournament"}; 
	String[] maptype = {"Standard","Random"}; 
	String[] playernumber = {"1","2","3","4"}; 
	

    /*
    * This is the constructor for the initial frame, has options to select difficulty, player number, and map size.
    *
    */
    public initial() {
    	this.setTitle("M.U.L.E.");
    	this.getContentPane().setBackground(Color.white);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        diff = new JComboBox(difficulty);
        diff.addActionListener(new diffListener());
        
        map = new JComboBox(maptype);
        map.addActionListener(new mtListener());
        
        playerno = new JComboBox(playernumber);
        playerno.addActionListener(new pnListener());
        
        diff.setPreferredSize(new Dimension(50,25));

        label1 = new JLabel(logo);
        label2 = new JLabel("Difficulty: ");
        label3 = new JLabel("Type of Map: ");
        label4 = new JLabel("Number of Players: ");
        

        bt1 = new JButton("Continue");
        bt1.addActionListener(new CListener(this));

        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label2)
                .addComponent(label3).addComponent(label4));
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label1)
                .addComponent(map).addComponent(diff).addComponent(playerno).addComponent(bt1));
        hGroup.addGap(5);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(100);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label1));
        vGroup.addGap(100);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label2)
                .addComponent(diff));
        vGroup.addGap(30);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label3)
                .addComponent(map));
        vGroup.addGap(30);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label4)
                .addComponent(playerno));
        vGroup.addGap(30);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING)
                .addComponent(bt1));
        vGroup.addGap(10);
        layout.setVerticalGroup(vGroup);
    }
    
    /*
    * This is a private class that sets the selectedDifficultly to 
    * to what is selected in the combo box with an action listener.
    */
    private class diffListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   JComboBox cb = (JComboBox)event.getSource();
           selectedDifficulty = (String)cb.getSelectedItem();
    	}
    }
    
    /*
    * This is a private class that sets the map size to 
    * to what is selected in the combo box with an ActionListener.
    */
    private class mtListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   JComboBox cb = (JComboBox)event.getSource();
           selectedMap = (String)cb.getSelectedItem();
    	}
    }
    
    /*
    * This is a private class that sets the player number to 
    * to what is selected in the combo box.
    */
    private class pnListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   JComboBox cb = (JComboBox)event.getSource();
           selectedPN = (String)cb.getSelectedItem();
    	}
    }
    
    /*
    * This is a private class that will eventually be implemented to continue to the next screen.
    */
    public class CListener implements ActionListener
    {
    	private JFrame frame;
    	public CListener(JFrame frame){
    		this.frame = frame;
    	}
       public void actionPerformed (ActionEvent event)
    	{
    	   PlayerConfig pConfig = new PlayerConfig(frame);

    	}
    }
}
