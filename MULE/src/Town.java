import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 *@author Wei Jiang
 *@Version 1.0 10/23/13
 * This the town panel holds the town.
 */

public class Town extends JPanel{
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 650;
	private GameMain frame;
	private JPanel oldPanel;//The panel that holds old panel

	/*
	 * Town Constructor
	 */
	public Town(GameMain frame){
		
		this.frame = frame;
		oldPanel = (JPanel) frame.getContentPane();
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		frame.setTitle("Town");
		GridLayout layout = new GridLayout(0,2);
		JPanel subPanel = new JPanel();
		subPanel.setLayout(layout);
		
		JButton StoreButton = new JButton();  
		StoreButton.setIcon(new ImageIcon("store.png"));
		StoreButton.setBorderPainted(false);  
		StoreButton.setFocusPainted(false);  
		StoreButton.setContentAreaFilled(false);
		StoreButton.addActionListener(new StoreListener(oldPanel));
		
		JButton PubButton = new JButton();  
		PubButton.setIcon(new ImageIcon("pub.png"));
		PubButton.setBorderPainted(false);  
		PubButton.setFocusPainted(false);  
		PubButton.setContentAreaFilled(false);
		PubButton.addActionListener(new PubListener(oldPanel));
		
		JButton LandOfficeButton = new JButton();  
		LandOfficeButton.setIcon(new ImageIcon("landoffice.png"));
		LandOfficeButton.setBorderPainted(false);  
		LandOfficeButton.setFocusPainted(false);  
		LandOfficeButton.setContentAreaFilled(false);
		LandOfficeButton.addActionListener(new LandOfficeListener());
		
		JButton AssayOfficeButton = new JButton();  
		AssayOfficeButton.setIcon(new ImageIcon("assayoffice.png"));
		AssayOfficeButton.setBorderPainted(false);  
		AssayOfficeButton.setFocusPainted(false);  
		AssayOfficeButton.setContentAreaFilled(false);
		AssayOfficeButton.addActionListener(new AssayOfficeListener());
		
		JButton GoBack = new JButton("Back");
		GoBack.addActionListener(new BackListener());
		
		subPanel.add(StoreButton);
		subPanel.add(PubButton);
		subPanel.add(LandOfficeButton);
		subPanel.add(AssayOfficeButton);
		this.add(subPanel);
		this.add(GoBack);
		
		frame.setContentPane(this);
	}
	/*
	 * StoreListener
	 */
	private class StoreListener implements ActionListener
    {
		JPanel oldPanel;
		public StoreListener(JPanel oldPanel){
			this.oldPanel=oldPanel;
		}
       public void actionPerformed (ActionEvent event)
    	{
    		StorePanel p = new StorePanel(frame, GameMain.getCurrPlayer(), oldPanel);
			frame.setContentPane(p);
    	}

    }
	/*
	 * Pub action listener
	 */
	private class PubListener implements ActionListener
    {
		JPanel oldPanel;
		public PubListener(JPanel oldPanel){
			this.oldPanel=oldPanel;
		}
       public void actionPerformed (ActionEvent event)
    	{
    		Pub p = new Pub(frame, GameMain.getCurrPlayer(), oldPanel);
			frame.setContentPane(p);
    	}
    }
	/*
	 * Land office action listener
	 */
	private class LandOfficeListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   
    	}
    }
	/*
	 * Assay office action Listener
	 */
	private class AssayOfficeListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   
    	}
    }
	/*
	 * Go back button action listener.
	 */
	private class BackListener implements ActionListener
    {
       public void actionPerformed (ActionEvent event)
    	{
    	   frame.setContentPane(oldPanel);
    	}
    }
}
