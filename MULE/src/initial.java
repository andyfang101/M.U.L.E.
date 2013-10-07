import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class initial extends JFrame{

	
	
    public static void main(String[] args) {
    	initial f = new initial();
    }
    
    
    

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    
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
        bt1.addActionListener(new CListener());

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
    
    private class diffListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   JComboBox cb = (JComboBox)event.getSource();
           selectedDifficulty = (String)cb.getSelectedItem();
    	}
    }
    
    private class mtListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   JComboBox cb = (JComboBox)event.getSource();
           selectedMap = (String)cb.getSelectedItem();
    	}
    }
    
    private class pnListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   JComboBox cb = (JComboBox)event.getSource();
           selectedPN = (String)cb.getSelectedItem();
           System.out.println(selectedPN);
    	}
    }
    
    private class CListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   System.out.println("Continue");
    	}
    }
}